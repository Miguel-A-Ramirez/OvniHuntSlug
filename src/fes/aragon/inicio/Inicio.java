package fes.aragon.inicio;

import fes.aragon.creditos.Creditos;
import fes.aragon.hilos.Hilo_Panel;
import fes.aragon.jpanel.Juego;
import fes.aragon.paneles.ImagenMenu;
import fes.aragon.paneles.OvniPri;
import fes.aragon.paneles.OvniPri2;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;

public class Inicio extends javax.swing.JFrame {
    AudioClip audioPrincipal = java.applet.Applet.newAudioClip(getClass().getResource("/fes/aragon/recursos/AudioPri.wav"));
    
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Metal Hunt Slug");
        Toolkit herram = Toolkit.getDefaultToolkit();
        Image icono = herram.getImage(getClass().getResource("/fes/aragon/recursos/icon.png"));
        this.setIconImage(icono);
        ImagenMenu fondo = new ImagenMenu(jPanel1, jPanel1.getSize());
        ((Hilo_Panel) jPanel1).getComponente().add(fondo);
        OvniPri Ovni = new OvniPri("ovni", 32, this, 380, 220);
        ((Hilo_Panel) jPanel1).getComponente().add(Ovni);
        OvniPri2 Ovnii = new OvniPri2("ovnii", 32, this, 118, 220);
        ((Hilo_Panel) jPanel1).getComponente().add(Ovnii);
        Thread hilo = new Thread((Runnable) this.jPanel1);
        hilo.start();
        //audioPrincipal = java.applet.Applet.newAudioClip(getClass().getResource("/fes/aragon/recursos/AudioPri.wav"));
        //audioPrincipal.play();
        audioPrincipal.loop();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new fes.aragon.hilos.Hilo_Panel();
        botonJugar = new javax.swing.JButton();
        botonCreditos = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonSilencio = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonJugar.setBackground(new java.awt.Color(153, 102, 0));
        botonJugar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        botonJugar.setForeground(new java.awt.Color(102, 102, 102));
        botonJugar.setText("Jugar");
        botonJugar.setBorder(null);
        botonJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarActionPerformed(evt);
            }
        });

        botonCreditos.setBackground(new java.awt.Color(153, 102, 0));
        botonCreditos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        botonCreditos.setForeground(new java.awt.Color(102, 102, 102));
        botonCreditos.setText("Creditos");
        botonCreditos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 51, 0)));
        botonCreditos.setBorderPainted(false);
        botonCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCreditosActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(153, 102, 0));
        botonSalir.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(102, 102, 102));
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 51, 0)));
        botonSalir.setBorderPainted(false);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonSilencio.setBackground(new java.awt.Color(153, 102, 0));
        botonSilencio.setForeground(new java.awt.Color(102, 102, 102));
        botonSilencio.setText("Silenciar");
        botonSilencio.setBorderPainted(false);
        botonSilencio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSilencioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(249, 249, 249))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botonSilencio)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(botonCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(botonSalir)
                .addGap(65, 65, 65)
                .addComponent(botonSilencio)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarActionPerformed
        Juego juegop = new Juego();
        juegop.setVisible(true);
        audioPrincipal.stop();
        this.dispose();
    }//GEN-LAST:event_botonJugarActionPerformed

    private void botonCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCreditosActionPerformed
        Creditos creditos = new Creditos();
        creditos.setVisible(rootPaneCheckingEnabled);
        audioPrincipal.stop();
        this.dispose();
    }//GEN-LAST:event_botonCreditosActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonSilencioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSilencioActionPerformed
        int playAudio;
        audioPrincipal.stop();
        playAudio =+ 1;
        System.out.println(playAudio);
    }//GEN-LAST:event_botonSilencioActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCreditos;
    private javax.swing.JButton botonJugar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JToggleButton botonSilencio;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
