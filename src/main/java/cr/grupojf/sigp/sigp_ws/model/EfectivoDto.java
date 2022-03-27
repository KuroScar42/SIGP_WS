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
public class EfectivoDto {
    private Integer id;
    private Float cantidad;
    private Float total;

    public EfectivoDto() {
    }
    
    public EfectivoDto(Efectivo e) {
        this.id = e.getIdEfectivo();
        this.cantidad = e.getCantidadEfectivo();
        this.total = e.getTotalEfectivo();
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

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    
    
    
    
    
}
