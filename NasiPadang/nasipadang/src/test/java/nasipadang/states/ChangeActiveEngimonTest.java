package nasipadang.states;

import nasipadang.display.Display;
import nasipadang.entities.Entity;
import nasipadang.entities.EntityManager;
import nasipadang.entities.creatures.Player;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class ChangeActiveEngimonTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);

    @Test
    public void ChangeActiveEngimon_Test(){
        ChangeActiveEngiState C = new ChangeActiveEngiState(handler);

    }


    @Test
    public void Tick_Test(){
        ChangeActiveEngiState C = new ChangeActiveEngiState(handler);
        C.tick();

    }

    @Test
    public void renderTest(){
        ChangeActiveEngiState C = new ChangeActiveEngiState(handler);
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
