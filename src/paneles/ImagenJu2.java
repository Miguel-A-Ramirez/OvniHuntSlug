package paneles;

import intf.Pintar;
import java.awt.*;


public class ImagenJu2 implements Pintar {
    private Image imagen = null;
    private MediaTracker tracker;
    private int x=600;
    private int y=154;
    private int hx=0;
    
    public ImagenJu2(Component componente) {
        tracker = new MediaTracker(componente);
        Toolkit herram = Toolkit.getDefaultToolkit();
        imagen = herram.getImage(getClass().getResource(
                "/recursos/fondo2.jpg"));

        tracker.addImage(imagen, 1);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void pintar(Graphics g) {
        g.drawImage(imagen, hx,460,x,y,null);
        
    }
    
}
