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
public class PartosDto {
    private Integer id;
    private String fecha;
    private String tipo;
    private Integer cantVivos;
    private Integer cantNacMuertos;
    private Integer cantMomias;
    private Integer cantEstripados;
    private String estadoCerda;
    private Integer cantTotalNacidos;
    private String detalles;
    private Float pesoProNacimiento;
    private Float pesoProDestete;

    public PartosDto() {
    }

    public PartosDto(Partos p) {
        this.id = p.getIdParto();
        try {
            this.fecha = LocalDateAdapter.adaptToJson(p.getFechaParto());
        } catch (Exception ex) {
            Logger.getLogger(PartosDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tipo = p.getTipoParto();
        this.cantVivos = p.getCantidadVivos();
        this.cantNacMuertos = p.getCantidadNacidosMuertos();
        this.cantMomias = p.getCantidadMomias();
        this.cantEstripados = p.getCantidadEstripados();
        this.estadoCerda = p.getEstadoCerda();
        this.cantTotalNacidos = p.getCantidadTodalNacidos();
        this.detalles = p.getDetalleParto();
        this.pesoProNacimiento = p.getPesoProNacimiento();
        this.pesoProDestete = p.getPesoProDestete();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantVivos() {
        return cantVivos;
    }

    public void setCantVivos(Integer cantVivos) {
        this.cantVivos = cantVivos;
    }

    public Integer getCantNacMuertos() {
        return cantNacMuertos;
    }

    public void setCantNacMuertos(Integer cantNacMuertos) {
        this.cantNacMuertos = cantNacMuertos;
    }

    public Integer getCantMomias() {
        return cantMomias;
    }

    public void setCantMomias(Integer cantMomias) {
        this.cantMomias = cantMomias;
    }

    public Integer getCantEstripados() {
        return cantEstripados;
    }

    public void setCantEstripados(Integer cantEstripados) {
        this.cantEstripados = cantEstripados;
    }

    public String getEstadoCerda() {
        return estadoCerda;
    }

    public void setEstadoCerda(String estadoCerda) {
        this.estadoCerda = estadoCerda;
    }

    public Integer getCantTotalNacidos() {
        return cantTotalNacidos;
    }

    public void setCantTotalNacidos(Integer cantTotalNacidos) {
        this.cantTotalNacidos = cantTotalNacidos;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Float getPesoProNacimiento() {
        return pesoProNacimiento;
    }

    public void setPesoProNacimiento(Float pesoProNacimiento) {
        this.pesoProNacimiento = pesoProNacimiento;
    }

    public Float getPesoProDestete() {
        return pesoProDestete;
    }

    public void setPesoProDestete(Float pesoProDestete) {
        this.pesoProDestete = pesoProDestete;
    }
    
    
    
    
}
