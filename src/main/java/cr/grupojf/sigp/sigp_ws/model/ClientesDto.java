/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class ClientesDto {

    private Integer id;
    private String cedula;
    private String cliente;
    private String email;
    private String telefono;
    private String telefono2;
    private String direccion;
    private String estado;
    private PersonasDto persona;

    public ClientesDto(Clientes c) {
        this.id = c.getIdCliente();
        this.cedula = c.getCedulaCliente();
        this.cliente = c.getEmailCliente();
        this.email = c.getEmailCliente();
        this.telefono = c.getEmailCliente();
        this.telefono2 = c.getEmailCliente();
        this.direccion = c.getDireccionCliente();
        this.estado = c.getEstadoCliente();
        if (c.getIdPresona() != null) {
            this.persona = new PersonasDto(c.getIdPresona());
        }
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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

    public PersonasDto getPersona() {
        return persona;
    }

    public void setPersona(PersonasDto persona) {
        this.persona = persona;
    }

}
