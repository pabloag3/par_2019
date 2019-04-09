/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.interfaces;

import java.util.List;
import par.entities.Categorias;

/**
 *
 * @author Pablo Aguilar
 */
public interface CategoriaInter {
    public List<Categorias> listarCategorias();
    public void guardarCategoria(Categorias categoria );
    public void actualizarCategoria(Categorias categoria );
    public void eliminarCategoria(int idCategoria);
}
