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
    private final static int JUNGLE_DERECHO = 1000;
    private final static int DESERT_IZQUIERDO = 325;
    private final static int DESERT_DERECHO = 880;
    private final static int UNDERWORLD_IZQUIERDO = 290;
    private final static int UNDERWORLD_DERECHO = 906;
    private final static int RAINBOW_IZQUIERDO = 271;
    private final static int RAINBOW_DERECHO = 906;
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
    private boolean credits;
    private boolean pausaCharSelect;
    private boolean pausaMapSelect;
    private boolean desert;
    private boolean jungle;
    private boolean underworld;
    private boolean rainbow;
    private boolean attackH1P1;
    private boolean attackH2P1;
    private boolean attackVP1;
    private boolean attackH1P2;
    private boolean attackH2P2;
    private boolean attackVP2;
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
    private Image RainbowRoad;
    private Image GameOver;
    private Image creditScreen;
    private Image cursorMenuInicialImg;
    private Image cursorP1Img;
    private Image cursorP2Img;
    private Image cursorPSelImg;
    private Image cursorMapaImg;
    private Image P1healthbar;
    private Image P2healthbar;
    private Image PowerDown;
    private Image PowerUp;
    private Image obstaculo1;
    private Image obstaculo2;
    private Image obstaculo3;
    private Image obstaculo1Jungle;
    private Image obstaculo2Jungle;
    private Image obstaculo3Jungle;
    private Image obstaculo1Desert;
    private Image obstaculo2Desert;
    private Image obstaculo3Desert;
    private Image obstaculo1Underworld;
    private Image obstaculo2Underworld;
    private Image obstaculo3Underworld;
    private Image obstaculo1Rainbow;
    private Image obstaculo2Rainbow;
    private Image obstaculo3Rainbow;
    private Animacion P1barra;
    private Animacion P2barra;
    private Image P1Icono;
    private Image P2Icono;
    private Image iZeus;
    private Image iAmaterasu;
    private Image iDragon;
    private Image iHades;
    private Image iQuetzal;
    private Image iRa;
    private Image iAnubis;
    private Image iFreya;
    private Image zeus;
    private Image amaterasu;
    private Image dragon;
    private Image hades;
    private Image quetzal;
    private Image ra;
    private Image anubis;
    private Image freya;
    private Image zeusPH1;
    private Image zeusPH2;
    private Image zeusPV;
    private Image amaterasuPH1;
    private Image amaterasuPH2;
    private Image amaterasuPV;
    private Image dragonPH1;
    private Image dragonPH2;
    private Image dragonPV;
    private Image hadesPH1;
    private Image hadesPH2;
    private Image hadesPV;
    private Image quetzalPH1;
    private Image quetzalPH2;
    private Image quetzalPV;
    private Image raPH1;
    private Image raPH2;
    private Image raPV;
    private Image anubisPH1;
    private Image anubisPH2;
    private Image anubisPV;
    private Image freyaPH1;
    private Image freyaPH2;
    private Image freyaPV;
    private SoundClip sonido_menu;
    private SoundClip sonido_jungle;
    private SoundClip sonido_desierto;
    private SoundClip sonido_underworld;
    private SoundClip sonido_rainbow;
    private SoundClip sonido_win;
    private SoundClip sonido_amaterasu;
    private SoundClip sonido_anubis;
    private SoundClip sonido_freya;
    private SoundClip sonido_hades;
    private SoundClip sonido_quetzal;
    private SoundClip sonido_ra;
    private SoundClip sonido_dragon;
    private SoundClip sonido_zeus;
    private SoundClip sonido_objColision;
    private SoundClip sonido_proyColision;
    private Obstaculos cursorP1;
    private Obstaculos cursorP2;
    private Obstaculos cursorMenu;
    private Obstaculos cursorMapa;
    private Obstaculos obstaculo;
    private Obstaculos powerUp;
    private Obstaculos powerP1H1;
    private Obstaculos powerP1H2;
    private Obstaculos powerP1V;
    private Obstaculos powerP2H1;
    private Obstaculos powerP2H2;
    private Obstaculos powerP2V;
    private BasePersonajes P1;
    private BasePersonajes P2;
    private LinkedList<Obstaculos> obstaclesLeft;
    private LinkedList<Obstaculos> obstaclesRight;
    
    //Variables control de tiempo de animacion
    private long tiempoActual;
    private long tiempoInicial;
    
        /**
         * Método constructor por default de la clase <I>Game</I>.
         */
        public Game() {
            setSize(1200,720);
            init();
            start();
        }

        /**
         * Método initi que inicializa los valores de las variables y carga
         * las imágenes y sonidos
         */
        public void init() {
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
            rainbow = false;
            gameover = false;
            credits = false;
            
            p1Select = false;
            p2Select = false;
            attackH1P1 = false;
            attackH2P1 = false;
            attackVP1 = false;
            attackH1P2 = false;
            attackH2P2 = false;
            attackVP2 = false;
            
            // Imágenes de fondo, menús, créditos, etc.
            startScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_TitleScreen.png"));
            instructionScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Instructions.png"));
            characterSelect = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_CharacterSelect2.png"));
            mapSelect = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MapSelect_1.png"));
            Desert = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map1_DesertGIF.gif"));
            Jungle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map1_JungleGIF.gif"));
            Underworld = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map2_UnderworldGIF.gif"));
            RainbowRoad = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Map2_RainbowRoad.gif"));
            GameOver = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_GameOver.png"));
            creditScreen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Credits.gif"));
            
            // Imagenes de cursores de seleccion
            cursorMenuInicialImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/Coin.gif"));
            cursorP1Img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MarcoP1.gif"));
            cursorP2Img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MarcoP2.gif"));
            cursorPSelImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MarcoPSELECT.gif"));
            cursorMapaImg = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_MarcoMP1.gif"));
            
            // Sonidos de background
            sonido_menu = new SoundClip("/sounds/Athenian_Rooftop.wav");
            sonido_jungle = new SoundClip("/sounds/Deep_Jungle.wav");
            sonido_desierto = new SoundClip("/sounds/Day_Agrabah.wav");
            sonido_underworld = new SoundClip("/sounds/Hades_Underworld.wav");
            sonido_rainbow = new SoundClip("/sounds/Rainbow_Road.wav");
            sonido_win = new SoundClip("/sounds/victoryMusic.wav");
            sonido_menu.setLooping(true);
            sonido_menu.play();
            
            // Imagenes de personajes y sus iconos
            iZeus = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char1.png"));
            iAmaterasu = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char2.png"));
            iDragon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char3.png"));
            iHades = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char4.png"));
            iQuetzal = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char5.png"));
            iRa = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char6.png"));
            iAnubis = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char7.png"));
            iFreya = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/char8.png"));
            zeus = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_ZEUS.gif"));
            amaterasu = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_AMATER.gif"));
            dragon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_SHENLONG.gif"));
            hades = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_HADES.gif"));
            quetzal = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_QUETZY.gif"));
            ra = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_RAH.gif"));
            anubis = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_ANUBIS.gif"));
            freya = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/character_FREYA.gif"));
            
            // Imagenes de los power-ups
            zeusPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_zeus.png"));
            zeusPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_zeus.png"));
            zeusPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_zeus.png"));
            amaterasuPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_amaterasu2.png"));
            amaterasuPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_amaterasu3.png"));
            amaterasuPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_amaterasu1.png"));
            dragonPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_shenlong.png"));
            dragonPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_shenlong.png"));
            dragonPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_shenlong.png"));
            hadesPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_hades1.png"));
            hadesPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_hades2.png"));
            hadesPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_hades3.png"));
            quetzalPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_quetzy3.png"));
            quetzalPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_quetzy1.png"));
            quetzalPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_quetzy2.png"));
            raPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_ra2.png"));
            raPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_ra3.png"));
            raPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_ra.png"));
            anubisPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_anubis1.png"));
            anubisPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_anubis1.png"));
            anubisPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_anubis2.png"));
            freyaPH1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_freya.png"));
            freyaPH2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_freya.png"));
            freyaPV = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/proyectil_freya.png"));
            
            // Imagenes de obstaculos dependiendo del nivel
            obstaculo1Jungle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/forest1.png"));
            obstaculo2Jungle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/forest2.png"));
            obstaculo3Jungle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/forest3.gif"));
            obstaculo1Desert = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/desierto1.gif"));
            obstaculo2Desert = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/desierto2.png"));
            obstaculo3Desert = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/desierto3.gif"));
            obstaculo1Underworld = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/infierno1.png"));
            obstaculo2Underworld = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/infierno2.png"));
            obstaculo3Underworld = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/infierno3.gif"));
            obstaculo1Rainbow = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/rainbow1.png"));
            obstaculo2Rainbow = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/rainbow2.png"));
            obstaculo3Rainbow = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/rainbow3.gif"));
            
            // Imagenes de barra de vida
            P1healthbar = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Health.png"));
            P2healthbar = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/BioForge_Health2.png"));
            
            P1barra = new Animacion();
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra0.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra1.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra2.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra3.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra4.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra5.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra6.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra7.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra8.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra9.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra10.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra11.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra12.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra13.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra14.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra15.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra16.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra17.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra18.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra19.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra20.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra21.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra22.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra23.gif")), 5);
            
            P2barra = new Animacion();
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra0.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra1.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra2.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra3.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra4.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra5.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra6.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra7.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra8.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra9.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra10.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra11.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra12.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra13.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra14.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra15.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra16.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra17.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra18.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra19.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra20.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra21.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra22.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra23.gif")), 5);
            
            // Sonidos de los personajes
            sonido_amaterasu = new SoundClip ("/sounds/amateratsuSfx.wav");
            sonido_anubis = new SoundClip ("/sounds/anubiSfx.wav");
            sonido_freya = new SoundClip ("/sounds/freyaSfx.wav");
            sonido_hades = new SoundClip ("/sounds/hadeSfx.wav");
            sonido_quetzal = new SoundClip ("/sounds/quetzySfx.wav");
            sonido_ra = new SoundClip ("/sounds/raSfx.wav");
            sonido_dragon = new SoundClip ("/sounds/shenSfx.wav");
            sonido_zeus = new SoundClip ("/sounds/zeusSfx.wav");
            
            // Sonidos de colisiones
            sonido_objColision = new SoundClip ("/sounds/obstacleSfx.wav");
            sonido_proyColision = new SoundClip ("/sounds/proyectileColision.wav");
            
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
            
            // Inicializa power up y su posicion inicial
            PowerUp = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/powerUP.gif"));
            PowerDown = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/powerDOWN.gif"));
            powerUp = new Obstaculos(getWidth()/2, -1000, PowerUp);
            powerP1H1 = new Obstaculos();
            powerP1H2 = new Obstaculos();
            powerP1V = new Obstaculos();
            powerP2H1 = new Obstaculos();
            powerP2H2 = new Obstaculos();
            powerP2V = new Obstaculos();
            
            // Inicialización de personajes
            vidaP1 = 120;
            vidaP2 = 120;
            P1 = new BasePersonajes();
            P2 = new BasePersonajes();
            
            addKeyListener(this);
        }
        
        /**
         * Método creaObstaculo que añade obstáculos a la pantalla
         * @param n es el número de obstáculo en la pantalla
         */
        public void creaObstaculo(int n) {
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
                    ob.setPosX(extremoDerecho - ob.getAncho() - randPosicionX.nextInt((int)((extremoDerecho - extremoIzquierdo)/2)));
                    ob.setPosY(obstaclesRight.getLast().getPosY() - randPosicionY.nextInt(100) - 200);
                    obstaclesRight.add(ob);
                break;
            }
        }
        
        /**
         * Método que inicializa la aparición de los obstáculos en la pantalla
         */
        public void inicializaObstaculos() {
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
            
            for (int i = 1; i < 10; i++) {
                creaObstaculo(0);
                creaObstaculo(1);
            }   
        }

        /** 
         * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
         * para la animacion este metodo es llamado despues del init o 
         * en donde esta este <code>Applet</code>
         */
        public void start () {
               // Declaras un hilo
               Thread th = new Thread (this);
               // Empieza el hilo
               th.start ();
       }

        /**
         * En este metodo se pueden tomar acciones para cuando se termina
         * en donde esta este <code>Applet</code>.
         */
        public void stop() {

        }

        /**
         * En este metodo se toman las acciones necesarias para cuando
         * cierra el navegador.
         */
        public void destroy() {

        }
        
        /** 
         * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se incrementa
         * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
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
         * Método <I>restart</I> que reinicializa las variables y objetos cuando
         * se reinicia el juego después de ganar.
         */
        public void restart() {
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
            rainbow = false;
            gameover = false;
            credits = false;
            
            obstaculo = new Obstaculos();
            obstaclesLeft = new<Obstaculos> LinkedList();
            obstaclesRight = new<Obstaculos> LinkedList();
            
            p1Select = false;
            p2Select = false;
            attackH1P1 = false;
            attackH2P1 = false;
            attackVP1 = false;
            attackH1P2 = false;
            attackH2P2 = false;
            attackVP2 = false;
            powerP1H1 = new Obstaculos();
            powerP1H2 = new Obstaculos();
            powerP1V = new Obstaculos();
            powerP2H1 = new Obstaculos();
            powerP2H2 = new Obstaculos();
            powerP2V = new Obstaculos();
            
            sonido_menu.setLooping(true);
            sonido_menu.play();
            
            opcionMenu = 0;
            opcionP1 = 0;
            opcionP2 = 1;
            
            P1barra = new Animacion();
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra0.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra1.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra2.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra3.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra4.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra5.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra6.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra7.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra8.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra9.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra10.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra11.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra12.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra13.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra14.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra15.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra16.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra17.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra18.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra19.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra20.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra21.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra22.gif")), 5);
            P1barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra23.gif")), 5);
            
            P2barra = new Animacion();
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra0.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra1.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra2.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra3.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra4.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra5.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra6.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra7.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra8.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra9.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra10.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra11.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra12.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra13.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra14.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra15.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra16.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra17.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra18.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra19.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra20.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra21.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra22.gif")), 5);
            P2barra.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/barra23.gif")), 5);
            
            vidaP1 = 120;
            vidaP2 = 120;
            P1 = new BasePersonajes();
            P2 = new BasePersonajes();
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
                        cursorMenu.setPosX(750);
                        cursorMenu.setPosY(465);
                    break;
                    case 1:
                        cursorMenu.setPosX(550);
                        cursorMenu.setPosY(580);
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
                    switch(opcionP1) {
                        case 0:
                            P1Icono = iZeus;
                            P1.setImagenI(zeus);
                            P1.setSonido(sonido_zeus);
                            powerP1H1.setImagenI(zeusPH1);
                            powerP1H2.setImagenI(zeusPH2);
                            powerP1V.setImagenI(zeusPV);
                        break;
                        case 1:
                            P1Icono = iAmaterasu;
                            P1.setImagenI(amaterasu);
                            P1.setSonido(sonido_amaterasu);
                            powerP1H1.setImagenI(amaterasuPH1);
                            powerP1H2.setImagenI(amaterasuPH2);
                            powerP1V.setImagenI(amaterasuPV);
                        break;
                        case 2:
                            P1Icono = iDragon;
                            P1.setImagenI(dragon);
                            P1.setSonido(sonido_dragon);
                            powerP1H1.setImagenI(dragonPH1);
                            powerP1H2.setImagenI(dragonPH2);
                            powerP1V.setImagenI(dragonPV);
                        break;
                        case 3:
                            P1Icono = iHades;
                            P1.setImagenI(hades);
                            P1.setSonido(sonido_hades);
                            powerP1H1.setImagenI(hadesPH1);
                            powerP1H2.setImagenI(hadesPH2);
                            powerP1V.setImagenI(hadesPV);
                        break;
                        case 4:
                            P1Icono = iQuetzal;
                            P1.setImagenI(quetzal);
                            P1.setSonido(sonido_quetzal);
                            powerP1H1.setImagenI(quetzalPH1);
                            powerP1H2.setImagenI(quetzalPH2);
                            powerP1V.setImagenI(quetzalPV);
                        break;
                        case 5:
                            P1Icono = iRa;
                            P1.setImagenI(ra);
                            P1.setSonido(sonido_ra);
                            powerP1H1.setImagenI(raPH1);
                            powerP1H2.setImagenI(raPH2);
                            powerP1V.setImagenI(raPV);
                        break;
                        case 6:
                            P1Icono = iAnubis;
                            P1.setImagenI(anubis);
                            P1.setSonido(sonido_anubis);
                            powerP1H1.setImagenI(anubisPH1);
                            powerP1H2.setImagenI(anubisPH2);
                            powerP1V.setImagenI(anubisPV);
                        break;
                        case 7:
                            P1Icono = iFreya;
                            P1.setImagenI(freya);
                            P1.setSonido(sonido_freya);
                            powerP1H1.setImagenI(freyaPH1);
                            powerP1H2.setImagenI(freyaPH2);
                            powerP1V.setImagenI(freyaPV);
                        break;
                    }
                    switch(opcionP2) {
                        case 0:
                            P2Icono = iZeus;
                            P2.setImagenI(zeus);
                            P2.setSonido(sonido_zeus);
                            powerP2H1.setImagenI(zeusPH1);
                            powerP2H2.setImagenI(zeusPH2);
                            powerP2V.setImagenI(zeusPV);
                        break;
                        case 1:
                            P2Icono = iAmaterasu;
                            P2.setImagenI(amaterasu);
                            P2.setSonido(sonido_amaterasu);
                            powerP2H1.setImagenI(amaterasuPH1);
                            powerP2H2.setImagenI(amaterasuPH2);
                            powerP2V.setImagenI(amaterasuPV);
                        break;
                        case 2:
                            P2Icono = iDragon;
                            P2.setImagenI(dragon);
                            P2.setSonido(sonido_dragon);
                            powerP2H1.setImagenI(dragonPH1);
                            powerP2H2.setImagenI(dragonPH2);
                            powerP2V.setImagenI(dragonPV);
                        break;
                        case 3:
                            P2Icono = iHades;
                            P2.setImagenI(hades);
                            P2.setSonido(sonido_hades);
                            powerP2H1.setImagenI(hadesPH1);
                            powerP2H2.setImagenI(hadesPH2);
                            powerP2V.setImagenI(hadesPV);
                        break;
                        case 4:
                            P2Icono = iQuetzal;
                            P2.setImagenI(quetzal);
                            P2.setSonido(sonido_quetzal);
                            powerP2H1.setImagenI(quetzalPH1);
                            powerP2H2.setImagenI(quetzalPH2);
                            powerP2V.setImagenI(quetzalPV);
                        break;
                        case 5:
                            P2Icono = iRa;
                            P2.setImagenI(ra);
                            P2.setSonido(sonido_ra);
                            powerP2H1.setImagenI(raPH1);
                            powerP2H2.setImagenI(raPH2);
                            powerP2V.setImagenI(raPV);
                        break;
                        case 6:
                            P2Icono = iAnubis;
                            P2.setImagenI(anubis);
                            P2.setSonido(sonido_anubis);
                            powerP2H1.setImagenI(anubisPH1);
                            powerP2H2.setImagenI(anubisPH2);
                            powerP2V.setImagenI(anubisPV);
                        break;
                        case 7:
                            P2Icono = iFreya;
                            P2.setImagenI(freya);
                            P2.setSonido(sonido_freya);
                            powerP2H1.setImagenI(freyaPH1);
                            powerP2H2.setImagenI(freyaPH2);
                            powerP2V.setImagenI(freyaPV);
                        break;
                    }
                    
                    P1.setPosX(getWidth()/4 + 100); 
                    P2.setPosX(2*getWidth()/4 + 100);
                    P1.setPosY(getHeight()-P1.getAlto());
                    P2.setPosY(getHeight()-P2.getAlto());
                    
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
            } else if (gameover && !credits) {
                switch (opcionMenu) {
                    case 0:
                        cursorMenu.setPosX(412);
                        cursorMenu.setPosY(505);
                    break;
                    case 1:
                        cursorMenu.setPosX(450);
                        cursorMenu.setPosY(590);
                    break;
                }
            }

            // Verifica que no esté en pausa y que esté en el escenario de juego
            if (!pausa && !gameover && (desert || jungle || underworld || rainbow)) {
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
                
                // Actualiza el power-up
                powerUp.actualizaPosY(10);
                
                // Actualiza los power-ups cuando si es que algun personaje lo tiene y lo uso
                if (attackH1P1) {
                    powerP1H1.actualizaPosX(-12);
                }
                if (attackH2P1) {
                    powerP1H2.actualizaPosX(12);
                }
                if (attackVP1) {
                    powerP1V.actualizaPosY(-12);
                }
                if (attackH1P2) {
                    powerP2H1.actualizaPosX(-12);
                }
                if (attackH2P2) {
                    powerP2H2.actualizaPosX(12);
                }
                if (attackVP2) {
                    powerP2V.actualizaPosY(-12);
                }
                
                // Checa que la vida de los personajes se acabe
                if (vidaP1 <= 0 || vidaP2 <= 0) {
                    switch(opcionMenu) {
                        case 0:
                            sonido_jungle.stop();
                        break;
                        case 1:
                            sonido_desierto.stop();
                        break;
                        case 2:
                            sonido_underworld.stop();
                        break;
                        case 3:
                            sonido_rainbow.stop();
                        break;
                    }
                    sonido_win.play();
                    gameover = true;
                    opcionMenu = 0;
                }
            }
        }
        
        /**
         * Este metodo checa la colision entre los personajes,
         * la  colision del bueno con los extremos del applet
         */
        public void checaColision() {
            // Verifica que no esté en pausa y esté en el escenario de juego
            if (!pausa && !gameover && (jungle || desert || underworld || rainbow)) {
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
                        vidaP1 -= 5;
                        sonido_objColision.play();
                        P1barra.actualiza(5);
                    }
                    if (obstaclesLeft.get(i).intersecta(P2)) {
                        obstaclesLeft.remove(i);
                        creaObstaculo(0);
                        vidaP2 -= 5;
                        sonido_objColision.play();
                        P2barra.actualiza(5);
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
                        vidaP1-=5;
                        sonido_objColision.play();
                        P1barra.actualiza(5);
                    }
                    if (obstaclesRight.get(i).intersecta(P2)) {
                        obstaclesRight.remove(i);
                        creaObstaculo(1);
                        vidaP2-=5;
                        sonido_objColision.play();
                        P2barra.actualiza(5);
                    }
                }
                
                if (jungle || desert || underworld || rainbow) {
                    // Verifica que el personaje 1 no choque con el frame
                    if (P1.getPosX() < extremoIzquierdo) {
                        P1.setPosX(extremoIzquierdo + 10);
                    }
                    if (P1.getPosX() + P1.getAncho() > extremoDerecho) {
                        P1.setPosX(extremoDerecho - 10 - P1.getAncho());
                    }
                    // Verifica que el personaje 2 no choque con el frame
                    if (P2.getPosX() < extremoIzquierdo) {
                        P2.setPosX(extremoIzquierdo + 10);
                    }
                    if (P2.getPosX() + P2.getAncho() > extremoDerecho) {
                        P2.setPosX(extremoDerecho - 10 - P2.getAncho());
                    }
                }
                
                // Colision entre personajes
                if (P1.intersecta(P2) || P2.intersecta(P1)) {
                    if (derecha || izquierda2) {
                        P1.actualizaPosX(-30);
                        P2.actualizaPosX(30);
                    } else if (derecha2 || izquierda) {
                        P1.actualizaPosX(30);
                        P2.actualizaPosX(-30);
                    } else if (arriba || abajo2) {
                        P1.actualizaPosY(30);
                        P2.actualizaPosY(-30);
                    } else if (abajo || arriba2) {
                        P1.actualizaPosY(-30);
                        P2.actualizaPosY(30);
                    }
                }
                
                // Colision de personaje con el objeto power-up
                Random randPosicionPU = new Random();
                if (powerUp.intersecta(P1)) {
                    P1.setPowerUp(true);
                    powerUp.setPosX(randPosicionPU.nextInt((int)((extremoDerecho - extremoIzquierdo)) - powerUp.getAncho()) + extremoIzquierdo);
                    powerUp.setPosY(-1800);
                }
                if (powerUp.intersecta(P2)) {
                    P2.setPowerUp(true);
                    powerUp.setPosX(randPosicionPU.nextInt((int)((extremoDerecho - extremoIzquierdo)) - powerUp.getAncho()) + extremoIzquierdo);
                    powerUp.setPosY(-1800);
                }
                    
                // Colision del objeto power-up con el frame
                if (powerUp.getPosY() > getHeight()) {
                    powerUp.setPosX(randPosicionPU.nextInt((int)((extremoDerecho - extremoIzquierdo)) - powerUp.getAncho()) + extremoIzquierdo);
                    powerUp.setPosY(-1800);
                }
                
                // Colision de los power-ups con los linderos del frame y pista
                if (powerP1H1.getPosX() < extremoIzquierdo) {
                    powerP1H1.setPosX(-100);
                    powerP1H1.setPosY(-100);
                    attackH1P1 = false;
                }
                if (powerP1H2.getPosX() + powerP1H2.getAncho() > extremoDerecho) {
                    powerP1H2.setPosX(-100);
                    powerP1H2.setPosY(-100);
                    attackH2P1 = false;
                }
                if (powerP2H1.getPosX() < extremoIzquierdo) {
                    powerP2H1.setPosX(-100);
                    powerP2H1.setPosY(-100);
                    attackH1P2 = false;
                }
                if (powerP2H2.getPosX() + powerP2H2.getAncho() > extremoDerecho) {
                    powerP2H2.setPosX(-100);
                    powerP2H2.setPosY(-100);
                    attackH2P2 = false;
                }
                if (powerP1V.getPosY() < 0) {
                    powerP1V.setPosX(-100);
                    powerP1V.setPosY(-100);
                    attackVP1 = false;
                }
                if (powerP2V.getPosY() < 0) {
                    powerP2V.setPosX(-100);
                    powerP2V.setPosY(-100);
                    attackVP2 = false;
                }
                
                // Colision de los power-ups con los personajes
                if (powerP1H1.intersecta(P2) || powerP1H2.intersecta(P2) || powerP1V.intersecta(P2)) {
                    powerP1H1.setPosX(-100);
                    powerP1H1.setPosY(-100);
                    powerP1H2.setPosX(-100);
                    powerP1H2.setPosY(-100);
                    powerP1V.setPosX(-100);
                    powerP1V.setPosY(-100);
                    vidaP2 -= 15;
                    sonido_proyColision.play();
                    P2barra.actualiza(15);
                    attackH1P1 = false;
                    attackH2P1 = false;
                    attackVP1 = false;
                }
                if (powerP2H1.intersecta(P1) || powerP2H2.intersecta(P1) || powerP2V.intersecta(P1)) {
                    powerP2H1.setPosX(-100);
                    powerP2H1.setPosY(-100);
                    powerP2H2.setPosX(-100);
                    powerP2H2.setPosY(-100);
                    powerP2V.setPosX(-100);
                    powerP2V.setPosY(-100);
                    sonido_proyColision.play();
                    vidaP1 -= 15;
                    P1barra.actualiza(15);
                    attackH1P2 = false;
                    attackH2P2 = false;
                    attackVP2 = false;
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
                    g.drawImage(cursorMenu.getImagenI(), cursorMenu.getPosX(), cursorMenu.getPosY(), this);
                    // Dibuja la pantalla de instrucciones
                    if (instrucciones) {
                        g.drawImage(instructionScreen, 0, 0, this);
                    }
                } else if (!pausaCharSelect) {
                    // Dibuja la pantalla de selección de personajes
                    g.drawImage(characterSelect, 0, 0, this);
                    if (p1Select)
                        g.drawImage(cursorPSelImg, cursorP1.getPosX(), cursorP1.getPosY(), this);
                    else
                        g.drawImage(cursorP1.getImagenI(), cursorP1.getPosX(), cursorP1.getPosY(), this);
                    if (p2Select)
                        g.drawImage(cursorPSelImg, cursorP2.getPosX(), cursorP2.getPosY(), this);
                    else
                        g.drawImage(cursorP2.getImagenI(), cursorP2.getPosX(), cursorP2.getPosY(), this);
                } else if (!pausaMapSelect) {
                    // Dibuja la pantalla de selección de pista
                    g.drawImage(mapSelect, 0, 0, this);
                    g.drawImage(cursorMapa.getImagenI(), cursorMapa.getPosX(), cursorMapa.getPosY(), this);
                } else if(!gameover){
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
                            g.drawImage(RainbowRoad, 0, 0, this);
                        break;
                    }
                    // Dibuja la healthbar
                    g.drawImage(P1healthbar, 0, 0, this);
                    g.drawImage(P2healthbar, getWidth()-155, 0, this);
                    g.drawImage(P1Icono, 10, 8, this);
                    g.drawImage(P2Icono, getWidth()-145, 8, this);
                    g.drawImage(P1barra.getImagen(), 4, 110, this);
                    g.drawImage(P2barra.getImagen(), getWidth()-25, 110, this);
                    if (P1.getPowerUp())
                        g.drawImage(PowerUp, 23, 295, this);
                    else
                        g.drawImage(PowerDown, 23, 295, this);
                    if (P2.getPowerUp())
                        g.drawImage(PowerUp, getWidth()-50, 295, this);
                    else
                        g.drawImage(PowerDown, getWidth()-50, 295, this);
                    
                    // Dibuja a los personajes
                    g.drawImage(P1.getImagenI(), P1.getPosX(), P1.getPosY(), this);
                    g.drawImage(P2.getImagenI(), P2.getPosX(), P2.getPosY(), this);
                    
                    // Dibuja los obstaculos
                    for (int i = 0; i < obstaclesLeft.size(); i++)
                        g.drawImage(obstaclesLeft.get(i).getImagenI(), obstaclesLeft.get(i).getPosX(), obstaclesLeft.get(i).getPosY(), this);
                    for (int i = 0; i < obstaclesRight.size(); i++)
                        g.drawImage(obstaclesRight.get(i).getImagenI(), obstaclesRight.get(i).getPosX(), obstaclesRight.get(i).getPosY(), this);
                    
                    // Dibuja el power-up
                    g.drawImage(powerUp.getImagenI(), powerUp.getPosX(), powerUp.getPosY(), this);
                    
                    // Dibuja los power-ups de los personajes
                    if (attackH1P1)
                        g.drawImage(powerP1H1.getImagenI(), powerP1H1.getPosX(), powerP1H1.getPosY(), this);
                    if (attackH2P1)
                        g.drawImage(powerP1H2.getImagenI(), powerP1H2.getPosX(), powerP1H2.getPosY(), this);
                    if (attackVP1)
                        g.drawImage(powerP1V.getImagenI(), powerP1V.getPosX(), powerP1V.getPosY(), this);
                    if (attackH1P2)
                        g.drawImage(powerP2H1.getImagenI(), powerP2H1.getPosX(), powerP2H1.getPosY(), this);
                    if (attackH2P2)
                        g.drawImage(powerP2H2.getImagenI(), powerP2H2.getPosX(), powerP2H2.getPosY(), this);
                    if (attackVP2)
                        g.drawImage(powerP2V.getImagenI(), powerP2V.getPosX(), powerP2V.getPosY(), this);
                } else if (!credits) {
                    // Dibuja la pantalla de créditos
                    g.drawImage(GameOver, 0, 0, this);
                    if (vidaP1 > vidaP2) {
                        g.drawImage(P1Icono, 535, 237, this);
                    } else {
                        g.drawImage(P2Icono, 535, 237, this);
                    }
                    g.drawImage(cursorMenu.getImagenI(), cursorMenu.getPosX(), cursorMenu.getPosY(), this);
                } else {
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
                                instrucciones = true;
                            break;
                        }
                    }
                } else if(pausaCharSelect && !pausaMapSelect) {
                    sonido_menu.stop();
                    switch (opcionMenu) {
                        case 0:
                            obstaculo1 = obstaculo1Jungle;
                            obstaculo2 = obstaculo2Jungle;
                            obstaculo3 = obstaculo3Jungle;
                            extremoIzquierdo = JUNGLE_IZQUIERDO;
                            extremoDerecho = JUNGLE_DERECHO;
                            inicializaObstaculos();
                            jungle = true;
                            sonido_jungle.setLooping(true);
                            sonido_jungle.play();
                        break;
                        case 1:
                            obstaculo1 = obstaculo1Desert;
                            obstaculo2 = obstaculo2Desert;
                            obstaculo3 = obstaculo3Desert;
                            extremoIzquierdo = DESERT_IZQUIERDO;
                            extremoDerecho = DESERT_DERECHO;
                            inicializaObstaculos();
                            desert = true;
                            sonido_desierto.setLooping(true);
                            sonido_desierto.play();
                        break;
                        case 2:
                            obstaculo1 = obstaculo1Underworld;
                            obstaculo2 = obstaculo2Underworld;
                            obstaculo3 = obstaculo3Underworld;
                            extremoIzquierdo = UNDERWORLD_IZQUIERDO;
                            extremoDerecho = UNDERWORLD_DERECHO;
                            inicializaObstaculos();
                            underworld = true;
                            sonido_underworld.setLooping(true);
                            sonido_underworld.play();
                        break;
                        case 3:
                            obstaculo1 = obstaculo1Rainbow;
                            obstaculo2 = obstaculo2Rainbow;
                            obstaculo3 = obstaculo3Rainbow;
                            extremoIzquierdo = RAINBOW_IZQUIERDO;
                            extremoDerecho = RAINBOW_DERECHO;
                            inicializaObstaculos();
                            rainbow = true;
                            sonido_rainbow.setLooping(true);
                            sonido_rainbow.play();
                        break;
                    }
                    pausaMapSelect = true;
                } else if (gameover && !credits) {
                    switch(opcionMenu) {
                        case 0:
                            restart();
                        break;
                        case 1:
                            credits = true;
                        break;
                    }
                }
            }
            
            // Verifica la tecla de pausa
            if (e.getKeyCode() == KeyEvent.VK_P) {
                pausa = !pausa;
            }
            
            if (e.getKeyCode() == KeyEvent.VK_F) {
                if (start && !pausaCharSelect) {
                    p1Select = !p1Select;
                } else if (P1.getPowerUp()) {
                    attackVP1 = true;
                    P1.getSonido().play();
                    powerP1V.setPosX(P1.getPosX() + P1.getAncho()/2);
                    powerP1V.setPosY(P1.getPosY());
                    P1.setPowerUp(false);
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_G) {
                if (P1.getPowerUp()) {
                    attackH1P1 = true;
                    attackH2P1 = true;
                    P1.getSonido().play();
                    powerP1H1.setPosX(P1.getPosX());
                    powerP1H1.setPosY(P1.getPosY() + P1.getAlto()/2);
                    powerP1H2.setPosX(P1.getPosX() + P1.getAncho());
                    powerP1H2.setPosY(P1.getPosY() + P1.getAlto()/2);
                    P1.setPowerUp(false);
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_N) {
                if (start && !pausaCharSelect) {
                    p2Select = !p2Select;
                } else if (P2.getPowerUp()) {
                    attackVP2 = true;
                    P2.getSonido().play();
                    powerP2V.setPosX(P2.getPosX() + P2.getAncho()/2);
                    powerP2V.setPosY(P2.getPosY());
                    P2.setPowerUp(false);
                }
            }
            
            if (e.getKeyCode() == KeyEvent.VK_M) {
                if (P2.getPowerUp()) {
                    attackH1P2 = true;
                    attackH2P2 = true;
                    P2.getSonido().play();
                    powerP2H1.setPosX(P2.getPosX());
                    powerP2H1.setPosY(P2.getPosY() + P2.getAlto()/2);
                    powerP2H2.setPosX(P2.getPosX() + P2.getAncho());
                    powerP2H2.setPosY(P2.getPosY() + P2.getAlto()/2);
                    P2.setPowerUp(false);
                }
            }
            
            // Verifica las teclas de movimiento para los personajes
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!pausaCharSelect && !p2Select) {
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
                if (!pausaCharSelect  && !p2Select) {
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
                if (!pausaCharSelect && !p2Select) {
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
                if (!pausaCharSelect && !p2Select) {
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
                if (!pausaCharSelect && !p1Select) {
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
                if (!pausaCharSelect && !p1Select) {
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
                            opcionMenu = 1;
                        break;
                        case 1:
                            opcionMenu = 0;
                        break;
                    }
                } else if (!pausaCharSelect && !p1Select) {
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
                } else if (gameover && !credits) {
                    switch (opcionMenu) {
                        case 0:
                            opcionMenu = 1;
                        break;
                        case 1:
                            opcionMenu = 0;
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
                            opcionMenu = 0;
                        break;
                    }
                } else if (!pausaCharSelect && !p1Select) {
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
                } else if (gameover && !credits) {
                    switch (opcionMenu) {
                        case 0:
                            opcionMenu = 1;
                        break;
                        case 1:
                            opcionMenu = 0;
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