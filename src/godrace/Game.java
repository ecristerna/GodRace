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
import java.util.LinkedList;
import java.util.Random;
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

public class Game extends JFrame implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;
    private final static int velocidadPersonajes = 8;
    private final static int EXTREMO_SUPERIOR = 35;
    private final static int JUNGLE_IZQUIERDO = 295;
    private final static int JUNGLE_DERECHO = 890;
    private final static int DESERT_IZQUIERDO = 325;
    private final static int DESERT_DERECHO = 770;
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
    private boolean p1Select;
    private boolean p2Select;
    private boolean instrucciones;
    private boolean start;
    private boolean gameover;
    private boolean pausaCharSelect;
    private boolean pausaMapSelect;
    private boolean desert;
    private boolean jungle;
    private boolean underworld;
    private int opcionMenu;
    private int opcionP1;
    private int opcionP2;
    private int vidaP1;
    private int vidaP2;
    private int extremoDerecho;
    private int extremoIzquierdo;
    private Graphics dbg;
    private Image dbImage;
    private Image startScreen;
    private Image instructionScreen;
    private Image characterSelect;
    private Image mapSelect;
    private Image Desert;
    private Image Jungle;
    private Image Underworld;
    private Image creditScreen;
    private Image cursorMenuInicialImg;
    private Image cursorP1Img;
    private Image cursorP2Img;
    private Image cursorPSelImg;
    private Image cursorMapaImg;
    private SoundClip sonido_menu;
    private SoundClip sonido_jungle;
    private SoundClip sonido_desierto;
    private SoundClip sonido_underworld;
    private Obstaculos cursorMenu;
    private Obstaculos cursorP1;
    private Obstaculos cursorP2;
    private Obstaculos cursorMapa;
    private Obstaculos obstaculo;
    private BasePersonajes P1;
    private BasePersonajes P2;
    private LinkedList<Obstaculos> obstaclesLeft;
    private LinkedList<Obstaculos> obstaclesRight;
    
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
            desert = false;
            jungle = false;
            underworld = false;
            gameover = false;
            
            p1Select = false;
            p2Select = false;
            
            // Imágenes de fondo, menús, créditos, etc.
            startScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_TitleScreen.png"));
            instructionScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Instructions.png"));
            characterSelect = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_CharacterSelect2.png"));
            mapSelect = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MapSelect_1.png"));
            Desert = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map1_DesertGIF.gif"));
            Jungle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map1_JungleGIF.gif"));
            Underworld = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map2_UnderworldGIF.gif"));
            creditScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/CREDITS.png"));
            
            // Imagenes de cursores de seleccion
            cursorMenuInicialImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Coin.gif"));
            cursorP1Img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Bioforge_MarcoP1.gif"));
            cursorP2Img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Bioforge_MarcoP2.gif"));
            cursorPSelImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Bioforge_MarcoSELECT.gif"));
            cursorMapaImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Bioforge_MarcoMP1.gif"));
            
            // Sonidos de background
            sonido_menu = new SoundClip("/sounds/Athenian_Rooftop.wav");
            sonido_jungle = new SoundClip("/sounds/Deep_Jungle.wav");
            sonido_desierto = new SoundClip("/sounds/Day_Agrabah.wav");
            sonido_underworld = new SoundClip("/sounds/Hades_Underworld.wav");
            sonido_menu.setLooping(true);
            sonido_menu.play();
            
            // Imagenes de personajes
            Image dragon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Character_DragonGIF.gif"));
            Image zeus = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Character_ZeusGIF.gif"));
            
            // Sonidos de los personajes
            SoundClip sonido_dragon = new SoundClip ("/sounds/bounce.wav");
            SoundClip sonido_zeus = new SoundClip ("/sounds/twink.wav");
            
            // Inicializa Cursores
            opcionMenu = 0;
            opcionP1 = 0;
            opcionP2 = 1;
            cursorMenu = new Obstaculos(cursorMenuInicialImg);
            cursorP1 = new Obstaculos(cursorP1Img);
            cursorP2 = new Obstaculos(cursorP2Img);
            cursorMapa = new Obstaculos(cursorMapaImg);
            
            // Inicializacion de obstaculos
            obstaculo = new Obstaculos();
            obstaclesLeft = new<Obstaculos> LinkedList();
            obstaclesRight = new<Obstaculos> LinkedList();
            inicializaObstaculos();
            
            // Inicialización de personajes
            vidaP1 = 100;
            vidaP2 = 100;
            P1 = new BasePersonajes(zeus, sonido_zeus);
            P2 = new BasePersonajes(dragon, sonido_dragon);
            P1.setPosX(getWidth()/4 + 100); 
            P2.setPosX(2*getWidth()/4 + 100);
            P1.setPosY(getHeight()-P1.getAlto());
            P2.setPosY(getHeight()-P2.getAlto());
            
            addKeyListener(this);
        }
        
        public void creaObstaculo(int n) {
            //Image power = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Coin.gif"));
            Image obstaculo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Fire-bar.gif"));
            Image obstaculo2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/SpinyEgg.gif"));
            Image obstaculo3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/cloud_plat.gif"));
            
            Obstaculos ob = new Obstaculos();
            
            Random randObstaculo = new Random();
            Random randPosicionX = new Random();
            Random randPosicionY = new Random();
            switch (randObstaculo.nextInt(3)) {
                case 0:
                    ob.setImagenI(obstaculo1);
                break;
                case 1:
                    ob.setImagenI(obstaculo2);
                break;
                case 2:
                    ob.setImagenI(obstaculo3);
                break;
            }
            
            switch (n) {
                case 0:
                    ob.setPosX(randPosicionX.nextInt((int)((extremoDerecho - extremoIzquierdo)/2) - ob.getAncho()) + extremoIzquierdo);
                    ob.setPosY(obstaclesLeft.getLast().getPosY() - randPosicionY.nextInt(100) - 200);
                    obstaclesLeft.add(ob);
                break;
                case 1:
                    ob.setPosX(extremoDerecho - randPosicionX.nextInt((int)((extremoDerecho - extremoIzquierdo)/2)));
                    ob.setPosY(obstaclesRight.getLast().getPosY() - randPosicionY.nextInt(100) - 200);
                    obstaclesRight.add(ob);
                break;
            }
        }
        
        public void inicializaObstaculos() {
            // Imagenes los obstaculos
            //Image power = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Coin.gif"));
            Image obstaculo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Fire-bar.gif"));
            Image obstaculo2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/SpinyEgg.gif"));
            Image obstaculo3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/cloud_plat.gif"));
            
            Random randObstaculo = new Random();
            switch (randObstaculo.nextInt(3)) {
                case 0:
                    obstaculo.setImagenI(obstaculo1);
                break;
                case 1:
                    obstaculo.setImagenI(obstaculo2);
                break;
                case 2:
                    obstaculo.setImagenI(obstaculo3);
                break;
            }
            
            obstaculo.setPosX(getWidth()/2 - 100);
            obstaculo.setPosY(-100);
            obstaclesLeft.add(obstaculo);
            obstaculo.setPosX(getWidth() + 100);
            obstaculo.setPosY(-100);
            obstaclesRight.add(obstaculo);
            
            extremoIzquierdo = JUNGLE_IZQUIERDO;
            extremoDerecho = JUNGLE_DERECHO;
            for (int i = 1; i < 10; i++) {
                creaObstaculo(0);
                creaObstaculo(1);
            }   
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
                        Thread.sleep (20);
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
            // Verifica que se este en el menu principal
            if (!start) {
                switch (opcionMenu) {
                    case 0:
                        cursorMenu.setPosX(720);
                        cursorMenu.setPosY(400);
                    break;
                    case 1:
                        cursorMenu.setPosX(580);
                        cursorMenu.setPosY(505);
                    break;
                    case 2:
                        cursorMenu.setPosX(550);
                        cursorMenu.setPosY(615);
                    break;
                }
            } else if (!pausaCharSelect) {
                if (!p1Select) {
                switch (opcionP1) {
                    case 0:
                        cursorP1.setPosX(97);
                        cursorP1.setPosY(194);
                    break;
                    case 1:
                        cursorP1.setPosX(365);
                        cursorP1.setPosY(194);
                    break;
                    case 2:
                        cursorP1.setPosX(636);
                        cursorP1.setPosY(194);
                    break;
                    case 3:
                        cursorP1.setPosX(908);
                        cursorP1.setPosY(194);
                    break;
                    case 4:
                        cursorP1.setPosX(98);
                        cursorP1.setPosY(431);
                    break;
                    case 5:
                        cursorP1.setPosX(367);
                        cursorP1.setPosY(431);
                    break;
                    case 6:
                        cursorP1.setPosX(636);
                        cursorP1.setPosY(431);
                    break;
                    case 7:
                        cursorP1.setPosX(908);
                        cursorP1.setPosY(431);
                    break;
                }
                }
                if (!p2Select) {
                switch (opcionP2) {
                    case 0:
                        cursorP2.setPosX(97);
                        cursorP2.setPosY(194);
                    break;
                    case 1:
                        cursorP2.setPosX(365);
                        cursorP2.setPosY(194);
                    break;
                    case 2:
                        cursorP2.setPosX(636);
                        cursorP2.setPosY(194);
                    break;
                    case 3:
                        cursorP2.setPosX(908);
                        cursorP2.setPosY(194);
                    break;
                    case 4:
                        cursorP2.setPosX(98);
                        cursorP2.setPosY(431);
                    break;
                    case 5:
                        cursorP2.setPosX(367);
                        cursorP2.setPosY(431);
                    break;
                    case 6:
                        cursorP2.setPosX(636);
                        cursorP2.setPosY(431);
                    break;
                    case 7:
                        cursorP2.setPosX(908);
                        cursorP2.setPosY(431);
                    break;
                }
                }
                if (p1Select && p2Select) {
                    // mandar a crear los objetos de personaje
                    pausaCharSelect = true;
                }
            } else if (!pausaMapSelect) {
                switch (opcionMenu) {
                    case 0:
                        cursorMapa.setPosX(47);
                        cursorMapa.setPosY(203);
                    break;
                    case 1:
                        cursorMapa.setPosX(635);
                        cursorMapa.setPosY(203);
                    break;
                    case 2:
                        cursorMapa.setPosX(47);
                        cursorMapa.setPosY(425);
                    break;
                    case 3:
                        cursorMapa.setPosX(635);
                        cursorMapa.setPosY(425);
                    break;
                }
            }

            // Verifica que no esté en pausa y que esté en el escenario de juego
            if (!pausa && !gameover && (desert || jungle || underworld)) {
                // Actualiza la posición de los personajes dependiendo de la tecla que se esté oprimiendo
                if (izquierda) {
                    P1.actualizaPosX(-velocidadPersonajes);
                }
                if (derecha) {
                    P1.actualizaPosX(velocidadPersonajes);
                }
                if (arriba) {    
                    P1.actualizaPosY(-velocidadPersonajes);
                }
                if (abajo) {
                    P1.actualizaPosY(velocidadPersonajes);
                }
                if (izquierda2) {
                    P2.actualizaPosX(-velocidadPersonajes);
                }
                if (derecha2) {
                    P2.actualizaPosX(velocidadPersonajes);
                }
                if (arriba2) {
                    P2.actualizaPosY(-velocidadPersonajes);
                }
                if (abajo2) {
                    P2.actualizaPosY(velocidadPersonajes);
                }
                
                // Actualiza obstaculos
                for (int i = 0; i < obstaclesLeft.size(); i++)
                    obstaclesLeft.get(i).actualizaPosY(5);
                for (int i = 0; i < obstaclesRight.size(); i++)
                   obstaclesRight.get(i).actualizaPosY(5);
                
                // Checa que la vida de los personajes se acabe
                if (vidaP1 <= 0) {
                    gameover = true;
                }
                if (vidaP2 <= 0) {
                    gameover = true;
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
                // Colision de los personajes con los extremos superiores e inferiores del frame
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
                
                // Intersecciones de los obstaculos con los personajes y con la parte inferior  del frame
                for (int i = 0; i < obstaclesLeft.size(); i++) {
                    if (obstaclesLeft.get(i).getPosY() > getHeight()) {
                        obstaclesLeft.removeFirst();
                        creaObstaculo(0);
                    }
                    if (obstaclesLeft.get(i).intersecta(P1)) {
                        obstaclesLeft.remove(i);
                        creaObstaculo(0);
                        vidaP1--;
                    }
                    if (obstaclesLeft.get(i).intersecta(P2)) {
                        obstaclesLeft.remove(i);
                        creaObstaculo(0);
                        vidaP2--;
                    }
                }
                for (int i = 0; i < obstaclesRight.size(); i++) {
                    if (obstaclesRight.get(i).getPosY() > getHeight()) {
                        obstaclesRight.removeFirst();
                        creaObstaculo(1);
                    }
                    if (obstaclesRight.get(i).intersecta(P1)) {
                        obstaclesRight.remove(i);
                        creaObstaculo(1);
                        vidaP1-=10;
                    }
                    if (obstaclesRight.get(i).intersecta(P2)) {
                        obstaclesRight.remove(i);
                        creaObstaculo(1);
                        vidaP2-=10;
                    }
                }
                
                if (desert) {
                    // Verifica que el personaje 1 no choque con el frame
                    if (P1.getPosX() < DESERT_IZQUIERDO) {
                        P1.setPosX(DESERT_IZQUIERDO + 10);
                    }
                    if (P1.getPosX() > DESERT_DERECHO) {
                        P1.setPosX(DESERT_DERECHO - 10);
                    }
                    // Verifica que el personaje 2 no choque con el frame
                    if (P2.getPosX() < DESERT_IZQUIERDO) {
                        P2.setPosX(DESERT_IZQUIERDO + 10);
                    }
                    if (P2.getPosX() > DESERT_DERECHO) {
                        P2.setPosX(DESERT_DERECHO - 10);
                    }
                }
                if (jungle) {
                    // Verifica que el personaje 1 no choque con el frame                   
                    if (P1.getPosX() < JUNGLE_IZQUIERDO) {
                        P1.setPosX(JUNGLE_IZQUIERDO + 10);
                    }
                    if (P1.getPosX() > JUNGLE_DERECHO) {
                        P1.setPosX(JUNGLE_DERECHO - 10);
                    }
                    // Verifica que el personaje 2 no choque con el frame
                    if (P2.getPosX() < JUNGLE_IZQUIERDO) {
                        P2.setPosX(JUNGLE_IZQUIERDO + 10);
                    }
                    if (P2.getPosX() > JUNGLE_DERECHO) {
                        P2.setPosX(JUNGLE_DERECHO - 10);
                    }
                }
                
                // Colision entre personajes
                if (P1.intersecta(P2) || P2.intersecta(P1)) {
                    if (derecha || izquierda2) {
                        P1.actualizaPosX(-24);
                        P2.actualizaPosX(24);
                    } else if (derecha2 || izquierda) {
                        P1.actualizaPosX(24);
                        P2.actualizaPosX(-24);
                    } else if (arriba || abajo2) {
                        P1.actualizaPosY(24);
                        P2.actualizaPosY(-24);
                    } else if (abajo || arriba2) {
                        P1.actualizaPosY(-24);
                        P2.actualizaPosY(24);
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
                    // Dibuja la pantalla de instrucciones
                    if (instrucciones) {
                        g.drawImage(instructionScreen, 0, 0, this);
                    }
                    g.drawImage(startScreen, 0, 0, this);
                    g.drawImage(cursorMenu.getImagenI(), cursorMenu.getPosX(), cursorMenu.getPosY(), this);
                } else if (!pausaCharSelect) {
                    // Dibuja la pantalla de selección de personajes
                    g.drawImage(characterSelect, 0, 0, this);
                    g.drawImage(cursorP1.getImagenI(), cursorP1.getPosX(), cursorP1.getPosY(), this);
                    g.drawImage(cursorP2.getImagenI(), cursorP2.getPosX(), cursorP2.getPosY(), this);
                } else if (!pausaMapSelect) {
                    // Dibuja la pantalla de selección de pista
                    g.drawImage(mapSelect, 0, 0, this);
                    g.drawImage(cursorMapa.getImagenI(), cursorMapa.getPosX(), cursorMapa.getPosY(), this);
                } else {
                    switch (opcionMenu) {
                        case 0:
                            g.drawImage(Jungle, 0, 0, this);
                        break;
                        case 1:
                            g.drawImage(Desert, 0, 0, this);
                        break;
                        case 2:
                            g.drawImage(Underworld, 0, 0, this);
                        break;
                        case 3:
                            g.drawImage(Underworld, 0, 0, this);
                        break;
                    }
                    g.drawImage(P1.getImagenI(), P1.getPosX(), P1.getPosY(), this);
                    g.drawImage(P2.getImagenI(), P2.getPosX(), P2.getPosY(), this);
                }
                // Dibuja los obstaculos
                for (int i = 0; i < obstaclesLeft.size(); i++)
                    g.drawImage(obstaclesLeft.get(i).getImagenI(), obstaclesLeft.get(i).getPosX(), obstaclesLeft.get(i).getPosY(), this);
                for (int i = 0; i < obstaclesRight.size(); i++)
                    g.drawImage(obstaclesRight.get(i).getImagenI(), obstaclesRight.get(i).getPosX(), obstaclesRight.get(i).getPosY(), this);
                
                // Dibuja la pantalla de créditos
                if (gameover) {
                    g.drawImage(creditScreen, 0, 0, this);
                }
            }
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
                
                /*if (start && pausaCharSelect && pausaMapSelect && underworld) {
                    underworld = false;
                    sonido_underworld.stop();
                    gameover = true;
                }
                if (start && pausaCharSelect && pausaMapSelect && desert) {
                    desert = false;
                    sonido_desierto.stop();
                    sonido_underworld.setLooping(true);
                    sonido_underworld.play();
                    underworld = true;
                }
                if (start && pausaCharSelect && pausaMapSelect && jungle) {
                    jungle = false;
                    desert = true;
                    sonido_jungle.stop();
                    sonido_desierto.setLooping(true);
                    sonido_desierto.play();
                }
                if (start && pausaCharSelect && !pausaMapSelect) {
                    pausaMapSelect = true;
                    sonido_menu.stop();
                    jungle = true;
                    sonido_jungle.setLooping(true);
                    sonido_jungle.play();
                }
                if (start && !pausaCharSelect) {
                    pausaCharSelect = true;
                } */
                if (!start) {
                    if (instrucciones)
                        instrucciones = false;
                    else {
                        switch (opcionMenu) {
                            case 0:
                                start = true;
                                opcionMenu = 0;
                            break;
                            case 1:
                                opcionMenu = 0;
                            break;
                            case 2:
                                instrucciones = true;
                            break;
                        }
                    }
                } else if(pausaCharSelect && !pausaMapSelect) {
                    pausaMapSelect = true;
                    sonido_menu.stop();
                    switch (opcionMenu) {
                        case 0:
                            jungle = true;
                            sonido_jungle.setLooping(true);
                            sonido_jungle.play();
                        break;
                        case 1:
                            desert = true;
                            sonido_desierto.setLooping(true);
                            sonido_desierto.play();
                        break;
                        case 2:
                            underworld = true;
                            sonido_underworld.setLooping(true);
                            sonido_underworld.play();
                        break;
                        case 3:
                            underworld = true;
                            sonido_underworld.setLooping(true);
                            sonido_underworld.play();
                        break;
                    }
                }
            }
            
            // Verifica la tecla de pausa
            if (e.getKeyCode() == KeyEvent.VK_P) {
                pausa = !pausa;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_F) {
                if (!pausaCharSelect) {
                    p1Select = true;
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_G) {
                
            }
            
            if (e.getKeyCode() == KeyEvent.VK_N) {
                if (!pausaCharSelect) {
                    p2Select = true;
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_M) {
                
            }
            
            // Verifica las teclas de movimiento para los personajes
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!pausaCharSelect) {
                    switch(opcionP2) {
                        case 0:
                            if (opcionP1 == 3) {
                                opcionP2 = 2;
                            } else {
                                opcionP2 = 3;
                            }
                        break;
                        case 1:
                            if (opcionP1 == 0) {
                                opcionP2 = 3;
                            } else {
                                opcionP2 = 0;
                            }
                        break;
                        case 2:
                            if (opcionP1 == 1) {
                                opcionP2 = 0;
                            } else {
                                opcionP2 = 1;
                            }
                        break;
                        case 3:
                            if (opcionP1 == 2) {
                                opcionP2 = 1;
                            } else {
                                opcionP2 = 2;
                            }
                        break;
                        case 4:
                            if (opcionP1 == 7) {
                                opcionP2 = 6;
                            } else {
                                opcionP2 = 7;
                            }
                        break;
                        case 5:
                            if (opcionP1 == 4) {
                                opcionP2 = 7;
                            } else {
                                opcionP2 = 4;
                            }
                        break;
                        case 6:
                            if (opcionP1 == 5) {
                                opcionP2 = 4;
                            } else {
                                opcionP2 = 5;
                            }
                        break;
                        case 7:
                            if (opcionP1 == 6) {
                                opcionP2 = 5;
                            } else {
                                opcionP2 = 6;
                            }
                        break;
                    }
                }
                izquierda2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (!pausaCharSelect) {
                    switch(opcionP2) {
                        case 0:
                            if (opcionP1 == 1) {
                                opcionP2 = 2;
                            } else {
                                opcionP2 = 1;
                            }
                        break;
                        case 1:
                            if (opcionP1 == 2) {
                                opcionP2 = 3;
                            } else {
                                opcionP2 = 2;
                            }
                        break;
                        case 2:
                            if (opcionP1 == 3) {
                                opcionP2 = 0;
                            } else {
                                opcionP2 = 3;
                            }
                        break;
                        case 3:
                            if (opcionP1 == 0) {
                                opcionP2 = 1;
                            } else {
                                opcionP2 = 0;
                            }
                        break;
                        case 4:
                            if (opcionP1 == 5) {
                                opcionP2 = 6;
                            } else {
                                opcionP2 = 5;
                            }
                        break;
                        case 5:
                            if (opcionP1 == 6) {
                                opcionP2 = 7;
                            } else {
                                opcionP2 = 6;
                            }
                        break;
                        case 6:
                            if (opcionP1 == 7) {
                                opcionP2 = 4;
                            } else {
                                opcionP2 = 7;
                            }
                        break;
                        case 7:
                            if (opcionP1 == 4) {
                                opcionP2 = 5;
                            } else {
                                opcionP2 = 4;
                            }
                        break;
                    }
                }
                derecha2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (!pausaCharSelect) {
                    switch(opcionP2) {
                        case 0:
                            if (opcionP1 != 4) {
                                opcionP2 = 4;
                            }
                        break;
                        case 1:
                            if (opcionP1 != 5) {
                                opcionP2 = 5;
                            }
                        break;
                        case 2:
                            if (opcionP1 != 6) {
                                opcionP2 = 6;
                            }
                        break;
                        case 3:
                            if (opcionP1 != 7) {
                                opcionP2 = 7;
                            }
                        break;
                        case 4:
                            if (opcionP1 != 0) {
                                opcionP2 = 0;
                            }
                        break;
                        case 5:
                            if (opcionP1 != 1) {
                                opcionP2 = 1;
                            }
                        break;
                        case 6:
                            if (opcionP1 != 2) {
                                opcionP2 = 2;
                            }
                        break;
                        case 7:
                            if (opcionP1 != 3) {
                                opcionP2 = 3;
                            }
                        break;
                    }
                }
                arriba2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (!pausaCharSelect) {
                    switch(opcionP2) {
                        case 0:
                            if (opcionP1 != 4) {
                                opcionP2 = 4;
                            }
                        break;
                        case 1:
                            if (opcionP1 != 5) {
                                opcionP2 = 5;
                            }
                        break;
                        case 2:
                            if (opcionP1 != 6) {
                                opcionP2 = 6;
                            }
                        break;
                        case 3:
                            if (opcionP1 != 7) {
                                opcionP2 = 7;
                            }
                        break;
                        case 4:
                            if (opcionP1 != 0) {
                                opcionP2 = 0;
                            }
                        break;
                        case 5:
                            if (opcionP1 != 1) {
                                opcionP2 = 1;
                            }
                        break;
                        case 6:
                            if (opcionP1 != 2) {
                                opcionP2 = 2;
                            }
                        break;
                        case 7:
                            if (opcionP1 != 3) {
                                opcionP2 = 3;
                            }
                        break;
                    }
                }
                abajo2 = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_A) {
                if (!pausaCharSelect) {
                    switch (opcionP1) {
                        case 0:
                            if (opcionP2 == 3) {
                                opcionP1 = 2;
                            } else {
                                opcionP1 = 3;
                            }
                        break;
                        case 1:
                            if (opcionP2 == 0) {
                                opcionP1 = 3;
                            } else {
                                opcionP1 = 0;
                            }
                        break;
                        case 2:
                            if (opcionP2 == 1) {
                                opcionP1 = 0;
                            } else {
                                opcionP1 = 1;
                            }
                        break;
                        case 3:
                            if (opcionP2 == 2) {
                                opcionP1 = 1;
                            } else {
                                opcionP1 = 2;
                            }
                        break;
                        case 4:
                            if (opcionP2 == 7) {
                                opcionP1 = 6;
                            } else {
                                opcionP1 = 7;
                            }
                        break;
                        case 5:
                            if (opcionP2 == 4) {
                                opcionP1 = 7;
                            } else {
                                opcionP1 = 4;
                            }
                        break;
                        case 6:
                            if (opcionP2 == 5) {
                                opcionP1 = 4;
                            } else {
                                opcionP1 = 5;
                            }
                        break;
                        case 7:
                            if (opcionP2 == 6) {
                                opcionP1 = 5;
                            } else {
                                opcionP1 = 6;
                            }
                        break;
                    }
                } else if (!pausaMapSelect) {
                    switch(opcionMenu) {
                        case 0:
                            opcionMenu = 1;
                        break;
                        case 1:
                            opcionMenu = 0;
                        break;
                        case 2:
                            opcionMenu = 3;
                        break;
                        case 3:
                            opcionMenu = 2;
                        break;
                    }
                }
                izquierda = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_D) {
                if (!pausaCharSelect) {
                    switch(opcionP1) {
                        case 0:
                            if (opcionP2 == 1) {
                                opcionP1 = 2;
                            } else {
                                opcionP1 = 1;
                            }
                        break;
                        case 1:
                            if (opcionP2 == 2) {
                                opcionP1 = 3;
                            } else {
                                opcionP1 = 2;
                            }
                        break;
                        case 2:
                            if (opcionP2 == 3) {
                                opcionP1 = 0;
                            } else {
                                opcionP1 = 3;
                            }
                        break;
                        case 3:
                            if (opcionP2 == 0) {
                                opcionP1 = 1;
                            } else {
                                opcionP1 = 0;
                            }
                        break;
                        case 4:
                            if (opcionP2 == 5) {
                                opcionP1 = 6;
                            } else {
                                opcionP1 = 5;
                            }
                        break;
                        case 5:
                            if (opcionP2 == 6) {
                                opcionP1 = 7;
                            } else {
                                opcionP1 = 6;
                            }
                        break;
                        case 6:
                            if (opcionP2 == 7) {
                                opcionP1 = 4;
                            } else {
                                opcionP1 = 7;
                            }
                        break;
                        case 7:
                            if (opcionP2 == 4) {
                                opcionP1 = 5;
                            } else {
                                opcionP1 = 4;
                            }
                        break;
                    }
                } else if (!pausaMapSelect) {
                    switch(opcionMenu) {
                        case 0:
                            opcionMenu = 1;
                        break;
                        case 1:
                            opcionMenu = 0;
                        break;
                        case 2:
                            opcionMenu = 3;
                        break;
                        case 3:
                            opcionMenu = 2;
                        break;
                    }
                }
                derecha = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_W) {
                if (!start) {
                    switch(opcionMenu) {
                        case 0:
                            opcionMenu = 2;
                        break;
                        case 1:
                            opcionMenu = 0;
                        break;
                        case 2:
                            opcionMenu = 1;
                        break;
                    }
                } else if (!pausaCharSelect) {
                    switch(opcionP1) {
                        case 0:
                            if (opcionP2 != 4) {
                                opcionP1 = 4;
                            }
                        break;
                        case 1:
                            if (opcionP2 != 5) {
                                opcionP1 = 5;
                            }
                        break;
                        case 2:
                            if (opcionP2 != 6) {
                                opcionP1 = 6;
                            }
                        break;
                        case 3:
                            if (opcionP2 != 7) {
                                opcionP1 = 7;
                            }
                        break;
                        case 4:
                            if (opcionP2 != 0) {
                                opcionP1 = 0;
                            }
                        break;
                        case 5:
                            if (opcionP2 != 1) {
                                opcionP1 = 1;
                            }
                        break;
                        case 6:
                            if (opcionP2 != 2) {
                                opcionP1 = 2;
                            }
                        break;
                        case 7:
                            if (opcionP2 != 3) {
                                opcionP1 = 3;
                            }
                        break;
                    }
                } else if (!pausaMapSelect) {
                    switch(opcionMenu) {
                        case 0:
                            opcionMenu = 2;
                        break;
                        case 1:
                            opcionMenu = 3;
                        break;
                        case 2:
                            opcionMenu = 0;
                        break;
                        case 3:
                            opcionMenu = 1;
                        break;
                    }
                }
                arriba = true;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_S) {
                if (!start) {
                    switch(opcionMenu) {
                        case 0:
                            opcionMenu = 1;
                        break;
                        case 1:
                            opcionMenu = 2;
                        break;
                        case 2:
                            opcionMenu = 0;
                        break;
                    }
                } else if (!pausaCharSelect) {
                    switch(opcionP1) {
                        case 0:
                            if (opcionP2 != 4) {
                                opcionP1 = 4;
                            }
                        break;
                        case 1:
                            if (opcionP2 != 5) {
                                opcionP1 = 5;
                            }
                        break;
                        case 2:
                            if (opcionP2 != 6) {
                                opcionP1 = 6;
                            }
                        break;
                        case 3:
                            if (opcionP2 != 7) {
                                opcionP1 = 7;
                            }
                        break;
                        case 4:
                            if (opcionP2 != 0) {
                                opcionP1 = 0;
                            }
                        break;
                        case 5:
                            if (opcionP2 != 1) {
                                opcionP1 = 1;
                            }
                        break;
                        case 6:
                            if (opcionP2 != 2) {
                                opcionP1 = 2;
                            }
                        break;
                        case 7:
                            if (opcionP2 != 3) {
                                opcionP1 = 3;
                            }
                        break;
                    }
                } else if (!pausaMapSelect) {
                    switch(opcionMenu) {
                        case 0:
                            opcionMenu = 2;
                        break;
                        case 1:
                            opcionMenu = 3;
                        break;
                        case 2:
                            opcionMenu = 0;
                        break;
                        case 3:
                            opcionMenu = 1;
                        break;
                    }
                }
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
