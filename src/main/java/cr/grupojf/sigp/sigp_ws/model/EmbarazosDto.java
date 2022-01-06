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
public class EmbarazosDto {
    private Integer id;
    private Date fecha;
    private String estado;
    private Date parto;
    private String detalles;

    public EmbarazosDto() {
    }
    
    public EmbarazosDto(Embarazos e) {
        this.id = e.getIdEmbarazo();
        this.fecha = e.getFechaEmbarazo();
        this.estado = e.getEstadoEmbarazo();
        this.parto = e.getFechaParto();
        this.detalles = e.getDestallesEmbarazo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getParto() {
        return parto;
    }

    public void setParto(Date parto) {
        this.parto = parto;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
    
    
}
