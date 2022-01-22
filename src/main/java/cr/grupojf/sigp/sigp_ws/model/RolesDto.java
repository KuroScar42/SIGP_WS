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
public class RolesDto {
    private Integer id;
    private String tipo;
    private String estado;
    private String nombre;
    private PermisoDto permisos;

    public RolesDto() {
    }
    
    public RolesDto(Roles r) {
        this.id = r.getIdRol();
        this.tipo = r.getTipoRol();
        this.estado = r.getEstadoRol();
        this.nombre = r.getNombreRol();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PermisoDto getPermisos() {
        return permisos;
    }

    public void setPermisos(PermisoDto permisos) {
        this.permisos = permisos;
    }
    
}
