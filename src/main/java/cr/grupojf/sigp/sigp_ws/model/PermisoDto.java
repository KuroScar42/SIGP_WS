/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class PermisoDto {
    private Integer id;
    private String permiso;
    private String estado;

    public PermisoDto(Permisos p) {
        this.id = p.getIdPermso();
        this.permiso = p.getPermiso();
        this.estado = p.getEstado();
    }

    public PermisoDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
