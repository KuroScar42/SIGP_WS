/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Personas")
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByIdPersona", query = "SELECT p FROM Personas p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Personas.findByNombrePersona", query = "SELECT p FROM Personas p WHERE p.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "Personas.findByApellidoPersona", query = "SELECT p FROM Personas p WHERE p.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "Personas.findByCedulaPersona", query = "SELECT p FROM Personas p WHERE p.cedulaPersona = :cedulaPersona"),
    @NamedQuery(name = "Personas.findByApellido2Persona", query = "SELECT p FROM Personas p WHERE p.apellido2Persona = :apellido2Persona"),
    @NamedQuery(name = "Personas.findByEstadoPersona", query = "SELECT p FROM Personas p WHERE p.estadoPersona = :estadoPersona"),
    @NamedQuery(name = "Personas.findByVersionPersona", query = "SELECT p FROM Personas p WHERE p.versionPersona = :versionPersona")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_PERSONA")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APELLIDO_PERSONA")
    private String apellidoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CEDULA_PERSONA")
    private String cedulaPersona;
    @Size(max = 20)
    @Column(name = "APELLIDO2_PERSONA")
    private String apellido2Persona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_PERSONA")
    private String estadoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION_PERSONA")
    private int versionPersona;
    @OneToMany(mappedBy = "idPersona")
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "idPersona")
    private List<Clientes> clientesList;

    public Personas() {
    }

    public Personas(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Personas(Integer idPersona, String nombrePersona, String apellidoPersona, String cedulaPersona, String estadoPersona, int versionPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.cedulaPersona = cedulaPersona;
        this.estadoPersona = estadoPersona;
        this.versionPersona = versionPersona;
    }
    
    public Personas(PersonasDto personaDto) {
        this.idPersona = personaDto.getId();
        this.actualizarPersona(personaDto);
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getApellido2Persona() {
        return apellido2Persona;
    }

    public void setApellido2Persona(String apellido2Persona) {
        this.apellido2Persona = apellido2Persona;
    }

    public String getEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(String estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public int getVersionPersona() {
        return versionPersona;
    }

    public void setVersionPersona(int versionPersona) {
        this.versionPersona = versionPersona;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Personas[ idPersona=" + idPersona + " ]";
    }
    
    public void actualizarPersona(PersonasDto personaDto) {
        this.apellido2Persona = personaDto.getApellido2();
        this.apellidoPersona = personaDto.getApellido();
        this.cedulaPersona = personaDto.getCedula();
        this.estadoPersona = personaDto.getEstado();
        this.nombrePersona = personaDto.getNombre();
    }
    
}
