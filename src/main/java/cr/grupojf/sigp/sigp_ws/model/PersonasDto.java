/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class PersonasDto {
    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String estado;

    public PersonasDto(Personas p) {
        this.id = p.getIdPresona();
        this.cedula = p.getCedulaPersona();
        this.nombre = p.getNomrePersona();
        this.apellido = p.getApellidoPersona();
        this.apellido2 =p.getApellido2Persona();
        this.cedula = p.getCedulaPersona();
        this.estado = p.getEstadoPersona();
    }

    public PersonasDto() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
