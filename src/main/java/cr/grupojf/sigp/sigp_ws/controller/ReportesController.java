package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.ReporteCajaDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteCerdaDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteGananciaDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteInventarioDto;
import cr.grupojf.sigp.sigp_ws.model.ReportePendienteDto;
import cr.grupojf.sigp.sigp_ws.service.ReportesService;
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
@Path("/ReportesController")
public class ReportesController {

    @EJB
    private ReportesService service;

    @GET
    @Path("/getReporteCajas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReporteCajas() {
        try {
            Respuesta respuesta = service.getReporteCajas();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado();
            return Response.ok(new GenericEntity<List<ReporteCajaDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar las cajas").build();
        }
    }

    @GET
    @Path("/getReporteCerdas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReporteCerdas() {
        try {
            Respuesta respuesta = service.getReporteCerdas();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado();
            return Response.ok(new GenericEntity<List<ReporteCerdaDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar las cerdas").build();
        }
    }

    @GET
    @Path("/getReporteGanancias")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReporteGanancias() {
        try {
            Respuesta respuesta = service.getReporteGanancias();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado();
            return Response.ok(new GenericEntity<List<ReporteGananciaDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar las ganancias").build();
        }
    }

    @GET
    @Path("/getReporteInventarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReporteInventarios() {
        try {
            Respuesta respuesta = service.getReporteInventarios();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado();
            return Response.ok(new GenericEntity<List<ReporteInventarioDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los inventarios").build();
        }
    }

    @GET
    @Path("/getReportePendientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReportePendientes() {
        try {
            Respuesta respuesta = service.getReportePendientes();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado();
            return Response.ok(new GenericEntity<List<ReportePendienteDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los pendientes").build();
        }
    }

}
