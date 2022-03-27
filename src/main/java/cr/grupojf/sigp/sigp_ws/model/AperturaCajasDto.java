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
public class AperturaCajasDto {
    private Integer id;
    private String fecha;
    private String estado;
    private String numCaja;
    private Float fondo;
    private Integer usuario;
    

    public AperturaCajasDto() {
    }
    
    public AperturaCajasDto(AperturaCajas apertura) {
        this.id = apertura.getIdApertura();
        try {
            this.fecha = LocalDateAdapter.adaptToJson(apertura.getFechaCaja());
        } catch (Exception ex) {
            Logger.getLogger(AperturaCajasDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estado = apertura.getEstadoCaja();
        this.numCaja = apertura.getNumCaja();
        this.fondo = apertura.getFondoCaja();
//        if (apertura.getIdUsuario() != null) {
//            this.usuario = new UsuarioDto(apertura.getIdUsuario());
//        }
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

    public String getNumCaja() {
        return numCaja;
    }

    public void setNumCaja(String numCaja) {
        this.numCaja = numCaja;
    }

    public Float getFondo() {
        return fondo;
    }

    public void setFondo(Float fondo) {
        this.fondo = fondo;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
