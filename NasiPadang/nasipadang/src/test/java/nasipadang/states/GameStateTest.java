package nasipadang.states;

import nasipadang.display.Display;
import nasipadang.entities.creatures.Player;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameStateTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);

    @Test
    public void GameState_Test(){
        GameState C = new GameState(handler);

    }


    @Test
    public void renderTest(){
        GameState C = new GameState(handler);
        Player P = new Player(handler,30,30);
        Display display  = new Display("Nasi Padang", 300, 150);
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        Graphics g ;
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        C.render(g);
    }
}
