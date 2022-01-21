/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Tipo_Cambio")
@NamedQueries({
    @NamedQuery(name = "TipoCambio.findAll", query = "SELECT t FROM TipoCambio t"),
    @NamedQuery(name = "TipoCambio.findByIdCambio", query = "SELECT t FROM TipoCambio t WHERE t.idCambio = :idCambio"),
    @NamedQuery(name = "TipoCambio.findByCompraCambio", query = "SELECT t FROM TipoCambio t WHERE t.compraCambio = :compraCambio"),
    @NamedQuery(name = "TipoCambio.findByVentaCambio", query = "SELECT t FROM TipoCambio t WHERE t.ventaCambio = :ventaCambio")})
public class TipoCambio implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPRA_CAMBIO")
    private float compraCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VENTA_CAMBIO")
    private float ventaCambio;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CAMBIO")
    private Integer idCambio;
    @JoinColumn(name = "ID_MONEDA", referencedColumnName = "ID_MONEDA")
    @ManyToOne
    private Monedas idMoneda;

    public TipoCambio() {
    }

    public TipoCambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public TipoCambio(Integer idCambio, float compraCambio, float ventaCambio) {
        this.idCambio = idCambio;
        this.compraCambio = compraCambio;
        this.ventaCambio = ventaCambio;
    }

    public Integer getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public float getCompraCambio() {
        return compraCambio;
    }

    public void setCompraCambio(float compraCambio) {
        this.compraCambio = compraCambio;
    }

    public float getVentaCambio() {
        return ventaCambio;
    }

    public void setVentaCambio(float ventaCambio) {
        this.ventaCambio = ventaCambio;
    }

    public Monedas getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Monedas idMoneda) {
        this.idMoneda = idMoneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambio != null ? idCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCambio)) {
            return false;
        }
        TipoCambio other = (TipoCambio) object;
        if ((this.idCambio == null && other.idCambio != null) || (this.idCambio != null && !this.idCambio.equals(other.idCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.TipoCambio[ idCambio=" + idCambio + " ]";
    }
    
}
