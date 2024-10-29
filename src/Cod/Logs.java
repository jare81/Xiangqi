/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;


/**
 *
 * @author Dell
 */
public class Logs {
    private String jugadorActual;
    private String oponente;
    private String estado;
    private int puntos;

    public Logs(String jugadorActual, String oponente, String estado, int puntos) {
        this.jugadorActual = jugadorActual;
        this.oponente = oponente;
        this.estado = estado;
        this.puntos=puntos;
    }

    public String getJugadorActual() {
        return jugadorActual;
    }

    public String getOponente() {
        return oponente;
    }

    public String getEstado() {
        return estado;
    }
    
    public String toString(){
        return " " + jugadorActual.toUpperCase() +  " VS " + oponente.toUpperCase() +
               "\n Estado: " + estado + "      Puntos Obtenidos: " + puntos + "\n\n";
    }
    
    
    
    
    
    
    
    
}
