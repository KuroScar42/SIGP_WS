/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.PermisoDto;
import cr.grupojf.sigp.sigp_ws.model.Permisos;
import cr.grupojf.sigp.sigp_ws.model.Personas;
import cr.grupojf.sigp.sigp_ws.model.PersonasDto;
import cr.grupojf.sigp.sigp_ws.model.Roles;
import cr.grupojf.sigp.sigp_ws.model.RolesDto;
import cr.grupojf.sigp.sigp_ws.model.UsuarioDto;
import cr.grupojf.sigp.sigp_ws.model.Usuarios;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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

    @EJB
    private ClienteService cs;

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
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe el usuario con las credeciales especificadas", "getUsuByNomContra" + ex.getMessage());
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

    public Respuesta guardarRoles(RolesDto rolDto) {
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
                em.persist(rol);
            }
            em.flush();
            List<Permisos> permisos = new ArrayList<>();
            rol.getPermisosList().clear();
            // eliminando los registros para volver a guardarlos
            eliminarAllPermisosForOneRol(rol.getIdRol());
            for (PermisoDto permisoDto : rolDto.getPermisos()) {
                Permisos p = em.find(Permisos.class, permisoDto.getId());
                em.refresh(p);
                rol.getPermisosList().add(p);
                // consultar todos los registros con el rolId en PermisosRoles y eliminarlos y luego guardarlos de nuevo
                final Integer rolId = rol.getIdRol();
                if (!p.getRolesList().stream().filter(e -> Objects.equals(e.getIdRol(), rolId)).findAny().isPresent()) {
                    p.getRolesList().add(rol);
                }
                permisos.add(p);
            }

            for (Permisos permiso : permisos) {
                em.merge(permiso);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "rol", new RolesDto(rol));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar los Roles.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar los Roles.", "guardarRoles " + e.getMessage());
        }
    }

    private void eliminarAllPermisosForOneRol(Integer rolId) {
        // hacer consulta y eliminar 
        em
                .createNativeQuery("DELETE FROM Role_Permiso WHERE ID_ROL = " + rolId)
                .executeUpdate();
        em.flush();
    }

    public Respuesta getAllRoles() {
        try {
            Query query = em.createNamedQuery("Roles.findAll", Roles.class);
            List<Roles> roles = query.getResultList();
            List<RolesDto> rolesDto = new ArrayList<>();

            for (Roles rol : roles) {
                rolesDto.add(new RolesDto(rol));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "roles", rolesDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los roles del sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los roles del sistema.", "getAllUsuarios " + ex.getMessage());
        }
    }
    public Respuesta getAllRolesActivos() {
        try {
            Query query = em.createNamedQuery("Roles.findAllActivos", Roles.class);
            List<Roles> roles = query.getResultList();
            List<RolesDto> rolesDto = new ArrayList<>();

            for (Roles rol : roles) {
                rolesDto.add(new RolesDto(rol));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "roles", rolesDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los roles del sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los roles del sistema.", "getAllUsuarios " + ex.getMessage());
        }
    }

    public Respuesta guardarUsuario(UsuarioDto usuarioDto) {
        try {
            Usuarios usuario;
            Respuesta resp = null;
            if (usuarioDto.getId() != null && usuarioDto.getId() > 0) {
                usuario = em.find(Usuarios.class, usuarioDto.getId());
                if (usuario == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el usuario especificado", "Usuarios NoResultException");
                }
                if (usuarioDto.getPersona() != null) {
                    resp = cs.guardarPersona(usuarioDto.getPersona());
                    if (!resp.getEstado()) {
                        throw new Exception("Ocurrio un error al guardar la persona del usuario.");
                    }
                }
                usuario.actualizarUsuario(usuarioDto);
                usuario = em.merge(usuario);
            } else {
                
                if (usuarioDto.getPersona() != null) {
                    resp = cs.guardarPersona(usuarioDto.getPersona());
                    if (!resp.getEstado()) {
                        throw new Exception("Ocurrio un error al guardar la persona del usuario.");
                    }
                }
                usuario = new Usuarios(usuarioDto);
                usuario.setIdPersona(em.find(Personas.class, ((PersonasDto)resp.getResultado("persona")).getId()));
                em.persist(usuario);

            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "usuario", new UsuarioDto(usuario));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el usuario.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el usuario.", "guardarUsuario " + e.getMessage());
        }
    }

    public Respuesta getPersonaByCedula(String cedula) {
        try {
            Query query = em.createNamedQuery("Personas.findByCedulaPersona", Personas.class);
            query.setParameter("cedulaPersona", cedula);
            PersonasDto personaDto = new PersonasDto((Personas) query.getSingleResult());

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "persona", personaDto);
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "No existe la persona con cédula'" + cedula, ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe la persona con cédula '" + cedula, "getPersonaByCedula " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar la persona.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar la persona", "getPersonaByCedula " + ex.getMessage());
        }
    }

}
