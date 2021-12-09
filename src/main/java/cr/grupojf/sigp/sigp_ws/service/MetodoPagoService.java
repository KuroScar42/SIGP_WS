/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.MetodosPago;
import cr.grupojf.sigp.sigp_ws.model.MetodosPagoDto;
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
 * @author sigp
 */
@Stateless
@LocalBean
public class MetodoPagoService {
    private static final Logger LOG = Logger.getLogger(MetodoPagoService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    public Respuesta getMetodosPago() {
        try {
            Query q = em.createNamedQuery("MetodosPago.findAll", MetodosPago.class);

            List<MetodosPago> metodos = q.getResultList();
            List<MetodosPagoDto> metodoDtos = new ArrayList<>();

            for (MetodosPago metodo : metodos) {
                metodoDtos.add(new MetodosPagoDto(metodo));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "metodosPago", metodoDtos);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los metodos de pago.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los metodos de pago.", "getMetodosPago " + ex.getMessage());
        }
    }
}
