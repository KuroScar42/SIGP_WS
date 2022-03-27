/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String registro;
    private Float peso;
    private List<EmbarazosDto> embarazos;

    public CerdosDto() {
    }
    
    public CerdosDto(Cerdos cerdo){
        this.id = cerdo.getIdCerdo();
        this.codigo = cerdo.getCodigoCerdo();
        this.estado = cerdo.getEstadoCerdo();
        this.descripcion = cerdo.getDescripcionCerdo();
        try {
            this.registro = LocalDateAdapter.adaptToJson(cerdo.getFechaRegistro());
        } catch (Exception ex) {
            Logger.getLogger(PedidosDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cerdo.getEmbarazosList() != null) {
            embarazos = new ArrayList<>();
            for (Embarazos e : cerdo.getEmbarazosList()) {
                embarazos.add(new EmbarazosDto(e));
            }
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

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String nacimiento) {
        this.registro = nacimiento;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public List<EmbarazosDto> getEmbarazos() {
        return embarazos;
    }

    public void setEmbarazos(List<EmbarazosDto> embarazos) {
        this.embarazos = embarazos;
    }
    
    
    
    
    
    
    
}
