/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.ClientesDto;
import cr.grupojf.sigp.sigp_ws.model.FacturasDto;
import cr.grupojf.sigp.sigp_ws.model.PersonasDto;
import cr.grupojf.sigp.sigp_ws.service.ClienteService;
import cr.grupojf.sigp.sigp_ws.service.FacturaService;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author herna
 */
@Path("/FacturaController")
public class FacturaController {
    @EJB
    private FacturaService service;
    
    
    @POST
    @Path("/guardarFactura")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarFactura(FacturasDto facturaDto) {
        try {
            Respuesta respuesta = service.guardarFactura(facturaDto);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((ClientesDto) respuesta.getResultado("factura")).build();
        }catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al guarda la factura").build();
        }
    }
    
    @GET
    @Path("/getFacturas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        try {
            Respuesta respuesta = service.getFacturas();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado();
            return Response.ok(new GenericEntity<List<FacturasDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar las facturas").build();
        }
    }
    
    /*@GET
    @Path("/getfactura")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        try {
            Respuesta respuesta = service.getClientes();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("clientes");
            return Response.ok(new GenericEntity<List<ClientesDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los clientes").build();
        }
    }
    
    @GET
    @Path("/getClienteByCedula/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getClienteByCedula(@PathParam("cedula") String cedula) {
        try {
            Respuesta respuesta = service.getClienteByCedula(cedula);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            ClientesDto cliente = (ClientesDto) respuesta.getResultado("cliente");
            return Response.ok(cliente).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar el cliente").build();
        }
    }
    @GET
    @Path("/getPersonaByCedula/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonaByCedula(@PathParam("cedula") String cedula) {
        try {
            Respuesta respuesta = service.getPersonaByCedula(cedula);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            PersonasDto persona = (PersonasDto) respuesta.getResultado();
            return Response.ok(persona).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar la persona").build();
        }
    }*/
}
