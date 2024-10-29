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
public class Caballo extends Pieza {
    private Tablero tablero;
    
     public Caballo ( String color, Tablero tablero){
        super("cab", color);
        this.tablero =tablero;
    }
    
    public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino) {
    if (forigen == fdestino && corigen == cdestino) {
        return false;
    }

    int mFila = Math.abs(fdestino - forigen);
    int mColum = Math.abs(cdestino - corigen);

    //vacio legal solo si esta en 3 o 7
    if (forigen == 3 || forigen == 7) {
        
        if (fdestino >= 3 && fdestino <= 7) {
            
            if (mFila == 3 && mColum == 1) {
                return validarDestino(fdestino, cdestino);
            }
        }
    }

    if ((mFila == 2 && mColum == 1) || (mFila == 1 && mColum == 2)) {

        if ((mFila == 2 && mColum == 1) || (mFila == 1 && mColum == 2)) {
            if (mFila == 2) {
                int pivoteFila = (fdestino + forigen) / 2;

                if (tablero.getTablero()[pivoteFila][corigen] != null) {
                    return false; 
                }
        }

            else if (mColum == 2) {
                int pivoteColumna = (cdestino + corigen) / 2;

                if (tablero.getTablero()[forigen][pivoteColumna] != null) {
                    return false; 
                }
            }
            return validarDestino(fdestino, cdestino);
        }

    }
    return false;
 }
      
   
    
    private boolean validarDestino(int fdestino, int cdestino) {
        Pieza destino = tablero.getTablero()[fdestino][cdestino];
        return destino == null || !destino.getColor().equals(this.getColor());
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
