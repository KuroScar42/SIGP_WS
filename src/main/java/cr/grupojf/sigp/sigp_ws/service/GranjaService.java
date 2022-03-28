/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Cerdos;
import cr.grupojf.sigp.sigp_ws.model.CerdosDto;
import cr.grupojf.sigp.sigp_ws.model.Embarazos;
import cr.grupojf.sigp.sigp_ws.model.EmbarazosDto;
import cr.grupojf.sigp.sigp_ws.model.Inseminacion;
import cr.grupojf.sigp.sigp_ws.model.InseminacionDto;
import cr.grupojf.sigp.sigp_ws.model.Partos;
import cr.grupojf.sigp.sigp_ws.model.PartosDto;
import cr.grupojf.sigp.sigp_ws.model.SaveCerdo;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
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

    public Respuesta guardarCerdo(SaveCerdo saveCerdo) {
        try {
            Cerdos cerdo;
            if (saveCerdo.getCerdo().getId() != null && saveCerdo.getCerdo().getId() > 0) {
                cerdo = em.find(Cerdos.class, saveCerdo.getCerdo().getId());
                if (cerdo == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el cerdo especificado", "Cerdos NoResultException");
                }
                cerdo.actualizar(saveCerdo.getCerdo());
                cerdo = em.merge(cerdo);
            } else {
                cerdo = new Cerdos(saveCerdo.getCerdo());
                em.persist(cerdo);
            }

//            guardar las inseminaciones aqui
            for (InseminacionDto i : saveCerdo.getInseminaciones()) {
                i.setCerdo(new CerdosDto(em.getReference(Cerdos.class, cerdo.getIdCerdo())));
                guardarInseminacion(i);
            }
//            guardar los embarazos aqui
            for (EmbarazosDto e : saveCerdo.getEmbarazos()) {
                e.setCerdo(new CerdosDto(em.getReference(Cerdos.class, cerdo.getIdCerdo())));
//                e.setPartoDto(partoDto);
                Respuesta res = guardarEmbarazos(e);
                if (res.getEstado()) {
                    EmbarazosDto em = (EmbarazosDto) res.getResultado();
                    if (e.getPartoDto() != null) {
                        e.getPartoDto().setEmbarazo(em);
                        guardarPartos(em.getPartoDto());
                    }
                }
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "cerdo", new CerdosDto(cerdo));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el cerdo.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar cerdo.", "guardarCerdo " + e.getMessage());
        }
    }

    public Respuesta guardarInseminacion(InseminacionDto inseminacionDto) {
        try {
            Inseminacion inseminacion;
            if (inseminacionDto.getId() != null && inseminacionDto.getId() > 0) {
                inseminacion = em.find(Inseminacion.class, inseminacionDto.getId());
                if (inseminacion == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "", "Inseminacion NoResultException");
                }
                inseminacion.actualizar(inseminacionDto);
                inseminacion = em.merge(inseminacion);
            } else {
                inseminacion = new Inseminacion(inseminacionDto);
                em.persist(inseminacion);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "ins", new InseminacionDto(inseminacion));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la inseminacion.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la inseminacion.", "guardarInseminacion " + e.getMessage());
        }
    }

    public Respuesta guardarEmbarazos(EmbarazosDto embarazoDto) {
        try {
            Embarazos embarazo;
            if (embarazoDto.getId() != null && embarazoDto.getId() > 0) {
                embarazo = em.find(Embarazos.class, embarazoDto.getId());
                if (embarazo == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "", "Embarazo NoResultException");
                }
                embarazo.actualizar(embarazoDto);
                embarazo = em.merge(embarazo);
            } else {
                embarazo = new Embarazos(embarazoDto);
                em.persist(embarazo);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", new EmbarazosDto(embarazo));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el embarazo.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el embarazo.", "guardarEmbarazo " + e.getMessage());
        }
    }

    public Respuesta guardarPartos(PartosDto partoDto) {
        try {
            Partos parto;
            if (partoDto.getEmbarazo() != null) {
                if (partoDto.getId() != null && partoDto.getId() > 0) {
                    parto = em.find(Partos.class, partoDto.getId());
                    if (parto == null) {
                        return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "", "Parto NoResultException");
                    }
                    parto.actualizar(partoDto);
                    parto.setIdEmbarazo(new Embarazos(partoDto.getEmbarazo()));
                    parto = em.merge(parto);
                } else {
                    parto = new Partos(partoDto);
                    parto.setIdEmbarazo(new Embarazos(partoDto.getEmbarazo()));
                    em.persist(parto);
                }
                em.flush();
                return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", new PartosDto(parto));
            } else{
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se puede guardar un parto sin embarazo", "Embarazo no existe");
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el parto.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el parto.", "guardarParto " + e.getMessage());
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

    public Respuesta getCerdo(String codigo) {
        try {
            Query query = em.createNamedQuery("Cerdos.findByCodigoCerdo", Cerdos.class);
            query.setParameter("codigoCerdo", codigo);
            Cerdos cliente = (Cerdos) query.getSingleResult();
            CerdosDto clienteDto = new CerdosDto(cliente);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "cerdo", clienteDto);
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "No existe el cerdo con codigo '" + codigo, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe el cerdo con codigo '" + codigo + "'", "getCerdo " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el cerdo", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el cerdo", "getCerdo " + ex.getMessage());
        }
    }
    public Respuesta getAllCerdo(){
        return null;
    }
}
