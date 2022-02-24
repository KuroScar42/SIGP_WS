/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Proveedores;
import cr.grupojf.sigp.sigp_ws.model.ProveedoresDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
public class ProveedoresService {
    private static final Logger LOG = Logger.getLogger(ProveedoresService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    public Respuesta getProveedores() {
        try {
            Query query = em.createNamedQuery("Proveedores.findAll", Proveedores.class);
            List<Proveedores> proveedores = query.getResultList();
            List<ProveedoresDto> proveedoresDtoList = new ArrayList<>();

            for (Proveedores proveedor : proveedores) {
                proveedoresDtoList.add(new ProveedoresDto(proveedor));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "proveedores", proveedoresDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los proveedores.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los proveedores.", "getProveedores " + ex.getMessage());
        }
    }
    public Respuesta getProveedoresActivos() {
        try {
            Query query = em.createNamedQuery("Proveedores.findAllActivos", Proveedores.class);
            List<Proveedores> proveedores = query.getResultList();
            List<ProveedoresDto> proveedoresDtoList = new ArrayList<>();

            for (Proveedores proveedor : proveedores) {
                proveedoresDtoList.add(new ProveedoresDto(proveedor));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "proveedores", proveedoresDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los proveedores.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los proveedores.", "getProveedores " + ex.getMessage());
        }
    }
    
    public Respuesta guardarProveedor(ProveedoresDto p) {
        try {
            Proveedores proveedor;
            if (p.getId() != null && p.getId() > 0) {
                proveedor = em.find(Proveedores.class, p.getId());
                if (proveedor == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el proveedor especificado", "Proveedor NoResultException");
                }
                proveedor.actualizarProveedor(p);
                proveedor = em.merge(proveedor);
            } else {
                proveedor = new Proveedores(p);
                em.persist(proveedor);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "proveedor", new ProveedoresDto(proveedor));
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                if (((SQLException)ex.getCause().getCause()).getErrorCode() == 1062) {
                    
                    if (((SQLException)ex.getCause().getCause()).getMessage().contains("CEDULA")) {
                        LOG.log(Level.SEVERE, "La cedula" + p.getCedula() + " ya esta ingresada.", ex);
                        return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "La cedula " + p.getCedula() + " ya esta ingresada.", "guardarProveedor " + ex.getMessage());
                    }
                  }
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Violacion a la integridad de los datos", "guardarPersona " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el proveedor", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el proveedor", "guardarProveedor " + ex.getMessage());
        }
    }
}
