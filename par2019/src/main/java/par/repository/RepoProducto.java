/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import conexiones.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import par.entities.Productos;

/**
 *
 * @author Perez
 */
public class RepoProducto {
    public List<Productos> listarProductos(){
        
        return (List<Productos>) new Productos();
    }

    public void guardarProducto(Productos prod ) {
        
        Connection conexion = null;

        try {
            conexion = Conexion.crear_conexion(bcp);
            String creacionString = "INSERT INTO producto (descripcion, id_categoria, "
                    + "precio_unit, cantidad) "
                    + "VALUES (?, ?, ?, ?);";
            PreparedStatement crearEntidad = conexion.prepareStatement(creacionString);
            Array descripcion = conexion.createArrayOf("varchar", new Object[] {prod.getDescripcion()});
            crearEntidad.setArray(0, descripcion);
            Array id_categoria = conexion.createArrayOf("varchar", new Object[] {prod.getIdCategoria()});
            crearEntidad.setArray(1, id_categoria);
            Array precio_unit = conexion.createArrayOf("varchar", new Object[] {prod.getPrecioUnit()});
            crearEntidad.setArray(2, precio_unit);
            Array cantidad = conexion.createArrayOf("varchar", new Object[] {prod.getCantidad()});
            crearEntidad.setArray(3, cantidad);
            crearEntidad.
            int i = crearEntidad.executeUpdate();
            System.out.println("Insercion correcta.");

            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            System.out.println("error");
        }
        
    }

    public void actualizarProducto(Productos prod ) {
        Connection conexion = null;
        try {
            conexion = Conexion.crear_conexion(bcp);
            String updateString = "UPDATE producto"
                + "SET descripcion = ? ,"
                + "SET id_categoria = ? ,"
                + "SET precio_unit = ? ,"
                + "SET cantidad = ?"
                + "WHERE id_categoria = ?;";
            PreparedStatement actualizarEntidad = conexion.prepareStatement(updateString);
            Array descripcion = conexion.createArrayOf("varchar", new Object[] {prod.getDescripcion()});
            actualizarEntidad.setArray(0, descripcion);
            Array id_categoria = conexion.createArrayOf("varchar", new Object[] {prod.getIdCategoria()});
            actualizarEntidad.setArray(1, id_categoria);
            Array precio_unit = conexion.createArrayOf("varchar", new Object[] {prod.getPrecioUnit()});
            actualizarEntidad.setArray(2, precio_unit);
            Array cantidad = conexion.createArrayOf("varchar", new Object[] {prod.getCantidad()});
            actualizarEntidad.setArray(3, cantidad);
            actualizarEntidad.setInt(4, prod.getIdProducto());
            int i = actualizarEntidad.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }

    public void eliminarProducto(int idPoducto) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.crear_conexion(bcp);
            String deleteString = "DELETE FROM producto "
                    +           "WHERE id_producto = " + idPoducto;
            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            
        }
    }
}
