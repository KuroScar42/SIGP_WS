/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "Facturas")
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByIdFactura", query = "SELECT f FROM Facturas f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Facturas.findByReferenciaFactura", query = "SELECT f FROM Facturas f WHERE f.referenciaFactura = :referenciaFactura"),
    @NamedQuery(name = "Facturas.findByClaveFactura", query = "SELECT f FROM Facturas f WHERE f.claveFactura = :claveFactura"),
    @NamedQuery(name = "Facturas.findByElectronicaFactura", query = "SELECT f FROM Facturas f WHERE f.electronicaFactura = :electronicaFactura"),
    @NamedQuery(name = "Facturas.findByFechaFactura", query = "SELECT f FROM Facturas f WHERE f.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "Facturas.findByEstadoFactura", query = "SELECT f FROM Facturas f WHERE f.estadoFactura = :estadoFactura"),
    @NamedQuery(name = "Facturas.findByVersionFactura", query = "SELECT f FROM Facturas f WHERE f.versionFactura = :versionFactura"),
    @NamedQuery(name = "Facturas.findBySubtotalFactura", query = "SELECT f FROM Facturas f WHERE f.subtotalFactura = :subtotalFactura"),
    @NamedQuery(name = "Facturas.findByIvaFactura", query = "SELECT f FROM Facturas f WHERE f.ivaFactura = :ivaFactura"),
    @NamedQuery(name = "Facturas.findByTotalFactura", query = "SELECT f FROM Facturas f WHERE f.totalFactura = :totalFactura"),
    @NamedQuery(name = "Facturas.findByPagoFactura", query = "SELECT f FROM Facturas f WHERE f.pagoFactura = :pagoFactura"),
    @NamedQuery(name = "Facturas.findByVueltoFactura", query = "SELECT f FROM Facturas f WHERE f.vueltoFactura = :vueltoFactura"),
    @NamedQuery(name = "Facturas.findByObservacionesFactura", query = "SELECT f FROM Facturas f WHERE f.observacionesFactura = :observacionesFactura")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TIPO_FACTURA")
    private byte[] tipoFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "REFERENCIA_FACTURA")
    private String referenciaFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CLAVE_FACTURA")
    private String claveFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ELECTRONICA_FACTURA")
    private String electronicaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_FACTURA")
    private String estadoFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION_FACTURA")
    private int versionFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBTOTAL_FACTURA")
    private float subtotalFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA_FACTURA")
    private float ivaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_FACTURA")
    private float totalFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_FACTURA")
    private float pagoFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VUELTO_FACTURA")
    private float vueltoFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "OBSERVACIONES_FACTURA")
    private String observacionesFactura;
    @JoinColumn(name = "ID_APERTURA", referencedColumnName = "ID_APERTURA")
    @ManyToOne
    private AperturaCaja idApertura;
    @JoinColumn(name = "ID_EMISOR", referencedColumnName = "ID_EMISOR")
    @ManyToOne(optional = false)
    private Emisores idEmisor;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "ID_METODO", referencedColumnName = "ID_METODO")
    @ManyToOne(optional = false)
    private MetodosPago idMetodo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<FacturasProductos> facturasProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<Clientes> clientesList;

    public Facturas() {
    }

    public Facturas(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Facturas(Integer idFactura, byte[] tipoFactura, String referenciaFactura, String claveFactura, String electronicaFactura, Date fechaFactura, String estadoFactura, int versionFactura, float subtotalFactura, float ivaFactura, float totalFactura, float pagoFactura, float vueltoFactura, String observacionesFactura) {
        this.idFactura = idFactura;
        this.tipoFactura = tipoFactura;
        this.referenciaFactura = referenciaFactura;
        this.claveFactura = claveFactura;
        this.electronicaFactura = electronicaFactura;
        this.fechaFactura = fechaFactura;
        this.estadoFactura = estadoFactura;
        this.versionFactura = versionFactura;
        this.subtotalFactura = subtotalFactura;
        this.ivaFactura = ivaFactura;
        this.totalFactura = totalFactura;
        this.pagoFactura = pagoFactura;
        this.vueltoFactura = vueltoFactura;
        this.observacionesFactura = observacionesFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public byte[] getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(byte[] tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getReferenciaFactura() {
        return referenciaFactura;
    }

    public void setReferenciaFactura(String referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
    }

    public String getClaveFactura() {
        return claveFactura;
    }

    public void setClaveFactura(String claveFactura) {
        this.claveFactura = claveFactura;
    }

    public String getElectronicaFactura() {
        return electronicaFactura;
    }

    public void setElectronicaFactura(String electronicaFactura) {
        this.electronicaFactura = electronicaFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public int getVersionFactura() {
        return versionFactura;
    }

    public void setVersionFactura(int versionFactura) {
        this.versionFactura = versionFactura;
    }

    public float getSubtotalFactura() {
        return subtotalFactura;
    }

    public void setSubtotalFactura(float subtotalFactura) {
        this.subtotalFactura = subtotalFactura;
    }

    public float getIvaFactura() {
        return ivaFactura;
    }

    public void setIvaFactura(float ivaFactura) {
        this.ivaFactura = ivaFactura;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }

    public float getPagoFactura() {
        return pagoFactura;
    }

    public void setPagoFactura(float pagoFactura) {
        this.pagoFactura = pagoFactura;
    }

    public float getVueltoFactura() {
        return vueltoFactura;
    }

    public void setVueltoFactura(float vueltoFactura) {
        this.vueltoFactura = vueltoFactura;
    }

    public String getObservacionesFactura() {
        return observacionesFactura;
    }

    public void setObservacionesFactura(String observacionesFactura) {
        this.observacionesFactura = observacionesFactura;
    }

    public AperturaCaja getIdApertura() {
        return idApertura;
    }

    public void setIdApertura(AperturaCaja idApertura) {
        this.idApertura = idApertura;
    }

    public Emisores getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(Emisores idEmisor) {
        this.idEmisor = idEmisor;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public MetodosPago getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(MetodosPago idMetodo) {
        this.idMetodo = idMetodo;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<FacturasProductos> getFacturasProductosList() {
        return facturasProductosList;
    }

    public void setFacturasProductosList(List<FacturasProductos> facturasProductosList) {
        this.facturasProductosList = facturasProductosList;
    }

    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Facturas[ idFactura=" + idFactura + " ]";
    }
    
}
