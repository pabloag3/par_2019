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
    private int idProducto;
    private String descripcion;
    private int idCategoria;
    private Long precioUnit;
    private Long cantidad;
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
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
