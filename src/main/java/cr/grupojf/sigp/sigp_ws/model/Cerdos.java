/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Cerdos")
@NamedQueries({
    @NamedQuery(name = "Cerdos.findAll", query = "SELECT c FROM Cerdos c"),
    @NamedQuery(name = "Cerdos.findByIdCerdo", query = "SELECT c FROM Cerdos c WHERE c.idCerdo = :idCerdo"),
    @NamedQuery(name = "Cerdos.findByCodigoCerdo", query = "SELECT c FROM Cerdos c join c.embarazosList e join e.idParto p where c.codigoCerdo = :codigoCerdo and c.estadoCerdo ='A'"),
    @NamedQuery(name = "Cerdos.findByEstadoCerdo", query = "SELECT c FROM Cerdos c WHERE c.estadoCerdo = :estadoCerdo"),
    @NamedQuery(name = "Cerdos.findByDescripcionCerdo", query = "SELECT c FROM Cerdos c WHERE c.descripcionCerdo = :descripcionCerdo"),
//    @NamedQuery(name = "Cerdos.findByFechaNacimiento", query = "SELECT c FROM Cerdos c WHERE c.fechaNacimiento = :fechaNacimiento"),
//    @NamedQuery(name = "Cerdos.findByPesoCerdo", query = "SELECT c FROM Cerdos c WHERE c.pesoCerdo = :pesoCerdo")
})
public class Cerdos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CERDO")
    private Integer idCerdo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CODIGO_CERDO")
    private String codigoCerdo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_CERDO")
    private String estadoCerdo;
    @Size(max = 800)
    @Column(name = "DESCRIPCION_CERDO")
    private String descripcionCerdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(mappedBy = "idCerdo")
    private List<Embarazos> embarazosList;
    @OneToMany(mappedBy = "idCerdo")
    private List<Inseminacion> inseminacionList;

    public Cerdos() {
    }

    public Cerdos(Integer idCerdo) {
        this.idCerdo = idCerdo;
    }

    public Cerdos(Integer idCerdo, String codigoCerdo, String estadoCerdo, Date fechaNacimiento, float pesoCerdo) {
        this.idCerdo = idCerdo;
        this.codigoCerdo = codigoCerdo;
        this.estadoCerdo = estadoCerdo;
        this.fechaRegistro = fechaNacimiento;
    }

    public Cerdos(CerdosDto cerdoDto) {
        this.idCerdo = cerdoDto.getId();
        this.actualizar(cerdoDto);
    }

    public Integer getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(Integer idCerdo) {
        this.idCerdo = idCerdo;
    }

    public String getCodigoCerdo() {
        return codigoCerdo;
    }

    public void setCodigoCerdo(String codigoCerdo) {
        this.codigoCerdo = codigoCerdo;
    }

    public String getEstadoCerdo() {
        return estadoCerdo;
    }

    public void setEstadoCerdo(String estadoCerdo) {
        this.estadoCerdo = estadoCerdo;
    }

    public String getDescripcionCerdo() {
        return descripcionCerdo;
    }

    public void setDescripcionCerdo(String descripcionCerdo) {
        this.descripcionCerdo = descripcionCerdo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaNacimiento) {
        this.fechaRegistro = fechaNacimiento;
    }

    public List<Embarazos> getEmbarazosList() {
        return embarazosList;
    }

    public void setEmbarazosList(List<Embarazos> embarazosList) {
        this.embarazosList = embarazosList;
    }

    public List<Inseminacion> getInseminacionList() {
        return inseminacionList;
    }

    public void setInseminacionList(List<Inseminacion> inseminacionList) {
        this.inseminacionList = inseminacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCerdo != null ? idCerdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cerdos)) {
            return false;
        }
        Cerdos other = (Cerdos) object;
        if ((this.idCerdo == null && other.idCerdo != null) || (this.idCerdo != null && !this.idCerdo.equals(other.idCerdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Cerdos[ idCerdo=" + idCerdo + " ]";
    }

    public void actualizar(CerdosDto cerdoDto) {
        this.codigoCerdo = cerdoDto.getCodigo();
        this.estadoCerdo = cerdoDto.getEstado();
        this.descripcionCerdo = cerdoDto.getDescripcion();
        try {
            this.fechaRegistro = LocalDateAdapter.adaptFromJson(cerdoDto.getRegistro());
        } catch (Exception e) {
        }
    }

}
