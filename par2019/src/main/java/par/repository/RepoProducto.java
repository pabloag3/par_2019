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
            crearEntidad.setArray(1, descripcion);
            Array id_categoria = conexion.createArrayOf("varchar", new Object[] {prod.getIdCategoria()});
            crearEntidad.setArray(2, id_categoria);
            Array precio_unit = conexion.createArrayOf("varchar", new Object[] {prod.getPrecioUnit()});
            crearEntidad.setArray(3, precio_unit);
            Array cantidad = conexion.createArrayOf("varchar", new Object[] {prod.getCantidad()});
            crearEntidad.setArray(4, cantidad);
            int i = crearEntidad.executeUpdate();
            System.out.println("Insercion correcta.");

            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            System.out.println("error");
        }
        
    }

    public void actualizarProducto(Productos prod ) {
    }

    public void eliminarProducto(int idPoducto) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.crear_conexion(bcp);
            String deleteString = "DELETE FROM categoria "
                    +           "WHERE id_producto = " + idPoducto;
            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            
        }
    }
}
