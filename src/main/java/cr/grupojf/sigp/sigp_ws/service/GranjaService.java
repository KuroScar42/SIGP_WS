/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Cerdos;
import cr.grupojf.sigp.sigp_ws.model.CerdosDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author herna
 */
@Stateless
@LocalBean
public class GranjaService {
    private static final Logger LOG = Logger.getLogger(GranjaService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    
    public Respuesta getCerdos() {
        try {
            Query query = em.createNamedQuery("Cerdos.findAll", Cerdos.class);
            List<Cerdos> cerdos = query.getResultList();
            List<CerdosDto> cerdosDtoList = new ArrayList<>();
            cerdos.forEach((cerdo) -> {
                cerdosDtoList.add(new CerdosDto(cerdo));
            });
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "cerdos", cerdosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los cerdos.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los cerdos.", "getCerdos" + ex.getMessage());
        }
    }
    
    public Respuesta guardarCerdo(CerdosDto cerdoDto) {
        try {
            Cerdos cerdos;
            if (cerdoDto.getId() != null && cerdoDto.getId() > 0) {
                cerdos = em.find(Cerdos.class, cerdoDto.getId());
                if (cerdos == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el cerdo especificado", "Cerdos NoResultException");
                }
                cerdos.actualizar(cerdoDto);
                cerdos = em.merge(cerdos);
            } else {
                cerdos = new Cerdos(cerdoDto);
                em.persist(cerdos);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "cerdo", new CerdosDto(cerdos));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el cerdo.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar cerdo.", "guardarCerdo " + e.getMessage());
        }
    }
    
    public Respuesta eliminarCerdo(CerdosDto cerdoDto) {
        try {
            Cerdos cerdo;
            if (cerdoDto.getId() != null && cerdoDto.getId() > 0) {
                cerdo = em.find(Cerdos.class, cerdoDto.getId());
                if (cerdo == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el cerdo especificado", "eliminarCerdo NoResultException");
                }
                em.remove(cerdo);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el cerdo especificado", "eliminarCerdo NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el producto pedido", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el producto pedido", "eliminarCerdo " + e.getMessage());
        }
    }
}
