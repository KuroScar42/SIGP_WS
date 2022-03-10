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
public class InseminacionDto {
    private Integer id;
    private String codigo;
    private String fechaInseminacion;
    private String estado;
    private String detalle;
    private String fechaRevision;
    private CerdosDto cerdo;

    public InseminacionDto() {
    }
    
    public InseminacionDto(Inseminacion i) {
        this.id = i.getIdInseminacion();
        this.codigo = i.getCodigoInsiminacion();
        try {
            this.fechaInseminacion = LocalDateAdapter.adaptToJson(i.getFechaInseminacion());
            this.fechaRevision = LocalDateAdapter.adaptToJson(i.getFechaRevision());
        } catch (Exception ex) {
            Logger.getLogger(InseminacionDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estado = i.getEstadoInsiminacion();
        this.detalle = i.getDetalleInsiminacion();
        if (i.getIdCerdo() != null) {
            cerdo = new CerdosDto(i.getIdCerdo());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaInseminacion() {
        return fechaInseminacion;
    }

    public void setFechaInseminacion(String fecha) {
        this.fechaInseminacion = fecha;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public CerdosDto getCerdo() {
        return cerdo;
    }

    public void setCerdo(CerdosDto cerdo) {
        this.cerdo = cerdo;
    }
    
    
    
    
}
