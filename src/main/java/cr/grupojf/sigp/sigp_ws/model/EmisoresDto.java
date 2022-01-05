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
public class EmisoresDto {
    private Integer id;
    private String cedula;
    private String email;
    private String telefono;
    private String direccion;
    private String estado;

    public EmisoresDto() {
    }
    
    public EmisoresDto(Emisores e) {
        this.id = e.getIdEmisor();
        this.cedula = e.getCedulaEmisor();
        this.email = e.getEmailEmisor();
        this.telefono = e.getTelefonoEmisor();
        this.direccion = e.getDireccionEmisor();
        this.estado = e.getEstadoEmisor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
