/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.util.Date;

/**
 *
 * @author herna
 */
public class FacturasDto {
    private Integer id;
    private String tipo;
    private String referencia;
    private String clave;
    private String electronica;
    private Date fecha;
    private String estado;
    private Float subTotal;
    private Float iva;
    private Float total;
    private Float pago;
    private Float vuelto;

    public FacturasDto() {
    }
    
    public FacturasDto(Facturas f) {
        this.id = f.getIdFactura();
        this.tipo = f.getTipoFactura();
        this.referencia = f.getReferenciaFactura();
        this.clave = f.getClaveFactura();
        this.electronica = f.getElectronicaFactura();
        this.fecha = f.getFechaFactura();
        this.estado = f.getEstadoFactura();
        this.subTotal = f.getSubtotalFactura();
        this.iva = f.getIvaFactura();
        this.total = f.getTotalFactura();
        this.pago = f.getPagoFactura();
        this.vuelto = f.getVueltoFactura();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getElectronica() {
        return electronica;
    }

    public void setElectronica(String electronica) {
        this.electronica = electronica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getPago() {
        return pago;
    }

    public void setPago(Float pago) {
        this.pago = pago;
    }

    public Float getVuelto() {
        return vuelto;
    }

    public void setVuelto(Float vuelto) {
        this.vuelto = vuelto;
    }
    
    
    
    
    
}
