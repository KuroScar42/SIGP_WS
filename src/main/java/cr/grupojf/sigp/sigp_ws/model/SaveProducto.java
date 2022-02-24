/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.util.List;

/**
 *
 * @author NZXT
 */
public class SaveProducto {
    private ProductosDto producto;
    private List<BodegasProductosDto> bodegasProductos;

    public SaveProducto() {
    }

    public ProductosDto getProducto() {
        return producto;
    }

    public void setProducto(ProductosDto producto) {
        this.producto = producto;
    }

    public List<BodegasProductosDto> getBodegasProductos() {
        return bodegasProductos;
    }

    public void setBodegasProductos(List<BodegasProductosDto> bodegasProductos) {
        this.bodegasProductos = bodegasProductos;
    }
    
    
    
}
