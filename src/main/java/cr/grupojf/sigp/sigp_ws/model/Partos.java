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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Partos")
@NamedQueries({
    @NamedQuery(name = "Partos.findAll", query = "SELECT p FROM Partos p"),
    @NamedQuery(name = "Partos.findByIdParto", query = "SELECT p FROM Partos p WHERE p.idParto = :idParto"),
    @NamedQuery(name = "Partos.findByFechaParto", query = "SELECT p FROM Partos p WHERE p.fechaParto = :fechaParto"),
    @NamedQuery(name = "Partos.findByTipoParto", query = "SELECT p FROM Partos p WHERE p.tipoParto = :tipoParto"),
    @NamedQuery(name = "Partos.findByCantidadVivos", query = "SELECT p FROM Partos p WHERE p.cantidadVivos = :cantidadVivos"),
    @NamedQuery(name = "Partos.findByCantidaNacidosMuertos", query = "SELECT p FROM Partos p WHERE p.cantidaNacidosMuertos = :cantidaNacidosMuertos"),
    @NamedQuery(name = "Partos.findByCantidaMomias", query = "SELECT p FROM Partos p WHERE p.cantidaMomias = :cantidaMomias"),
    @NamedQuery(name = "Partos.findByCantidadEstripados", query = "SELECT p FROM Partos p WHERE p.cantidadEstripados = :cantidadEstripados"),
    @NamedQuery(name = "Partos.findByEstadoCerda", query = "SELECT p FROM Partos p WHERE p.estadoCerda = :estadoCerda"),
    @NamedQuery(name = "Partos.findByCantidadTodalNacidos", query = "SELECT p FROM Partos p WHERE p.cantidadTodalNacidos = :cantidadTodalNacidos"),
    @NamedQuery(name = "Partos.findByDetalleParto", query = "SELECT p FROM Partos p WHERE p.detalleParto = :detalleParto")})
public class Partos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARTO")
    private Integer idParto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PARTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaParto;
    @Size(max = 3)
    @Column(name = "TIPO_PARTO")
    private String tipoParto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_VIVOS")
    private int cantidadVivos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_NACIDOS_MUERTOS")
    private int cantidadNacidosMuertos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_MOMIAS")
    private int cantidadMomias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_ESTRIPADOS")
    private int cantidadEstripados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO_CERDA")
    private String estadoCerda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_TODAL_NACIDOS")
    private int cantidadTodalNacidos;
    @Size(max = 750)
    @Column(name = "DETALLE_PARTO")
    private String detalleParto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDA_NACIDOS_MUERTOS")
    private int cantidaNacidosMuertos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDA_MOMIAS")
    private int cantidaMomias;
    @JoinTable(name = "Supervisores_Parto", joinColumns = {
        @JoinColumn(name = "ID_PARTO", referencedColumnName = "ID_PARTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "idParto")
    private List<Embarazos> embarazosList;
    @OneToMany(mappedBy = "idParto")
    private List<Lechones> lechonesList;
    @JoinColumn(name = "ID_EMBARAZO", referencedColumnName = "ID_EMBARAZO")
    @ManyToOne
    private Embarazos idEmbarazo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public Partos() {
    }

    public Partos(Integer idParto) {
        this.idParto = idParto;
    }

    public Partos(Integer idParto, Date fechaParto, int cantidadVivos, int cantidaNacidosMuertos, int cantidaMomias, int cantidadEstripados, String estadoCerda, int cantidadTodalNacidos) {
        this.idParto = idParto;
        this.fechaParto = fechaParto;
        this.cantidadVivos = cantidadVivos;
        this.cantidaNacidosMuertos = cantidaNacidosMuertos;
        this.cantidaMomias = cantidaMomias;
        this.cantidadEstripados = cantidadEstripados;
        this.estadoCerda = estadoCerda;
        this.cantidadTodalNacidos = cantidadTodalNacidos;
    }

    public Integer getIdParto() {
        return idParto;
    }

    public void setIdParto(Integer idParto) {
        this.idParto = idParto;
    }

    public Date getFechaParto() {
        return fechaParto;
    }

    public void setFechaParto(Date fechaParto) {
        this.fechaParto = fechaParto;
    }

    public String getTipoParto() {
        return tipoParto;
    }

    public void setTipoParto(String tipoParto) {
        this.tipoParto = tipoParto;
    }

    public int getCantidadVivos() {
        return cantidadVivos;
    }

    public void setCantidadVivos(int cantidadVivos) {
        this.cantidadVivos = cantidadVivos;
    }

    public int getCantidaNacidosMuertos() {
        return cantidaNacidosMuertos;
    }

    public void setCantidaNacidosMuertos(int cantidaNacidosMuertos) {
        this.cantidaNacidosMuertos = cantidaNacidosMuertos;
    }

    public int getCantidaMomias() {
        return cantidaMomias;
    }

    public void setCantidaMomias(int cantidaMomias) {
        this.cantidaMomias = cantidaMomias;
    }

    public int getCantidadEstripados() {
        return cantidadEstripados;
    }

    public void setCantidadEstripados(int cantidadEstripados) {
        this.cantidadEstripados = cantidadEstripados;
    }

    public String getEstadoCerda() {
        return estadoCerda;
    }

    public void setEstadoCerda(String estadoCerda) {
        this.estadoCerda = estadoCerda;
    }

    public int getCantidadTodalNacidos() {
        return cantidadTodalNacidos;
    }

    public void setCantidadTodalNacidos(int cantidadTodalNacidos) {
        this.cantidadTodalNacidos = cantidadTodalNacidos;
    }

    public String getDetalleParto() {
        return detalleParto;
    }

    public void setDetalleParto(String detalleParto) {
        this.detalleParto = detalleParto;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public List<Embarazos> getEmbarazosList() {
        return embarazosList;
    }

    public void setEmbarazosList(List<Embarazos> embarazosList) {
        this.embarazosList = embarazosList;
    }

    public List<Lechones> getLechonesList() {
        return lechonesList;
    }

    public void setLechonesList(List<Lechones> lechonesList) {
        this.lechonesList = lechonesList;
    }

    public Embarazos getIdEmbarazo() {
        return idEmbarazo;
    }

    public void setIdEmbarazo(Embarazos idEmbarazo) {
        this.idEmbarazo = idEmbarazo;
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
        hash += (idParto != null ? idParto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partos)) {
            return false;
        }
        Partos other = (Partos) object;
        if ((this.idParto == null && other.idParto != null) || (this.idParto != null && !this.idParto.equals(other.idParto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Partos[ idParto=" + idParto + " ]";
    }

    
    public int getCantidadNacidosMuertos() {
        return cantidadNacidosMuertos;
    }

    public void setCantidadNacidosMuertos(int cantidadNacidosMuertos) {
        this.cantidadNacidosMuertos = cantidadNacidosMuertos;
    }

    public int getCantidadMomias() {
        return cantidadMomias;
    }

    public void setCantidadMomias(int cantidadMomias) {
        this.cantidadMomias = cantidadMomias;
    }
    
}
