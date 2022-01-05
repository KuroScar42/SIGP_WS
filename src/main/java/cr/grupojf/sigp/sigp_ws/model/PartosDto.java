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
public class PartosDto {
    private Integer id;
    private Date fecha;
    private String tipo;
    private Integer cantVivos;
    private Integer cantNacMuertos;
    private Integer cantMomias;
    private Integer cantEstripados;
    private String estadoCerda;
    private Integer cantTotalNacidos;
    private String detalles;

    public PartosDto() {
    }

    public PartosDto(Partos p) {
        this.id = p.getIdParto();
        this.fecha = p.getFechaParto();
        this.tipo = p.getTipoParto();
        this.cantVivos = p.getCantidadVivos();
        this.cantNacMuertos = p.getCantidaNacidosMuertos();
        this.cantMomias = p.getCantidaMomias();
        this.cantEstripados = p.getCantidadEstripados();
        this.estadoCerda = p.getEstadoCerda();
        this.cantTotalNacidos = p.getCantidadTodalNacidos();
        this.detalles = p.getDetalleParto();
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
    
    
    
    
}
