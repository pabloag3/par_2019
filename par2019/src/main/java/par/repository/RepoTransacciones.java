/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import conexiones.Conexion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import par.dtos.Transacciones;
import par.interfaces.TransaccionesInter;

/**
 *
 * @author Perez
 */
public class RepoTransacciones implements TransaccionesInter{
    @Override
    public List<Transacciones> listarTransacciones(){
        return (List<Transacciones>) new Transacciones();
    }

    @Override
    public void guardarTransacciones(Transacciones trans ) {
        Connection conexion = null;

        try {
            conexion = Conexion.crear_conexion(bcp);
            String creacionString = "INSERT INTO transacciones_cab (fecha, id_cliente, "
                    + "total, direccion_envio, id_medio_pago, nro_tarjeta, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement crearEntidad = conexion.prepareStatement(creacionString);
            crearEntidad.setDate(0, (Date) trans.getCabecera().getFecha());
            crearEntidad.setInt(1, trans.getCabecera().getCliente().getIdCliente());
            crearEntidad.setLong(2, trans.getCabecera().getTotal());
            Array direccion = conexion.createArrayOf("varchar", 
                    new Object[] {trans.getCabecera().getDireccionEnvio()});
            crearEntidad.setArray(3, direccion);
            crearEntidad.setInt(4, trans.getCabecera().getIdMedioPago());
            crearEntidad.setLong(5, trans.getCabecera().getNroTarjeta());
            Array estado = conexion.createArrayOf("varchar", 
                    new Object[] {trans.getCabecera().getEstado()});
            crearEntidad.setArray(6, estado);
            int i = crearEntidad.executeUpdate();
            System.out.println("Insercion correcta.");

            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @Override
    public void actualizarTransacciones(Transacciones trans ) {
        Connection conexion = null;
        try {
            conexion = Conexion.crear_conexion(bcp);
            String updateString = "UPDATE transacciones_cab"
                    + "SET fecha = ?,"
                    + "SET id_cliente = ?,"
                    + "SET total = ?,"
                    + "SET direccion_envio = ?,"
                    + "SET id_medio_pago = ?,"
                    + "SET nro_tarjeta = ?,"
                    + "SET estado = ?"
                    + "WHERE id_transaccion = ?;";
            PreparedStatement actualizarEntidad = conexion.prepareStatement(updateString);
            actualizarEntidad.setDate(0, (Date) trans.getCabecera().getFecha());
            actualizarEntidad.setInt(1, trans.getCabecera().getCliente().getIdCliente());
            actualizarEntidad.setLong(2, trans.getCabecera().getTotal());
            Array direccion = conexion.createArrayOf("varchar", 
                    new Object[] {trans.getCabecera().getDireccionEnvio()});
            actualizarEntidad.setArray(3, direccion);
            actualizarEntidad.setInt(4, trans.getCabecera().getIdMedioPago());
            actualizarEntidad.setLong(5, trans.getCabecera().getNroTarjeta());
            Array estado = conexion.createArrayOf("varchar", 
                    new Object[] {trans.getCabecera().getEstado()});
            actualizarEntidad.setArray(6, estado);
            actualizarEntidad.setInt(7, trans.getCabecera().getIdTransaccion());
            int i = actualizarEntidad.executeUpdate();
            System.out.println("Actualizacion correcta.");

            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            System.out.println("error");
        }
        
    }

    @Override
    public void eliminarTransacciones(int idTransaccion) {
        Connection conexion = null;
        try {
            conexion = Conexion.crear_conexion(bcp);
            String deleteString = "DELETE FROM transacciones_cab "
                    +           "WHERE id_categoria = " + idTransaccion;
            bcp.releaseConnection(conexion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
