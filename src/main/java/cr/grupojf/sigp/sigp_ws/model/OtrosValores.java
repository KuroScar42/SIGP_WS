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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Otros_Valores")
@NamedQueries({
    @NamedQuery(name = "OtrosValores.findAll", query = "SELECT o FROM OtrosValores o"),
    @NamedQuery(name = "OtrosValores.findByIdValores", query = "SELECT o FROM OtrosValores o WHERE o.idValores = :idValores"),
    @NamedQuery(name = "OtrosValores.findByMontoMoneda", query = "SELECT o FROM OtrosValores o WHERE o.montoMoneda = :montoMoneda"),
    @NamedQuery(name = "OtrosValores.findByMontoTotal", query = "SELECT o FROM OtrosValores o WHERE o.montoTotal = :montoTotal")})
public class OtrosValores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VALORES")
    private Integer idValores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_MONEDA")
    private float montoMoneda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_TOTAL")
    private float montoTotal;
    @OneToMany(mappedBy = "idValores")
    private List<CierresCajas> cierresCajasList;
    @JoinColumn(name = "ID_METODO", referencedColumnName = "ID_METODO")
    @ManyToOne
    private MetodosPago idMetodo;

    public OtrosValores() {
    }

    public OtrosValores(Integer idValores) {
        this.idValores = idValores;
    }

    public OtrosValores(Integer idValores, float montoMoneda, float montoTotal) {
        this.idValores = idValores;
        this.montoMoneda = montoMoneda;
        this.montoTotal = montoTotal;
    }

    public Integer getIdValores() {
        return idValores;
    }

    public void setIdValores(Integer idValores) {
        this.idValores = idValores;
    }

    public float getMontoMoneda() {
        return montoMoneda;
    }

    public void setMontoMoneda(float montoMoneda) {
        this.montoMoneda = montoMoneda;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<CierresCajas> getCierresCajasList() {
        return cierresCajasList;
    }

    public void setCierresCajasList(List<CierresCajas> cierresCajasList) {
        this.cierresCajasList = cierresCajasList;
    }

    public MetodosPago getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(MetodosPago idMetodo) {
        this.idMetodo = idMetodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValores != null ? idValores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtrosValores)) {
            return false;
        }
        OtrosValores other = (OtrosValores) object;
        if ((this.idValores == null && other.idValores != null) || (this.idValores != null && !this.idValores.equals(other.idValores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.OtrosValores[ idValores=" + idValores + " ]";
    }
    
}
