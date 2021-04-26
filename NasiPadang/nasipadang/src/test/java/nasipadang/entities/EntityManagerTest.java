package nasipadang.entities;

import nasipadang.display.Display;
import nasipadang.entities.creatures.Player;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityManagerTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);
    private Player P = new Player(handler,30,30);

    @Test
    public void EntityManager_Test(){

        EntityManager E = new EntityManager(handler,P);
    }

    @Test
    public void Render_Test(){

        EntityManager E = new EntityManager(handler,P);
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

    @Test
    public void getPlayer() {
        EntityManager E = new EntityManager(handler,P);
        E.getPlayer();

    }
    @Test
    public void setPlayer() {
        EntityManager E = new EntityManager(handler,P);
        Player P = new Player(handler,19,10);
        E.setPlayer(P);


    }
    @Test
    public void getHandler() {
        EntityManager E = new EntityManager(handler,P);
        Handler H = E.getHandler();
        assertEquals(handler,H);

    }
    @Test
    public void setHandler() {
        EntityManager E = new EntityManager(handler,P);
        E.setHandler(handler);
        assertEquals(handler,E.getHandler());


    }




}
