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
    public List<Clientes> listarClientes(){
        
        return (List<Clientes>) new Clientes();
    }

    public void guardarClientes(Clientes cliente ) {
        String sent = "SELECT nextval('cliente_id_cliente');";
        Integer codigoCliente = Integer.parseInt(sent);
        cliente.setIdCliente(codigoCliente);
        String sql = "insert into categoria values (" + cliente.getIdCliente()
                + ", " + cliente.getNombre()
                + ", " + cliente.getApellido()
                + ", " + cliente.getEmail()
                + ", " + cliente.getLoginName()
                + ", " + cliente.getPasswd()
                + ", " + cliente.getTipoCliente()
                + ")";
        
    }

    public void actualizarClientes(Clientes cliente ) {
    }

    public void eliminarClientes(int idCliente) {
        String sent = "DELETE FROM clientes"
                 + "WHERE id_cliente = " + idCliente + ";";
    }
}
