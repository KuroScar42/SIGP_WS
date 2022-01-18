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
public class MoveProductDto {
    private ProductosDto producto;
    private BodegaDto origen;
    private BodegaDto destino;
    private Float cantidad;

    public MoveProductDto() {
    }

    public ProductosDto getProducto() {
        return producto;
    }

    public void setProducto(ProductosDto producto) {
        this.producto = producto;
    }

    public BodegaDto getOrigen() {
        return origen;
    }

    public void setOrigen(BodegaDto origen) {
        this.origen = origen;
    }

    public BodegaDto getDestino() {
        return destino;
    }

    public void setDestino(BodegaDto destino) {
        this.destino = destino;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
