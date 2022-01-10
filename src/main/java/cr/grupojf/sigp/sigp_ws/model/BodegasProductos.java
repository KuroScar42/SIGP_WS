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
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Bodegas_Productos")
@NamedQueries({
    @NamedQuery(name = "BodegasProductos.findAll", query = "SELECT b FROM BodegasProductos b"),
    @NamedQuery(name = "BodegasProductos.findByIdBodegaProductos", query = "SELECT b FROM BodegasProductos b WHERE b.idBodegaProductos = :idBodegaProductos"),
    @NamedQuery(name = "BodegasProductos.findByCantidadProducto", query = "SELECT b FROM BodegasProductos b WHERE b.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "BodegasProductos.findByPrecioProducto", query = "SELECT b FROM BodegasProductos b WHERE b.precioProducto = :precioProducto"),
    @NamedQuery(name = "BodegasProductos.findByUnidadMedida", query = "SELECT b FROM BodegasProductos b WHERE b.unidadMedida = :unidadMedida")})
public class BodegasProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BODEGA_PRODUCTOS")
    private Integer idBodegaProductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private float cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_PRODUCTO")
    private float precioProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UNIDAD_MEDIDA")
    private String unidadMedida;
    @JoinColumn(name = "ID_BODEGA", referencedColumnName = "ID_BODEGA")
    @ManyToOne(optional = false)
    private Bodegas idBodega;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public BodegasProductos() {
    }

    public BodegasProductos(Integer idBodegaProductos) {
        this.idBodegaProductos = idBodegaProductos;
    }

    public BodegasProductos(Integer idBodegaProductos, float cantidadProducto, float precioProducto, String unidadMedida) {
        this.idBodegaProductos = idBodegaProductos;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.unidadMedida = unidadMedida;
    }

    public BodegasProductos(BodegasProductosDto bp) {
        this.idBodegaProductos = bp.getId();
        this.actualizar(bp);
    }

    public Integer getIdBodegaProductos() {
        return idBodegaProductos;
    }

    public void setIdBodegaProductos(Integer idBodegaProductos) {
        this.idBodegaProductos = idBodegaProductos;
    }

    public float getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(float cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Bodegas getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodegas idBodega) {
        this.idBodega = idBodega;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodegaProductos != null ? idBodegaProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BodegasProductos)) {
            return false;
        }
        BodegasProductos other = (BodegasProductos) object;
        if ((this.idBodegaProductos == null && other.idBodegaProductos != null) || (this.idBodegaProductos != null && !this.idBodegaProductos.equals(other.idBodegaProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.BodegasProductos[ idBodegaProductos=" + idBodegaProductos + " ]";
    }

    public void actualizar(BodegasProductosDto bp) {
        if (bp.getBodega() != null) {
            this.idBodega = new Bodegas(bp.getBodega());
        }
        if (bp.getProducto() != null) {
            this.idProducto = new Productos(bp.getProducto());
        }
        this.cantidadProducto = bp.getCantidad();
        this.precioProducto = bp.getPrecio();
        this.unidadMedida = bp.getUnidadMedida();
//        this.idBodega = bp.getBodega();
    }
    
}
