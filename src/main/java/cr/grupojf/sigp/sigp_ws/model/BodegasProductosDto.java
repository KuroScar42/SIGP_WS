/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class BodegasProductosDto {
    private Integer id;
    private BodegaDto bodega;
    private ProductosDto producto;
    private Float cantidad;
    private Float precio;
    private String unidadMedida;

    public BodegasProductosDto(BodegasProductos bp) {
        this.id = bp.getIdBodegaProductos();
        if (bp.getIdBodega() != null) {
            this.bodega = new BodegaDto(bp.getIdBodega());
        }
        if (bp.getIdProducto() != null) {
            this.producto = new ProductosDto(bp.getIdProducto());
        }
        this.cantidad = bp.getCantidadProducto();
        this.precio = bp.getPrecioProducto();
        this.unidadMedida = bp.getUnidadMedida();
    }

    public BodegasProductosDto() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BodegaDto getBodega() {
        return bodega;
    }

    public void setBodega(BodegaDto bodega) {
        this.bodega = bodega;
    }

    public ProductosDto getProducto() {
        return producto;
    }

    public void setProducto(ProductosDto producto) {
        this.producto = producto;
    }
    
}
