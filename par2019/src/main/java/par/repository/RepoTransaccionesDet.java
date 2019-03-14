/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.repository;

import java.util.List;
import par.entities.TransaccionesDet;

/**
 *
 * @author Pablo Aguilar
 */
public class RepoTransaccionesDet {
    public List<TransaccionesDet> listarTransacciones(){
        
        return (List<TransaccionesDet>) new TransaccionesDet();
    }

    public void guardarTransacciones(TransaccionesDet transDet ) {
    }

    public void actualizarTransacciones(TransaccionesDet transDet ) {
    }

    public void eliminarTransacciones(int idTransaccionesDet) {
        
    }
}
