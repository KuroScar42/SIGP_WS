/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author herna
 */
public class FacturasProductosDto {
    private Integer id;
    private Float cantidad;
    private Float descuento;
    private Float iva;
    private Float precio;
    private Float precioIva;

    public FacturasProductosDto() {
    }
    
    public FacturasProductosDto(FacturasProductos f) {
        this.id = f.getIdFacturasProductos();
        this.cantidad = f.getCantidadProducto();
        this.descuento = f.getDescuentoProducto();
        this.iva = f.getIvaProducto();
        this.precio = f.getPrecio();
        this.precioIva = f.getPrecioIva();
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

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(Float precio) {
        this.precioIva = precio;
    }
    
    
    
}
