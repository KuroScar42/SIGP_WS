/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Facturas_Productos")
@NamedQueries({
    @NamedQuery(name = "FacturasProductos.findAll", query = "SELECT f FROM FacturasProductos f"),
    @NamedQuery(name = "FacturasProductos.findByIdFacturasProductos", query = "SELECT f FROM FacturasProductos f WHERE f.idFacturasProductos = :idFacturasProductos"),
    @NamedQuery(name = "FacturasProductos.findByCantidadProducto", query = "SELECT f FROM FacturasProductos f WHERE f.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "FacturasProductos.findByDescuentoProducto", query = "SELECT f FROM FacturasProductos f WHERE f.descuentoProducto = :descuentoProducto"),
    @NamedQuery(name = "FacturasProductos.findByIvaProducto", query = "SELECT f FROM FacturasProductos f WHERE f.ivaProducto = :ivaProducto"),
    @NamedQuery(name = "FacturasProductos.findByPrecio", query = "SELECT f FROM FacturasProductos f WHERE f.precio = :precio"),
    @NamedQuery(name = "FacturasProductos.findByPrecioIva", query = "SELECT f FROM FacturasProductos f WHERE f.precioIva = :precioIva")})
public class FacturasProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURAS_PRODUCTOS")
    private Integer idFacturasProductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private float cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO_PRODUCTO")
    private float descuentoProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA_PRODUCTO")
    private float ivaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_IVA")
    private float precioIva;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Productos idProducto;
    @JoinColumn(name = "ID_FACTURA", referencedColumnName = "ID_FACTURA")
    @ManyToOne(optional = false)
    private Facturas idFactura;

    public FacturasProductos() {
    }

    public FacturasProductos(Integer idFacturasProductos) {
        this.idFacturasProductos = idFacturasProductos;
    }

    public FacturasProductos(Integer idFacturasProductos, float cantidadProducto, float descuentoProducto, float ivaProducto, float precio, float precioIva) {
        this.idFacturasProductos = idFacturasProductos;
        this.cantidadProducto = cantidadProducto;
        this.descuentoProducto = descuentoProducto;
        this.ivaProducto = ivaProducto;
        this.precio = precio;
        this.precioIva = precioIva;
    }

    public Integer getIdFacturasProductos() {
        return idFacturasProductos;
    }

    public void setIdFacturasProductos(Integer idFacturasProductos) {
        this.idFacturasProductos = idFacturasProductos;
    }

    public float getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(float cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(float descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public float getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(float ivaProducto) {
        this.ivaProducto = ivaProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(float precioIva) {
        this.precioIva = precioIva;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturasProductos != null ? idFacturasProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasProductos)) {
            return false;
        }
        FacturasProductos other = (FacturasProductos) object;
        if ((this.idFacturasProductos == null && other.idFacturasProductos != null) || (this.idFacturasProductos != null && !this.idFacturasProductos.equals(other.idFacturasProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.FacturasProductos[ idFacturasProductos=" + idFacturasProductos + " ]";
    }
    
}
