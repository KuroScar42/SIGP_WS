/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Metodos_Pago")
@NamedQueries({
    @NamedQuery(name = "MetodosPago.findAll", query = "SELECT m FROM MetodosPago m"),
    @NamedQuery(name = "MetodosPago.findByIdMetodo", query = "SELECT m FROM MetodosPago m WHERE m.idMetodo = :idMetodo"),
    @NamedQuery(name = "MetodosPago.findByMetodoPago", query = "SELECT m FROM MetodosPago m WHERE m.metodoPago = :metodoPago"),
    @NamedQuery(name = "MetodosPago.findByDescripcionPago", query = "SELECT m FROM MetodosPago m WHERE m.descripcionPago = :descripcionPago"),
    @NamedQuery(name = "MetodosPago.findByEstadoPago", query = "SELECT m FROM MetodosPago m WHERE m.estadoPago = :estadoPago"),
    @NamedQuery(name = "MetodosPago.findByVersionPago", query = "SELECT m FROM MetodosPago m WHERE m.versionPago = :versionPago")})
public class MetodosPago implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "METODO_PAGO")
    private String metodoPago;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_PAGO")
    private String descripcionPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO_PAGO")
    private String estadoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION_PAGO")
    private int versionPago;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_METODO")
    private Integer idMetodo;
    @JoinColumn(name = "ID_MONEDA", referencedColumnName = "ID_MONEDA")
    @ManyToOne
    private Monedas idMoneda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMetodo")
    private List<Facturas> facturasList;
    @OneToMany(mappedBy = "idMetodo")
    private List<OtrosValores> otrosValoresList;

    public MetodosPago() {
    }

    public MetodosPago(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    public MetodosPago(Integer idMetodo, String metodoPago, String estadoPago, int versionPago) {
        this.idMetodo = idMetodo;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.versionPago = versionPago;
    }

    public Integer getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDescripcionPago() {
        return descripcionPago;
    }

    public void setDescripcionPago(String descripcionPago) {
        this.descripcionPago = descripcionPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getVersionPago() {
        return versionPago;
    }

    public void setVersionPago(int versionPago) {
        this.versionPago = versionPago;
    }

    public Monedas getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Monedas idMoneda) {
        this.idMoneda = idMoneda;
    }

    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    public List<OtrosValores> getOtrosValoresList() {
        return otrosValoresList;
    }

    public void setOtrosValoresList(List<OtrosValores> otrosValoresList) {
        this.otrosValoresList = otrosValoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetodo != null ? idMetodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodosPago)) {
            return false;
        }
        MetodosPago other = (MetodosPago) object;
        if ((this.idMetodo == null && other.idMetodo != null) || (this.idMetodo != null && !this.idMetodo.equals(other.idMetodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.MetodosPago[ idMetodo=" + idMetodo + " ]";
    }
    
}
