package paneles;

import intf.Pintar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;

public class ImagenJu implements Pintar{
    private ArrayList<Image> imagenes = new ArrayList<Image>();
    private MediaTracker tracker;
    private int indice = 0;
    private int x = 0;
    private int y = 0;

    public ImagenJu(String nombreArchivo, int numeroFrames, Component componente, int x, int y) {
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
            indice = 0;
        }
        g.drawImage(imagenes.get(indice), x, y, null);
        indice++;
    }
}
