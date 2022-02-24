/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author herna
 */
public class DenominacionEfectivoDto {
    
    private Integer id;
    private String efectivo;
    private String estado;

    public DenominacionEfectivoDto() {
    }
    
    public DenominacionEfectivoDto(DenominacionEfectivo d) {
        this.id = d.getIdDenominacion();
        this.estado = d.getEstadoDenominacion();
        this.efectivo = d.getDenominacionEfectivo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(String efectivo) {
        this.efectivo = efectivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
