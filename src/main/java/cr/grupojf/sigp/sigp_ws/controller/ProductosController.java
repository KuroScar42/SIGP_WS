/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.model.BodegaDto;
import cr.grupojf.sigp.sigp_ws.model.MoveProductDto;
import cr.grupojf.sigp.sigp_ws.model.ProductosDto;
import cr.grupojf.sigp.sigp_ws.service.MetodoPagoService;
import cr.grupojf.sigp.sigp_ws.service.ProductosService;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/ProductosController")
public class ProductosController {
    @EJB
    private ProductosService service;
    
    
    
    @POST
    @Path("/guardarProducto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarProducto(ProductosDto productoDto) {
        try {
            Respuesta respuesta = service.guardarProducto(productoDto);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((ProductosDto) respuesta.getResultado("producto")).build();
        }catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al guardar el producto").build();
        }
    }
    
    @PUT
    @Path("/moveProduct")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response moveProduct(MoveProductDto m) {
        try {
            Respuesta respuesta = service.moveProduct(m);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok().build();
        }catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al mover el producto de bodega").build();
        }
    }
    
    @GET
    @Path("/getProductosByBodega/{bodegaId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProductosByBodega(@PathParam("bodegaId") Integer bodegaId) {
        try {
            Respuesta respuesta = service.getProductosByBodega(bodegaId);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("productos");
            return Response.ok(new GenericEntity<List<ProductosDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los productos").build();
        }
    }
    
    @GET
    @Path("/getProductosByBodegaCompl/{bodegaId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProductosByBodegaCompl(@PathParam("bodegaId") Integer bodegaId) {
        try {
            Respuesta respuesta = service.getProductosByBodegaCompl(bodegaId);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("productos");
            return Response.ok(new GenericEntity<List<ProductosDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los productos").build();
        }
    }
    
    /**
     * SR significa "Sin restricciones"
    */
    @GET
    @Path("/getProductosByBodegaComplSR/{bodegaId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProductosByBodegaComplSR(@PathParam("bodegaId") Integer bodegaId) {
        try {
            Respuesta respuesta = service.getProductosByBodegaComplSR(bodegaId);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("productos");
            return Response.ok(new GenericEntity<List<ProductosDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar los productos").build();
        }
    }
    
    
    
    @GET
    @Path("/getProductByCode/{bodegaId}/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProductoByBodega(@PathParam("bodegaId")Integer bodegaId, @PathParam("codigo")String codigo) {
        try {
            Respuesta respuesta = service.getProductoByBodega(bodegaId,codigo);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            ProductosDto producto = (ProductosDto) respuesta.getResultado("producto");
            return Response.ok(producto).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar el producto").build();
        }
    }
    
    @GET
    @Path("/getBodegas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBodegas() {
        try {
            Respuesta respuesta = service.getBodegas();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            List resultado = (List) respuesta.getResultado("bodegas");
            return Response.ok(new GenericEntity<List<BodegaDto>>(resultado) {
            }).build();
        } catch (Exception ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al consultar las bodegas").build();
        }
    }
    
    @POST
    @Path("moveProduct")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response moveProduct(){
        return null;
    }
}
