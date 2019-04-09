/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par.dtos;

import java.util.List;
import par.entities.TransaccionesCab;
import par.entities.TransaccionesDet;

/**
 *
 * @author Perez
 */
public class Transacciones {
    public TransaccionesCab cabecera;
    public List<TransaccionesDet> detalles;

    public TransaccionesCab getCabecera() {
        return cabecera;
    }

    public void setCabecera(TransaccionesCab cabecera) {
        this.cabecera = cabecera;
    }

    public List<TransaccionesDet> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<TransaccionesDet> detalles) {
        this.detalles = detalles;
    }
    
}
