/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class UsuarioDto {
    private Integer id;
    private String nombreUsuario;
    private String contrasena;
    private String estado;
    private PersonasDto persona;

    public UsuarioDto(Usuarios u) {
        this.id = u.getIdUsuario();
        this.contrasena = u.getContrasennaUsuario();
        this.nombreUsuario = u.getNombreUsuario();
        this.estado = u.getEstadoUsuario();
        if (u.getIdPresona() != null) {
            this.persona = new PersonasDto(u.getIdPresona());
        }
    }

//    public UsuarioDto(Usuarios u, Personas p) {
//        this(u);
//        this.persona = new PersonasDto(p);
//    }

    public UsuarioDto() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PersonasDto getPersona() {
        return persona;
    }

    public void setPersona(PersonasDto persona) {
        this.persona = persona;
    }
    
    
    
}
