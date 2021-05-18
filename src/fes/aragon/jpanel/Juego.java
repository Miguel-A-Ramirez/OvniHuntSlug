package fes.aragon.jpanel;

import fes.aragon.hilos.Hilo_Panel2;
import fes.aragon.paneles.ImagenJu;
import fes.aragon.paneles.ImagenJu2;
import fes.aragon.paneles.OvniJuego;
import fes.aragon.paneles.naveAdelante;
import fes.aragon.paneles.naveAtras;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JButton;

public class Juego extends javax.swing.JFrame {
    private Cursor cursor;
    OvniJuego Ovni = new OvniJuego("ovniJuego", 20, this, 600, 600);
    
    public Juego() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Metal Hunt Slug");
        Toolkit herram = Toolkit.getDefaultToolkit();
        cursor=herram.createCustomCursor(herram.getImage(getClass().getResource("/fes/aragon/recursos/mira.png")),new Point(2,2), "p1");
        this.setCursor(cursor);
        Image icono = herram.getImage(getClass().getResource("/fes/aragon/recursos/icon.png"));
        this.setIconImage(icono);
        ImagenJu fondo = new ImagenJu("fondo", 4, this, 0, 0);
        ((Hilo_Panel2) jPanel1).getComponente().add(fondo);
        ImagenJu2 imaInferior = new ImagenJu2(this);
        ((Hilo_Panel2) jPanel1).getComponente().add(imaInferior);
        naveAtras naveAtras = new naveAtras("naveAtras", 3, this, 0, 0);
        ((Hilo_Panel2) jPanel1).getComponente().add(naveAtras);
        ((Hilo_Panel2) jPanel1).getComponente().add(Ovni);
        naveAdelante naveAdelante = new naveAdelante("naveAdelante", 3, this, 0, 0);
        ((Hilo_Panel2) jPanel1).getComponente().add(naveAdelante);
        Thread hilo = new Thread((Runnable) this.jPanel1);
        hilo.start();
        //System.out.println(Ovni.getEstado());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new fes.aragon.hilos.Hilo_Panel2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
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
  
    //public void setSalir(boolean salirr){
        //salir.setVisible(salirr);
    //}
   
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

