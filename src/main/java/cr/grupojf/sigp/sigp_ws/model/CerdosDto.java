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
public class CerdosDto {
    private Integer id;
    private String codigo;
    private String sexo;
    private String estado;
    private String descripcion;
    private Date registro;
    private Float peso;

    public CerdosDto() {
    }
    
    public CerdosDto(Cerdos cerdo){
        this.id = cerdo.getIdCerdo();
        this.codigo = cerdo.getCodigoCerdo();
        this.estado = cerdo.getEstadoCerdo();
        this.descripcion = cerdo.getDescripcionCerdo();
        this.registro = cerdo.getFechaRegistro();
        this.peso = cerdo.getPesoCerdo();
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date nacimiento) {
        this.registro = nacimiento;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
    
    
    
    
    
}
