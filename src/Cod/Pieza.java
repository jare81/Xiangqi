/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;

/**
 *
 * @author Dell
 */
public abstract class Pieza  {
    
    
    private String nombrePieza;
    private String color;
   
     public Pieza(String nombrePieza, String color) {
        this.color = color;
        this.nombrePieza = nombrePieza;
    }
     
      
    public String getColor() {
        return color;
    }
    
    public String getNombrePieza(){
        return nombrePieza;
    }
    
    
     
    public abstract boolean esMovimientoValido(int forigen, int corigen, int fdestino, int cdestino);
    public abstract boolean moverPieza(int forigen, int corigen, int fdestino, int cdestino); 

    
}
