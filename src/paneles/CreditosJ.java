package paneles;

import intf.Pintar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

public class CreditosJ implements Pintar{
    private Image img = null;
    private MediaTracker tracker;
    private Dimension altoAncho;

    public CreditosJ(Component cmp,Dimension altoAncho) {
        tracker = new MediaTracker(cmp);
        Toolkit herram = Toolkit.getDefaultToolkit();
        img = herram.getImage(getClass().getResource("/recursos/background2.jpg"));
        tracker.addImage(img, 1);
        this.altoAncho=altoAncho;
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void pintar(Graphics g) {
        g.drawImage(img, 0, 0,altoAncho.width,altoAncho.height, null);
    }
}
