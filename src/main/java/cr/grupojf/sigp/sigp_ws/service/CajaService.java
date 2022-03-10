/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.AperturaCajas;
import cr.grupojf.sigp.sigp_ws.model.AperturaCajasDto;
import cr.grupojf.sigp.sigp_ws.model.CierresCajas;
import cr.grupojf.sigp.sigp_ws.model.CierresCajasDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sigp
 */
@Stateless
@LocalBean
public class CajaService {
    private static final Logger LOG = Logger.getLogger(CajaService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    
    public Respuesta abrirCaja(AperturaCajasDto cajaDto) {
        try {
            AperturaCajas caja;
            if (cajaDto.getId() != null && cajaDto.getId() > 0) {
                caja = em.find(AperturaCajas.class, cajaDto.getId());
                if (caja == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro la caja especificada", "abrirCaja NoResultException");
                }
                caja.actualizar(cajaDto);
                caja = em.merge(caja);
            } else {
                caja = new AperturaCajas(cajaDto);
                em.persist(caja);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "caja", new AperturaCajasDto(caja));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la apertura de caja.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la apertura de caja.", "abrirCaja " + e.getMessage());
        }
    }
    
    public Respuesta getAperturaCaja(String numCaja,Date fecha) {
        try {
            Query query = em.createNamedQuery("Cerdos.findByCodigoCerdo", AperturaCajas.class);
            query.setParameter("numCaja", numCaja);
            query.setParameter("fecha", fecha);
            AperturaCajas aperturaCaja = (AperturaCajas) query.getSingleResult();
            AperturaCajasDto acDto = new AperturaCajasDto(aperturaCaja);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "isOpen", acDto);
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "No existe una apertura de caja'", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe una apertura de caja'", "getAperturaCaja " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la apertura de caja", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la apertura de caja", "getAperturaCaja " + ex.getMessage());
        }
    }
    
    public Respuesta nuevoCorte(CierresCajasDto cierreDto) {
        try {
            CierresCajas caja;
            if (cierreDto.getId() != null && cierreDto.getId() > 0) {
                caja = em.find(CierresCajas.class, cierreDto.getId());
//                if (caja == null) {
//                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro la caja especificada", "abrirCaja NoResultException");
//                }
//                caja.actualizar(cierreDto);
//                caja = em.merge(caja);
            } else {
                caja = new CierresCajas(cierreDto);
                em.persist(caja);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "caja", new CierresCajasDto(caja));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el corte/cierre de caja.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el corte/Cierre de caja.", "nuevoCorte " + e.getMessage());
        }
    }
}
