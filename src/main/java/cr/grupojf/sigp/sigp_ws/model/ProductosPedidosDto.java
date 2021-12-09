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
    private Integer cantidad;
    private ProductosDto producto;

    public ProductosPedidosDto(Integer cantidad, Productos producto) {
        this.cantidad = cantidad;
        if (producto != null) {
            this.producto = new ProductosDto(producto);
        }
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
    
    
}
