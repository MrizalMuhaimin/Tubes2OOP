package nasipadang.game;

import nasipadang.game.Game;


public class Launcher {

    public static void main(String[] args){
        Game game = new Game("NasiPadang", 640, 360);
        game.start();
    }

}

