/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String fecha;
    private String estado;
    private Float subTotal;
    private Float iva;
    private Float total;
    private Float pago;
    private Float vuelto;
    private ClientesDto cliente;
    private Integer emisor;
    private MetodosPagoDto metodo;
    private AperturaCajasDto apertura;
    private String observaciones;
    private Integer usuario;


    
    
    public FacturasDto() {
    }
    
    public FacturasDto(Facturas f) {
        this.id = f.getIdFactura();
        this.tipo = f.getTipoFactura();
        this.referencia = f.getReferenciaFactura();
        this.clave = f.getClaveFactura();
        this.electronica = f.getElectronicaFactura();
        try {
            this.fecha = LocalDateAdapter.adaptToJson(f.getFechaFactura());
        } catch (Exception ex) {
            Logger.getLogger(FacturasDto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estado = f.getEstadoFactura();
        this.subTotal = f.getSubtotalFactura();
        this.iva = f.getIvaFactura();
        this.total = f.getTotalFactura();
        this.pago = f.getPagoFactura();
        this.vuelto = f.getVueltoFactura();
        this.observaciones = f.getObservacionesFactura();
        if (f.getIdCliente() != null) {
            this.cliente = new ClientesDto(f.getIdCliente());
        }
        if (f.getIdEmisor()!= null) {
            this.emisor = f.getIdEmisor().getIdEmisor();
        }
        if (f.getIdMetodo() != null) {
            this.metodo = new MetodosPagoDto(f.getIdMetodo());
        }
        if (f.getIdApertura()!= null) {
            this.apertura = new AperturaCajasDto(f.getIdApertura());
        }
        if(f.getIdUsuario()!=null){
            this.usuario = f.getIdUsuario().getIdUsuario();
        }
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
    
    public ClientesDto getCliente() {
        return cliente;
    }

    public void setCliente(ClientesDto cliente) {
        this.cliente = cliente;
    }

    public Integer getEmisor() {
        return emisor;
    }

    public void setEmisor(Integer emisor) {
        this.emisor = emisor;
    }

    public MetodosPagoDto getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodosPagoDto metodo) {
        this.metodo = metodo;
    }

    public AperturaCajasDto getApertura() {
        return apertura;
    }

    public void setApertura(AperturaCajasDto apertura) {
        this.apertura = apertura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
    
    
    
}
