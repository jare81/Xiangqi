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

        boolean movValido = false;

        
        if (tablero.getRojo()&& getColor().equals("R")) {
            
            if (fdestino>=8 && (cdestino>=3 && cdestino<=5)) {
              
                //cuando va para arriba
                if((fdestino == forigen - 1 && corigen == cdestino) || 
                   (cdestino == corigen - 1 && forigen == fdestino)){
                        movValido = true;
                        
                //cuando va para abajo
                } else if((forigen == fdestino - 1 && corigen == cdestino) || 
                           (corigen == cdestino - 1 && forigen == fdestino)){
                    movValido = true;
                }
                
                
                
        } else if (!tablero.getRojo() && getColor().equals("N")) {
            
            if (fdestino<=2 && (cdestino>=3 && cdestino<=5)) {
              
                //cuando va para arriba
                if((fdestino == forigen - 1 && corigen == cdestino) || 
                   (cdestino == corigen - 1 && forigen == fdestino)){
                        movValido = true;
                        
                //cuando va para abajo
                } else if((forigen == fdestino - 1 && corigen == cdestino) || 
                           (corigen == cdestino - 1 && forigen == fdestino)){
                    movValido = true;
                }
                
            }   
        
        }
        
            Pieza destino = tablero.getTablero()[fdestino][cdestino];
            if (destino != null && destino.getColor().equals(this.getColor())) {
                movValido= false;
            }

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
