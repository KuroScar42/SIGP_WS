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
public class ProveedoresDto {
    private Integer id;
    private String nombre;
    private String tipoCedula;
    private String cedula;
    private String estado;
    private String telefono;
    private String email;

    public ProveedoresDto() {
    }
    
    public ProveedoresDto(Proveedores p) {
        this.id = p.getIdProveedor();
        this.nombre = p.getNombreProveedor();
        this.tipoCedula = p.getTipoCedula();
        this.cedula = p.getCedula();
        this.estado = p.getEstado();
        this.email = p.getEmail();
        this.telefono = p.getTelefono();
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

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
