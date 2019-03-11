/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.entities;

/**
 *
 * @author Perez
 */
public class Productos {
    private Long idProducto;
    private String descripcion;
    private Categorias idCategoria;
    private Long precioUnit;
    private Long cantidad;
    
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(Long precioUnit) {
        this.precioUnit = precioUnit;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
