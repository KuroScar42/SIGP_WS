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
public class ReporteCerdaDto {

    private Integer numero;
    private String estado;
    private InseminacionDto inseminacion;
    private EmbarazosDto embarazo;
    private Integer numeroPartos;

    public ReporteCerdaDto() {
    }

    public ReporteCerdaDto(Integer numero, String estado, InseminacionDto inseminacion, EmbarazosDto embarazo, Integer numeroPartos) {
        this.numero = numero;
        this.estado = estado;
        this.inseminacion = inseminacion;
        this.embarazo = embarazo;
        this.numeroPartos = numeroPartos;
    }
    
    

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public InseminacionDto getInseminacion() {
        return this.inseminacion;
    }

    public void setInseminacion(InseminacionDto inseminacion) {
        this.inseminacion = inseminacion;
    }

    public EmbarazosDto getEmbarazo() {
        return this.embarazo;
    }

    public void setEmbarazo(EmbarazosDto embarazo) {
        this.embarazo = embarazo;
    }

    public Integer getNumeroPartos() {
        return numeroPartos;
    }

    public void setNumeroPartos(Integer numeroPartos) {
        this.numeroPartos = numeroPartos;
    }

}
