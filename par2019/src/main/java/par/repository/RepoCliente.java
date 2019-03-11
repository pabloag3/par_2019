/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import java.util.List;
import par.entities.Clientes;

/**
 *
 * @author PabloAgHP
 */
public class RepoCliente {
    public List<Clientes> listarProductos(){
        
        return (List<Clientes>) new Clientes();
    }

    public void guardarProducto(Clientes prod ) {
    }

    public void actualizarProducto(Clientes prod ) {
    }

    public void eliminarProducto(Long idPoducto) {
        
    }
}
