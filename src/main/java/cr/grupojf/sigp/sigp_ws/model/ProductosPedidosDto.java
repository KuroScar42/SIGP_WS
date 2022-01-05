/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
// servira como el detalle del pedido
public class ProductosPedidosDto {
    private Integer id;
    private Integer cantidad;
    private ProductosDto producto;
    private PedidosDto pedido;

    public ProductosPedidosDto(ProductosPedidos productoP, Productos producto,Pedidos pedido) {
        this(productoP);
        if (producto != null) {
            this.producto = new ProductosDto(producto);
        }
        if (pedido != null) {
            this.pedido = new PedidosDto(pedido);
        }
    }
    
    public ProductosPedidosDto(ProductosPedidos p){
        this.id = p.getIdProductosPedidos();
        this.cantidad = p.getCantidad();
        if (producto != null) {
            this.producto = new ProductosDto(p.getIdProducto());
        }
        if (pedido != null) {
            this.pedido = new PedidosDto(p.getIdPedidos());
        }
    }

    public ProductosPedidosDto() {
    }
    

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductosDto getProducto() {
        return producto;
    }

    public void setProducto(ProductosDto producto) {
        this.producto = producto;
    }

    public PedidosDto getPedido() {
        return pedido;
    }

    public void setPedido(PedidosDto pedido) {
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
}
