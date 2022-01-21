/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Emisores")
@NamedQueries({
    @NamedQuery(name = "Emisores.findAll", query = "SELECT e FROM Emisores e"),
    @NamedQuery(name = "Emisores.findByIdEmisor", query = "SELECT e FROM Emisores e WHERE e.idEmisor = :idEmisor"),
    @NamedQuery(name = "Emisores.findByCedulaEmisor", query = "SELECT e FROM Emisores e WHERE e.cedulaEmisor = :cedulaEmisor"),
    @NamedQuery(name = "Emisores.findByEmailEmisor", query = "SELECT e FROM Emisores e WHERE e.emailEmisor = :emailEmisor"),
    @NamedQuery(name = "Emisores.findByTelefonoEmisor", query = "SELECT e FROM Emisores e WHERE e.telefonoEmisor = :telefonoEmisor"),
    @NamedQuery(name = "Emisores.findByDireccionEmisor", query = "SELECT e FROM Emisores e WHERE e.direccionEmisor = :direccionEmisor"),
    @NamedQuery(name = "Emisores.findByEstadoEmisor", query = "SELECT e FROM Emisores e WHERE e.estadoEmisor = :estadoEmisor"),
    @NamedQuery(name = "Emisores.findByVersionEstado", query = "SELECT e FROM Emisores e WHERE e.versionEstado = :versionEstado")})
public class Emisores implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CEDULA_EMISOR")
    private String cedulaEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL_EMISOR")
    private String emailEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "TELEFONO_EMISOR")
    private String telefonoEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DIRECCION_EMISOR")
    private String direccionEmisor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_EMISOR")
    private String estadoEmisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION_ESTADO")
    private int versionEstado;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMISOR")
    private Integer idEmisor;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmisor")
    private List<Facturas> facturasList;

    public Emisores() {
    }

    public Emisores(Integer idEmisor) {
        this.idEmisor = idEmisor;
    }

    public Emisores(Integer idEmisor, String cedulaEmisor, String emailEmisor, String telefonoEmisor, String direccionEmisor, String estadoEmisor, int versionEstado) {
        this.idEmisor = idEmisor;
        this.cedulaEmisor = cedulaEmisor;
        this.emailEmisor = emailEmisor;
        this.telefonoEmisor = telefonoEmisor;
        this.direccionEmisor = direccionEmisor;
        this.estadoEmisor = estadoEmisor;
        this.versionEstado = versionEstado;
    }

    public Integer getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Integer idEmisor) {
        this.idEmisor = idEmisor;
    }

    public String getCedulaEmisor() {
        return cedulaEmisor;
    }

    public void setCedulaEmisor(String cedulaEmisor) {
        this.cedulaEmisor = cedulaEmisor;
    }

    public String getEmailEmisor() {
        return emailEmisor;
    }

    public void setEmailEmisor(String emailEmisor) {
        this.emailEmisor = emailEmisor;
    }

    public String getTelefonoEmisor() {
        return telefonoEmisor;
    }

    public void setTelefonoEmisor(String telefonoEmisor) {
        this.telefonoEmisor = telefonoEmisor;
    }

    public String getDireccionEmisor() {
        return direccionEmisor;
    }

    public void setDireccionEmisor(String direccionEmisor) {
        this.direccionEmisor = direccionEmisor;
    }

    public String getEstadoEmisor() {
        return estadoEmisor;
    }

    public void setEstadoEmisor(String estadoEmisor) {
        this.estadoEmisor = estadoEmisor;
    }

    public int getVersionEstado() {
        return versionEstado;
    }

    public void setVersionEstado(int versionEstado) {
        this.versionEstado = versionEstado;
    }

    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmisor != null ? idEmisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emisores)) {
            return false;
        }
        Emisores other = (Emisores) object;
        if ((this.idEmisor == null && other.idEmisor != null) || (this.idEmisor != null && !this.idEmisor.equals(other.idEmisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Emisores[ idEmisor=" + idEmisor + " ]";
    }
    
}
