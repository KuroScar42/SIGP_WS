/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.CerdosDto;
import cr.grupojf.sigp.sigp_ws.service.GranjaService;
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
 * @author herna
 */
@Path("/GranjaController")
public class GranjaController {

    @EJB
    private GranjaService service;

    @GET
    @Path("/getCerdos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCerdos() {
        try {
            Respuesta respuesta = service.getCerdos();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("cerdos");
            return Response.ok(new GenericEntity<List<CerdosDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(GranjaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los cerdos").build();
        }
    }

    @POST
    @Path("/guardarCerdo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarCerdos(CerdosDto ped) {
        try {
            Respuesta respuesta = service.guardarCerdo(ped);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((CerdosDto) respuesta.getResultado("cerdo")).build();
        } catch (Exception ex) {
            Logger.getLogger(GranjaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al guardar el cerdo").build();
        }
    }

    @GET
    @Path("/getCerdo/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCerdo(@PathParam("codigo") String codigo) {
        try {
            Respuesta respuesta = service.getCerdo(codigo);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            CerdosDto cerdo = (CerdosDto) respuesta.getResultado("cerdo");
            return Response.ok(cerdo).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar el cerdo").build();
        }
    }
}
