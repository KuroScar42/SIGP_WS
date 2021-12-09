/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class MetodosPagoDto {
    private Integer id;
    private String metodoPago;
    private String descripcion;
    private String estado;
    
    public MetodosPagoDto(){
        
    }

    public MetodosPagoDto(MetodosPago met) {
        this.id = met.getIdMetodo();
        this.descripcion = met.getDescripcionPago();
        this.metodoPago = met.getMetodoPago();
        this.estado = met.getEstadoPago();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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
    
    
    
    
}
