/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.MetodosPagoDto;
import cr.grupojf.sigp.sigp_ws.service.MetodoPagoService;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sigp
 */
@Path("/MetodoPagoController")
public class MetodoPagoController {
    @EJB
    MetodoPagoService metodoPagoService;
    
    @GET
    @Path("/getMetodosPago")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getActividades() {
        try {
            Respuesta respuesta = metodoPagoService.getMetodosPago();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("metodosPago");
            return Response.ok(new GenericEntity<List<MetodosPagoDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los metodos de pago").build();
        }
    }
    
    @Path("/ping")
    public Response ping(){
        
        return Response.ok().build();
        
    }
}
