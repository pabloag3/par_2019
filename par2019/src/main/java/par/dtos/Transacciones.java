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
    private TransaccionesCab cabecera;
    private List<TransaccionesDet> detalles;
}
