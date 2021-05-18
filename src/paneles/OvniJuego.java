package paneles;

import intf.Pintar;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

public class OvniJuego extends JFrame implements Pintar, ActionListener {
    private ArrayList<Image> imagenes = new ArrayList<Image>();
    private MediaTracker tracker;
    private int indice = 0;
    private int x = 0;
    private int y = 0;
    private int hx=276;
    private int hy=0;
    private int cx=0;
    private int cy=0;
    private int largo=0;
    private int ancho=0;
    private boolean clickRaton;
    private boolean clickFuera=false;
    private int balas=3;
    private boolean perdiste;
    private boolean ganaste;
    private int noAliens=2;
    private int puntaje;
    private int noNivel=1;
    private AudioClip laser;
    private AudioClip audioFondo;
    private AudioClip audioGanaste;
    private AudioClip audioPerdiste;
    private boolean estado = false;
    
    public int izquierda = -6;
    public int derecha = 6;
    public int arriba = -6;
    public int abajo = 6;
    
    public OvniJuego(String nombreArchivo, int numeroFrames, Component componente, int x, int y) {
        tracker = new MediaTracker(componente);
        this.x = x;
        this.y = y;
        Toolkit herram = Toolkit.getDefaultToolkit();
        for (int i = 1; i < numeroFrames; i++) {
            Image imagen = herram.getImage(getClass().getResource("/recursos/" + nombreArchivo + "/" + nombreArchivo + " (" + i + ").png"));
            imagenes.add(imagen);
            tracker.addImage(imagen, i);
        }
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        EventoRaton raton = new EventoRaton();
        componente.addMouseListener(raton);
        laser = java.applet.Applet.newAudioClip(getClass().getResource("/recursos/laser.wav"));
        audioFondo = java.applet.Applet.newAudioClip(getClass().getResource("/recursos/fondoJuego.wav"));
        audioGanaste = java.applet.Applet.newAudioClip(getClass().getResource("/recursos/juegoGanaste.wav"));
        audioPerdiste = java.applet.Applet.newAudioClip(getClass().getResource("/recursos/juegoPerdiste.wav"));
        audioFondo.loop();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void accion(){
        if(isClickRaton()){
            setHx(276);
            setHy(0);
            if(getBalas()>0){
            setBalas(getBalas()-1);
            }
            if(noAliens>0){
            noAliens=noAliens-1;
            }
            puntaje=puntaje+25;
            niveles();    
        }
    }
    
    public void niveles(){
        if(getBalas()>=noAliens && noAliens==0){
            noNivel=noNivel+1;
            if(noNivel==2){
                noAliens=3;
                setBalas(getBalas()+noAliens+1);
                izquierda = -12;
                derecha = 12;
                arriba = -12;
                abajo = 12;
            }
            if(noNivel==3){
                noAliens=4;
                setBalas(getBalas()+noAliens+1);
                izquierda = -15;
                derecha = 15;
                arriba = -15;
                abajo = 15;
            }
            if(noNivel==4){
                noAliens=5;
                setBalas(getBalas()+noAliens+1);
                izquierda = -20;
                derecha = 20;
                arriba = -20;
                abajo = 20;
            }
            if(noNivel==5){
                noAliens=6;
                setBalas(getBalas()+noAliens+1);
                izquierda = -25;
                derecha = 25;
                arriba = -25;
                abajo = 25;
            }
            if(noNivel==6){
                audioGanaste.play();
                ganaste=true;
            }
        }else if(getBalas()<noAliens && getBalas()==0){
            perdiste=true;
        }
    }
    
    @Override
    public void pintar(Graphics g) {
        Graphics2D gg = (Graphics2D)g;
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hx+=3;
        if (indice > imagenes.size() - 1) {
            indice = 0;
        }
        if(getHx() <= 0){
            setCy(derecha);
        }
        if(getHx() >= 540){
            setCy(izquierda);
        }
        hx=hx+getCy();
        
        if(getHy() <= 0){
            setCx(abajo);
        }
        if(getHy() >= 396){
        setCx(arriba);
        }
        hy=hy+getCx();

        gg.drawImage(imagenes.get(indice), getHx(), getHy(), 70, 70, null);
        indice++;
        setAncho(70);
        setLargo(70);
        gg.setColor(Color.white);
        gg.drawRect(5, 540, 70, 65);
        gg.setFont(new Font("verdana", Font.CENTER_BASELINE, 50));
        gg.drawString(getBalas()+"", 23, 580);
        gg.setFont(new Font("verdana", Font.CENTER_BASELINE, 15));
        gg.drawString("Disparos", 5, 598);
        gg.setFont(new Font("verdana", Font.CENTER_BASELINE, 30));
        gg.drawString("Aliens:"+noAliens, 245, 598);
        gg.drawRect(420, 558, 178, 50);
        gg.setFont(new Font("verdana", Font.CENTER_BASELINE, 25));
        gg.drawString("Puntaje:"+puntaje, 420, 595);
        gg.setFont(new Font("verdana", Font.CENTER_BASELINE, 25));
        gg.drawString("Nivel:"+noNivel, 100, 598);
        Toolkit herrami = Toolkit.getDefaultToolkit();
        Image image = herrami.getImage(getClass().getResource("/recursos/gameOver.png"));
        Image image2 = herrami.getImage(getClass().getResource("/recursos/complete.png"));
        Image image3 = herrami.getImage(getClass().getResource("/recursos/misionc.gif"));
        if(perdiste){
            gg.drawImage(image, 0, 120, null);
            setHx(250);
            setHy(450);
            laser.stop();
            audioFondo.stop();
        }else if(ganaste){
            setHy(4450);
            gg.drawImage(image2, 0, 80, null);
            gg.drawImage(image3, 250, 450, 70, 83, null);
            audioFondo.stop();
            laser.stop();
        }

    }
    
    private class EventoRaton extends MouseAdapter {
    @Override
        public void mousePressed(MouseEvent e) {
        super.mouseClicked(e);
        if(colision(getHx(), getHy()+27, getAncho(), getLargo(), e.getX(), e.getY())){
            setClickRaton(true);
            accion();
            laser.play();
        }else{
            if(getBalas()>0){
            setBalas(getBalas()-1);
            }else if(getBalas()==0){
                audioPerdiste.play();
                perdiste=true;
                setEstado(perdiste);
                System.out.println(getEstado());
            }
            puntaje=puntaje-20;
            laser.play();
        }
        }
    }
    
    public boolean colision(int x1, int y1, int ancho, int alto, int xM, int yM){
        if(xM>x1 && xM<x1+ancho && yM<y1+alto && yM>y1){
            return true;
        }else{
        return false;
        }
    }
    
    public int getHx() {
        return hx;
    }

    public void setHx(int hx) {
        this.hx = hx;
    }

    public int getHy() {
        return hy;
    }

    public void setHy(int hy) {
        this.hy = hy;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public boolean isClickRaton() {
        return clickRaton;
    }

    public void setClickRaton(boolean clickRaton) {
        this.clickRaton = clickRaton;
    }

    public int getBalas() {
        return balas;
    }

    public void setBalas(int balas) {
        this.balas = balas;
    }
   
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public boolean getEstado(){
        return estado;
    }
    
    

}
