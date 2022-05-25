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
public class ReporteCajaDto {
    
    private String caja;
    private String fecha;
    private Integer numAbiertas;
    private Integer numCerradas;

    public ReporteCajaDto() {
    }

    public ReporteCajaDto(String caja, String fecha, Integer numAbiertas, Integer numCerradas) {
        this.caja = caja;
        this.fecha = fecha;
        this.numAbiertas = numAbiertas;
        this.numCerradas = numCerradas;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getNumAbiertas() {
        return numAbiertas;
    }

    public void setNumAbiertas(Integer numAbiertas) {
        this.numAbiertas = numAbiertas;
    }

    public Integer getNumCerradas() {
        return numCerradas;
    }

    public void setNumCerradas(Integer numCerradas) {
        this.numCerradas = numCerradas;
    }
    
    
    
}
