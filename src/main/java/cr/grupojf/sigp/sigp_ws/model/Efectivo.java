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
@Table(name = "Efectivo")
@NamedQueries({
    @NamedQuery(name = "Efectivo.findAll", query = "SELECT e FROM Efectivo e"),
    @NamedQuery(name = "Efectivo.findByIdEfectivo", query = "SELECT e FROM Efectivo e WHERE e.idEfectivo = :idEfectivo"),
    @NamedQuery(name = "Efectivo.findByCantidadEfectivo", query = "SELECT e FROM Efectivo e WHERE e.cantidadEfectivo = :cantidadEfectivo"),
    @NamedQuery(name = "Efectivo.findByTotalEfectivo", query = "SELECT e FROM Efectivo e WHERE e.totalEfectivo = :totalEfectivo")})
public class Efectivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EFECTIVO")
    private Integer idEfectivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_EFECTIVO")
    private int cantidadEfectivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_EFECTIVO")
    private int totalEfectivo;
    @OneToMany(mappedBy = "idEfectivo")
    private List<CierresCajas> cierresCajasList;
    @JoinColumn(name = "ID_DENOMINACION", referencedColumnName = "ID_DENOMINACION")
    @ManyToOne
    private DenominacionEfectivo idDenominacion;

    public Efectivo() {
    }

    public Efectivo(Integer idEfectivo) {
        this.idEfectivo = idEfectivo;
    }

    public Efectivo(Integer idEfectivo, int cantidadEfectivo, int totalEfectivo) {
        this.idEfectivo = idEfectivo;
        this.cantidadEfectivo = cantidadEfectivo;
        this.totalEfectivo = totalEfectivo;
    }

    public Integer getIdEfectivo() {
        return idEfectivo;
    }

    public void setIdEfectivo(Integer idEfectivo) {
        this.idEfectivo = idEfectivo;
    }

    public int getCantidadEfectivo() {
        return cantidadEfectivo;
    }

    public void setCantidadEfectivo(int cantidadEfectivo) {
        this.cantidadEfectivo = cantidadEfectivo;
    }

    public int getTotalEfectivo() {
        return totalEfectivo;
    }

    public void setTotalEfectivo(int totalEfectivo) {
        this.totalEfectivo = totalEfectivo;
    }

    public List<CierresCajas> getCierresCajasList() {
        return cierresCajasList;
    }

    public void setCierresCajasList(List<CierresCajas> cierresCajasList) {
        this.cierresCajasList = cierresCajasList;
    }

    public DenominacionEfectivo getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(DenominacionEfectivo idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEfectivo != null ? idEfectivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Efectivo)) {
            return false;
        }
        Efectivo other = (Efectivo) object;
        if ((this.idEfectivo == null && other.idEfectivo != null) || (this.idEfectivo != null && !this.idEfectivo.equals(other.idEfectivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Efectivo[ idEfectivo=" + idEfectivo + " ]";
    }
    
}
