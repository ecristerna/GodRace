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
 * @author Ovidio
 */
public class BasePersonajes {
    private int posX;
    private int posY;

    protected Animacion anim;

    public BasePersonajes() {
        this.posX = 0;
        this.posY = 0;
        
        Image zeus = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Zeus.jpg"));
        anim = new Animacion();
        anim.sumaCuadro(zeus, 100);
    }

    public BasePersonajes(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
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
        *
        * @return un valor boleano <code>true</code> si lo intersecta <code>false</code>
        * en caso contrario
        */
       public boolean intersecta(BasePersonajes obj){
               return getPerimetro().intersects(obj.getPerimetro());
       }

       /**
        * Metodo de actualizacion de imagen de los sprites
        * @param tiempo 
        */
       public void actualiza(long tiempo) {
           anim.actualiza(tiempo);
       }
}