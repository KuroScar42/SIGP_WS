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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Productos")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByCodigoInterno", query = "SELECT p FROM Productos p WHERE p.codigoInterno = :codigoInterno"),
    @NamedQuery(name = "Productos.findByCodigoBarras", query = "SELECT p FROM Productos p WHERE p.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "Productos.findProductosByBodega", query = "SELECT p FROM Bodegas b join b.bodegasProductosList bp join bp.idProducto p WHERE p.estado = 'A' and b.idBodega = :idBodega"),
    @NamedQuery(name = "Productos.findProductosByBodegaComplete", query = "SELECT p,bp FROM Bodegas b join b.bodegasProductosList bp join bp.idProducto p WHERE b.idBodega = :idBodega and p.estado = 'A'"),
    @NamedQuery(name = "Productos.findProductosByBodegaCompleteSR", query = "SELECT p,bp FROM Bodegas b join b.bodegasProductosList bp join bp.idProducto p WHERE b.idBodega = :idBodega"),
    @NamedQuery(name = "Productos.findProductoByBodega", query = "SELECT p,bp FROM Bodegas b join b.bodegasProductosList bp join bp.idProducto p WHERE p.estado = 'A' and b.idBodega = :idBodega and p.codigoInterno = :codigo"),
    @NamedQuery(name = "Productos.findProductoByPedido", query = "SELECT p,pl,pe FROM Productos p join p.productosPedidosList pl join pl.idPedidos pe where pe.idPedidos = :pedidoId"),
    @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Productos.findByDescripcionProducto", query = "SELECT p FROM Productos p WHERE p.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "Productos.findByUnidadEmbalage", query = "SELECT p FROM Productos p WHERE p.unidadEmbalage = :unidadEmbalage"),
    @NamedQuery(name = "Productos.findByPrecioCosto", query = "SELECT p FROM Productos p WHERE p.precioCosto = :precioCosto"),
    @NamedQuery(name = "Productos.findByCodigoCabys", query = "SELECT p FROM Productos p WHERE p.codigoCabys = :codigoCabys"),
    @NamedQuery(name = "Productos.findByCaducidad", query = "SELECT p FROM Productos p WHERE p.caducidad = :caducidad"),
    @NamedQuery(name = "Productos.findByEstado", query = "SELECT p FROM Productos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Productos.findByVersion", query = "SELECT p FROM Productos p WHERE p.version = :version")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Size(max = 8)
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @Size(max = 16)
    @Column(name = "CODIGO_BARRAS")
    private String codigoBarras;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_PRODUCTO")
    private String descripcionProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIDAD_EMBALAGE")
    private float unidadEmbalage;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "PRECIO_COSTO")
    private float precioCosto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CODIGO_CABYS")
    private String codigoCabys;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IVA_PRODUCTO")
    private Float ivaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;
    @Column(name = "CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date caducidad;
    @JoinTable(name = "Productos_Proveedores", joinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")})
    @ManyToMany
    private List<Proveedores> proveedoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<ProductosPedidos> productosPedidosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<FacturasProductos> facturasProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<BodegasProductos> bodegasProductosList;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String nombreProducto, float unidadEmbalage, float precioCosto, String codigoCabys, String estado, int version) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.unidadEmbalage = unidadEmbalage;
        this.precioCosto = precioCosto;
        this.codigoCabys = codigoCabys;
        this.estado = estado;
        this.version = version;
    }
    
    public Productos(ProductosDto p) {
        this.idProducto = p.getId();
        actualizarProducto(p);
    }
    
    public void actualizarProducto(ProductosDto p) {
        this.nombreProducto = p.getNombre();
        this.codigoInterno =p.getCodigoInterno();
        this.unidadEmbalage = p.getUnidadEmbalage();
        this.precioCosto = p.getCosto();
        this.codigoCabys = p.getCodigoCabys();
        this.estado = p.getEstado();
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getUnidadEmbalage() {
        return unidadEmbalage;
    }

    public void setUnidadEmbalage(float unidadEmbalage) {
        this.unidadEmbalage = unidadEmbalage;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public String getCodigoCabys() {
        return codigoCabys;
    }

    public void setCodigoCabys(String codigoCabys) {
        this.codigoCabys = codigoCabys;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public float getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(float ivaProducto) {
        this.ivaProducto = ivaProducto;
    }


    public List<Proveedores> getProveedoresList() {
        return proveedoresList;
    }

    public void setProveedoresList(List<Proveedores> proveedoresList) {
        this.proveedoresList = proveedoresList;
    }

    public List<ProductosPedidos> getProductosPedidosList() {
        return productosPedidosList;
    }

    public void setProductosPedidosList(List<ProductosPedidos> productosPedidosList) {
        this.productosPedidosList = productosPedidosList;
    }

    public List<FacturasProductos> getFacturasProductosList() {
        return facturasProductosList;
    }

    public void setFacturasProductosList(List<FacturasProductos> facturasProductosList) {
        this.facturasProductosList = facturasProductosList;
    }

    public List<BodegasProductos> getBodegasProductosList() {
        return bodegasProductosList;
    }

    public void setBodegasProductosList(List<BodegasProductos> bodegasProductosList) {
        this.bodegasProductosList = bodegasProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Productos[ idProducto=" + idProducto + " ]";
    }

    public void setIvaProducto(Float ivaProducto) {
        this.ivaProducto = ivaProducto;
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
    
}
