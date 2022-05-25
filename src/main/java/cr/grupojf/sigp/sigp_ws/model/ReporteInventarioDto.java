/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author NZXT
 */
public class ReporteInventarioDto {
    
    private ProductosDto producto;
    private Integer cantidad;
    private BodegaDto bodega;

    public ReporteInventarioDto() {
    }

    public ReporteInventarioDto(ProductosDto producto, Integer cantidad, BodegaDto bodega) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.bodega = bodega;
    }    

    public ProductosDto getProducto() {
        return producto;
    }

    public void setProducto(ProductosDto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BodegaDto getBodega() {
        return bodega;
    }

    public void setBodega(BodegaDto bodega) {
        this.bodega = bodega;
    }
    
    
    
}
