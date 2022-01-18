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
@Table(name = "Empresas")
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByIdEmpresa", query = "SELECT e FROM Empresas e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresas.findByNombreEmpresa", query = "SELECT e FROM Empresas e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Empresas.findByRazonSocial", query = "SELECT e FROM Empresas e WHERE e.razonSocial = :razonSocial"),
    @NamedQuery(name = "Empresas.findByEstadoEmrpresa", query = "SELECT e FROM Empresas e WHERE e.estadoEmrpresa = :estadoEmrpresa"),
    @NamedQuery(name = "Empresas.findByVersion", query = "SELECT e FROM Empresas e WHERE e.version = :version")})
public class Empresas implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CEDULA_EMPRESA")
    private String cedulaEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_EMRPRESA")
    private String estadoEmrpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    @OneToMany(mappedBy = "idEmpresa")
    private List<Clientes> clientesList;

    public Empresas() {
    }

    public Empresas(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresas(Integer idEmpresa, String nombreEmpresa, String razonSocial, String estadoEmrpresa, int version) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.razonSocial = razonSocial;
        this.estadoEmrpresa = estadoEmrpresa;
        this.version = version;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCedulaEmpresa() {
        return cedulaEmpresa;
    }

    public void setCedulaEmpresa(String cedulaEmpresa) {
        this.cedulaEmpresa = cedulaEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEstadoEmrpresa() {
        return estadoEmrpresa;
    }

    public void setEstadoEmrpresa(String estadoEmrpresa) {
        this.estadoEmrpresa = estadoEmrpresa;
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
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Empresas[ idEmpresa=" + idEmpresa + " ]";
    }


    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
}
