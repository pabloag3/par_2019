/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import conexiones.BasicConnectionPool;
import conexiones.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import par.entities.Categorias;

/**
 *
 * @author PabloAgHP
 */
public class RepoCategoria {
     public List<Categorias> listarCategorias(){
        
        return (List<Categorias>) new Categorias();
    }

    public static void guardarCategoria(Categorias categoria ) {
        BasicConnectionPool bcp = new BasicConnectionPool();//esto unicamente desde el login
        Connection conexion = null;

        try {
            conexion = Conexion.crear_conexion(bcp);
            
            String creacionString = "INSERT INTO categoria (descripcion) VALUES (?);";
            PreparedStatement crearEntidad = conexion.prepareStatement(creacionString);
            //crearCategoria.setInt(1, codigoCategoria);
            Array a = conexion.createArrayOf("varchar", new Object[] {categoria.getDescripcion()});
            crearEntidad.setArray(1, a);
            int i = crearEntidad.executeUpdate();
            System.out.println("Insercion correcta.");
            
            bcp.releaseConnection(conexion);
            
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void actualizarCategoria(Categorias categoria ) {
    }

    public void eliminarCategoria(int idCategoria) {
        String sent = "DELETE FROM categoria"
                 + "WHERE id_categoria = " + idCategoria + ";";
    }
}
