/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Pedidos;
import cr.grupojf.sigp.sigp_ws.model.PedidosDto;
import cr.grupojf.sigp.sigp_ws.model.Productos;
import cr.grupojf.sigp.sigp_ws.model.ProductosDto;
import cr.grupojf.sigp.sigp_ws.model.ProductosPedidos;
import cr.grupojf.sigp.sigp_ws.model.ProductosPedidosDto;
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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sigp
 */
@Stateless
@LocalBean
public class PedidosServices {

    private static final Logger LOG = Logger.getLogger(PedidosServices.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;

    public Respuesta getPedidos() {
        try {
            Query query = em.createNamedQuery("Pedidos.findAll", Pedidos.class);
            List<Pedidos> pedidos = query.getResultList();
            List<PedidosDto> pedidosDtoList = new ArrayList<>();

            for (Pedidos pedido : pedidos) {
                pedidosDtoList.add(new PedidosDto(pedido));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "pedidos", pedidosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los pedidos.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los pedidos.", "getPedidos " + ex.getMessage());
        }
    }

    /**
     * Obtiene todos los productos que estan sujetos a un pedido
     *
     */
    public Respuesta getProductosByPedidos(Integer pedidoId) {
        try {
            Query query = em.createNamedQuery("Productos.findProductoByPedido", Productos.class);
            query.setParameter("pedidoId", pedidoId);
            List<Object[]> productos = query.getResultList();
            List<ProductosPedidosDto> productosDtoList = new ArrayList<>();

            for (Object[] producto : productos) {
                ProductosPedidosDto pp = new ProductosPedidosDto((ProductosPedidos) producto[1], (Productos) producto[0], (Pedidos) producto[2]);
                pp.asignarBodega(((Productos) producto[0]).getBodegasProductosList());
                productosDtoList.add(pp);
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del pedido.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del pedido.", "getProductosByPedidos " + ex.getMessage());
        }
    }

    public Respuesta guardarPedido(PedidosDto pedidoDto) {
        try {
            Pedidos pedido;
            if (pedidoDto.getId() != null && pedidoDto.getId() > 0) {
                pedido = em.find(Pedidos.class, pedidoDto.getId());
                if (pedido == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el pedido especificado", "Pedidos NoResultException");
                }
                pedido.actualizarPedido(pedidoDto);
                pedido = em.merge(pedido);
            } else {
                pedido = new Pedidos(pedidoDto);
//                pedido.setAreaId(em.getReference(Area.class, pedidoDto.getArea().getId()));
                pedido.setIdUsuario(em.find(Usuarios.class, pedidoDto.getIdUsuario()));
                em.persist(pedido);
            }
            em.flush();
            if (pedidoDto.getProductosPedido() != null) {
                for (ProductosPedidosDto pp : pedidoDto.getProductosPedido()) {
                    pp.setProducto(new ProductosDto(em.getReference(Productos.class, pp.getProducto().getId())));
                    pp.setPedido(new PedidosDto(pedido));
                    guardarProductoPedido(pp);
                }
            }
            if (pedidoDto.getEliminados() != null) {
                for (ProductosPedidosDto pp : pedidoDto.getEliminados()) {
                    eliminarProductoPedido(pp);
                }
            }
            PedidosDto pDto = new PedidosDto(pedido);
            Respuesta res = getProductosByPedidos(pedido.getIdPedidos());
            if (res.getEstado()) {
                pDto.setProductosPedido((List<ProductosPedidosDto>) res.getResultado("productos"));
            }else{
                return res;
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Pedido", pDto);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar los pedidos.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar los pedidos.", "guardarPedido " + e.getMessage());
        }
    }

    public Respuesta guardarProductoPedido(ProductosPedidosDto pp) {
        try {
            ProductosPedidos productoPedido;
            if (pp.getId() != null && pp.getId() > 0) {
                productoPedido = em.find(ProductosPedidos.class, pp.getId());
                if (productoPedido == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el productoPedido especificado", "productoPedido NoResultException");
                }
                productoPedido.actualizarProductoPedido(pp);
                productoPedido = em.merge(productoPedido);
            } else {
                productoPedido = new ProductosPedidos(pp);
                em.persist(productoPedido);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productoPedido", new ProductosPedidosDto(productoPedido));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el producto pedido", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el producto pedido", "guardarProductoPedido " + e.getMessage());
        }
    }

    /**
     * Elimina el ProductoPedido a travez del id
     *
     */
    public Respuesta eliminarProductoPedido(ProductosPedidosDto pp) {
        try {
            ProductosPedidos productoPedido;
            if (pp.getId() != null && pp.getId() > 0) {
                productoPedido = em.find(ProductosPedidos.class, pp.getId());
                if (productoPedido == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el productoPedido especificado", "eliminarProductoPedido NoResultException");
                }
                em.remove(productoPedido);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el productoPedido especificado", "eliminarProductoPedido NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el producto pedido", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el producto pedido", "guardarProductoPedido " + e.getMessage());
        }
    }
}
