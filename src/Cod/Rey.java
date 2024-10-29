/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;

import Inter.Tablero;
import javax.swing.JOptionPane;


/**
 *
 * @author Dell
 */
public class Rey extends Pieza{
    private Tablero tablero;
    
     public Rey (String color, Tablero tablero){
        super("rey", color);
        this.tablero=tablero;
    }
     
     
    public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino){
         if (forigen == fdestino && corigen == cdestino) {
            return false;
        }

        if (faceToface()) {
            return false;
        }

        boolean movValido = false;

        if (tablero.getRojo() && getColor().equals("R")) {

            if (fdestino >= 8 && (cdestino >= 3 && cdestino <= 5)) {
                //  hacia arriba
                if ((fdestino == forigen - 1 && corigen == cdestino) || 
                    (cdestino == corigen - 1 && forigen == fdestino)) {
                    movValido = true;
                }
                //= hacia abajo
                else if ((forigen == fdestino - 1 && corigen == cdestino) || 
                         (corigen == cdestino - 1 && forigen == fdestino)) {
                    movValido = true;
                }


            }
        } 
        else if (!tablero.getRojo() && getColor().equals("N")) {

            if (fdestino <= 2 && (cdestino >= 3 && cdestino <= 5)) {
                //  arriba
                if ((fdestino == forigen - 1 && corigen == cdestino) || 
                    (cdestino == corigen - 1 && forigen == fdestino)) {
                    movValido = true;
                }
                // abajo
                else if ((forigen == fdestino - 1 && corigen == cdestino) || 
                         (corigen == cdestino - 1 && forigen == fdestino)) {
                    movValido = true;
                }
            }
        }
        
        String colorOponente = getColor().equals("R") ? "N" : "R";
        int[] posicionReyOponente = tablero.obtenerPosicionRey(colorOponente);
        int filaReyOponente = posicionReyOponente[0];
        int columnaReyOponente = posicionReyOponente[1];

        if (cdestino == columnaReyOponente && !hayPiezaEntreReyes(fdestino, filaReyOponente, cdestino)) {
            return false;  // cara a cara no puede move
        }
        
      
    Pieza destino = tablero.getTablero()[fdestino][cdestino];
    if (destino != null && destino.getColor().equals(this.getColor())) {
        movValido = false;
    }

    return movValido;
}
    
    
    
    
   public boolean hayPiezaEntreReyes(int filaInicio, int filaFin, int columna) {
        if (columna < 0 || columna >= tablero.getTablero()[0].length) {
            return false; //fuera de los límites
        }

        //no hay espacio intermedio sin piezas
        if (Math.abs(filaInicio - filaFin) == 1) {
            return false;
        }

        int siguienteFila = filaInicio < filaFin ? filaInicio + 1 : filaInicio - 1;

        if (siguienteFila < 0 || siguienteFila >= tablero.getTablero().length) {
            return false; // fuera de los límites
        }

        if (tablero.getTablero()[siguienteFila][columna] != null) {
            return true; // Hay una pieza
        }

        return hayPiezaEntreReyes(siguienteFila, filaFin, columna);
    }
   
   
    public boolean faceToface() {
        int[] posicionReyRojo = tablero.obtenerPosicionRey("R");
        int[] posicionReyNegro = tablero.obtenerPosicionRey("N");

        if (posicionReyRojo != null && posicionReyNegro != null &&
            posicionReyRojo[1] == posicionReyNegro[1]) {

            int columnaReyes = posicionReyRojo[1];
            int filaInicio = Math.min(posicionReyRojo[0], posicionReyNegro[0]);
            int filaFin = Math.max(posicionReyRojo[0], posicionReyNegro[0]);

            return !hayPiezaEntreReyes(filaInicio, filaFin, columnaReyes);
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
