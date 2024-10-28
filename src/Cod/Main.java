/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;

import Inter.Iniciar_Sesion;
import Inter.Menu_Inicio;
import Inter.Registro;

/**
 *
 * @author Dell
 */
public class Main {
    public static void main(String[] args) {
        
        ManejoUsuario user = new ManejoUsuario(100);
       // Iniciar_Sesion iniciarSesion = new Iniciar_Sesion(user);
        
        Menu_Inicio inicio = new Menu_Inicio(user);
        //Registro registro = new Registro(user);
        
        inicio.setVisible(true);
      
    }    
         
}
