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
public class TipoCambioDto {
    private Integer id;
    private Float compraCambio;
    private Float ventaCambio;

    public TipoCambioDto() {
    }
    
    public TipoCambioDto(TipoCambio t) {
        this.id = t.getIdCambio();
        this.compraCambio = t.getCompraCambio();
        this.ventaCambio = t.getVentaCambio();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCompraCambio() {
        return compraCambio;
    }

    public void setCompraCambio(Float compraCambio) {
        this.compraCambio = compraCambio;
    }

    public Float getVentaCambio() {
        return ventaCambio;
    }

    public void setVentaCambio(Float ventaCambio) {
        this.ventaCambio = ventaCambio;
    }
    
    
    
    
}
