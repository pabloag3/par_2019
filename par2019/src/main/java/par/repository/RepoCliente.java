/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import conexiones.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        
        Connection conexion = null;
        
        try {
            conexion = Conexion.crear_conexion(bcp);
            
            String creacionString = "INSERT INTO cliente (nombre, apellido, "
                    + "email, login_name, passwd, tipo_cliente) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement crearEntidad = conexion.prepareStatement(creacionString);
            //crearCategoria.setInt(1, codigoCategoria);
            Array nombre = conexion.createArrayOf("varchar", new Object[] {cliente.getNombre()});
            crearEntidad.setArray(1, nombre);
            Array apellido = conexion.createArrayOf("varchar", new Object[] {cliente.getApellido()});
            crearEntidad.setArray(2, apellido);
            Array email = conexion.createArrayOf("varchar", new Object[] {cliente.getEmail()});
            crearEntidad.setArray(3, email);
            Array loginName = conexion.createArrayOf("varchar", new Object[] {cliente.getLoginName()});
            crearEntidad.setArray(4, loginName);
            Array passwd= conexion.createArrayOf("varchar", new Object[] {cliente.getPasswd()});
            crearEntidad.setArray(5, passwd);
            Array tipoCliente = conexion.createArrayOf("varchar", new Object[] {cliente.getTipoCliente()});
            crearEntidad.setArray(6, tipoCliente);
            int i = crearEntidad.executeUpdate();
            System.out.println("Insercion correcta.");
            
            bcp.releaseConnection(conexion);
            
        } catch (Exception e) {
            System.out.println("error");
        }
        
    }

    public void actualizarClientes(Clientes cliente ) {
    }

    public void eliminarClientes(int idCliente) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.crear_conexion(bcp);
            String deleteString = "DELETE FROM categoria "
                    +           "WHERE id_cliente = " + idCliente;
            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            
        }
    }
}
