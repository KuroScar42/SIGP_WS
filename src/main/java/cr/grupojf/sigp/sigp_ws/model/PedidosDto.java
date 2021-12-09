/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class PedidosDto {

    private Integer Id;
    private String codigoPedido;
    private String fechaEntrega;
    private String fechaPedido;
    private String estado;
    private String descripcion;
    private ClientesDto cliente;

    public PedidosDto(Pedidos p) {
        this.Id = p.getIdPedidos();
        this.codigoPedido = p.getCodigoPedido();
//        this.fechaEntrega = p.getFechaEntrega().toString();
//        this.fechaPedido = p.getFechaPedido().toString();
        this.estado = p.getEstadoPedido();
        this.descripcion = p.getDescripcionPedido();
        if (p.getIdCliente() != null) {
            this.cliente = new ClientesDto(p.getIdCliente());
        }
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

    public ClientesDto getCliente() {
        return cliente;
    }

    public void setCliente(ClientesDto cliente) {
        this.cliente = cliente;
    }

}
