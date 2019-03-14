/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import java.util.List;
import par.dtos.Transacciones;

/**
 *
 * @author Perez
 */
public class RepoTransacciones {
    public List<Transacciones> listarTransacciones(){
        
        return (List<Transacciones>) new Transacciones();
    }

    public void guardarTransacciones(Transacciones trans ) {
    }

    public void actualizarTransacciones(Transacciones trans ) {
    }

    public void eliminarTransacciones(int idTransaccion) {
        
    }
}
