/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Pedidos;
import cr.grupojf.sigp.sigp_ws.model.PedidosDto;
import cr.grupojf.sigp.sigp_ws.model.Productos;
import cr.grupojf.sigp.sigp_ws.model.ProductosPedidosDto;
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
    
    // obtiene todos los productos que estan sujetos a un pedido
    public Respuesta getProductosByPedidos(Integer pedidoId){
        try {
            Query query = em.createNamedQuery("Productos.findProductoByPedido", Productos.class);
            query.setParameter("pedidoId", pedidoId);
            List<Object[]> productos = query.getResultList();
            List<ProductosPedidosDto> productosDtoList = new ArrayList<>();

            for (Object[] producto : productos) {
                productosDtoList.add(new ProductosPedidosDto((Integer) producto[1],(Productos)producto[0]));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "productos", productosDtoList);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los productos del pedido.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los productos del pedido.", "getProductosByPedidos " + ex.getMessage());
        }
    }
}
