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
@Table(name = "Lechones")
@NamedQueries({
    @NamedQuery(name = "Lechones.findAll", query = "SELECT l FROM Lechones l"),
    @NamedQuery(name = "Lechones.findByIdLechon", query = "SELECT l FROM Lechones l WHERE l.idLechon = :idLechon"),
    @NamedQuery(name = "Lechones.findByCodigoLechon", query = "SELECT l FROM Lechones l WHERE l.codigoLechon = :codigoLechon"),
    @NamedQuery(name = "Lechones.findByFechaNacimiento", query = "SELECT l FROM Lechones l WHERE l.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Lechones.findByEstadoLechon", query = "SELECT l FROM Lechones l WHERE l.estadoLechon = :estadoLechon"),
    @NamedQuery(name = "Lechones.findByTipoLechon", query = "SELECT l FROM Lechones l WHERE l.tipoLechon = :tipoLechon"),
    @NamedQuery(name = "Lechones.findByPesoLechon", query = "SELECT l FROM Lechones l WHERE l.pesoLechon = :pesoLechon"),
    @NamedQuery(name = "Lechones.findByDetallesLechon", query = "SELECT l FROM Lechones l WHERE l.detallesLechon = :detallesLechon")})
public class Lechones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LECHON")
    private Integer idLechon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CODIGO_LECHON")
    private String codigoLechon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO_LECHON")
    private String estadoLechon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_LECHON")
    private String tipoLechon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO_LECHON")
    private float pesoLechon;
    @Size(max = 750)
    @Column(name = "DETALLES_LECHON")
    private String detallesLechon;
    @JoinColumn(name = "ID_PARTO", referencedColumnName = "ID_PARTO")
    @ManyToOne
    private Partos idParto;

    public Lechones() {
    }

    public Lechones(Integer idLechon) {
        this.idLechon = idLechon;
    }

    public Lechones(Integer idLechon, String codigoLechon, Date fechaNacimiento, String estadoLechon, String tipoLechon, float pesoLechon) {
        this.idLechon = idLechon;
        this.codigoLechon = codigoLechon;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoLechon = estadoLechon;
        this.tipoLechon = tipoLechon;
        this.pesoLechon = pesoLechon;
    }

    public Integer getIdLechon() {
        return idLechon;
    }

    public void setIdLechon(Integer idLechon) {
        this.idLechon = idLechon;
    }

    public String getCodigoLechon() {
        return codigoLechon;
    }

    public void setCodigoLechon(String codigoLechon) {
        this.codigoLechon = codigoLechon;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoLechon() {
        return estadoLechon;
    }

    public void setEstadoLechon(String estadoLechon) {
        this.estadoLechon = estadoLechon;
    }

    public String getTipoLechon() {
        return tipoLechon;
    }

    public void setTipoLechon(String tipoLechon) {
        this.tipoLechon = tipoLechon;
    }

    public float getPesoLechon() {
        return pesoLechon;
    }

    public void setPesoLechon(float pesoLechon) {
        this.pesoLechon = pesoLechon;
    }

    public String getDetallesLechon() {
        return detallesLechon;
    }

    public void setDetallesLechon(String detallesLechon) {
        this.detallesLechon = detallesLechon;
    }

    public Partos getIdParto() {
        return idParto;
    }

    public void setIdParto(Partos idParto) {
        this.idParto = idParto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLechon != null ? idLechon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lechones)) {
            return false;
        }
        Lechones other = (Lechones) object;
        if ((this.idLechon == null && other.idLechon != null) || (this.idLechon != null && !this.idLechon.equals(other.idLechon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Lechones[ idLechon=" + idLechon + " ]";
    }
    
}
