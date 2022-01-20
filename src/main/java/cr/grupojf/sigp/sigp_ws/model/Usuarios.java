/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByNombreUsuario", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuarios.findByNombreUsuarioContrasenia", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario and u.contrasennaUsuario = :contrasennaUsuario and u.estadoUsuario='A'"),
    @NamedQuery(name = "Usuarios.findByContrasennaUsuario", query = "SELECT u FROM Usuarios u WHERE u.contrasennaUsuario = :contrasennaUsuario"),
    @NamedQuery(name = "Usuarios.findByEstadoUsuario", query = "SELECT u FROM Usuarios u WHERE u.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "Usuarios.findByVersionUsuario", query = "SELECT u FROM Usuarios u WHERE u.versionUsuario = :versionUsuario")})
public class Usuarios implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CONTRASENNA_USUARIO")
    private String contrasennaUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_USUARIO")
    private String estadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION_USUARIO")
    private int versionUsuario;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne
    private Roles idRol;
    @JoinColumn(name = "ID_PRESONA", referencedColumnName = "ID_PRESONA")
    @ManyToOne
    private Personas idPresona;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String nombreUsuario, String contrasennaUsuario, String estadoUsuario, int versionUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasennaUsuario = contrasennaUsuario;
        this.estadoUsuario = estadoUsuario;
        this.versionUsuario = versionUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasennaUsuario() {
        return contrasennaUsuario;
    }

    public void setContrasennaUsuario(String contrasennaUsuario) {
        this.contrasennaUsuario = contrasennaUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public int getVersionUsuario() {
        return versionUsuario;
    }

    public void setVersionUsuario(int versionUsuario) {
        this.versionUsuario = versionUsuario;
    }

    public Personas getIdPresona() {
        return idPresona;
    }

    public void setIdPresona(Personas idPresona) {
        this.idPresona = idPresona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Usuarios[ idUsuario=" + idUsuario + " ]";
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }
    
}
