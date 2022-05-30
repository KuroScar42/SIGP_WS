/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.util.Date;

/**
 *
 * @author herna
 */
public class CreditosDto {
    private Integer id;
    private Float credito;
    private Date fechaProceso;
    private String estado;

    public CreditosDto() {
    }
    
    public CreditosDto(Creditos credito){
        this.id = credito.getIdCredito();
        this.credito = credito.getMontoAbonado();
        this.fechaProceso = credito.getFechaPago();
//        this.estado = credito.getEstadoCredito();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCredito() {
        return credito;
    }

    public void setCredito(Float credito) {
        this.credito = credito;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

