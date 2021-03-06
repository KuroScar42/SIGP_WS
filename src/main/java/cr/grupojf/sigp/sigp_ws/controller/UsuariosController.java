/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.PermisoDto;
import cr.grupojf.sigp.sigp_ws.model.PersonasDto;
import cr.grupojf.sigp.sigp_ws.model.RolesDto;
import cr.grupojf.sigp.sigp_ws.model.UsuarioDto;
import cr.grupojf.sigp.sigp_ws.service.UsuariosService;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sigp
 */
@Path("/UsuariosController")
public class UsuariosController {
    @EJB
    private UsuariosService service;
    
    @POST
    @Path("/verifyUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsuByNombreContra(UsuarioDto usuarioDto) {
        try {
            Respuesta respuesta = service.getUsuByNomContra(usuarioDto.getNombreUsuario(),usuarioDto.getContrasena());
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            UsuarioDto usuario = (UsuarioDto) respuesta.getResultado("usuario");
            return Response.ok(usuario).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar el usuario").build();
        }
    }
    
    @GET
    @Path("/getAllUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllUsuarios() {
        try {
            Respuesta respuesta = service.getAllUsuarios();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("usuarios");
            return Response.ok(new GenericEntity<List<UsuarioDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los usuarios").build();
        }
    }
    
    @GET
    @Path("/getAllPermisos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllPermisos() {
        try {
            Respuesta respuesta = service.getAllPermisos();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("permisos");
            return Response.ok(new GenericEntity<List<PermisoDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los permisos").build();
        }
    }
    
    
    @POST
    @Path("/guardarRoles")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarRoles(RolesDto rolDto) {
        try {
            Respuesta respuesta = service.guardarRoles(rolDto);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            RolesDto rol = (RolesDto) respuesta.getResultado("rol");
            return Response.ok(rol).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar el Rol").build();
        }
    }
    
    @GET
    @Path("/getAllRoles")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRoles() {
        try {
            Respuesta respuesta = service.getAllRoles();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("roles");
            return Response.ok(new GenericEntity<List<RolesDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los roles").build();
        }
    }
    @GET
    @Path("/getAllRolesActivos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllRolesActivos() {
        try {
            Respuesta respuesta = service.getAllRolesActivos();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("roles");
            return Response.ok(new GenericEntity<List<RolesDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los roles").build();
        }
    }
    
    @POST
    @Path("/guardarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarUsuario(UsuarioDto usuarioDto) {
        try {
            Respuesta respuesta = service.guardarUsuario(usuarioDto);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            UsuarioDto usu = (UsuarioDto) respuesta.getResultado("usuario");
            return Response.ok(usu).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al guardar el usuario").build();
        }
    }
    
    @GET
    @Path("/getPersonaByCedula/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonaByCedula(@PathParam("cedula")String cedula) {
        try {
            Respuesta respuesta = service.getPersonaByCedula(cedula);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            PersonasDto persona = (PersonasDto) respuesta.getResultado("persona");
            return Response.ok(persona).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar la persona").build();
        }
    }
    @GET
    @Path("/getRolByUsuario/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRolByUsuario(@PathParam("idUsuario")Integer idUsuario) {
        try {
            Respuesta respuesta = service.getRolByUsuario(idUsuario);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            RolesDto rolDto = (RolesDto) respuesta.getResultado("rol");
            return Response.ok(rolDto).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar el rol").build();
        }
    }
}
