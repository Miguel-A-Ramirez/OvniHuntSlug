package paneles;

import intf.Pintar;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OvniPri implements Pintar {

    private ArrayList<Image> imagenes = new ArrayList<Image>();
    private MediaTracker tracker;
    private int indice = 0;
    private int x = 0;
    private int y = 0;

    public OvniPri(String nombreArchivo, int numeroFrames, Component componente, int x, int y) {
        tracker = new MediaTracker(componente);
        this.x = x;
        this.y = y;
        Toolkit herram = Toolkit.getDefaultToolkit();
        for (int i = 1; i < numeroFrames; i++) {
            Image imagen = herram.getImage(getClass().getResource(
                    "/recursos/" + nombreArchivo + "/" + nombreArchivo + " (" + i
                    + ").png"));
            imagenes.add(imagen);
            tracker.addImage(imagen, i);

        }
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void pintar(Graphics g) {
        if (indice > imagenes.size() - 1) {
            // System.out.println("Cambio de indice");
            indice = 0;
        }
        g.drawImage(imagenes.get(indice), x, y, 117, 190, null);
        indice++;
        //g.drawRect(x, y, 117, 190);
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
