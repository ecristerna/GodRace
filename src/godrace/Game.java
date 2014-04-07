/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package godrace;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Ovidio
 */
public class Game extends JFrame implements Runnable, MouseListener, KeyListener {
    private static final long serialVersionUID = 1L;
    //variables
    private boolean pausa;
    private boolean instrucciones;
    private boolean start;
    private boolean gameover;
    
    //Variables control de tiempo de animacion
    private long tiempoActual;
    private long tiempoInicial;
    
        public Game() {
            init();
            start();
        }

        public void init() {
            setSize(1200,720);
            pausa = false;
            instrucciones = false;
            start = false;
            gameover = false;
        }

        /** 
        * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
       * En este metodo se crea e inicializa el hilo
       * para la animacion este metodo es llamado despues del init o 
       * cuando el usuario visita otra pagina y luego regresa a la pagina
       * en donde esta este <code>Applet</code>
       * 
       */
       public void start () {
               // Declaras un hilo
               Thread th = new Thread (this);
               // Empieza el hilo
               th.start ();
       }

       /**
        * Metodo <I>stop</I> sobrescrito de la clase <code>Applet</code>.<P>
        * En este metodo se pueden tomar acciones para cuando se termina
        * de usar el <code>Applet</code>. Usualmente cuando el usuario sale de la pagina
        * en donde esta este <code>Applet</code>.
        */
        public void stop() {

        }

        /**
        * Metodo <I>destroy</I> sobrescrito de la clase <code>Applet</code>.<P>
        * En este metodo se toman las acciones necesarias para cuando
        * el <code>Applet</code> ya no va a ser usado. Usualmente cuando el usuario
        * cierra el navegador.
        */
        public void destroy() {

        }
        
        /** 
        * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
        * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se incrementa
        * la posicion en x o y dependiendo de la direccion, finalmente 
        * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
        * 
        */
        public void run () {
            //Guarda el tiempo actual del sistema
            //tiempoActual = System.currentTimeMillis();
            while (true) {
                actualiza();
                checaColision();
                repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.
                try	{
                        // El thread se duerme.
                        Thread.sleep (30);
                }
                catch (InterruptedException ex)	{
                        System.out.println("Error en " + ex.toString());
                }
            }
        }
        
        /**
         * Metodo <I>actualiza</I>
         * Este metodo actualiza a los personajes en el applet en sus movimientos
        */
        public void actualiza() {
            
        }
        
        /**
        * Metodo <I>checaColision</I>
        * Este metodo checa la colision entre los personajes,
        * la colision de los malos con la parte inferior del applet y
        * la  colision del bueno con los extremos del applet
        */
        public void checaColision() {
            
        }
    
        /**
	 * Metodo mouseClicked sobrescrito de la interface MouseListener.
	 * En este metodo maneja el evento que se genera al hacer click con el mouse
	 * sobre algun componente.
	 * e es el evento generado al hacer click con el mouse.
	 */
        public void mouseClicked(MouseEvent e) {
           
        }

        /**
	 * Metodo mousePressed sobrescrito de la interface MouseListener.
	 * En este metodo maneja el evento que se genera al presionar un botÃ³n
	 * del mouse sobre algun componente.
	 * e es el evento generado al presionar un botÃ³n del mouse sobre algun componente.
	 */
        public void mousePressed(MouseEvent e) {
        }

        /**
	 * Metodo mouseReleased sobrescrito de la interface MouseListener.
	 * En este metodo maneja el evento que se genera al soltar un botÃ³n
	 * del mouse sobre algun componente.
	 * e es el evento generado al soltar un botÃ³n del mouse sobre algun componente.
	 */
        public void mouseReleased(MouseEvent e) {
        }

        /**
	 * Metodo mouseEntered sobrescrito de la interface MouseListener.
	 * En este metodo maneja el evento que se genera cuando el mouse
	 * entra en algun componente.
	 * e es el evento generado cuando el mouse entra en algun componente.
	 */
        public void mouseEntered(MouseEvent e) {

        }

        /**
	 * Metodo mouseExited sobrescrito de la interface MouseListener.
	 * En este metodo maneja el evento que se genera cuando el mouse
	 * sale de algun componente.
	 * e es el evento generado cuando el mouse sale de algun componente.
	 */
        public void mouseExited(MouseEvent e) {

        }
        
        /**
	 * Metodo <I>keyPressed</I> sobrescrito de la interface <code>KeyListener</code>.<P>
	 * En este metodo maneja el evento que se genera al presionar cualquier la tecla.
	 * @param e es el <code>evento</code> generado al presionar las teclas.
	 */
	public void keyPressed(KeyEvent e) {
        }   
    
         /**
	 * Metodo <I>keyTyped</I> sobrescrito de la interface <code>KeyListener</code>.<P>
	 * En este metodo maneja el evento que se genera al presionar una tecla que no es de accion.
	 * @param e es el <code>evento</code> que se genera en al presionar las teclas.
	 */
        public void keyTyped(KeyEvent e){
        }
    
        /**
	 * Metodo <I>keyReleased</I> sobrescrito de la interface <code>KeyListener</code>.<P>
	 * En este metodo maneja el evento que se genera al soltar la tecla presionada.
	 * @param e es el <code>evento</code> que se genera en al soltar las teclas.
	 */
        public void keyReleased(KeyEvent e){
        }
}
