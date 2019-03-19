/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.interfaces;

import java.util.List;
import par.entities.Productos;

/**
 *
 * @author Pablo Aguilar
 */
public interface ProductoInter {
    public List<Productos> listarProductos();
    public void guardarProducto(Productos prod );
    public void actualizarProducto(Productos prod );
    public void eliminarProducto(int idPoducto);
}
