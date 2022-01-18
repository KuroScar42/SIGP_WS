/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "FacturasProductos.findByIvaProcucto", query = "SELECT f FROM FacturasProductos f WHERE f.ivaProcucto = :ivaProcucto"),
//    @NamedQuery(name = "FacturasProductos.findByPRECIOsIVA", query = "SELECT f FROM FacturasProductos f WHERE f.pRECIOsIVA = :pRECIOsIVA"),
//    @NamedQuery(name = "FacturasProductos.findByPRECIOcIVA", query = "SELECT f FROM FacturasProductos f WHERE f.pRECIOcIVA = :pRECIOcIVA")
})
public class FacturasProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "IVA_PROCUCTO")
    private float ivaProcucto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_sIVA")
    private float preciosIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_cIVA")
    private float preciocIva;
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

    public FacturasProductos(Integer idFacturasProductos, float cantidadProducto, float descuentoProducto, float ivaProcucto, float pRECIOsIVA, float pRECIOcIVA) {
        this.idFacturasProductos = idFacturasProductos;
        this.cantidadProducto = cantidadProducto;
        this.descuentoProducto = descuentoProducto;
        this.ivaProcucto = ivaProcucto;
        this.preciosIva = pRECIOsIVA;
        this.preciocIva = pRECIOcIVA;
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

    public float getIvaProcucto() {
        return ivaProcucto;
    }

    public void setIvaProcucto(float ivaProcucto) {
        this.ivaProcucto = ivaProcucto;
    }

    public float getPreciosIva() {
        return preciosIva;
    }

    public void setPreciosIva(float preciosIva) {
        this.preciosIva = preciosIva;
    }

    public float getPreciocIva() {
        return preciocIva;
    }

    public void setPreciocIva(float preciocIva) {
        this.preciocIva = preciocIva;
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
