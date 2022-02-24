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
@Table(name = "Cuentas_Cobrar")
@NamedQueries({
    @NamedQuery(name = "CuentasCobrar.findAll", query = "SELECT c FROM CuentasCobrar c"),
    @NamedQuery(name = "CuentasCobrar.findByIdCobrar", query = "SELECT c FROM CuentasCobrar c WHERE c.idCobrar = :idCobrar"),
    @NamedQuery(name = "CuentasCobrar.findByPlazoCobrar", query = "SELECT c FROM CuentasCobrar c WHERE c.plazoCobrar = :plazoCobrar"),
    @NamedQuery(name = "CuentasCobrar.findByMontoPagar", query = "SELECT c FROM CuentasCobrar c WHERE c.montoPagar = :montoPagar"),
    @NamedQuery(name = "CuentasCobrar.findByTotalPagar", query = "SELECT c FROM CuentasCobrar c WHERE c.totalPagar = :totalPagar"),
    @NamedQuery(name = "CuentasCobrar.findByEstadoPagar", query = "SELECT c FROM CuentasCobrar c WHERE c.estadoPagar = :estadoPagar"),
    @NamedQuery(name = "CuentasCobrar.findByInteresPagar", query = "SELECT c FROM CuentasCobrar c WHERE c.interesPagar = :interesPagar"),
    @NamedQuery(name = "CuentasCobrar.findByInteresMoratorio", query = "SELECT c FROM CuentasCobrar c WHERE c.interesMoratorio = :interesMoratorio")})
public class CuentasCobrar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COBRAR")
    private Integer idCobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAZO_COBRAR")
    private int plazoCobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_PAGAR")
    private float montoPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_PAGAR")
    private float totalPagar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO_PAGAR")
    private String estadoPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERES_PAGAR")
    private float interesPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERES_MORATORIO")
    private float interesMoratorio;
    @ManyToMany(mappedBy = "cuentasCobrarList")
    private List<Creditos> creditosList;

    public CuentasCobrar() {
    }

    public CuentasCobrar(Integer idCobrar) {
        this.idCobrar = idCobrar;
    }

    public CuentasCobrar(Integer idCobrar, int plazoCobrar, float montoPagar, float totalPagar, String estadoPagar, float interesPagar, float interesMoratorio) {
        this.idCobrar = idCobrar;
        this.plazoCobrar = plazoCobrar;
        this.montoPagar = montoPagar;
        this.totalPagar = totalPagar;
        this.estadoPagar = estadoPagar;
        this.interesPagar = interesPagar;
        this.interesMoratorio = interesMoratorio;
    }

    public Integer getIdCobrar() {
        return idCobrar;
    }

    public void setIdCobrar(Integer idCobrar) {
        this.idCobrar = idCobrar;
    }

    public int getPlazoCobrar() {
        return plazoCobrar;
    }

    public void setPlazoCobrar(int plazoCobrar) {
        this.plazoCobrar = plazoCobrar;
    }

    public float getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(float montoPagar) {
        this.montoPagar = montoPagar;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getEstadoPagar() {
        return estadoPagar;
    }

    public void setEstadoPagar(String estadoPagar) {
        this.estadoPagar = estadoPagar;
    }

    public float getInteresPagar() {
        return interesPagar;
    }

    public void setInteresPagar(float interesPagar) {
        this.interesPagar = interesPagar;
    }

    public float getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(float interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    public List<Creditos> getCreditosList() {
        return creditosList;
    }

    public void setCreditosList(List<Creditos> creditosList) {
        this.creditosList = creditosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobrar != null ? idCobrar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasCobrar)) {
            return false;
        }
        CuentasCobrar other = (CuentasCobrar) object;
        if ((this.idCobrar == null && other.idCobrar != null) || (this.idCobrar != null && !this.idCobrar.equals(other.idCobrar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.CuentasCobrar[ idCobrar=" + idCobrar + " ]";
    }
    
}
