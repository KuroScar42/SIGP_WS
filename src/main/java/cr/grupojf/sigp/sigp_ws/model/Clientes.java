/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sigp
 */
@Entity
@Table(name = "Clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientes.findByCedulaCliente", query = "SELECT c FROM Clientes c LEFT JOIN c.idEmpresa e LEFT JOIN c.idPersona p WHERE e.cedulaEmpresa = :cedula OR p.cedulaPersona = :cedula and c.estadoCliente = 'A'"),
    @NamedQuery(name = "Clientes.findByEmailCliente", query = "SELECT c FROM Clientes c WHERE c.emailCliente = :emailCliente"),
    @NamedQuery(name = "Clientes.findByTelefonoCliente", query = "SELECT c FROM Clientes c WHERE c.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "Clientes.findByTelefono2Cliente", query = "SELECT c FROM Clientes c WHERE c.telefono2Cliente = :telefono2Cliente"),
    @NamedQuery(name = "Clientes.findByDireccionCliente", query = "SELECT c FROM Clientes c WHERE c.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "Clientes.findByEstadoCliente", query = "SELECT c FROM Clientes c WHERE c.estadoCliente = :estadoCliente"),
    @NamedQuery(name = "Clientes.findByVersion", query = "SELECT c FROM Clientes c WHERE c.version = :version")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL_CLIENTE")
    private String emailCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TELEFONO_CLIENTE")
    private String telefonoCliente;
    @Size(max = 20)
    @Column(name = "TELEFONO2_CLIENTE")
    private String telefono2Cliente;
    @Size(max = 500)
    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO_CLIENTE")
    private String estadoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;
    @OneToMany(mappedBy = "idCliente")
    private List<Facturas> facturasList;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne
    private Empresas idEmpresa;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Personas idPersona;
//    @OneToMany(mappedBy = "idCliente")
//    private List<Creditos> creditosList;

    public Clientes() {
    }

    public Clientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Clientes(Integer idCliente, String emailCliente, String telefonoCliente, String estadoCliente, int version) {
        this.idCliente = idCliente;
        this.emailCliente = emailCliente;
        this.telefonoCliente = telefonoCliente;
        this.estadoCliente = estadoCliente;
        this.version = version;
    }

    public Clientes(ClientesDto clienteDto) {
        this.idCliente = clienteDto.getId();
        this.actualizarCliente(clienteDto);
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getTelefono2Cliente() {
        return telefono2Cliente;
    }

    public void setTelefono2Cliente(String telefono2Cliente) {
        this.telefono2Cliente = telefono2Cliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Personas getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

//    public List<Creditos> getCreditosList() {
//        return creditosList;
//    }
//
//    public void setCreditosList(List<Creditos> creditosList) {
//        this.creditosList = creditosList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.grupojf.sigp.sigp_ws.model.Clientes[ idCliente=" + idCliente + " ]";
    }
    
    public void actualizarCliente(ClientesDto c) {
        this.direccionCliente = c.getDireccion();
        this.emailCliente = c.getEmail();
        this.estadoCliente = c.getEstado();
        this.telefono2Cliente = c.getTelefono2();
        this.telefonoCliente = c.getTelefono();
    }
}
