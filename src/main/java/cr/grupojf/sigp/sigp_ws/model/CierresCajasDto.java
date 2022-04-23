/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;

/**
 *
 * @author herna
 */
public class CierresCajasDto {
    
    private Integer id;
    private String codigo;
    private String fecha;
    private String estado;
    private AperturaCajasDto apertura;
    private EfectivoDto efectivo;
    private UsuarioDto usuario;
    

    public CierresCajasDto() {
    }
    
    public CierresCajasDto(CierresCajas cierre) {
        this.id = cierre.getIdCierre();
        this.codigo = cierre.getCodigoCierre();
        try {
            this.fecha = LocalDateAdapter.adaptToJson(cierre.getFechaCierre());
        } catch (Exception e) {
        }
        
        this.estado = cierre.getEstadoCierre();
        if (cierre.getIdApertura() != null) {
            this.apertura = new AperturaCajasDto(cierre.getIdApertura());
        }
        if (cierre.getIdEfectivo() != null) {
            this.efectivo = new EfectivoDto(cierre.getIdEfectivo());
        }
        if (cierre.getIdUsuario() != null) {
            this.usuario = new UsuarioDto(cierre.getIdUsuario());
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

    public AperturaCajasDto getApertura() {
        return apertura;
    }

    public void setApertura(AperturaCajasDto apertura) {
        this.apertura = apertura;
    }

    public EfectivoDto getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(EfectivoDto efectivo) {
        this.efectivo = efectivo;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
    
    
    
}
