package nasipadang.worlds;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import nasipadang.display.*;
import nasipadang.tiles.*;
import static org.junit.jupiter.api.Assertions.*;
import nasipadang.utils.Utils;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;


public class WorldTest {
    private Display display  = new Display("Nasi Padang", 300, 150);
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);
    private World world_2 = new World(handler,"src/main/resources/worlds/world1.txt");
    private BufferStrategy bs = display.getCanvas().getBufferStrategy();
    private Graphics g ;


    @Test
    public void World_Test(){
        World word = new World(handler,"src/main/resources/worlds/world1.txt");
    }

    @Test
    public void renderTest(){
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        world_2.render(g);

    }

    @Test
    public void getTile_Test(){
        Tile tile = world_2.getTile(0,0);

    }

    @Test
    public void  getSpawnX_Test(){
        int val = world_2.getSpawnX();
        //System.out.println(val);
        assertEquals(0,val);

    }

    @Test
    public void  getSpawnY_Test(){
        int val = world_2.getSpawnY();
        //System.out.println(val);
        assertEquals(0,val);

    }
    @Test
    public void  getWidth_Test(){
        int val = world_2.getWidth();
        //System.out.println(val);
        assertEquals(15,val);

    }

    @Test
    public void  getHeight_Test(){
        int val = world_2.getHeight();
        //System.out.println(val);
        assertEquals(15,val);

    }

}
