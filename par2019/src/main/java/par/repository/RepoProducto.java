/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

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
    }

    public void actualizarProducto(Productos prod ) {
    }

    public void eliminarProducto(Long idPoducto) {
        
    }
}