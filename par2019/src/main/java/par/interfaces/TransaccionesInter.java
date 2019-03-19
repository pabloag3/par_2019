/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.interfaces;

import java.util.List;
import par.dtos.Transacciones;

/**
 *
 * @author Pablo Aguilar
 */
public interface TransaccionesInter {
    public List<Transacciones> listarTransacciones();
    public void guardarTransacciones(Transacciones trans );
    public void actualizarTransacciones(Transacciones trans );
    public void eliminarTransacciones(int idTransaccion);
}
