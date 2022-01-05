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
public class CuentasPagarDto {
    private Integer id;
    private String estado;
    private Date cancelacion;
    private String factura;

    public CuentasPagarDto() {
    }

    public CuentasPagarDto(CuentasPagar cp) {
        this.id = cp.getIdPagar();
        this.estado = cp.getEstadoPagar();
        this.cancelacion = cp.getFechaCancelacion();
        this.factura = cp.getFacturaCancelar();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(Date cancelacion) {
        this.cancelacion = cancelacion;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }
    
    
}
