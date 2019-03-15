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
        Categorias cat = new Categorias();
        cat.setDescripcion("carpinteria");

        guardarCategoria(cat);
    }
    
    public static void guardarCategoria(Categorias categoria ) {
        BasicConnectionPool bcp = new BasicConnectionPool();//esto unicamente desde el login
        Connection conexion = null;

        try {
            conexion = Conexion.crear_conexion(bcp);
            
            Statement sentencia = conexion.createStatement();
            //para secuencia
            String sec = "SELECT nextval('categoria_id_categoria_seq');";
            sentencia.execute(sec);
            ResultSet rs = sentencia.executeQuery(sec);

            int codigoCategoria = 1;
            while (rs.next()){
                String val = rs.getString(1);
                codigoCategoria = Integer.parseInt(val);
            }
            categoria.setIdCategoria(codigoCategoria);
            
            //para insert
            String sql = "insert into CATEGORIA values (" + categoria.getIdCategoria()
                    + ", '{"+ categoria.getDescripcion()+"}');";
            sentencia.executeUpdate(sql);
            //ResultSet resultado = sentencia.executeQuery(sql);
            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
}
