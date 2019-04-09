/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.interfaces.readOnly;

import java.util.List;
import par.entities.Productos;

/**
 *
 * @author PabloAgHP
 */
public interface readOnlyProducto {
    List<Productos> buscarPorDescripcion(String descrip);
    List<Productos> buscarPorId(int id);
    List<Productos> buscarPorCategoria(int idCategoria);
    List<Productos> traerTodos();
}
