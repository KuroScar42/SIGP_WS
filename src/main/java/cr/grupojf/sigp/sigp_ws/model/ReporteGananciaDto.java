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
public class ReporteGananciaDto {
    
    private String fecha;
    private Float ganancia;

    public ReporteGananciaDto() {
    }

    public ReporteGananciaDto(String fecha, Float ganancia) {
        this.fecha = fecha;
        this.ganancia = ganancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getGanancia() {
        return ganancia;
    }

    public void setGanancia(Float ganancia) {
        this.ganancia = ganancia;
    }
    
    
    
    
}
