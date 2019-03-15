/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author PabloAgHP
 */
public class Conexion {
    
    public static String jdbcconexion = "jdbc:postgresql://localhost:5432/ecomerce";
    public static String usuariodb = "postgres";
    public static String contrasenhadb = "QAZwsx123plm";
    public static BasicConnectionPool basicCPoll;

    public Conexion() throws SQLException {
    }

    public static Connection crear_conexion(BasicConnectionPool basicCPoll) throws SQLException {
        return basicCPoll.create(jdbcconexion, usuariodb, 
                    contrasenhadb).getConnection();
    }
    
    
    
    
}
