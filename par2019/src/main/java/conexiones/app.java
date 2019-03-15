/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import par.entities.Categorias;

/**
 *
 * @author PabloAgHP
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Categorias cat = new Categorias();
        cat.setDescripcion("carpinteria");

        guardarCategoria(cat);
    }
    
    public static void guardarCategoria(Categorias categoria ) {
        
        BasicConnectionPool bcp = new BasicConnectionPool();//esto unicamente desde el login
        Connection conexion = null;

        try {
            conexion = Conexion.crear_conexion(bcp);
            
            String creacionString = "INSERT INTO categoria (descripcion) VALUES (?);";
            PreparedStatement crearCategoria = conexion.prepareStatement(creacionString);
            //crearCategoria.setInt(1, codigoCategoria);
            Array a = conexion.createArrayOf("varchar", new Object[] {categoria.getDescripcion()});
            crearCategoria.setArray(1, a);
            int i = crearCategoria.executeUpdate();
            System.out.println("Insercion correcta.");
            
            bcp.releaseConnection(conexion);
            
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
}
