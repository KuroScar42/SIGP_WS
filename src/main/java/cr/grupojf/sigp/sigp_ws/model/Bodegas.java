/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Bodegas")
@NamedQueries({
    @NamedQuery(name = "Bodegas.findAll", query = "SELECT b FROM Bodegas b"),
    @NamedQuery(name = "Bodegas.findAllActives", query = "SELECT b FROM Bodegas b where b.estado = 'A'"),
    @NamedQuery(name = "Bodegas.findByIdBodega", query = "SELECT b FROM Bodegas b WHERE b.idBodega = :idBodega"),
//    @NamedQuery(name = "Bodegas.findProductosByBodega", query = "SELECT p FROM Bodegas b join b.bodegasProductosList bp join bp.idProducto p WHERE p.estado = 'A' and b.idBodega = :idBodega"),
//    @NamedQuery(name = "Bodegas.findProductosByIds", query = "SELECT p FROM Bodegas b join b.bodegasProductosList bp join bp.idProducto p WHERE p.estado = 'A' and b.idBodega = :idBodega and p.codigoInterno = :codigo"),
    @NamedQuery(name = "Bodegas.findByCodigoBodega", query = "SELECT b FROM Bodegas b WHERE b.codigoBodega = :codigoBodega"),
    @NamedQuery(name = "Bodegas.findByNombreBodega", query = "SELECT b FROM Bodegas b WHERE b.nombreBodega = :nombreBodega"),
    @NamedQuery(name = "Bodegas.findByDescripcion", query = "SELECT b FROM Bodegas b WHERE b.descripcion = :descripcion"),
    @NamedQuery(name = "Bodegas.findByEstado", query = "SELECT b FROM Bodegas b WHERE b.estado = :estado"),
    @NamedQuery(name = "Bodegas.findByVersion", query = "SELECT b FROM Bodegas b WHERE b.version = :version")})
public class Bodegas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BODEGA")
    private Integer idBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODIGO_BODEGA")
    private String codigoBodega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_BODEGA")
    private String nombreBodega;
    @Size(max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBodega")
    private List<BodegasProductos> bodegasProductosList;

    public Bodegas() {
    }

    public Bodegas(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Bodegas(Integer idBodega, String codigoBodega, String nombreBodega, String estado, int version) {
        this.idBodega = idBodega;
        this.codigoBodega = codigoBodega;
        this.nombreBodega = nombreBodega;
        this.estado = estado;
        this.version = version;
    }

    Bodegas(BodegaDto b) {
        this.idBodega = b.getId();
        this.actualizar(b);
        
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<BodegasProductos> getBodegasProductosList() {
        return bodegasProductosList;
    }

    public void setBodegasProductosList(List<BodegasProductos> bodegasProductosList) {
        this.bodegasProductosList = bodegasProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodegas)) {
            return false;
        }
        Bodegas other = (Bodegas) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Bodegas[ idBodega=" + idBodega + " ]";
    }

    public void actualizar(BodegaDto b) {
//        this.
    }
    
}
