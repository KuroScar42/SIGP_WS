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
@Table(name = "Inseminacion")
@NamedQueries({
    @NamedQuery(name = "Inseminacion.findAll", query = "SELECT i FROM Inseminacion i"),
    @NamedQuery(name = "Inseminacion.findByIdInseminacion", query = "SELECT i FROM Inseminacion i WHERE i.idInseminacion = :idInseminacion"),
    @NamedQuery(name = "Inseminacion.findByCodigoEnsiminacion", query = "SELECT i FROM Inseminacion i WHERE i.codigoEnsiminacion = :codigoEnsiminacion"),
    @NamedQuery(name = "Inseminacion.findByFechaInseminacion", query = "SELECT i FROM Inseminacion i WHERE i.fechaInseminacion = :fechaInseminacion"),
    @NamedQuery(name = "Inseminacion.findByEstadoEnsiminacion", query = "SELECT i FROM Inseminacion i WHERE i.estadoEnsiminacion = :estadoEnsiminacion"),
    @NamedQuery(name = "Inseminacion.findByDetalleEnsiminacion", query = "SELECT i FROM Inseminacion i WHERE i.detalleEnsiminacion = :detalleEnsiminacion")})
public class Inseminacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INSEMINACION")
    private Integer idInseminacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CODIGO_ENSIMINACION")
    private String codigoEnsiminacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INSEMINACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInseminacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO_ENSIMINACION")
    private String estadoEnsiminacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 750)
    @Column(name = "DETALLE_ENSIMINACION")
    private String detalleEnsiminacion;
    @JoinColumn(name = "ID_CERDO", referencedColumnName = "ID_CERDO")
    @ManyToOne
    private Cerdos idCerdo;

    public Inseminacion() {
    }

    public Inseminacion(Integer idInseminacion) {
        this.idInseminacion = idInseminacion;
    }

    public Inseminacion(Integer idInseminacion, String codigoEnsiminacion, Date fechaInseminacion, String estadoEnsiminacion, String detalleEnsiminacion) {
        this.idInseminacion = idInseminacion;
        this.codigoEnsiminacion = codigoEnsiminacion;
        this.fechaInseminacion = fechaInseminacion;
        this.estadoEnsiminacion = estadoEnsiminacion;
        this.detalleEnsiminacion = detalleEnsiminacion;
    }

    public Integer getIdInseminacion() {
        return idInseminacion;
    }

    public void setIdInseminacion(Integer idInseminacion) {
        this.idInseminacion = idInseminacion;
    }

    public String getCodigoEnsiminacion() {
        return codigoEnsiminacion;
    }

    public void setCodigoEnsiminacion(String codigoEnsiminacion) {
        this.codigoEnsiminacion = codigoEnsiminacion;
    }

    public Date getFechaInseminacion() {
        return fechaInseminacion;
    }

    public void setFechaInseminacion(Date fechaInseminacion) {
        this.fechaInseminacion = fechaInseminacion;
    }

    public String getEstadoEnsiminacion() {
        return estadoEnsiminacion;
    }

    public void setEstadoEnsiminacion(String estadoEnsiminacion) {
        this.estadoEnsiminacion = estadoEnsiminacion;
    }

    public String getDetalleEnsiminacion() {
        return detalleEnsiminacion;
    }

    public void setDetalleEnsiminacion(String detalleEnsiminacion) {
        this.detalleEnsiminacion = detalleEnsiminacion;
    }

    public Cerdos getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(Cerdos idCerdo) {
        this.idCerdo = idCerdo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInseminacion != null ? idInseminacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inseminacion)) {
            return false;
        }
        Inseminacion other = (Inseminacion) object;
        if ((this.idInseminacion == null && other.idInseminacion != null) || (this.idInseminacion != null && !this.idInseminacion.equals(other.idInseminacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Inseminacion[ idInseminacion=" + idInseminacion + " ]";
    }
    
}
