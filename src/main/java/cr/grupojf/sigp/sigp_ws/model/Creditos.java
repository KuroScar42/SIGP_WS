/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Creditos")
@NamedQueries({
    @NamedQuery(name = "Creditos.findAll", query = "SELECT c FROM Creditos c"),
    @NamedQuery(name = "Creditos.findByIdCredito", query = "SELECT c FROM Creditos c WHERE c.idCredito = :idCredito"),
    @NamedQuery(name = "Creditos.findByTotalCredito", query = "SELECT c FROM Creditos c WHERE c.totalCredito = :totalCredito"),
    @NamedQuery(name = "Creditos.findByFechaCreditoProceso", query = "SELECT c FROM Creditos c WHERE c.fechaCreditoProceso = :fechaCreditoProceso"),
    @NamedQuery(name = "Creditos.findByEstadoCredito", query = "SELECT c FROM Creditos c WHERE c.estadoCredito = :estadoCredito")})
public class Creditos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CREDITO")
    private Integer idCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_CREDITO")
    private float totalCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREDITO_PROCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreditoProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_CREDITO")
    private String estadoCredito;
    @JoinTable(name = "Creditos_Cuentas_Cobrar", joinColumns = {
        @JoinColumn(name = "ID_CREDITO", referencedColumnName = "ID_CREDITO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_COBRAR", referencedColumnName = "ID_COBRAR")})
    @ManyToMany
    private List<CuentasCobrar> cuentasCobrarList;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Clientes idCliente;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public Creditos() {
    }

    public Creditos(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public Creditos(Integer idCredito, float totalCredito, Date fechaCreditoProceso, String estadoCredito) {
        this.idCredito = idCredito;
        this.totalCredito = totalCredito;
        this.fechaCreditoProceso = fechaCreditoProceso;
        this.estadoCredito = estadoCredito;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public float getTotalCredito() {
        return totalCredito;
    }

    public void setTotalCredito(float totalCredito) {
        this.totalCredito = totalCredito;
    }

    public Date getFechaCreditoProceso() {
        return fechaCreditoProceso;
    }

    public void setFechaCreditoProceso(Date fechaCreditoProceso) {
        this.fechaCreditoProceso = fechaCreditoProceso;
    }

    public String getEstadoCredito() {
        return estadoCredito;
    }

    public void setEstadoCredito(String estadoCredito) {
        this.estadoCredito = estadoCredito;
    }

    public List<CuentasCobrar> getCuentasCobrarList() {
        return cuentasCobrarList;
    }

    public void setCuentasCobrarList(List<CuentasCobrar> cuentasCobrarList) {
        this.cuentasCobrarList = cuentasCobrarList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredito != null ? idCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditos)) {
            return false;
        }
        Creditos other = (Creditos) object;
        if ((this.idCredito == null && other.idCredito != null) || (this.idCredito != null && !this.idCredito.equals(other.idCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Creditos[ idCredito=" + idCredito + " ]";
    }
    
}
