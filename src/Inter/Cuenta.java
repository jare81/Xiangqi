/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inter;

import Cod.ManejoUsuario;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Dell
 */
public class Cuenta extends javax.swing.JFrame {

   private ManejoUsuario user;
    public Cuenta(ManejoUsuario user) {
        this.user=user;
        initComponents();
        this.setLocationRelativeTo(null);
        
        actualizar();
         
          
          
    }
    
    private void actualizar(){
         txtfecha.setEditable(false);
          txtpuntos.setEditable(false);
          txtusername.setEditable(false);
          
          txtusername.setText(user.obtenerUsuarioActual().getUsername());
          txtfecha.setText(user.obtenerUsuarioActual().getFecha());
          txtpuntos.setText(Integer.toString(user.obtenerUsuarioActual().getPuntos()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bncambiarpass = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        bneliminarcuenta = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        txtpuntos = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        bnX = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("KATANA", 0, 38)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CUENTA");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 300, 100));

        jLabel6.setFont(new java.awt.Font("KATANA", 1, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/botonG.png"))); // NOI18N
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 430, 150));

        jLabel8.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("username");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 200, 80));

        jLabel9.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FECHA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 170, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 200, 80));

        jLabel10.setFont(new java.awt.Font("KATANA", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PUNTOS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 170, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 200, 80));

        jLabel11.setFont(new java.awt.Font("KATANA", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("cambiar password");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 170, 40));

        bncambiarpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        bncambiarpass.setBorderPainted(false);
        bncambiarpass.setContentAreaFilled(false);
        bncambiarpass.setRolloverEnabled(false);
        bncambiarpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bncambiarpassActionPerformed(evt);
            }
        });
        getContentPane().add(bncambiarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 210, 80));

        jLabel12.setFont(new java.awt.Font("KATANA", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ELIMINAR CUENTA");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 170, 40));

        bneliminarcuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button2.png"))); // NOI18N
        bneliminarcuenta.setBorderPainted(false);
        bneliminarcuenta.setContentAreaFilled(false);
        bneliminarcuenta.setRolloverEnabled(false);
        bneliminarcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bneliminarcuentaActionPerformed(evt);
            }
        });
        getContentPane().add(bneliminarcuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 210, 80));

        txtusername.setBackground(new java.awt.Color(102, 0, 0));
        txtusername.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusernameKeyTyped(evt);
            }
        });
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 261, 40));

        txtfecha.setBackground(new java.awt.Color(102, 0, 0));
        txtfecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtfecha.setForeground(new java.awt.Color(255, 255, 255));
        txtfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        txtfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechaKeyTyped(evt);
            }
        });
        getContentPane().add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 261, 40));

        txtpuntos.setBackground(new java.awt.Color(102, 0, 0));
        txtpuntos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        txtpuntos.setForeground(new java.awt.Color(255, 255, 255));
        txtpuntos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        txtpuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpuntosActionPerformed(evt);
            }
        });
        txtpuntos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpuntosKeyTyped(evt);
            }
        });
        getContentPane().add(txtpuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 261, 40));

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Back");
        jLabel13.setToolTipText("");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 50, 20));

        bnX.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        bnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/button_back.png"))); // NOI18N
        bnX.setBorderPainted(false);
        bnX.setContentAreaFilled(false);
        bnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnXActionPerformed(evt);
            }
        });
        getContentPane().add(bnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imags/cuen.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bncambiarpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncambiarpassActionPerformed
        JPasswordField ante = new JPasswordField();
        JPasswordField confir = new JPasswordField();

        Object[] mensaje = {
            "Anterior contraseña:", ante,
            "Confirmar contraseña:", confir
        };

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Cambiar Contraseña", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            String anterior = new String(ante.getPassword());
            String nueva = new String(confir.getPassword());

            if (anterior.isEmpty() || nueva.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else if (!anterior.equals(user.obtenerUsuarioActual().getContrasena())) {
                JOptionPane.showMessageDialog(null, "La contraseña anterior es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else if (nueva.equals(user.obtenerUsuarioActual().getContrasena())) {
                JOptionPane.showMessageDialog(null, "La contraseña nueva no puede ser igual que la anterior.", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else if (nueva.length() != 5) {
                JOptionPane.showMessageDialog(null, "La contraseña nueva debe tener excatamente 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
               user.obtenerUsuarioActual().setContrasena(nueva);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
    
    }//GEN-LAST:event_bncambiarpassActionPerformed

    private void bneliminarcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bneliminarcuentaActionPerformed
        JPasswordField confir = new JPasswordField();

        Object[] mensaje = {
            "Confirmar contraseña:", confir
        };

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Cambiar Contraseña", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            String nueva = new String(confir.getPassword());

            if ( nueva.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Asegurate de ingresar la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else if (!nueva.equals(user.obtenerUsuarioActual().getContrasena())) {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else if (nueva.equals(user.obtenerUsuarioActual().getContrasena())) {
                
                
                int respuesta = JOptionPane.showConfirmDialog(null, 
                "¿Está seguro de que desea eliminar el usuario " + user.obtenerUsuarioActual().getUsername() + "?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);

                if (respuesta == JOptionPane.YES_OPTION) {
                    
                        if(user.eliminar(user.obtenerUsuarioActual())==true){
                           JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                           this.setVisible(false);
                           new Menu_Inicio(user).setVisible(true);
                           
                        }else{
                           JOptionPane.showMessageDialog(null, "No se encontró el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {

                    JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                }
                
                
               
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }
        
        

    }//GEN-LAST:event_bneliminarcuentaActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtusernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyTyped

    }//GEN-LAST:event_txtusernameKeyTyped

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void txtfechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaKeyTyped

    }//GEN-LAST:event_txtfechaKeyTyped

    private void txtpuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpuntosActionPerformed

    private void txtpuntosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpuntosKeyTyped

    }//GEN-LAST:event_txtpuntosKeyTyped

    private void bnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnXActionPerformed
        this.setVisible(false);
        new Menu_Principal(user).setVisible(true);
    }//GEN-LAST:event_bnXActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
             ManejoUsuario user;
            public void run() {
               
                new Cuenta(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnX;
    private javax.swing.JButton bncambiarpass;
    private javax.swing.JButton bneliminarcuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtpuntos;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
