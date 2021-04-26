package nasipadang.entities.creatures;

import nasipadang.display.Display;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class PlayerTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);
    @Test
    public void playerTest(){
        Player P = new Player(handler,30,30);
    }

    @Test
    public void render(){
        Player P = new Player(handler,30,30);
        Display display  = new Display("Nasi Padang", 300, 150);
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        Graphics g ;
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        P.render(g);

    }
}
