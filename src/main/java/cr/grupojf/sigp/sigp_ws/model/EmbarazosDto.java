/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herna
 */
public class EmbarazosDto {
    private Integer id;
    private String fecha;
    private String estado;
    private String parto;
    private String detalles;
    private CerdosDto cerdo;
    private PartosDto partoDto;

    public EmbarazosDto() {
    }
    
    public EmbarazosDto(Embarazos e) {
        this.id = e.getIdEmbarazo();
        try {
            this.fecha = LocalDateAdapter.adaptToJson(e.getFechaEmbarazo());
            this.parto = LocalDateAdapter.adaptToJson(e.getFechaParto());
        } catch (Exception ex) {
            Logger.getLogger(EmbarazosDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estado = e.getEstadoEmbarazo();
        this.detalles = e.getDestallesEmbarazo();
        if (e.getIdCerdo() != null) {
//            this.cerdo = new CerdosDto(e.getIdCerdo());
        }
        if (e.getIdParto() != null) {
            this.partoDto = new PartosDto(e.getIdParto());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getParto() {
        return parto;
    }

    public void setParto(String parto) {
        this.parto = parto;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public CerdosDto getCerdo() {
        return cerdo;
    }

    public void setCerdo(CerdosDto cerdo) {
        this.cerdo = cerdo;
    }

    public PartosDto getPartoDto() {
        return partoDto;
    }

    public void setPartoDto(PartosDto partoDto) {
        this.partoDto = partoDto;
    }
    
    
    
    
}
