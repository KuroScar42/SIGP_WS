/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author Hernan
 */
public class SaveCierre {
    
    private CierresCajasDto cierre;
    private Float montoFacturado;
    private Float montoCortes;
    private Float restanteCaja;

    public SaveCierre() {
    }

    public SaveCierre(CierresCajasDto cierre, Float montoFacturado, Float montoCortes, Float restanteCaja) {
        this.cierre = cierre;
        this.montoFacturado = montoFacturado;
        this.montoCortes = montoCortes;
        this.restanteCaja = restanteCaja;
    }

    public CierresCajasDto getCierre() {
        return cierre;
    }

    public void setCierre(CierresCajasDto cierre) {
        this.cierre = cierre;
    }

    public Float getMontoFacturado() {
        return montoFacturado;
    }

    public void setMontoFacturado(Float montoFacturado) {
        this.montoFacturado = montoFacturado;
    }

    public Float getMontoCortes() {
        return montoCortes;
    }

    public void setMontoCortes(Float montoCortes) {
        this.montoCortes = montoCortes;
    }

    public Float getRestanteCaja() {
        return restanteCaja;
    }

    public void setRestanteCaja(Float restanteCaja) {
        this.restanteCaja = restanteCaja;
    }
    
    
    
}
