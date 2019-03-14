/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
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
        Connection conexion = null;
        try {
//            conexion = BasicConnectionPool.create("jdbc:postgresql://"
//                    + "localhost:5432/ecomerce", "postgres", 
//                    "QAZwsx123plm").getConnection();
            Statement sentencia = conexion.createStatement();
            //String sql = "SELECT * FROM CATEGORIA";
            String sql = "insert into CATEGORIA values (2, '{domitica}');";
            ResultSet resultado = sentencia.executeQuery(sql);
            System.out.println("resultado " + resultado);
            //List<Categorias > cat = (List<Categorias>) resultado.g;
                        
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            //conexion.close();
        };
            
            
    }
    
}
