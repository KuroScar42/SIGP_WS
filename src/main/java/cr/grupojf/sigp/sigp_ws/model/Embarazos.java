/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.persistence.OneToOne;
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
@Table(name = "Embarazos")
@NamedQueries({
    @NamedQuery(name = "Embarazos.findAll", query = "SELECT e FROM Embarazos e"),
    @NamedQuery(name = "Embarazos.findByIdEmbarazo", query = "SELECT e FROM Embarazos e WHERE e.idEmbarazo = :idEmbarazo"),
    @NamedQuery(name = "Embarazos.findByFechaEmbarazo", query = "SELECT e FROM Embarazos e WHERE e.fechaEmbarazo = :fechaEmbarazo"),
    @NamedQuery(name = "Embarazos.findByEstadoEmbarazo", query = "SELECT e FROM Embarazos e WHERE e.estadoEmbarazo = :estadoEmbarazo"),
    @NamedQuery(name = "Embarazos.findByFechaParto", query = "SELECT e FROM Embarazos e WHERE e.fechaParto = :fechaParto"),
    @NamedQuery(name = "Embarazos.findByDestallesEmbarazo", query = "SELECT e FROM Embarazos e WHERE e.destallesEmbarazo = :destallesEmbarazo")})
public class Embarazos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMBARAZO")
    private Integer idEmbarazo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EMBARAZO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmbarazo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO_EMBARAZO")
    private String estadoEmbarazo;
    @Basic(optional = false)
    @Column(name = "FECHA_PARTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaParto;
    @Size(max = 750)
    @Column(name = "DESTALLES_EMBARAZO")
    private String destallesEmbarazo;
    
//    @JoinColumn(name = "ID_CERDO", referencedColumnName = "ID_CERDO")
//    @ManyToOne
//    private Cerdos idCerdo;
    @OneToOne
    @JoinColumn(name = "ID_INSEMINACION", referencedColumnName = "ID_INSEMINACION")
    private Inseminacion idInseminacion;
//    @JoinColumn(name = "ID_PARTO", referencedColumnName = "ID_PARTO")
    
    @OneToOne(mappedBy = "idEmbarazo")
    private Partos idParto;
//    @OneToMany(mappedBy = "idEmbarazo")
//    private List<Partos> partosList;

    public Embarazos() {
    }

    public Embarazos(Integer idEmbarazo) {
        this.idEmbarazo = idEmbarazo;
    }

    public Embarazos(Integer idEmbarazo, Date fechaEmbarazo, String estadoEmbarazo, Date fechaParto) {
        this.idEmbarazo = idEmbarazo;
        this.fechaEmbarazo = fechaEmbarazo;
        this.estadoEmbarazo = estadoEmbarazo;
        this.fechaParto = fechaParto;
    }

    public Embarazos(EmbarazosDto embarazoDto) {
        this.idEmbarazo = embarazoDto.getId();
        this.actualizar(embarazoDto);
    }

    public Integer getIdEmbarazo() {
        return idEmbarazo;
    }

    public void setIdEmbarazo(Integer idEmbarazo) {
        this.idEmbarazo = idEmbarazo;
    }

    public Date getFechaEmbarazo() {
        return fechaEmbarazo;
    }

    public void setFechaEmbarazo(Date fechaEmbarazo) {
        this.fechaEmbarazo = fechaEmbarazo;
    }

    public String getEstadoEmbarazo() {
        return estadoEmbarazo;
    }

    public void setEstadoEmbarazo(String estadoEmbarazo) {
        this.estadoEmbarazo = estadoEmbarazo;
    }

    public Date getFechaParto() {
        return fechaParto;
    }

    public void setFechaParto(Date fechaParto) {
        this.fechaParto = fechaParto;
    }

    public String getDestallesEmbarazo() {
        return destallesEmbarazo;
    }

    public void setDestallesEmbarazo(String destallesEmbarazo) {
        this.destallesEmbarazo = destallesEmbarazo;
    }

//    public Cerdos getIdCerdo() {
//        return idCerdo;
//    }
//
//    public void setIdCerdo(Cerdos idCerdo) {
//        this.idCerdo = idCerdo;
//    }

    public Partos getIdParto() {
        return idParto;
    }

    public void setIdParto(Partos idParto) {
        this.idParto = idParto;
    }

    public Inseminacion getIdInseminacion() {
        return idInseminacion;
    }

    public void setIdInseminacion(Inseminacion idInseminacion) {
        this.idInseminacion = idInseminacion;
    }
    
//
//    public List<Partos> getPartosList() {
//        return partosList;
//    }
//
//    public void setPartosList(List<Partos> partosList) {
//        this.partosList = partosList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmbarazo != null ? idEmbarazo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Embarazos)) {
            return false;
        }
        Embarazos other = (Embarazos) object;
        if ((this.idEmbarazo == null && other.idEmbarazo != null) || (this.idEmbarazo != null && !this.idEmbarazo.equals(other.idEmbarazo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Embarazos[ idEmbarazo=" + idEmbarazo + " ]";
    }

    public void actualizar(EmbarazosDto e) {
        this.destallesEmbarazo = e.getDetalles();
        this.estadoEmbarazo = e.getEstado();
        try {
            this.fechaEmbarazo = LocalDateAdapter.adaptFromJson(e.getFecha());
            this.fechaParto = LocalDateAdapter.adaptFromJson(e.getParto());
        } catch (Exception ex) {
            Logger.getLogger(Embarazos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (e.getInseminacion() != null) {
            this.idInseminacion = new Inseminacion(e.getInseminacion());
        }
    }

}
