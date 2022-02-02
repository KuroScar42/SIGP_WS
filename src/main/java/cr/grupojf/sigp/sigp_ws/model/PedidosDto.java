/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sigp
 */
public class PedidosDto {

    private Integer id;
    private String codigoPedido;
    public String fechaEntrega;
    public String fechaPedido;
    private String estado;
    private String descripcion;
    private String cliente;
    private List<ProductosPedidosDto> productosPedido;
    private List<ProductosPedidosDto> eliminados;
    private Integer idUsuario;

    public PedidosDto(Pedidos p) {
        this.id = p.getIdPedidos();
        this.codigoPedido = p.getCodigoPedido();
        try {
//        this.fechaEntrega = p.getFechaEntrega();
//        this.fechaPedido = p.getFechaPedido();
            this.fechaEntrega = LocalDateAdapter.adaptToJson(p.getFechaEntrega());
            this.fechaPedido = LocalDateAdapter.adaptToJson(p.getFechaPedido());
        } catch (Exception ex) {
            Logger.getLogger(PedidosDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estado = p.getEstadoPedido();
        this.descripcion = p.getDescripcionPedido();
        this.cliente = p.getCliente();
//        if (p.getIdUsuario() != null) {
//            this.persona = new PersonasDto(p.getIdUsuario().getIdPersona());
//        }
    }

    public PedidosDto() {
        eliminados = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
            this.fechaEntrega = fechaEntrega;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
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

//    public PersonasDto getPersona() {
//        return persona;
//    }
//
//    public void setPersona(PersonasDto persona) {
//        this.persona = persona;
//    }

    public List<ProductosPedidosDto> getEliminados() {
        return eliminados;
    }

    public void setEliminados(List<ProductosPedidosDto> eliminados) {
        this.eliminados = eliminados;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

}
