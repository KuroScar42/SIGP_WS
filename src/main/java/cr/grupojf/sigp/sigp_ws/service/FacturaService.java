/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Facturas;
import cr.grupojf.sigp.sigp_ws.model.FacturasDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sigp
 */
public class FacturaService {
    private static final Logger LOG = Logger.getLogger(FacturaService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    
    public Respuesta guardarFactura(FacturasDto facturasDto){
        try {
            Facturas factura;
            Respuesta resp = null;
            if (facturasDto.getId() != null && facturasDto.getId() > 0) {
                factura = em.find(Facturas.class, facturasDto.getId());
                if(factura == null){
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro la Factura especificada", "Factura NoResultException");
                }
                factura.actualizarFactura(facturasDto);
                factura = em.merge(factura);
                
                return resp;
            }else {
                factura = new Facturas(facturasDto);
                em.persist(factura);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "factura", new FacturasDto(factura));
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                if (((SQLException)ex.getCause().getCause()).getErrorCode() == 1062) {
                    
                    if (((SQLException)ex.getCause().getCause()).getMessage().contains("FACTURA")) {
                        LOG.log(Level.SEVERE, "La Factura " + facturasDto.getReferencia()+ " ya esta ingresada.", ex);
                        return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "La Factura " + facturasDto.getReferencia() + " ya esta ingresada.", "guardarFactura " + ex.getMessage());
                    }
                  }
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Violacion a la integridad de los datos", "guardarFactura " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la Factura", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la Factura", "guardarFactura " + ex.getMessage());
        }
    }
    
    
}
