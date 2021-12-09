/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByIdProveedor", query = "SELECT p FROM Proveedores p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedores.findByNombreProveedor", query = "SELECT p FROM Proveedores p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedores.findByTipoCedula", query = "SELECT p FROM Proveedores p WHERE p.tipoCedula = :tipoCedula"),
    @NamedQuery(name = "Proveedores.findByCedula", query = "SELECT p FROM Proveedores p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Proveedores.findByRazonSocial", query = "SELECT p FROM Proveedores p WHERE p.razonSocial = :razonSocial"),
    @NamedQuery(name = "Proveedores.findByInteresMoratorio", query = "SELECT p FROM Proveedores p WHERE p.interesMoratorio = :interesMoratorio"),
    @NamedQuery(name = "Proveedores.findByDescuento", query = "SELECT p FROM Proveedores p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Proveedores.findByPlazoCredito", query = "SELECT p FROM Proveedores p WHERE p.plazoCredito = :plazoCredito"),
    @NamedQuery(name = "Proveedores.findByTipoDevoluciones", query = "SELECT p FROM Proveedores p WHERE p.tipoDevoluciones = :tipoDevoluciones"),
    @NamedQuery(name = "Proveedores.findByCuentaPago", query = "SELECT p FROM Proveedores p WHERE p.cuentaPago = :cuentaPago"),
    @NamedQuery(name = "Proveedores.findByEstado", query = "SELECT p FROM Proveedores p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proveedores.findByVersion", query = "SELECT p FROM Proveedores p WHERE p.version = :version")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_CEDULA")
    private String tipoCedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CEDULA")
    private String cedula;
    @Size(max = 30)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERES_MORATORIO")
    private float interesMoratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO")
    private float descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAZO_CREDITO")
    private int plazoCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_DEVOLUCIONES")
    private String tipoDevoluciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CUENTA_PAGO")
    private String cuentaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;
    @ManyToMany(mappedBy = "proveedoresList")
    private List<Productos> productosList;

    public Proveedores() {
    }

    public Proveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedores(Integer idProveedor, String nombreProveedor, String tipoCedula, String cedula, float interesMoratorio, float descuento, int plazoCredito, String tipoDevoluciones, String cuentaPago, String estado, int version) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.tipoCedula = tipoCedula;
        this.cedula = cedula;
        this.interesMoratorio = interesMoratorio;
        this.descuento = descuento;
        this.plazoCredito = plazoCredito;
        this.tipoDevoluciones = tipoDevoluciones;
        this.cuentaPago = cuentaPago;
        this.estado = estado;
        this.version = version;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(float interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public int getPlazoCredito() {
        return plazoCredito;
    }

    public void setPlazoCredito(int plazoCredito) {
        this.plazoCredito = plazoCredito;
    }

    public String getTipoDevoluciones() {
        return tipoDevoluciones;
    }

    public void setTipoDevoluciones(String tipoDevoluciones) {
        this.tipoDevoluciones = tipoDevoluciones;
    }

    public String getCuentaPago() {
        return cuentaPago;
    }

    public void setCuentaPago(String cuentaPago) {
        this.cuentaPago = cuentaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Proveedores[ idProveedor=" + idProveedor + " ]";
    }
    
}