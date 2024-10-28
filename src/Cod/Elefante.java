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
public class Elefante extends Pieza {
    private Tablero tablero;
    
     public Elefante ( String color, Tablero tablero){
        super("ele", color);
        this.tablero=tablero;
    }
    
  public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino){
      if (forigen == fdestino && corigen == cdestino) {
        return false; 
    }

    boolean movValido = false;

    if (getColor().equals("R")) {

        if (Math.abs(fdestino - forigen) == 2 && Math.abs(cdestino - corigen) == 2) {
            // no cruce el río
            if (fdestino >= 6) {

                int filaIntermedia = (forigen + fdestino) / 2;
                int columnaIntermedia = (corigen + cdestino) / 2;
                if (tablero.getTablero()[filaIntermedia][columnaIntermedia] == null) {
                    movValido = true;
                }
            }
        }
    }

    else if (getColor().equals("N")) {
        //  dos espacios en diagonal
        if (Math.abs(fdestino - forigen) == 2 && Math.abs(cdestino - corigen) == 2) {

            if (fdestino <=4) {
                //  no piezas intermedias
                int filaIntermedia = (forigen + fdestino) / 2;
                int columnaIntermedia = (corigen + cdestino) / 2;
                if (tablero.getTablero()[filaIntermedia][columnaIntermedia] == null) {
                    movValido = true;
                }
            }
        }
    }


    Pieza destino = tablero.getTablero()[fdestino][cdestino];
    if (destino != null && destino.getColor().equals(this.getColor())) {
        return false; 
    }

    return movValido;
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
