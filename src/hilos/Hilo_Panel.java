package hilos;

import intf.Pintar;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Hilo_Panel extends JPanel implements Runnable{
    ArrayList<Pintar> componente=new ArrayList<Pintar>();

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
                Thread.sleep(60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
