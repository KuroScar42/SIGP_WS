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
public class OtrosValoresDto {
    private Integer id;
    private Float moneda;
    private Float total;

    public OtrosValoresDto() {
    }
    
    public OtrosValoresDto(OtrosValores o) {
        this.id = o.getIdValores();
        this.moneda = o.getMontoMoneda();
        this.total = o.getMontoTotal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMoneda() {
        return moneda;
    }

    public void setMoneda(Float moneda) {
        this.moneda = moneda;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    
}
