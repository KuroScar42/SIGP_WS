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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Apertura_Caja")
@NamedQueries({
    @NamedQuery(name = "AperturaCaja.findAll", query = "SELECT a FROM AperturaCaja a"),
    @NamedQuery(name = "AperturaCaja.findByIdApertura", query = "SELECT a FROM AperturaCaja a WHERE a.idApertura = :idApertura"),
    @NamedQuery(name = "AperturaCaja.findByFechaCaja", query = "SELECT a FROM AperturaCaja a WHERE a.fechaCaja = :fechaCaja"),
    @NamedQuery(name = "AperturaCaja.findByEtadoCaja", query = "SELECT a FROM AperturaCaja a WHERE a.etadoCaja = :etadoCaja")})
public class AperturaCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_APERTURA")
    private Integer idApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ETADO_CAJA")
    private String etadoCaja;
    @OneToMany(mappedBy = "idApertura")
    private List<Facturas> facturasList;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;
    @OneToMany(mappedBy = "idApertura")
    private List<CierresCaja> cierresCajaList;

    public AperturaCaja() {
    }

    public AperturaCaja(Integer idApertura) {
        this.idApertura = idApertura;
    }

    public AperturaCaja(Integer idApertura, Date fechaCaja, String etadoCaja) {
        this.idApertura = idApertura;
        this.fechaCaja = fechaCaja;
        this.etadoCaja = etadoCaja;
    }

    public Integer getIdApertura() {
        return idApertura;
    }

    public void setIdApertura(Integer idApertura) {
        this.idApertura = idApertura;
    }

    public Date getFechaCaja() {
        return fechaCaja;
    }

    public void setFechaCaja(Date fechaCaja) {
        this.fechaCaja = fechaCaja;
    }

    public String getEtadoCaja() {
        return etadoCaja;
    }

    public void setEtadoCaja(String etadoCaja) {
        this.etadoCaja = etadoCaja;
    }

    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<CierresCaja> getCierresCajaList() {
        return cierresCajaList;
    }

    public void setCierresCajaList(List<CierresCaja> cierresCajaList) {
        this.cierresCajaList = cierresCajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApertura != null ? idApertura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AperturaCaja)) {
            return false;
        }
        AperturaCaja other = (AperturaCaja) object;
        if ((this.idApertura == null && other.idApertura != null) || (this.idApertura != null && !this.idApertura.equals(other.idApertura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.AperturaCaja[ idApertura=" + idApertura + " ]";
    }
    
}
