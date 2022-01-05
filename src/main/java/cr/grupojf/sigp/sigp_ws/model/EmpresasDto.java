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
public class EmpresasDto {
    private Integer id;
    private String nombre;
    private String razonSocial;
    private String estado;

    public EmpresasDto() {
    }
    
    public EmpresasDto(Empresas e) {
        this.id = e.getIdEmpresa();
        this.nombre = e.getNombreEmpresa();
        this.razonSocial = e.getRazonSocial();
        this.estado = e.getEstadoEmrpresa();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
