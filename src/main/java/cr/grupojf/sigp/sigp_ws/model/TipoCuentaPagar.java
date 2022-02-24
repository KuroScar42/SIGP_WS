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
@Table(name = "Tipo_Cuenta_Pagar")
@NamedQueries({
    @NamedQuery(name = "TipoCuentaPagar.findAll", query = "SELECT t FROM TipoCuentaPagar t"),
    @NamedQuery(name = "TipoCuentaPagar.findByIdTipo", query = "SELECT t FROM TipoCuentaPagar t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TipoCuentaPagar.findByEmpresaTipo", query = "SELECT t FROM TipoCuentaPagar t WHERE t.empresaTipo = :empresaTipo"),
    @NamedQuery(name = "TipoCuentaPagar.findByCuentaTipo", query = "SELECT t FROM TipoCuentaPagar t WHERE t.cuentaTipo = :cuentaTipo"),
    @NamedQuery(name = "TipoCuentaPagar.findByPlazoTipo", query = "SELECT t FROM TipoCuentaPagar t WHERE t.plazoTipo = :plazoTipo"),
    @NamedQuery(name = "TipoCuentaPagar.findByEstadoTipo", query = "SELECT t FROM TipoCuentaPagar t WHERE t.estadoTipo = :estadoTipo")})
public class TipoCuentaPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPRESA_TIPO")
    private String empresaTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CUENTA_TIPO")
    private String cuentaTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PLAZO_TIPO")
    private String plazoTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_TIPO")
    private String estadoTipo;
    @OneToMany(mappedBy = "idTipo")
    private List<CuentasPagar> cuentasPagarList;

    public TipoCuentaPagar() {
    }

    public TipoCuentaPagar(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoCuentaPagar(Integer idTipo, String empresaTipo, String cuentaTipo, String plazoTipo, String estadoTipo) {
        this.idTipo = idTipo;
        this.empresaTipo = empresaTipo;
        this.cuentaTipo = cuentaTipo;
        this.plazoTipo = plazoTipo;
        this.estadoTipo = estadoTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getEmpresaTipo() {
        return empresaTipo;
    }

    public void setEmpresaTipo(String empresaTipo) {
        this.empresaTipo = empresaTipo;
    }

    public String getCuentaTipo() {
        return cuentaTipo;
    }

    public void setCuentaTipo(String cuentaTipo) {
        this.cuentaTipo = cuentaTipo;
    }

    public String getPlazoTipo() {
        return plazoTipo;
    }

    public void setPlazoTipo(String plazoTipo) {
        this.plazoTipo = plazoTipo;
    }

    public String getEstadoTipo() {
        return estadoTipo;
    }

    public void setEstadoTipo(String estadoTipo) {
        this.estadoTipo = estadoTipo;
    }

    public List<CuentasPagar> getCuentasPagarList() {
        return cuentasPagarList;
    }

    public void setCuentasPagarList(List<CuentasPagar> cuentasPagarList) {
        this.cuentasPagarList = cuentasPagarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaPagar)) {
            return false;
        }
        TipoCuentaPagar other = (TipoCuentaPagar) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.TipoCuentaPagar[ idTipo=" + idTipo + " ]";
    }
    
}
