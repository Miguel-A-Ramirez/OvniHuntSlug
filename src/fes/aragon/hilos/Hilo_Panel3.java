package fes.aragon.hilos;

import fes.aragon.intf.Pintar;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Hilo_Panel3 extends JPanel implements Runnable{
    ArrayList<Pintar> componente=new ArrayList<Pintar>();
    private int sleep=1;

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getSleep() {
        return sleep;
    }
    
    

    public ArrayList<Pintar> getComponente() {
        return componente;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for (Pintar pintar : componente) {
            pintar.pintar(g);
        }
    }

    @Override
    public void run() {
        while(true){            
            try {
                repaint();
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo_Panel3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
