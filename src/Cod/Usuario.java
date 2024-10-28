/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;

/**
 *
 * @author Dell
 */
public class Usuario {
    private String  username;
    private String  contrasena;
    private String  fecha;
    private boolean estado; 
    private int puntos;
    private ManejoUsuario user;
    
     private Logs[] logs;
     private int indexL;
    
    
    public Usuario(String username, String contrasena, String fecha, boolean estado, ManejoUsuario user){
        this.username=username;
        this.contrasena=contrasena;
        this.fecha=fecha;
        this.estado=estado;
        
        puntos=0;
        
        this.user=user;
        logs = new Logs[100];
        this.indexL=0;
        
    }
    
    public Usuario getUser(){
        return user.obtenerUsuarioActual();
    }
    
    public Usuario getOpon(String us){
        return user.obtenerUsuario(us);
    }
    
   
    public String getUsername(){
        return username;
    }
   
    public String getContrasena(){
        return contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public void setPuntos(int puntos){
        this.puntos+=puntos;
    }
    
    public void setEstado(boolean estado){
        this.estado=estado;
    } 
    
    public void cambiarEstado(boolean nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    public boolean getEstado() {
        return estado;
    }
    
    
    public void agregarLog(Logs log){
        if (indexL < logs.length) {
            logs[indexL] = log;
            indexL++;
        } else {
            System.out.println("No se pueden agregar más logs.");
            }
        
    }
    
    public Logs[] getLogs(){
        Logs[] logsAct = new Logs[indexL];
        System.arraycopy(logs, 0, logsAct, 0, indexL);
        return logsAct;
    }
   
    
   
    
}
