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
public class CierresCajasDto {
    
    private Integer id;
    private String codigo;
    private Date fecha;
    private String estado;
    

    public CierresCajasDto() {
    }
    
    public CierresCajasDto(CierresCajas cierre) {
        this.id = cierre.getIdCierre();
        this.codigo = cierre.getCodigoCierre();
        this.fecha = cierre.getFechaCierre();
        this.estado = cierre.getEstadoCierre();
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
    
    
    
    
    
    
    
}
