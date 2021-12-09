/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Cierres_Caja")
@NamedQueries({
    @NamedQuery(name = "CierresCaja.findAll", query = "SELECT c FROM CierresCaja c"),
    @NamedQuery(name = "CierresCaja.findByIdCierre", query = "SELECT c FROM CierresCaja c WHERE c.idCierre = :idCierre"),
    @NamedQuery(name = "CierresCaja.findByCodigoCierre", query = "SELECT c FROM CierresCaja c WHERE c.codigoCierre = :codigoCierre"),
    @NamedQuery(name = "CierresCaja.findByFechaCierre", query = "SELECT c FROM CierresCaja c WHERE c.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "CierresCaja.findByEstadoCierre", query = "SELECT c FROM CierresCaja c WHERE c.estadoCierre = :estadoCierre")})
public class CierresCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CIERRE")
    private Integer idCierre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO_CIERRE")
    private String codigoCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_CIERRE")
    private String estadoCierre;
    @JoinColumn(name = "ID_APERTURA", referencedColumnName = "ID_APERTURA")
    @ManyToOne
    private AperturaCaja idApertura;
    @JoinColumn(name = "ID_EFECTIVO", referencedColumnName = "ID_EFECTIVO")
    @ManyToOne
    private Efectivo idEfectivo;
    @JoinColumn(name = "ID_VALORES", referencedColumnName = "ID_VALORES")
    @ManyToOne
    private OtrosValores idValores;

    public CierresCaja() {
    }

    public CierresCaja(Integer idCierre) {
        this.idCierre = idCierre;
    }

    public CierresCaja(Integer idCierre, String codigoCierre, Date fechaCierre, String estadoCierre) {
        this.idCierre = idCierre;
        this.codigoCierre = codigoCierre;
        this.fechaCierre = fechaCierre;
        this.estadoCierre = estadoCierre;
    }

    public Integer getIdCierre() {
        return idCierre;
    }

    public void setIdCierre(Integer idCierre) {
        this.idCierre = idCierre;
    }

    public String getCodigoCierre() {
        return codigoCierre;
    }

    public void setCodigoCierre(String codigoCierre) {
        this.codigoCierre = codigoCierre;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEstadoCierre() {
        return estadoCierre;
    }

    public void setEstadoCierre(String estadoCierre) {
        this.estadoCierre = estadoCierre;
    }

    public AperturaCaja getIdApertura() {
        return idApertura;
    }

    public void setIdApertura(AperturaCaja idApertura) {
        this.idApertura = idApertura;
    }

    public Efectivo getIdEfectivo() {
        return idEfectivo;
    }

    public void setIdEfectivo(Efectivo idEfectivo) {
        this.idEfectivo = idEfectivo;
    }

    public OtrosValores getIdValores() {
        return idValores;
    }

    public void setIdValores(OtrosValores idValores) {
        this.idValores = idValores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCierre != null ? idCierre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CierresCaja)) {
            return false;
        }
        CierresCaja other = (CierresCaja) object;
        if ((this.idCierre == null && other.idCierre != null) || (this.idCierre != null && !this.idCierre.equals(other.idCierre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.CierresCaja[ idCierre=" + idCierre + " ]";
    }
    
}
