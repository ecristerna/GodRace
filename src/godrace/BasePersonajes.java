/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package godrace;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author
 * Eduardo Cristerna Morales
 * Edgar Ovidio Villarreal Treviño
 * Graciela Garcia Diaz
 * Andres Marcelo Garza Cantu
 * 
 */

public class BasePersonajes {
    private int posX;
    private int posY;
    private boolean powerUp;
    protected Animacion anim;
    private SoundClip sonido;

    /**
     * Método constructor de la clase <I>BasePersonajes</I> que inicializa
     * posX y posY con 0
     */
    public BasePersonajes(Image img, SoundClip sonido) {
        this.posX = 0;
        this.posY = 0;
        powerUp = false;
<<<<<<< HEAD
=======
        this.sonido = sonido;
>>>>>>> 422a6d5d49be8c9a06fbde73b81ada72ed2d7bb1
        
        anim = new Animacion();
        anim.sumaCuadro(img, 100);
    }

    /**
     * Método constructor con parámetros de la clase <I>BasePersonajes</I>
     * @param posX es la posición en x del personaje
     * @param posY es la posición en y del personaje del tipo int
     */
    public BasePersonajes(int posX, int posY, Image img, SoundClip sonido) {
        this.posX = posX;
        this.posY = posY;
        powerUp = false;
<<<<<<< HEAD
=======
        this.sonido = sonido;
>>>>>>> 422a6d5d49be8c9a06fbde73b81ada72ed2d7bb1
        
        anim = new Animacion();
        anim.sumaCuadro(img, 100);
    }

    /**
     * Metodo modificador usado para cambiar la posicion en x del objeto 
     * @param x es la <code>posicion en x</code> del objeto.
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Metodo de acceso que regresa la posicion en x del objeto 
     * @return x es la <code>posicion en x</code> del objeto.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Metodo modificador usado para cambiar la posicion en y del objeto 
     * @param y es la <code>posicion en y</code> del objeto.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Metodo de acceso que regresa la posicion en y del objeto 
     * @return y es la <code>posicion en y</code> del objeto.
     */
    public int getPosY() {
        return posY;
    }
    
    /**
     * Metodo modificador usado para cambiar el valor de powerUp del objeto 
     * @param powerUp es el <code>power up</code> del objeto.
     */
    public void setPowerUp(boolean powerUp) {
        this.powerUp = powerUp;
    }
    
    /**
     * Metodo de acceso que regresa si tiene power up el objeto 
     * @return powerUp es el <code>power up</code> del objeto.
     */
    public boolean getPowerUp() {
        return powerUp;
    }
    
    /**
     * Metodo modificador para actualizar la posicion en x del objeto
     * @param avance es el <code>avance</code> del objeto.
     */
    public void actualizaPosX(int avance) {
        this.posX+=avance;
    }
    
    /**
     * Metodo modificador para actualizar la posicion en y del objeto
     * @param avance es el <code>avance</code> del objeto.
     */
    public void actualizaPosY(int avance) {
        this.posY+=avance;
    }
    
    /**
     * Metodo modificador para actualizar el powerUp del objeto
     */
    public void actualizaPowerUp() {
        this.powerUp = !this.powerUp;
    }
    
    /**
     * Metodo de acceso que regresa el ancho del icono 
     * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
     */
    public int getAncho() {
        return (new ImageIcon(anim.getImagen())).getIconWidth();
    }
    
    /**
     * Metodo de acceso que regresa el alto del icono 
     * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
     */
    public int getAlto() {
        return (new ImageIcon(anim.getImagen())).getIconHeight();
    }
    
    /**
     * Metodo de acceso que regresa la imagen del icono 
     * @return un objeto de la clase <code>Image</code> que es la imagen del icono.
     */
    public Image getImagenI() {
        return (new ImageIcon(anim.getImagen())).getImage();
    }
    
    /**
     * Metodo de acceso que regresa un nuevo rectangulo
     * @return un objeto de la clase <code>Rectangle</code> que es el perimetro 
     * del rectangulo
     */
    public Rectangle getPerimetro(){
        return new Rectangle(getPosX(),getPosY(),getAncho(),getAlto());
    }
    
    /**
     * Checa si el objeto <code>Animal</code> intersecta a otro <code>Animal</code>
     * @return un valor boleano <code>true</code> si lo intersecta <code>false</code>
     * en caso contrario
     */
    public boolean intersecta(BasePersonajes obj){
        return getPerimetro().intersects(obj.getPerimetro());
    }
    
    /**
     * Metodo de acceso que regresa el sonido del objeto 
     * @return un objeto de la clase <code>SoundClip</code> que es el sonido del objeto.
     */
    public SoundClip getSonido() {
        return sonido;
    }
            
    /**
     * Metodo de actualizacion de imagen de los sprites
     * @param tiempo 
     */
    public void actualiza(long tiempo) {
        anim.actualiza(tiempo);
    }
}