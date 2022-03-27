/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.AperturaCajas;
import cr.grupojf.sigp.sigp_ws.model.AperturaCajasDto;
import cr.grupojf.sigp.sigp_ws.model.CierresCajas;
import cr.grupojf.sigp.sigp_ws.model.CierresCajasDto;
import cr.grupojf.sigp.sigp_ws.model.FacturasDto;
import cr.grupojf.sigp.sigp_ws.model.Usuarios;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
                caja.setIdUsuario(em.find(Usuarios.class, cajaDto.getUsuario()));
                em.persist(caja);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "caja", new AperturaCajasDto(caja));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la apertura de caja.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la apertura de caja.", "abrirCaja " + e.getMessage());
        }
    }

    public Respuesta getAperturaCaja(String numCaja, Date fecha) {
        try {
            Query query = em.createNamedQuery("AperturaCajas.findByNumCaja", AperturaCajas.class);
            query.setParameter("numCaja", numCaja);
            List<AperturaCajas> list = query.setMaxResults(1).getResultList();
            if (list != null) {
                AperturaCajas aperturaCaja = list.get(0);
                AperturaCajasDto acDto = new AperturaCajasDto(aperturaCaja);
                if (isSameDate(LocalDateAdapter.adaptFromJson(acDto.getFecha()),fecha)) {

                    return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "caja", acDto);
                } else {
                    return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe una apertura de caja'", "getAperturaCaja");
                }
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe una apertura de caja'", "getAperturaCaja");
            }

        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "No existe una apertura de caja'", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe una apertura de caja'", "getAperturaCaja " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la apertura de caja", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la apertura de caja", "getAperturaCaja " + ex.getMessage());
        }
    }

    private LocalDate dateToLocalDate(Date date) {
        ZoneId defaultZoneId = ZoneId.systemDefault();

        //Converting the date to Instant
        Instant instant = date.toInstant();

        //Converting the Date to LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        return localDate;
    }
    
    private boolean isSameDate(Date d1, Date d2){
        LocalDate ld1 = dateToLocalDate(d1);
        LocalDate ld2 = dateToLocalDate(d2);
        return ld1.compareTo(ld2) == 0;
    }

    public Respuesta nuevoCorte(CierresCajasDto cierreDto) {
        try {
            CierresCajas caja;
            if (cierreDto.getId() != null && cierreDto.getId() > 0) {
                caja = em.find(CierresCajas.class, cierreDto.getId());
            } else {
                caja = new CierresCajas(cierreDto);
                Float montoFactura = getMontoFacturado(cierreDto.getApertura().getNumCaja(), LocalDateAdapter.adaptFromJson(cierreDto.getApertura().getFecha()));
                Float montoCorte = getCorteTotal(cierreDto.getApertura().getNumCaja(), LocalDateAdapter.adaptFromJson(cierreDto.getApertura().getFecha()));
                caja.getIdEfectivo().setTotalEfectivo((montoFactura - montoCorte));
                em.persist(caja);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "caja", new CierresCajasDto(caja));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el corte/cierre de caja.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el corte/Cierre de caja.", "nuevoCorte " + e.getMessage());
        }
    }

    private Float getMontoFacturado(String numCaja, Date fecha) {

        Float total = 0f;
        try {
            Query query = em.createNamedQuery("Facturas.getMontoTotalPerDay", Long.class);
            query.setParameter("fecha", fecha);
            query.setParameter("numCaja", numCaja);
            query.setParameter("metodo", "EF"); // EF = Efectivo

            total = (Float) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.log(Level.SEVERE, "No se encuentran registros de facturado.", e);
            return 0f;
        } catch (Exception e) {
            return 0f;
        }

        return total;
    }

    private Float getCorteTotal(String numCaja, Date fecha) {

        Float total = 0f;
        try {
            Query query = em.createNamedQuery("Facturas.getCorteTotalPerDay", Long.class);
            query.setParameter("fecha", fecha);
            query.setParameter("numCaja", numCaja);

            total = (Float) query.getSingleResult();
        } catch (NoResultException e) {
            LOG.log(Level.SEVERE, "No se encuentran registros de cortes.", e);
            return 0f;
        } catch (Exception e) {
            return 0f;
        }

        return total;
    }

    private Respuesta guardarFactura(FacturasDto factura) {
        return null;
    }

}
