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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Permisos")
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"),
    @NamedQuery(name = "Permisos.findAllActive", query = "SELECT p FROM Permisos p where p.estado = 'A'"),
    @NamedQuery(name = "Permisos.findByIdPermso", query = "SELECT p FROM Permisos p WHERE p.idPermso = :idPermso"),
    @NamedQuery(name = "Permisos.findByPermiso", query = "SELECT p FROM Permisos p WHERE p.permiso = :permiso"),
    @NamedQuery(name = "Permisos.findByEstado", query = "SELECT p FROM Permisos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Permisos.findByVersion", query = "SELECT p FROM Permisos p WHERE p.version = :version")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERMSO")
    private Integer idPermso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PERMISO")
    private String permiso;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "VERSION")
    private Integer version;
    @JoinTable(name = "Role_Permiso", joinColumns = {
        @JoinColumn(name = "ID_PERMSO", referencedColumnName = "ID_PERMSO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")})
    @ManyToMany
    private List<Roles> rolesList;

    public Permisos() {
    }

    public Permisos(Integer idPermso) {
        this.idPermso = idPermso;
    }

    public Permisos(Integer idPermso, String permiso) {
        this.idPermso = idPermso;
        this.permiso = permiso;
    }

    public Integer getIdPermso() {
        return idPermso;
    }

    public void setIdPermso(Integer idPermso) {
        this.idPermso = idPermso;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermso != null ? idPermso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPermso == null && other.idPermso != null) || (this.idPermso != null && !this.idPermso.equals(other.idPermso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Permisos[ idPermso=" + idPermso + " ]";
    }
    
}
