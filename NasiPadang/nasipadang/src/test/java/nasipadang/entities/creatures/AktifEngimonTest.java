package nasipadang.entities.creatures;

import nasipadang.display.Display;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class AktifEngimonTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);

    @Test
    public void AktifEngimon_Test(){

        AktifEngimon A = new AktifEngimon(handler,3,3,1);
    }

    @Test
    public void isValidTile_Test(){
        AktifEngimon A = new AktifEngimon(handler,3,3,1);
        A.isValidTile();

    }

    @Test
    public void render_test(){
        AktifEngimon A = new AktifEngimon(handler,3,3,1);
        Display display  = new Display("Nasi Padang", 300, 150);
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        Graphics g ;
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        A.render(g);

    }
}
