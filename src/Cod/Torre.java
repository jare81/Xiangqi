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
public class Torre extends Pieza{
    private Tablero tablero;
    
     public Torre( String color, Tablero tablero){
        super("tor", color);
        this.tablero= tablero;
    }
    
    public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino){
        if (forigen == fdestino && corigen == cdestino) {
            return false;
        }
        
        // Lhorizontal o vertical
        if (forigen != fdestino && corigen != cdestino) {
            return false;
        }

        // del movimiento
        int filaInc = Integer.signum(fdestino - forigen); // -1, 0 o 1
        int colInc = Integer.signum(cdestino - corigen);  // -1, 0 o 1

        int fila = forigen + filaInc;
        int columna = corigen + colInc;
        
            while (fila != fdestino || columna != cdestino) {
                if (tablero.getTablero()[fila][columna] != null) {
                    return false;
                }
                fila += filaInc;
                columna += colInc;
            }

        Pieza destino = tablero.getTablero()[fdestino][cdestino];
            if (destino != null && destino.getColor().equals(this.getColor())) {
                return false; 
            }

        return true; 
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
