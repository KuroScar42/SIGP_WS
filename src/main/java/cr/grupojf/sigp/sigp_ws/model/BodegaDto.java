/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.model;

/**
 *
 * @author sigp
 */
public class BodegaDto {
   private Integer Id;
   private String codigoBodega;
   private String nombre;
   private String descripcion;
   private String estado;

    public BodegaDto(Bodegas bod) {
        this.Id = bod.getIdBodega();
        this.codigoBodega = bod.getCodigoBodega();
        this.descripcion = bod.getDescripcion();
        this.nombre = bod.getNombreBodega();
        this.estado = bod.getEstado();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
   
}
