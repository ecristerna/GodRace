/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package godrace;

import javax.swing.JFrame;

/**
 *
 * @author 
 * @author
 * Eduardo Cristerna Morales
 * Edgar Ovidio Villarreal Treviño
 * Graciela Garcia Diaz
 * Andres Marcelo Garza Cantu
 * 
 */

public class GodRace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.setTitle("GODRACE");
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
