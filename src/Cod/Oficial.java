/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;

import Inter.Tablero;

/**
 *
 * @author Dell
 */
public class Oficial extends Pieza {
    
    private Tablero tablero;
     public Oficial ( String color, Tablero tablero){
        super("ofi", color);
        this.tablero=tablero;
    }
    
    public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino) {
        if (forigen == fdestino && corigen == cdestino) {
            return false;
        }

        if (getColor().equals("R")) {
            // entre filas 8-10 y columnas 3-5
            if (fdestino < 8 || fdestino > 10 || cdestino < 3 || cdestino > 5) {
                return false;
            }
        } else if (getColor().equals("N")) {
            //  entre filas 0-2 y columnas 3-5
            if (fdestino < 0 || fdestino > 2 || cdestino < 3 || cdestino > 5) {
                return false;
            }
        }

        // El oficial solo puede moverse en diagonal una casilla
        int diffFila = Math.abs(fdestino - forigen);
        int diffCol = Math.abs(cdestino - corigen);
        
        if (diffFila == 1 && diffCol == 1) { 
           
            Pieza destino = tablero.getTablero()[fdestino][cdestino];
            if (destino != null && destino.getColor().equals(this.getColor())) {
                return false; 
            }
            return true; 
        }

        return false; 
    }
  
    
    
    public boolean moverPieza(int forigen, int corigen, int fdestino, int cdestino){
         if (esMovimientoValido(forigen, corigen, fdestino, cdestino)) {
           
            tablero.getTablero()[fdestino][cdestino] = tablero.getTablero()[forigen][corigen];
            tablero.getTablero()[forigen][corigen] = null;
            
            return true;
        }
        return false;
    }
    
}
