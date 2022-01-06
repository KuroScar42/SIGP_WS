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
public class MonedasDto {
    private Integer id;
    private String tipo;
    private String simbolo;
    private String estado;

    public MonedasDto() {
    }
    
    public MonedasDto(Monedas m) {
        this.id = m.getIdMoneda();
        this.tipo = m.getTipoMoneda();
        this.simbolo = m.getSimboloMoneda();
        this.estado = m.getEstadoMoneda();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
