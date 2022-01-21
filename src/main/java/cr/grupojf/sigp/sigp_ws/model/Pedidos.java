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
@Table(name = "Pedidos")
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p where p.estadoPedido = 'A'"),
    @NamedQuery(name = "Pedidos.findByIdPedidos", query = "SELECT p FROM Pedidos p WHERE p.idPedidos = :idPedidos"),
    @NamedQuery(name = "Pedidos.findByCodigoPedido", query = "SELECT p FROM Pedidos p WHERE p.codigoPedido = :codigoPedido"),
    @NamedQuery(name = "Pedidos.findByFechaEntrega", query = "SELECT p FROM Pedidos p WHERE p.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "Pedidos.findByEstadoPedido", query = "SELECT p FROM Pedidos p WHERE p.estadoPedido = :estadoPedido"),
    @NamedQuery(name = "Pedidos.findByDescripcionPedido", query = "SELECT p FROM Pedidos p WHERE p.descripcionPedido = :descripcionPedido"),
    @NamedQuery(name = "Pedidos.findByCliente", query = "SELECT p FROM Pedidos p WHERE p.cliente = :cliente")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PEDIDOS")
    private Integer idPedidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO_PEDIDO")
    private String codigoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_PEDIDO")
    private String estadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLIENTE")
    private String cliente;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_PEDIDO")
    private String descripcionPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedidos")
    private List<ProductosPedidos> productosPedidosList;

    
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public Pedidos() {
    }

    public Pedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Pedidos(Integer idPedidos, String codigoPedido, Date fechaEntrega, String estadoPedido, String cliente) {
        this.idPedidos = idPedidos;
        this.codigoPedido = codigoPedido;
        this.fechaEntrega = fechaEntrega;
        this.estadoPedido = estadoPedido;
        this.cliente = cliente;
    }

    public Pedidos(PedidosDto pedidoDto) {
        this.idPedidos = pedidoDto.getId();
        actualizarPedido(pedidoDto);
    }
    
    public void actualizarPedido(PedidosDto p) {
        this.codigoPedido = p.getCodigoPedido();
        this.descripcionPedido = p.getDescripcion();
        this.estadoPedido = p.getEstado();
        this.fechaEntrega = p.getFechaEntrega();
        this.fechaPedido = p.getFechaPedido();
        this.cliente=p.getCliente();
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getDescripcionPedido() {
        return descripcionPedido;
    }

    public void setDescripcionPedido(String descripcionPedido) {
        this.descripcionPedido = descripcionPedido;
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
        hash += (idPedidos != null ? idPedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedidos == null && other.idPedidos != null) || (this.idPedidos != null && !this.idPedidos.equals(other.idPedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Pedidos[ idPedidos=" + idPedidos + " ]";
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ProductosPedidos> getProductosPedidosList() {
        return productosPedidosList;
    }

    public void setProductosPedidosList(List<ProductosPedidos> productosPedidosList) {
        this.productosPedidosList = productosPedidosList;
    }
    
}
