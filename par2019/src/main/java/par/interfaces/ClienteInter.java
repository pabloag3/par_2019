/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.interfaces;

import java.util.List;
import par.entities.Clientes;

/**
 *
 * @author Pablo Aguilar
 */
public interface ClienteInter {
    public List<Clientes> listarClientes();
    public void guardarClientes(Clientes cliente );
    public void actualizarClientes(Clientes cliente );
    public void eliminarClientes(int idCliente);
}
