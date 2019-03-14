/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import conexiones.BasicConnectionPool;
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

    public void guardarCategoria(Categorias categoria ) {
        
       //Query para pk de categoria
        String sent = "SELECT nextval('categoria_id_categoria_seq');";
        Integer codigoCategoria = Integer.parseInt(sent);
        categoria.setIdCategoria(codigoCategoria);
        String sql = "insert into categoria values (" + categoria.getIdCategoria()
                + ", " + categoria.getDescripcion() + ")";
        
        //emc.persist(prod);
    }

    public void actualizarCategoria(Categorias categoria ) {
    }

    public void eliminarCategoria(int idCategoria) {
        String sent = "DELETE FROM categoria"
                 + "WHERE id_categoria = " + idCategoria + ";";
    }
}
