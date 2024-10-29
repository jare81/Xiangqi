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
public class Canon extends Pieza {
    private Tablero tablero;
    
     public Canon( String color, Tablero tablero){
        super("can", color);
        this.tablero = tablero;
    }
    
    public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino){
         if (forigen == fdestino && corigen == cdestino) {
        return false; 
        }

        //  horizontal o vertical
        if (forigen != fdestino && corigen != cdestino) {
            return false;
        }

        // incrementos para la fila y la columna
        int filaInc = Integer.signum(fdestino - forigen); 
        int colInc = Integer.signum(cdestino - corigen);  

        int fila = forigen + filaInc;
        int columna = corigen + colInc;
        int contadorPiezas = 0; 


        while (fila != fdestino || columna != cdestino) {
            if (tablero.getTablero()[fila][columna] != null) {
                contadorPiezas++; 
            }
            fila += filaInc;
            columna += colInc;
        }
        
        
        //  pieza en el destino
        Pieza destino = tablero.getTablero()[fdestino][cdestino];

        if (destino != null) {
            if (contadorPiezas == 1 && !destino.getColor().equals(this.getColor())) {
                return true; 
            } else {
                return false; 
            }
        } else {
            return contadorPiezas == 0;
        }
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
