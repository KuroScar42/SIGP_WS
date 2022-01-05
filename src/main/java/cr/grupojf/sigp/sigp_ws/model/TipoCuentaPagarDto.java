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
public class TipoCuentaPagarDto {
    private Integer id;
    private String empresa;
    private String cuenta;
    private String plazo;
    private String estado;

    public TipoCuentaPagarDto() {
    }
    
    public TipoCuentaPagarDto(TipoCuentaPagar t) {
        this.id = t.getIdTipo();
        this.empresa = t.getEmpresaTipo();
        this.cuenta = t.getCuentaTipo();
        this.plazo = t.getPlazoTipo();
        this.estado = t.getEstadoTipo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
