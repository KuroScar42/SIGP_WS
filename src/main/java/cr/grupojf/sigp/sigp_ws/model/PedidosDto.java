/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author sigp
 */
public class PedidosDto {

    private Integer Id;
    private String codigoPedido;
    private Date fechaEntrega;
    private Date fechaPedido;
    private String estado;
    private String descripcion;
    private String cliente;
    private List<ProductosPedidosDto> productosPedido;
    private List<ProductosPedidosDto> eliminados;
    private PersonasDto persona;

    public PedidosDto(Pedidos p) {
        this.Id = p.getIdPedidos();
        this.codigoPedido = p.getCodigoPedido();
        this.fechaEntrega = p.getFechaEntrega();
        this.fechaPedido = p.getFechaPedido();
        this.estado = p.getEstadoPedido();
        this.descripcion = p.getDescripcionPedido();
        this.cliente = p.getCliente();
        if (p.getIdUsuario() != null) {
            this.persona = new PersonasDto(p.getIdUsuario().getIdPresona());
        }
    }

    public PedidosDto() {
    }
    

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ProductosPedidosDto> getProductosPedido() {
        return productosPedido;
    }

    public void setProductosPedido(List<ProductosPedidosDto> productosPedido) {
        this.productosPedido = productosPedido;
    }

    public PersonasDto getPersona() {
        return persona;
    }

    public void setPersona(PersonasDto persona) {
        this.persona = persona;
    }

    public List<ProductosPedidosDto> getEliminados() {
        return eliminados;
    }

    public void setEliminados(List<ProductosPedidosDto> eliminados) {
        this.eliminados = eliminados;
    }
    
    
    
    

}
