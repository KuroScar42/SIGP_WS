/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.BodegaDto;
import cr.grupojf.sigp.sigp_ws.model.Bodegas;
import cr.grupojf.sigp.sigp_ws.model.BodegasProductos;
import cr.grupojf.sigp.sigp_ws.model.Pedidos;
import cr.grupojf.sigp.sigp_ws.model.PedidosDto;
import cr.grupojf.sigp.sigp_ws.model.ProductosDto;
import cr.grupojf.sigp.sigp_ws.model.Productos;
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
public class ProductosService {

    private static final Logger LOG = Logger.getLogger(MetodoPagoService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;

    public Respuesta getProductosByBodega(Integer bodegaId) {
        try {
            Query query = em.createNamedQuery("Productos.findProductosByBodega", Bodegas.class);
            query.setParameter("idBodega", bodegaId);
            List<Productos> productos = query.getResultList();
            List<ProductosDto> productosDtoList = new ArrayList<>();

            for (Productos producto : productos) {
                productosDtoList.add(new ProductosDto(producto));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProductosByBodega " + ex.getMessage());
        }
    }
    
    public Respuesta getProductosByBodegaCompl(Integer bodegaId) {
        try {
            Query query = em.createNamedQuery("Productos.findProductosByBodegaComplete", Bodegas.class);
            query.setParameter("idBodega", bodegaId);
            
            List<Object[]> productos = query.getResultList();
            List<ProductosDto> productosDtoList = new ArrayList<>();

            for (Object[] producto : productos) {
                productosDtoList.add(new ProductosDto((Productos)producto[0],(BodegasProductos)producto[1]));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProductosByBodega " + ex.getMessage());
        }
    }

    public Respuesta getProductoByBodega(Integer bodegaId, String codigoProd) {
        try {
            Query query = em.createNamedQuery("Productos.findProductoByBodega", Productos.class);
            query.setParameter("idBodega", bodegaId);
            query.setParameter("codigo", codigoProd);
            Object[] resultado = (Object[]) query.getSingleResult();
            ProductosDto productoDto = new ProductosDto((Productos) resultado[0],(BodegasProductos) resultado[1]);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "producto", productoDto);
//return null;
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe el producto con el codigo '" + codigoProd + "' en la bodega consultada.", "getProducByIds " + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del inventario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del inventario.", "getProducByIds " + ex.getMessage());
        }
    }

    public Respuesta getBodegas() {
        try {
            Query query = em.createNamedQuery("Bodegas.findAllActives", Bodegas.class);
            List<Bodegas> bodegas = query.getResultList();
            List<BodegaDto> bodegasDto = new ArrayList<>();

            for (Bodegas bodega : bodegas) {
                bodegasDto.add(new BodegaDto(bodega));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "bodegas", bodegasDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los inventarios.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los inventarios.", "getBodegas " + ex.getMessage());
        }
    }
    
}
