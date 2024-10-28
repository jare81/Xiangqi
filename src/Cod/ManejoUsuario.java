/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cod;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public final class ManejoUsuario {
    private Usuario usuarios[];
    private int contadorUsers;
    private Usuario usuarioActual;
    
     public ManejoUsuario(int cantidad){
    
      usuarios = new Usuario[cantidad]; 
      contadorUsers=0;
      usuarioActual = null;
      
      
    }
     
     
     
    public final Usuario obtenerUsuarioActual() {
        if (usuarioActual == null) {
            System.out.println("No hay un usuario actual");
            return null;  
        }
        return usuarioActual;
    }
    
    public Usuario obtenerUsuario(String username) {
        for (int i = 0; i <contadorUsers ; i++) {
            if (usuarios[i] != null && usuarios[i].getUsername().equals(username)) {
                return usuarios[i];
            }
        }
        return null;
    }
    
     public Usuario getUsuarioLinea(int index){
           if(index>=0 && index < contadorUsers){
               return usuarios[index];
           }
           return null;
       }
       
     public int getContadorUs(){
         return contadorUsers;
     }
    
     public boolean agregarUser (String username, String contrasena, String fecha, boolean estado){
        if (contadorUsers < usuarios.length) {
            Usuario nuevoUsuario = new Usuario(username, contrasena, fecha, estado, this);
            usuarios[contadorUsers] = nuevoUsuario;
            contadorUsers++;

            usuarioActual = nuevoUsuario;
            return true;
        } else {
            System.out.println("No se puede agregar más usuarios.");
            return false;
        }
        
     }
     
    public boolean validarCredenciales(String username, String password) {
        Usuario usuario = obtenerUsuario(username);
        if (usuario != null && usuario.getContrasena().equals(password)) {
            usuarioActual = usuario;
            return true;
        }
        return false;
    }
    
      public String mostrarUser() {
        if (usuarioActual != null) {
            return usuarioActual.getUsername();
        }
            return "Usuario no encontrado";  
    }
      
       public boolean cambiarEstadoUsuario(String username, boolean nuevoEstado) {
        Usuario usuario = obtenerUsuario(username);
        if (usuario != null) {
             usuario.cambiarEstado(nuevoEstado);
            return true;
        }
        return false;
    }
       
       
       public void agregarPuntos(String username, int puntos){
           Usuario usuario = obtenerUsuario(username);
           if(usuario != null){
               usuario.setPuntos(usuario.getPuntos() + puntos);
           }
       }
       
      
       
       
       
     public boolean eliminar(Usuario use){
         for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i].equals(use)){
                 
                 for (int j = i; j < contadorUsers - 1; j++) {
                 usuarios[j] = usuarios[j + 1];
                 }
                 
            usuarios[contadorUsers - 1] = null;
            contadorUsers--; 
            return true;
            }
        }
        return false;
     }
      
    public boolean cerrarSesion() {
        if (usuarioActual != null) {
            usuarioActual = null;
            return true;
        }
        return false;
    }
    
    public boolean usuarioExiste(String username) {
        for (int i = 0; i < contadorUsers; i++) {
            if (usuarios[i] != null && usuarios[i].getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public Usuario[] obtenerRanking() {
        Usuario[] usuariosActivos = obtenerUsuarios();
        for (int i = 0; i < usuariosActivos.length - 1; i++) {
            for (int j = i + 1; j < usuariosActivos.length; j++) {
                
                if (usuariosActivos[i].getPuntos() < usuariosActivos[j].getPuntos()) {
                    Usuario temp = usuariosActivos[i];
                    usuariosActivos[i] = usuariosActivos[j];
                    usuariosActivos[j] = temp;
                }
            }
        }
        return usuariosActivos;
}
    
    
    public Usuario[] obtenerUsuarios() {
        Usuario[] todos = new Usuario[contadorUsers];
        int contador = 0;
        for (int i = 0; i < contadorUsers; i++) {
            if (usuarios[i] != null) {
                todos[contador] = usuarios[i];
                contador++;
            }
        }

        Usuario[] usuariosActivos = new Usuario[contador];
        System.arraycopy(todos, 0, usuariosActivos, 0, contador);

        return usuariosActivos;
    }
    
    
    
}
