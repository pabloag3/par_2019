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
    
    public String conexion;
    public String usuario;
    public String contrasenhaBase;
    
    public Conexion() {
        conexion = "jdbc:postgresql://localhost:5432/ecomerce";
        usuario = "postgres";
        contrasenhaBase = "QAZwsx123plm";
    }
    
    
    
    
}
