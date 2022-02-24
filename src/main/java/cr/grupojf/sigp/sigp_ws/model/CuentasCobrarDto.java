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
public class CuentasCobrarDto {
    private Integer id;
    private Integer plazoCobrar;
    private Float montoPagar;
    private float totalPagar;
    private String estado;
    private float interesPagar;
    private float interesMoratorio;

    public CuentasCobrarDto() {
    }

    public CuentasCobrarDto(CuentasCobrar cobrar) {
        this.id = cobrar.getIdCobrar();
        this.plazoCobrar = cobrar.getPlazoCobrar();
        this.montoPagar = cobrar.getMontoPagar();
        this.totalPagar = cobrar.getTotalPagar();
        this.estado = cobrar.getEstadoPagar();
        this.interesPagar = cobrar.getInteresPagar();
        this.interesMoratorio = cobrar.getInteresPagar();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlazoCobrar() {
        return plazoCobrar;
    }

    public void setPlazoCobrar(Integer plazoCobrar) {
        this.plazoCobrar = plazoCobrar;
    }

    public Float getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(Float montoPagar) {
        this.montoPagar = montoPagar;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getInteresPagar() {
        return interesPagar;
    }

    public void setInteresPagar(float interesPagar) {
        this.interesPagar = interesPagar;
    }

    public float getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(float interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }
    
    
    
    
    
}
