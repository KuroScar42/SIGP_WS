/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Cuentas_Pagar")
@NamedQueries({
    @NamedQuery(name = "CuentasPagar.findAll", query = "SELECT c FROM CuentasPagar c"),
    @NamedQuery(name = "CuentasPagar.findByIdPagar", query = "SELECT c FROM CuentasPagar c WHERE c.idPagar = :idPagar"),
    @NamedQuery(name = "CuentasPagar.findByEstadoPagar", query = "SELECT c FROM CuentasPagar c WHERE c.estadoPagar = :estadoPagar"),
    @NamedQuery(name = "CuentasPagar.findByFechaCancelacion", query = "SELECT c FROM CuentasPagar c WHERE c.fechaCancelacion = :fechaCancelacion"),
    @NamedQuery(name = "CuentasPagar.findByFacturaCancelar", query = "SELECT c FROM CuentasPagar c WHERE c.facturaCancelar = :facturaCancelar")})
public class CuentasPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAGAR")
    private Integer idPagar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_PAGAR")
    private String estadoPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CANCELACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FACTURA_CANCELAR")
    private String facturaCancelar;
    @JoinColumn(name = "ID_TIPO", referencedColumnName = "ID_TIPO")
    @ManyToOne
    private TipoCuentaPagar idTipo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuarios idUsuario;

    public CuentasPagar() {
    }

    public CuentasPagar(Integer idPagar) {
        this.idPagar = idPagar;
    }

    public CuentasPagar(Integer idPagar, String estadoPagar, Date fechaCancelacion, String facturaCancelar) {
        this.idPagar = idPagar;
        this.estadoPagar = estadoPagar;
        this.fechaCancelacion = fechaCancelacion;
        this.facturaCancelar = facturaCancelar;
    }

    public Integer getIdPagar() {
        return idPagar;
    }

    public void setIdPagar(Integer idPagar) {
        this.idPagar = idPagar;
    }

    public String getEstadoPagar() {
        return estadoPagar;
    }

    public void setEstadoPagar(String estadoPagar) {
        this.estadoPagar = estadoPagar;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getFacturaCancelar() {
        return facturaCancelar;
    }

    public void setFacturaCancelar(String facturaCancelar) {
        this.facturaCancelar = facturaCancelar;
    }

    public TipoCuentaPagar getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoCuentaPagar idTipo) {
        this.idTipo = idTipo;
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
        hash += (idPagar != null ? idPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentasPagar)) {
            return false;
        }
        CuentasPagar other = (CuentasPagar) object;
        if ((this.idPagar == null && other.idPagar != null) || (this.idPagar != null && !this.idPagar.equals(other.idPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.CuentasPagar[ idPagar=" + idPagar + " ]";
    }
    
}
