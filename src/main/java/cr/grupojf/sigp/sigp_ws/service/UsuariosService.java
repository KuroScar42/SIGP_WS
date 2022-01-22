/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.PermisoDto;
import cr.grupojf.sigp.sigp_ws.model.Permisos;
import cr.grupojf.sigp.sigp_ws.model.PersonasDto;
import cr.grupojf.sigp.sigp_ws.model.Roles;
import cr.grupojf.sigp.sigp_ws.model.RolesDto;
import cr.grupojf.sigp.sigp_ws.model.UsuarioDto;
import cr.grupojf.sigp.sigp_ws.model.Usuarios;
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
 * @author sigp
 */
@Stateless
@LocalBean
public class UsuariosService {
    
    private static final Logger LOG = Logger.getLogger(UsuariosService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    public Respuesta getUsuByNomContra(String nombre, String contrasenia) {
        try {
            Query query = em.createNamedQuery("Usuarios.findByNombreUsuarioContrasenia", Usuarios.class);
            query.setParameter("nombreUsuario", nombre);
            query.setParameter("contrasennaUsuario", contrasenia);
            UsuarioDto usuario = new UsuarioDto((Usuarios) query.getSingleResult());

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "usuario", usuario);
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe el usuario con las credeciales especificadas","getUsuByNomContra" + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario", "getUsuByNomContra " + ex.getMessage());
        }
    }
    
    public Respuesta getAllUsuarios() {
        try {
            Query query = em.createNamedQuery("Usuarios.findAll", Usuarios.class);
            List<Usuarios> usuarios = query.getResultList();
            List<UsuarioDto> usuariosDtoList = new ArrayList<>();

            for (Usuarios usuario : usuarios) {
                usuariosDtoList.add(new UsuarioDto(usuario));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "usuarios", usuariosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los usuarios del sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los usuarios del sistema.", "getAllUsuarios " + ex.getMessage());
        }
    }

    public Respuesta getAllPermisos() {
        try {
            Query query = em.createNamedQuery("Permisos.findAllActive", Permisos.class);
            List<Permisos> permisos = query.getResultList();
            List<PermisoDto> permisosDtoList = new ArrayList<>();

            for (Permisos permiso : permisos) {
                permisosDtoList.add(new PermisoDto(permiso));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "permisos", permisosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los usuarios del sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los usuarios del sistema.", "getAllUsuarios " + ex.getMessage());
        }
    }
    
    public Respuesta guardarPedido(RolesDto rolDto) {
        try {
            Roles rol;
            if (rolDto.getId() != null && rolDto.getId() > 0) {
                rol = em.find(Roles.class, rolDto.getId());
                if (rol == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el pedido especificado", "Pedidos NoResultException");
                }
                rol.actualizar(rolDto);
                rol = em.merge(rol);
            } else {
                rol = new Roles(rolDto);
//                pedido.setAreaId(em.getReference(Area.class, pedidoDto.getArea().getId()));
                em.persist(rol);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Pedido", new RolesDto(rol));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar los pedidos.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar los pedidos.", "guardarPedido " + e.getMessage());
        }
    }
    
}
