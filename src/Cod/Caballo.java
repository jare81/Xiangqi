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
      
   /*   if (forigen == fdestino && corigen == cdestino) {
        return false;
    }

    int mFila = Math.abs(fdestino - forigen);
    int mColum = Math.abs(cdestino - corigen);

    // Verificación especial para filas 3 y 7 (permite saltar el río)
    if (forigen == 3 || forigen == 7) {
        // Permite salto especial cuando el caballo cruza el río
        if (mFila == 3 && mColum == 1) {
            Pieza destino = tablero.getTablero()[fdestino][cdestino];
            if (destino != null && destino.getColor().equals(this.getColor())) {
                return false; // Hay una pieza del mismo color en el destino
            }
            return true; // Movimiento válido para cruzar el río
        }
    }

    // Verificación estándar de movimiento en "L" y pivotes para el resto del tablero
    if ((mFila == 2 && mColum == 1) || (mFila == 1 && mColum == 2)) {
        // Verificación de pivote para movimiento vertical
        if (mFila == 2) {
            int pivoteFila = (fdestino + forigen) / 2;
            if (tablero.getTablero()[pivoteFila][corigen] != null) {
                return false; // Bloqueado en el punto pivote vertical
            }
        }
        // Verificación de pivote para movimiento horizontal
        else if (mColum == 2) {
            int pivoteColumna = (cdestino + corigen) / 2;
            if (tablero.getTablero()[forigen][pivoteColumna] != null) {
                return false; // Bloqueado en el punto pivote horizontal
            }
        }

        // Verificación de pieza en el destino para evitar capturar del mismo color
        Pieza destino = tablero.getTablero()[fdestino][cdestino];
        if (destino != null && destino.getColor().equals(this.getColor())) {
            return false; // Hay una pieza del mismo color en el destino
        }

        return true; // Movimiento válido
    }

    return false; // Movimiento no válido*/
    
    
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
