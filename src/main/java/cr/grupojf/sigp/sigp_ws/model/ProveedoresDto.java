/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author herna
 */
public class ProveedoresDto {
    private Integer id;
    private String nombre;
    private String tipoCedula;
    private String cedula;
    private String razonSocial;
    private Float interesMoratorio;
    private Float descuento;
    private Integer plazoCredito;
    private String tipoDevoluciones;
    private String cuentaPago;
    private String estado;

    public ProveedoresDto() {
    }
    
    public ProveedoresDto(Proveedores p) {
        this.id = p.getIdProveedor();
        this.nombre = p.getNombreProveedor();
        this.tipoCedula = p.getTipoCedula();
        this.cedula = p.getCedula();
        this.razonSocial = p.getRazonSocial();
        this.interesMoratorio = p.getInteresMoratorio();
        this.descuento = p.getDescuento();
        this.plazoCredito = p.getPlazoCredito();
        this.tipoDevoluciones = p.getTipoDevoluciones();
        this.cuentaPago = p.getCuentaPago();
        this.estado = p.getEstado();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Float getInteresMoratorio() {
        return interesMoratorio;
    }

    public void setInteresMoratorio(Float interesMoratorio) {
        this.interesMoratorio = interesMoratorio;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Integer getPlazoCredito() {
        return plazoCredito;
    }

    public void setPlazoCredito(Integer plazoCredito) {
        this.plazoCredito = plazoCredito;
    }

    public String getTipoDevoluciones() {
        return tipoDevoluciones;
    }

    public void setTipoDevoluciones(String tipoDevoluciones) {
        this.tipoDevoluciones = tipoDevoluciones;
    }

    public String getCuentaPago() {
        return cuentaPago;
    }

    public void setCuentaPago(String cuentaPago) {
        this.cuentaPago = cuentaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
