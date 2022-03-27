/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.AperturaCajasDto;
import cr.grupojf.sigp.sigp_ws.service.CajaService;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sigp
 */
@Path("/CajaController")
public class CajaController {
    
    @EJB
    private CajaService service;
    
    @POST
    @Path("/abrirCaja")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response abrirCaja(AperturaCajasDto ac) {
        try {
            Respuesta respuesta = service.abrirCaja(ac);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((AperturaCajasDto) respuesta.getResultado("caja")).build();
        } catch (Exception ex) {
            Logger.getLogger(GranjaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al intentar abrir la caja").build();
        }
    }
    
    @GET
    @Path("/getAperturaCaja/{numCaja}/{fecha}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAperturaCaja(@PathParam("numCaja") String numCaja,@PathParam("fecha") String fecha) {
        try {
            Respuesta respuesta = service.getAperturaCaja(numCaja,LocalDateAdapter.adaptFromJson(fecha));
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            AperturaCajasDto aperturaCaja = (AperturaCajasDto) respuesta.getResultado("caja");
            return Response.ok(aperturaCaja).build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar la caja").build();
        }
    }
}
