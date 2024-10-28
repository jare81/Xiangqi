 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inter;

import Cod.ManejoUsuario;
import Cod.Pieza;
import Cod.Caballo;
import Cod.Peon;
import Cod.Oficial;
import Cod.Elefante;
import Cod.Canon;
import Cod.Logs;
import Cod.Torre;
import Cod.Rey;

import Cod.Usuario;
import Inter.Menu_Principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Tablero extends javax.swing.JFrame {
    //////////////////////////////////CUIDADO CON EL STATIC
     //private static Control control;
     private Usuario oponente;
    ManejoUsuario user;
    
     
    private JButton[][] casillas = new JButton[11][9];
    private  Pieza[][] tablero = new Pieza[11][9];
    private JButton[] resaltos = new JButton[20];
    private int contadorR = 0;
    private Logs[] logs;
   
    private final Border bordeResaltado = new LineBorder(Color.YELLOW, 3); 
    
    private boolean hayPiezaSelect = false;
    private int filaClick;
    private int columnaClick;
    private boolean turnoRojo = true;
    
   
    
    public Tablero(ManejoUsuario user, Usuario oponente) {
       this.user=user;
       this.oponente=oponente;
        
       
       
        initComponents();
        iniciarCasillas();
        mostrarNombres();
        
       
           tt1.setVisible(true);
           tt11.setVisible(true);
           
            tt2.setVisible(false);
           tt22.setVisible(false);
        
    }
    
      private void mostrarNombres() {
        txtplay1.setText(user.obtenerUsuarioActual().getUsername().toUpperCase());
        txtplay2.setText(oponente.getUsername().toUpperCase());
    }
    
   
   private void iniciarCasillas() {
        tablero[0][0] = new Torre("N", this);
        tablero[0][1] = new Caballo("N", this);
        tablero[0][2] = new Elefante("N", this);
        tablero[0][3] = new Oficial("N", this);
        tablero[0][4] = new Rey("N", this);
        tablero[0][5] = new Oficial("N", this);
        tablero[0][6] = new Elefante("N", this);
        tablero[0][7] = new Caballo("N", this);
        tablero[0][8] = new Torre("N", this);
        tablero[2][1] = new Canon("N", this);
        tablero[2][7] = new Canon("N", this);
        for (int i = 0; i < 9; i += 2) {
            tablero[3][i] = new Peon("N", this);
        }

        // Colocar piezas rojas en sus posiciones
        tablero[10][0] = new Torre("R", this);
        tablero[10][1] = new Caballo("R", this);
        tablero[10][2] = new Elefante("R", this);
        tablero[10][3] = new Oficial("R", this);
        tablero[10][4] = new Rey("R", this);
        tablero[10][5] = new Oficial("R", this);
        tablero[10][6] = new Elefante("R", this);
        tablero[10][7] = new Caballo("R", this);
        tablero[10][8] = new Torre("R", this);
        tablero[8][1] = new Canon("R", this);
        tablero[8][7] = new Canon("R", this);
        for (int i = 0; i < 9; i += 2) {
            tablero[7][i] = new Peon("R", this);
        }
       
       
       
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        Tablero.setLayout(new GridLayout(11, 9));
        Color colorTablero = Color.decode("#ff6242");
        
        for (int fila = 0; fila < 11; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                 casillas[fila][columna] = new JButton();

                if ((fila == 0 || fila == 1 || fila ==2) && (columna == 3 || columna == 4 || columna ==5) || 
                   ((fila == 8 || fila == 9 || fila==10) && (columna == 3 || columna == 4 || columna ==5))) {
                    casillas[fila][columna].setBackground(Color.WHITE);  
                }

                else if (fila == 5) {  
                    casillas[fila][columna].setBackground(Color.gray);  
                    casillas[fila][columna].setEnabled(false);  
                }

                  else if ((fila + columna) % 2 == 0) {
                        casillas[fila][columna].setBackground(Color.BLACK); 
                    } else {
                        casillas[fila][columna].setBackground(colorTablero);   
                    }
                
                
                
                 if (tablero[fila][columna] != null) {
                    String nombrePieza = tablero[fila][columna].getNombrePieza();
                    String color = tablero[fila][columna].getColor();
                    
                  //unir los dos strings pata formar nombrePieza 
                    casillas[fila][columna].setIcon(cargarIcono(color + "_" + nombrePieza));
                }  

                final int f = fila;
                final int c = columna;

                casillas[fila][columna].setOpaque(true); 
                    casillas[fila][columna].addActionListener(new ActionListener(){
                        public void actionPerformed (ActionEvent e){
                            manejarClic(f, c);
                            System.out.println("Fila " + getFila() + " Columna " + getColumna());

                        }
                    });

                    Tablero.add(casillas[fila][columna]);

                 }

            }

    }
   
    public Pieza[][] getTablero(){
        return tablero;
    }
   
   
    public Pieza obtenerPieza(int fila, int columna){
        return tablero[fila][columna];
    }
   
   
   public void manejarClic(int fila, int columna){
       
       //si no hya pieza sleccionada
       if (hayPiezaSelect) {
            limpiarResaltado(); 
            
            Pieza pieza = tablero[filaClick][columnaClick];
            Pieza piezaDestino = tablero[fila][columna];
        
        if (pieza != null && pieza.esMovimientoValido(filaClick, columnaClick, fila, columna)) {
          
            if (piezaDestino != null && !piezaDestino.getColor().equals(pieza.getColor())) {
                capturarPieza(piezaDestino);
            }
            
            
            pieza.moverPieza(filaClick, columnaClick, fila, columna);
            
            Icon iPieza = casillas[filaClick][columnaClick].getIcon();
            casillas[fila][columna].setIcon(iPieza);
            casillas[filaClick][columnaClick].setIcon(null);
            
            turnoRojo = !turnoRojo;
            TT();
            verificarGanador(); 
            
        } else {
            hayPiezaSelect = false;
             return;
        }
        
        hayPiezaSelect = false; 
        
    } else {
           //limpiarResaltado(); 
           Pieza pieza = tablero[fila][columna];
           
           if (pieza == null || casillas[fila][columna].getIcon() == null) {
            hayPiezaSelect = false;
            System.out.println("Fila " + fila + " Columna " + columna);
            return;
            }

        if (piezaDeTurno(fila, columna)) {
            filaClick = fila;
            columnaClick = columna;
            hayPiezaSelect = true;
            resaltarValidos(fila, columna);
        }
        
    }
   }
   
   private void verificarGanador() {
        boolean reyRojoPresente = false;
        boolean reyNegroPresente = false;

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {

                Pieza pieza = tablero[fila][columna];
                if (pieza != null && pieza.getNombrePieza().equals("rey")) {

                    if (pieza.getColor().equals("R")) {
                        reyRojoPresente = true;
                    } else if (pieza.getColor().equals("N")) {
                        reyNegroPresente = true;
                    }
                }
            }
        }

        if (!reyRojoPresente) {
              Win(oponente);
            JOptionPane.showMessageDialog(this, "Jugador " + oponente.getUsername().toUpperCase() + " venció a "  + 
                    user.obtenerUsuarioActual().getUsername() + " ¡Las piezas negras ganan!" );
            
          
            
            Logs partida = new Logs(oponente.getUsername(), user.obtenerUsuarioActual().getUsername(), "Ganada", 3);
            oponente.agregarLog(partida);
            oponente.setPuntos(3);
            
            Logs partida2 = new Logs(user.obtenerUsuarioActual().getUsername(), oponente.getUsername(), "Perdida", 0);
            user.obtenerUsuarioActual().agregarLog(partida2);
            
            this.setVisible(false);
            new Menu_Principal(user).setVisible(true);

            
        } else if (!reyNegroPresente) {
            Win(user.obtenerUsuarioActual());
            JOptionPane.showMessageDialog(this, "El jugador " + user.obtenerUsuarioActual().getUsername().toUpperCase() +
                    " venció a " + oponente.getUsername() + " ¡Las piezas rojas ganan!" );
            
            
            Logs partida = new Logs(user.obtenerUsuarioActual().getUsername(), oponente.getUsername(), "Ganada", 3);
            user.obtenerUsuarioActual().agregarLog(partida);
            user.obtenerUsuarioActual().setPuntos(3);
            
            Logs partida2 = new Logs(oponente.getUsername(), user.obtenerUsuarioActual().getUsername(),  "Perdida", 0);
            oponente.agregarLog(partida2);
            
            this.setVisible(false);
            new Menu_Principal(user).setVisible(true);
        }
}
   
   
   
   private void resaltarValidos(int fila, int columna) {
        Pieza pieza = obtenerPieza(fila, columna);
        if (pieza == null) 
            return;  // No resaltar si no hay pieza

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                
                if (pieza.esMovimientoValido(fila, columna, i, j)) {
                    casillas[i][j].setBorder(bordeResaltado);
                    
                    if (contadorR < resaltos.length) {  
                        resaltos[contadorR++] = casillas[i][j];
                    }
                }
            }
        }
    }
   
   private void limpiarResaltado() {
        for (int i = 0; i < contadorR; i++) {
            resaltos[i].setBorder(null);
            resaltos[i] = null; 
        }
        contadorR = 0; 
    }
   
   
   
   
   public boolean getRojo(){
       return turnoRojo;
   }
   
   
  
   public int getFila(){
       return filaClick;
   }
   
   public int getColumna(){
       return columnaClick;
   }
   
   
   
   private boolean piezaDeTurno(int fila, int columna){
      Pieza piezaSeleccionada = tablero[fila][columna];
      
        if (piezaSeleccionada != null) {
            String colorPieza = piezaSeleccionada.getColor();
            if (turnoRojo && colorPieza.equals("R")) {
                return true; 
            } else if (!turnoRojo && colorPieza.equals("N")) {
                return true; 
            }
        }
        return false; 
   }
   
   private ImageIcon cargarIcono(String nombrePieza){
       String ruta = "/imags/" + nombrePieza + ".png";
       return new ImageIcon(getClass().getResource(ruta));
   }
   
   private void capturarPieza(Pieza piezaCapturada) {
        JLabel etiquetaPieza = new JLabel();
        etiquetaPieza.setIcon(cargarIcono(piezaCapturada.getColor() + "_" + piezaCapturada.getNombrePieza()));

       
        if (piezaCapturada.getColor().equals("R")) {
            piezasn.add(etiquetaPieza);
            piezasn.revalidate();
            piezasn.repaint(); // 
        } else {
            piezasr.add(etiquetaPieza); 
            piezasr.revalidate();
            piezasr.repaint(); 
        }
}
   
   
   private void TT(){
       if(turnoRojo){
           tt1.setVisible(true);
           tt11.setVisible(true);
           
            tt2.setVisible(false);
           tt22.setVisible(false);
           
       }else if(!turnoRojo){
           tt2.setVisible(true);
           tt22.setVisible(true);
           
           tt1.setVisible(false);
           tt11.setVisible(false);
       }
   }
   
    private void Win(Usuario uu){
       if(uu==user.obtenerUsuarioActual()){
           tt1.setVisible(true);
           tt11.setText("GANADOR");
           tt11.setVisible(true);
           
           
           
            tt2.setVisible(false);
           tt22.setVisible(false);
           
       }else if(uu==oponente){
           tt2.setVisible(true);
            tt22.setText("GANADOR");
           tt22.setVisible(true);
          
           
           tt1.setVisible(false);
           tt11.setVisible(false);
       }
   }
   
   
   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tablero = new javax.swing.JPanel();
        panelR = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtplay1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        piezasr = new javax.swing.JPanel();
        panelN = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtplay2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        piezasn = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tt11 = new javax.swing.JLabel();
        tt1 = new javax.swing.JLabel();
        tt22 = new javax.swing.JLabel();
        tt2 = new javax.swing.JLabel();
        bnRetirar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Tablero.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        getContentPane().add(Tablero);
        Tablero.setBounds(440, 20, 650, 750);

        panelR.setBackground(new java.awt.Color(102, 0, 0));
        panelR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ROJO");
        panelR.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 40));

        jLabel11.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("JUGADOR 1");
        panelR.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 40));

        txtplay1.setBackground(new java.awt.Color(102, 0, 0));
        txtplay1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtplay1.setForeground(new java.awt.Color(255, 255, 255));
        txtplay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtplay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplay1ActionPerformed(evt);
            }
        });
        txtplay1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtplay1KeyTyped(evt);
            }
        });
        panelR.add(txtplay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        panelR.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));
        panelR.add(piezasr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, 310));

        getContentPane().add(panelR);
        panelR.setBounds(60, 100, 350, 480);

        panelN.setBackground(new java.awt.Color(0, 0, 0));
        panelN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panelN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NEGRO");
        panelN.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 40));

        jLabel9.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("JUGADOR 2");
        panelN.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 40));

        txtplay2.setBackground(new java.awt.Color(0, 0, 0));
        txtplay2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtplay2.setForeground(new java.awt.Color(255, 255, 255));
        txtplay2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtplay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplay2ActionPerformed(evt);
            }
        });
        txtplay2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtplay2KeyTyped(evt);
            }
        });
        panelN.add(txtplay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 180, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        panelN.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));
        panelN.add(piezasn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, 300));

        getContentPane().add(panelN);
        panelN.setBounds(1130, 110, 350, 470);

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Retirar");
        jLabel12.setToolTipText("");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 30, 70, 30);

        tt11.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        tt11.setForeground(new java.awt.Color(255, 255, 255));
        tt11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tt11.setText("TURNO DE");
        getContentPane().add(tt11);
        tt11.setBounds(150, 40, 170, 40);

        tt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        getContentPane().add(tt1);
        tt1.setBounds(140, 30, 194, 59);

        tt22.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        tt22.setForeground(new java.awt.Color(255, 255, 255));
        tt22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tt22.setText("TURNO DE");
        getContentPane().add(tt22);
        tt22.setBounds(1220, 50, 170, 40);

        tt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        getContentPane().add(tt2);
        tt2.setBounds(1210, 40, 194, 59);

        bnRetirar.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        bnRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button_back.png"))); // NOI18N
        bnRetirar.setBorderPainted(false);
        bnRetirar.setContentAreaFilled(false);
        bnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnRetirarActionPerformed(evt);
            }
        });
        getContentPane().add(bnRetirar);
        bnRetirar.setBounds(20, 20, 108, 55);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/hh.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1530, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtplay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplay2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplay2ActionPerformed

    private void txtplay2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplay2KeyTyped

    }//GEN-LAST:event_txtplay2KeyTyped

    private void txtplay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplay1ActionPerformed

    private void txtplay1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplay1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplay1KeyTyped

    private void bnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnRetirarActionPerformed
        Usuario retirado = user.obtenerUsuarioActual();
        Usuario noRetirado = user.obtenerUsuarioActual();
        
        if(turnoRojo){
            retirado=user.obtenerUsuarioActual();
            noRetirado=oponente;
        }else if(!turnoRojo){
            retirado=oponente;
            noRetirado = user.obtenerUsuarioActual();
        }
        
        
        int respuesta = JOptionPane.showConfirmDialog(null, 
                "¿Está seguro que deseas retirarte "  + retirado.getUsername() + "?", 
                "Confirmar Retiro", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);

                if (respuesta == JOptionPane.YES_OPTION) {
                    noRetirado.setPuntos(3);
                            Win(noRetirado);
                           JOptionPane.showMessageDialog(null, "El jugador " + retirado.getUsername()+ " Se ha retirado.\n Felicidades " +  noRetirado.getUsername()  +  " eres el ganador! ", "GANADOR", JOptionPane.INFORMATION_MESSAGE);
                            
                            
                            Logs partida = new Logs(noRetirado.getUsername(), retirado.getUsername(), "Ganada por Retiro", 3);
                            noRetirado.agregarLog(partida);
                            
                            Logs partida2 = new Logs(retirado.getUsername(), noRetirado.getUsername(), "Retirada", 0);
                            retirado.agregarLog(partida2);
                            
                           this.setVisible(false);
                           new Menu_Principal(user).setVisible(true);
                           
                       
                    } else {

                    JOptionPane.showMessageDialog(null, "Retiro cancelado.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                }
    }//GEN-LAST:event_bnRetirarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // Crear la ventana principal
        
        java.awt.EventQueue.invokeLater(new Runnable() {
                Usuario oponente;
                 ManejoUsuario user;
            public void run() {
               
                new Tablero( user, oponente).setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tablero;
    private javax.swing.JButton bnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelN;
    private javax.swing.JPanel panelR;
    private javax.swing.JPanel piezasn;
    private javax.swing.JPanel piezasr;
    private javax.swing.JLabel tt1;
    private javax.swing.JLabel tt11;
    private javax.swing.JLabel tt2;
    private javax.swing.JLabel tt22;
    private javax.swing.JTextField txtplay1;
    private javax.swing.JTextField txtplay2;
    // End of variables declaration//GEN-END:variables
}


