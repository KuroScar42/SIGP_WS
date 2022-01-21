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
@Table(name = "Monedas")
@NamedQueries({
    @NamedQuery(name = "Monedas.findAll", query = "SELECT m FROM Monedas m"),
    @NamedQuery(name = "Monedas.findByIdMoneda", query = "SELECT m FROM Monedas m WHERE m.idMoneda = :idMoneda"),
    @NamedQuery(name = "Monedas.findByTipoMoneda", query = "SELECT m FROM Monedas m WHERE m.tipoMoneda = :tipoMoneda"),
    @NamedQuery(name = "Monedas.findBySimboloMoneda", query = "SELECT m FROM Monedas m WHERE m.simboloMoneda = :simboloMoneda"),
    @NamedQuery(name = "Monedas.findByEstadoMoneda", query = "SELECT m FROM Monedas m WHERE m.estadoMoneda = :estadoMoneda")})
public class Monedas implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "TIPO_MONEDA")
    private String tipoMoneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SIMBOLO_MONEDA")
    private String simboloMoneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_MONEDA")
    private String estadoMoneda;
    @OneToMany(mappedBy = "idMoneda")
    private List<TipoCambio> tipoCambioList;
    @OneToMany(mappedBy = "idMoneda")
    private List<DenominacionEfectivo> denominacionEfectivoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MONEDA")
    private Integer idMoneda;
    @OneToMany(mappedBy = "idMoneda")
    private List<MetodosPago> metodosPagoList;

    public Monedas() {
    }

    public Monedas(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Monedas(Integer idMoneda, String tipoMoneda, String simboloMoneda, String estadoMoneda) {
        this.idMoneda = idMoneda;
        this.tipoMoneda = tipoMoneda;
        this.simboloMoneda = simboloMoneda;
        this.estadoMoneda = estadoMoneda;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getSimboloMoneda() {
        return simboloMoneda;
    }

    public void setSimboloMoneda(String simboloMoneda) {
        this.simboloMoneda = simboloMoneda;
    }

    public String getEstadoMoneda() {
        return estadoMoneda;
    }

    public void setEstadoMoneda(String estadoMoneda) {
        this.estadoMoneda = estadoMoneda;
    }

    public List<MetodosPago> getMetodosPagoList() {
        return metodosPagoList;
    }

    public void setMetodosPagoList(List<MetodosPago> metodosPagoList) {
        this.metodosPagoList = metodosPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMoneda != null ? idMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monedas)) {
            return false;
        }
        Monedas other = (Monedas) object;
        if ((this.idMoneda == null && other.idMoneda != null) || (this.idMoneda != null && !this.idMoneda.equals(other.idMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Monedas[ idMoneda=" + idMoneda + " ]";
    }

    public List<DenominacionEfectivo> getDenominacionEfectivoList() {
        return denominacionEfectivoList;
    }

    public void setDenominacionEfectivoList(List<DenominacionEfectivo> denominacionEfectivoList) {
        this.denominacionEfectivoList = denominacionEfectivoList;
    }

    public List<TipoCambio> getTipoCambioList() {
        return tipoCambioList;
    }

    public void setTipoCambioList(List<TipoCambio> tipoCambioList) {
        this.tipoCambioList = tipoCambioList;
    }
    
}
