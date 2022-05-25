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
public class ReportePendienteDto {
    
    private String nombreCliente;
    private Float total;
    private Float pendiente;
    private String fecha;
    private Integer dias;

    public ReportePendienteDto() {
    }

    public ReportePendienteDto(String nombreCliente, Float total, Float pendiente, String fecha, Integer dias) {
        this.nombreCliente = nombreCliente;
        this.total = total;
        this.pendiente = pendiente;
        this.fecha = fecha;
        this.dias = dias;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getPendiente() {
        return pendiente;
    }

    public void setPendiente(Float pendiente) {
        this.pendiente = pendiente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
    
    
    
}
