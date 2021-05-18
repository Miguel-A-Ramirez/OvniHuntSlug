package paneles;

import intf.Pintar;
import java.awt.*;

public class ImagenMenu implements Pintar {
    private Image img = null;
    private MediaTracker tracker;
    private Dimension altoAncho;
    
    public ImagenMenu(Component cmp,Dimension altoAncho) {
        tracker = new MediaTracker(cmp);
        Toolkit herram = Toolkit.getDefaultToolkit();
        img = herram.getImage(getClass().getResource(
                "/recursos/background.jpg"));
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
