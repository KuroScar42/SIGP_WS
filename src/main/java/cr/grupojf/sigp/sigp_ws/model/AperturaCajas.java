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
@Table(name = "Apertura_Cajas")
@NamedQueries({
    @NamedQuery(name = "AperturaCajas.findAll", query = "SELECT a FROM AperturaCajas a"),
    @NamedQuery(name = "AperturaCajas.findByIdApertura", query = "SELECT a FROM AperturaCajas a WHERE a.idApertura = :idApertura"),
    @NamedQuery(name = "AperturaCajas.findByFechaCaja", query = "SELECT a FROM AperturaCajas a WHERE a.fechaCaja = :fechaCaja"),
    @NamedQuery(name = "AperturaCajas.findByEstadoCaja", query = "SELECT a FROM AperturaCajas a WHERE a.estadoCaja = :estadoCaja")})
public class AperturaCajas implements Serializable {

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
    @Column(name = "ESTADO_CAJA")
    private String estadoCaja;
    @OneToMany(mappedBy = "idApertura")
    private List<CierresCajas> cierresCajasList;
    @OneToMany(mappedBy = "idApertura")
    private List<Facturas> facturasList;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public AperturaCajas() {
    }

    public AperturaCajas(Integer idApertura) {
        this.idApertura = idApertura;
    }

    public AperturaCajas(Integer idApertura, Date fechaCaja, String estadoCaja) {
        this.idApertura = idApertura;
        this.fechaCaja = fechaCaja;
        this.estadoCaja = estadoCaja;
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

    public String getEstadoCaja() {
        return estadoCaja;
    }

    public void setEstadoCaja(String estadoCaja) {
        this.estadoCaja = estadoCaja;
    }

    public List<CierresCajas> getCierresCajasList() {
        return cierresCajasList;
    }

    public void setCierresCajasList(List<CierresCajas> cierresCajasList) {
        this.cierresCajasList = cierresCajasList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApertura != null ? idApertura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AperturaCajas)) {
            return false;
        }
        AperturaCajas other = (AperturaCajas) object;
        if ((this.idApertura == null && other.idApertura != null) || (this.idApertura != null && !this.idApertura.equals(other.idApertura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.AperturaCajas[ idApertura=" + idApertura + " ]";
    }
    
}
