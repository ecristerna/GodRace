/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package godrace;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author
 * Eduardo Cristerna Morales
 * Edgar Ovidio Villarreal Treviño
 * Graciela Garcia Diaz
 * Andres Marcelo Garza Cantu
 * 
 */

public class Game extends JFrame implements Runnable, MouseListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private final static int EXTREMO_SUPERIOR = 35;
    private final static int JUNGLE_IZQUIERDO = 295;
    private final static int JUNGLE_DERECHO = 890;
    //variables
    private boolean izquierda;
    private boolean izquierda2;
    private boolean derecha;
    private boolean derecha2;
    private boolean arriba;
    private boolean arriba2;
    private boolean abajo;
    private boolean abajo2;
    private boolean pausa;
    private boolean instrucciones;
    private boolean start;
    private boolean gameover;
    private boolean pausaCharSelect;
    private boolean pausaMapSelect;
    private boolean rainbow;
    private boolean jungle;
    private Graphics dbg;
    private Image dbImage;
    private Image startScreen;
    private Image instructionScreen;
    private Image characterSelect;
    private Image mapSelect;
    private Image RainbowRoad;
    private Image Jungle;
    private Image creditScreen;
    private BasePersonajes P1;
    private BasePersonajes P2;
    
    //Variables control de tiempo de animacion
    private long tiempoActual;
    private long tiempoInicial;
    
        public Game() {
            init();
            start();
        }

        public void init() {
            setSize(1200,720);
            //variables booleanas de movimiento de personajes
            izquierda = false;
            izquierda2 = false;
            derecha = false;
            derecha2 = false;
            arriba = false;
            arriba2 = false;
            abajo = false;
            abajo2 = false;
            
            pausa = false;
            instrucciones = false;
            start = false;
            pausaCharSelect = false;
            pausaMapSelect = false;
            rainbow = false;
            jungle = false;
            gameover = false;
            
            // Imágenes de fondo, menús, créditos, etc.
            startScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_TitleScreen.png"));
            instructionScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Instructions.png"));
            characterSelect = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_CharacterSelect.png"));
            mapSelect = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MapSelect.png"));
            RainbowRoad = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map2_RainbowRoadGIF.gif"));
            Jungle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map1_JungleGIF.gif"));
            creditScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/CREDITS.png"));
            
            // Imagenes de personajes
            Image dragon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Character_DragonGIF.gif"));
            Image zeus = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Character_ZeusGIF.gif"));
            
            // Sonidos de los personajes
            
            
            // Inicialización de personajes
            P1 = new BasePersonajes(dragon);
            P2 = new BasePersonajes(zeus);
            P1.setPosX(getWidth()/4); 
            P2.setPosX(2*getWidth()/4+150);
            P1.setPosY(getHeight()-P1.getAlto());
            P2.setPosY(getHeight()-P2.getAlto());
            
            addKeyListener(this);
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
            tiempoActual = System.currentTimeMillis();
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
            // Verifica que no esté en pausa y que esté en el escenario de juego
            if (!pausa && (rainbow || jungle)) {
                // Actualiza la posición dependiendo de la tecla que se esté oprimiendo
                if (izquierda) {
                    P1.actualizaPosX(-5);
                }
                if (derecha) {
                    P1.actualizaPosX(5);
                }
                if (arriba) {    
                    P1.actualizaPosY(-5);
                }
                if (abajo) {
                    P1.actualizaPosY(5);
                }
                if (izquierda2) {
                    P2.actualizaPosX(-5);
                }
                if (derecha2) {
                    P2.actualizaPosX(5);
                }
                if (arriba2) {
                    P2.actualizaPosY(-5);
                }
                if (abajo2) {
                    P2.actualizaPosY(5);
                }
            }
        }
        
        /**
        * Metodo <I>checaColision</I>
        * Este metodo checa la colision entre los personajes,
        * la colision de los malos con la parte inferior del applet y
        * la  colision del bueno con los extremos del applet
        */
        public void checaColision() {
            // Verifica que no esté en pausa y esté en el escenario de juego
            if (!pausa) {
                if (P1.getPosY() < EXTREMO_SUPERIOR) {
                    P1.setPosY(35);
                }
                if (P1.getPosY() + P1.getAlto() > getHeight()) {
                    P1.setPosY(getHeight() - P1.getAlto());
                }
                if (P2.getPosY() < EXTREMO_SUPERIOR) {
                    P2.setPosY(35);
                }
                if (P2.getPosY() + P2.getAlto() > getHeight()) {
                    P2.setPosY(getHeight() - P2.getAlto());
                }    
                if (rainbow) {
                    // Verifica que el personaje 1 no choque con el frame
                    if (P1.getPosX() < 260) {
                        P1.setPosX(270);
                    }
                    if (P1.getPosX() > 800) {
                        P1.setPosX(790);
                    }
                    // Verifica que el personaje 2 no choque con el frame
                    if (P2.getPosX() < 260) {
                        P2.setPosX(270);
                    }
                    if (P2.getPosX() > 800) {
                        P2.setPosX(790);
                    }
                }
                if (jungle) {
                    // Verifica que el personaje 1 no choque con el frame                   
                    if (P1.getPosX() < JUNGLE_IZQUIERDO) {
                        P1.setPosX(305);
                    }
                    if (P1.getPosX() > JUNGLE_DERECHO) {
                        P1.setPosX(880);
                    }
                    // Verifica que el personaje 2 no choque con el frame
                    if (P2.getPosX() < JUNGLE_IZQUIERDO) {
                        P2.setPosX(305);
                    }
                    if (P2.getPosX() > JUNGLE_DERECHO) {
                        P2.setPosX(880);
                    }
                }
                
                // Colision entre personajes
                if (P1.intersecta(P2) || P2.intersecta(P1)) {
                    if (derecha || izquierda2) {
                        P1.actualizaPosX(-20);
                        P2.actualizaPosX(20);
                    } else if (derecha2 || izquierda) {
                        P1.actualizaPosX(20);
                        P2.actualizaPosX(-20);
                    } else if (arriba || abajo2) {
                        P1.actualizaPosY(20);
                        P2.actualizaPosY(-20);
                    } else if (abajo || arriba2) {
                        P1.actualizaPosY(-20);
                        P2.actualizaPosY(20);
                    }
                }
            }
        }
        
        /**
	 * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>,
	 * heredado de la clase Container.<P>
	 * En este metodo se dibuja la imagen con la posicion actualizada,
	 * ademas que cuando la imagen es cargada te despliega una advertencia.
	 * @param g es el <code>objeto grafico</code> usado para dibujar.
	 */
        public void paint(Graphics g) {
                //Inicializa el DoubleBuffer
                if (dbImage == null) {
                    dbImage = createImage(this.getSize().width, this.getSize().height);
                    dbg = dbImage.getGraphics();
                }
                //Actualiza la imagen de fondo
                dbg.setColor(getBackground());
                dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
                //Actualiza el Foreground
                dbg.setColor(getForeground());
                paint1(dbg);
                //Dibuja la imagen actualizada
                g.drawImage(dbImage, 0, 0, this);
        }
        
        /**
         * El método <I>paint1</I> muestra en pantalla la animación
         *
         * @param g es la imágen a proyectar
        */
        public void paint1(Graphics g) {
            // Verifica que no esté pausado el juego
            if (!pausa) {
                // Dibuja la pantalla de inicio
                if (!start) {
                    g.drawImage(startScreen, 0, 0, this);
                }
                // Dibuja la pantalla de instrucciones
                if (!start && instrucciones) {
                    g.drawImage(instructionScreen, 0, 0, this);
                }
                // Dibuja la pantalla de selección de personajes
                if (start && !pausaCharSelect) {
                    g.drawImage(characterSelect, 0, 0, this);
                }
                // Dibuja la pantalla de selección de pista
                if (start && pausaCharSelect && !pausaMapSelect) {
                    g.drawImage(mapSelect, 0, 0, this);
                }
                // Dibuja el escenario de juego con sus personajes
                if (start && pausaCharSelect && pausaMapSelect && jungle) {
                    g.drawImage(Jungle, 0, 0, this);
                    g.drawImage(P1.getImagenI(), P1.getPosX(), P1.getPosY(), this);
                    g.drawImage(P2.getImagenI(), P2.getPosX(), P2.getPosY(), this);
                }
                // Dibuja el escenario de juego con sus personajes
                if (start && pausaCharSelect && pausaMapSelect && rainbow) {
                    g.drawImage(RainbowRoad, 0, 0, this);
                    g.drawImage(P1.getImagenI(), P1.getPosX(), P1.getPosY(), this);
                    g.drawImage(P2.getImagenI(), P2.getPosX(), P2.getPosY(), this);
                }
                // Dibuja la pantalla de créditos
                if (gameover) {
                    g.drawImage(creditScreen, 0, 0, this);
                }
            }
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
            // Verifica la tecla enter para cambiar de pantallas, dependiendo
            // de la pantalla actual en la que se esté
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                
                if (start && pausaCharSelect && pausaMapSelect && rainbow) {
                    rainbow = false;
                    gameover = true;
                }
                
                if (start && pausaCharSelect && pausaMapSelect && jungle) {
                    jungle = false;
                    rainbow = true;
                    //gameover = true;
                }
                
                if (start && pausaCharSelect && !pausaMapSelect) {
                    pausaMapSelect = true;
                    jungle = true;
                }
                
                if (start && !pausaCharSelect) {
                    pausaCharSelect = true;
                }
                
                if (!start) {
                    start = true;
                }
            }
            
            // Verifica la tecla I para mostrar las instrucciones mientras se esté
            // en la pantalla de inicio
            if (e.getKeyCode() == KeyEvent.VK_I) {
                
                if (!start) {
                    instrucciones = !instrucciones;
                }
            }
            // Verifica la tecla de pausa
            if (e.getKeyCode() == KeyEvent.VK_P) {
                pausa = !pausa;
            }
            
            // Verifica las teclas de movimiento para los personajes
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                izquierda2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                derecha2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                arriba2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                abajo2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_A) {
                izquierda = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_D) {
                derecha = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_W) {
                arriba = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_S) {
                abajo = true;
            }
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
        public void keyReleased(KeyEvent e) {
            // Verifica que la tecla se haya soltado para dejar de mover el personaje
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                izquierda2 = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                derecha2 = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                arriba2 = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                abajo2 = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_A) {
                izquierda = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_D) {
                derecha = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_W) {
                arriba = false;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_S) {
                abajo = false;
            }
        }
}
