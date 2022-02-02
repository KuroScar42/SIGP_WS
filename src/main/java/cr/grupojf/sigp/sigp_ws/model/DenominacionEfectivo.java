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
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Denominacion_Efectivo")
@NamedQueries({
    @NamedQuery(name = "DenominacionEfectivo.findAll", query = "SELECT d FROM DenominacionEfectivo d"),
    @NamedQuery(name = "DenominacionEfectivo.findByIdDenominacion", query = "SELECT d FROM DenominacionEfectivo d WHERE d.idDenominacion = :idDenominacion"),
    @NamedQuery(name = "DenominacionEfectivo.findByDenominacionEfectivo", query = "SELECT d FROM DenominacionEfectivo d WHERE d.denominacionEfectivo = :denominacionEfectivo"),
    @NamedQuery(name = "DenominacionEfectivo.findByEstadoDenominacion", query = "SELECT d FROM DenominacionEfectivo d WHERE d.estadoDenominacion = :estadoDenominacion")})
public class DenominacionEfectivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DENOMINACION")
    private Integer idDenominacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DENOMINACION_EFECTIVO")
    private String denominacionEfectivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_DENOMINACION")
    private String estadoDenominacion;
    @JoinColumn(name = "ID_MONEDA", referencedColumnName = "ID_MONEDA")
    @ManyToOne
    private Monedas idMoneda;
    @OneToMany(mappedBy = "idDenominacion")
    private List<Efectivo> efectivoList;

    public DenominacionEfectivo() {
    }

    public DenominacionEfectivo(Integer idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public DenominacionEfectivo(Integer idDenominacion, String denominacionEfectivo, String estadoDenominacion) {
        this.idDenominacion = idDenominacion;
        this.denominacionEfectivo = denominacionEfectivo;
        this.estadoDenominacion = estadoDenominacion;
    }

    public Integer getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(Integer idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public String getDenominacionEfectivo() {
        return denominacionEfectivo;
    }

    public void setDenominacionEfectivo(String denominacionEfectivo) {
        this.denominacionEfectivo = denominacionEfectivo;
    }

    public String getEstadoDenominacion() {
        return estadoDenominacion;
    }

    public void setEstadoDenominacion(String estadoDenominacion) {
        this.estadoDenominacion = estadoDenominacion;
    }

    public Monedas getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Monedas idMoneda) {
        this.idMoneda = idMoneda;
    }

    public List<Efectivo> getEfectivoList() {
        return efectivoList;
    }

    public void setEfectivoList(List<Efectivo> efectivoList) {
        this.efectivoList = efectivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenominacion != null ? idDenominacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DenominacionEfectivo)) {
            return false;
        }
        DenominacionEfectivo other = (DenominacionEfectivo) object;
        if ((this.idDenominacion == null && other.idDenominacion != null) || (this.idDenominacion != null && !this.idDenominacion.equals(other.idDenominacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.DenominacionEfectivo[ idDenominacion=" + idDenominacion + " ]";
    }
    
}
