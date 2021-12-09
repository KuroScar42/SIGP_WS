/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class ProductosDto {

    private Integer id;
    private String codigoInterno;
    private String codigoBarras;
    private String nombre;
    private String descripcion;
    private Float unidadEmbalage;
    private Float costo;
    private String codigoCabys;
//    private String caducidad;
    private Float ivaProducto;
    private String estado;
//    private Float cantidad;
//    private Float precio;
//    private String unidadMedida;
    private BodegasProductosDto detalles;

    public ProductosDto(Productos p) {
        this.id = p.getIdProducto();
        this.codigoInterno = p.getCodigoInterno();
        this.nombre = p.getNombreProducto();
        this.descripcion = p.getDescripcionProducto();
        this.unidadEmbalage = p.getUnidadEmbalage();
        this.costo = p.getPrecioCosto();
        this.codigoCabys = p.getCodigoCabys();
        this.ivaProducto = p.getIvaProducto();
        this.estado = p.getEstado();
    }

    public ProductosDto(Productos p, BodegasProductos bp) {
        this(p);
        this.detalles = new BodegasProductosDto(bp);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getUnidadEmbalage() {
        return unidadEmbalage;
    }

    public void setUnidadEmbalage(Float unidadEmbalage) {
        this.unidadEmbalage = unidadEmbalage;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public String getCodigoCabys() {
        return codigoCabys;
    }

    public void setCodigoCabys(String codigoCabys) {
        this.codigoCabys = codigoCabys;
    }

//    public String getCaducidad() {
//        return caducidad;
//    }
//
//    public void setCaducidad(String caducidad) {
//        this.caducidad = caducidad;
//    }

    public Float getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(Float ivaProducto) {
        this.ivaProducto = ivaProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BodegasProductosDto getDetalles() {
        return detalles;
    }

    public void setDetalles(BodegasProductosDto detalles) {
        this.detalles = detalles;
    }

    

    
}
