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
@Table(name = "Productos_Pedidos")
@NamedQueries({
    @NamedQuery(name = "ProductosPedidos.findAll", query = "SELECT p FROM ProductosPedidos p"),
    @NamedQuery(name = "ProductosPedidos.findByIdProductosPedidos", query = "SELECT p FROM ProductosPedidos p WHERE p.idProductosPedidos = :idProductosPedidos"),
    @NamedQuery(name = "ProductosPedidos.findByCantidad", query = "SELECT p FROM ProductosPedidos p WHERE p.cantidad = :cantidad")})
public class ProductosPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCTOS_PEDIDOS")
    private Integer idProductosPedidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "ID_PEDIDOS", referencedColumnName = "ID_PEDIDOS")
    @ManyToOne(optional = false)
    private Pedidos idPedidos;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public ProductosPedidos() {
    }

    public ProductosPedidos(Integer idProductosPedidos) {
        this.idProductosPedidos = idProductosPedidos;
    }

    public ProductosPedidos(Integer idProductosPedidos, int cantidad) {
        this.idProductosPedidos = idProductosPedidos;
        this.cantidad = cantidad;
    }

    public Integer getIdProductosPedidos() {
        return idProductosPedidos;
    }

    public void setIdProductosPedidos(Integer idProductosPedidos) {
        this.idProductosPedidos = idProductosPedidos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedidos getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Pedidos idPedidos) {
        this.idPedidos = idPedidos;
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
        hash += (idProductosPedidos != null ? idProductosPedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosPedidos)) {
            return false;
        }
        ProductosPedidos other = (ProductosPedidos) object;
        if ((this.idProductosPedidos == null && other.idProductosPedidos != null) || (this.idProductosPedidos != null && !this.idProductosPedidos.equals(other.idProductosPedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.ProductosPedidos[ idProductosPedidos=" + idProductosPedidos + " ]";
    }
    
}
