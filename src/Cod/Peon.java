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
public class Peon extends Pieza{
    
    private Tablero tablero;
    
    public Peon(String color, Tablero tablero){
        super("peo", color);
        this.tablero = tablero;
       
        
    }
    
    public boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino){
        
        if (forigen == fdestino && corigen == cdestino) {
             return false; 
        }

        boolean movValido = false;

       
        
        if (tablero.getRojo() && getColor().equals("R")) {
            
            if (fdestino == forigen - 1 && corigen == cdestino) {
                movValido = true;
                
            } else if (tablero.getFila()==6){
                    if(fdestino == forigen - 2 && corigen == cdestino) {
                    movValido = true; 
                }
            }
        }   
           

  
        else if (!tablero.getRojo() && getColor().equals("N")) {
            
            if (fdestino == forigen + 1 && corigen == cdestino) {
                movValido = true;
                
            } else if (tablero.getFila()==4){
                    if(fdestino == forigen + 2 && corigen == cdestino) {
                    movValido = true; 
                }
            }
        }

        //horizontal campo enemigo
        if (getColor().equals("R") && fdestino < 5 && fdestino == forigen && 
            Math.abs(cdestino - corigen) == 1) {
            movValido = true;
            
        } else if (getColor().equals("N") && fdestino > 5 && fdestino == forigen && 
                   Math.abs(cdestino - corigen) == 1) {
            movValido = true;
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
