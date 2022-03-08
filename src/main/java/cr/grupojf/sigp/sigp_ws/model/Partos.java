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
    @NamedQuery(name = "Partos.findByCantidadNacidosMuertos", query = "SELECT p FROM Partos p WHERE p.cantidadNacidosMuertos = :cantidadNacidosMuertos"),
    @NamedQuery(name = "Partos.findByCantidadMomias", query = "SELECT p FROM Partos p WHERE p.cantidadMomias = :cantidadMomias"),
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
    @NotNull
    @Column(name = "PESO_PRO_NACIMIENTO")
    private float pesoProNacimiento;
    @NotNull
    @Column(name = "PESO_PRO_DESTETE")
    private float pesoProDestete;
    @Size(max = 750)
    @Column(name = "DETALLE_PARTO")
    private String detalleParto;
    @JoinTable(name = "Supervisores_Parto", joinColumns = {
        @JoinColumn(name = "ID_PARTO", referencedColumnName = "ID_PARTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")})
    @ManyToMany
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "idParto")
    private List<Embarazos> embarazosList;
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

    public Partos(Integer idParto, Date fechaParto, int cantidadVivos, int cantidadNacidosMuertos, int cantidadMomias, int cantidadEstripados, String estadoCerda, int cantidadTodalNacidos) {
        this.idParto = idParto;
        this.fechaParto = fechaParto;
        this.cantidadVivos = cantidadVivos;
        this.cantidadNacidosMuertos = cantidadNacidosMuertos;
        this.cantidadMomias = cantidadMomias;
        this.cantidadEstripados = cantidadEstripados;
        this.estadoCerda = estadoCerda;
        this.cantidadTodalNacidos = cantidadTodalNacidos;
    }

    public Partos(PartosDto partoDto) {
        this.idParto = partoDto.getId();
        this.actualizar(partoDto);
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

    public float getPesoProNacimiento() {
        return pesoProNacimiento;
    }

    public void setPesoProNacimiento(float pesoProNacimiento) {
        this.pesoProNacimiento = pesoProNacimiento;
    }

    public float getPesoProDestete() {
        return pesoProDestete;
    }

    public void setPesoProDestete(float pesoProDestete) {
        this.pesoProDestete = pesoProDestete;
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

    public void actualizar(PartosDto p) {
        this.cantidadEstripados = p.getCantEstripados();
        this.cantidadMomias = p.getCantMomias();
        this.cantidadNacidosMuertos = p.getCantNacMuertos();
        this.cantidadTodalNacidos = p.getCantTotalNacidos();
        this.cantidadVivos = p.getCantVivos();
        this.detalleParto = p.getDetalles();
        try {
            this.fechaParto = LocalDateAdapter.adaptFromJson(p.getFecha());
        } catch (Exception ex) {
            Logger.getLogger(Partos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estadoCerda = p.getEstadoCerda();
        this.pesoProDestete = p.getPesoProDestete();
        this.pesoProNacimiento = p.getPesoProNacimiento();
        this.tipoParto = p.getTipo();
    }

}
