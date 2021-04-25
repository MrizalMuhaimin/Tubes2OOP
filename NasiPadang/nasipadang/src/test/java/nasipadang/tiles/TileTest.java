package nasipadang.tiles;

import org.junit.jupiter.api.Test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;
import nasipadang.gfx.*;

public class TileTest {
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile waterTile = new WaterTile(1);
    public static Tile dirtTile = new DirtTile(2);

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    private SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/world.png"));

    protected BufferedImage texture = sheet.crop(32, 192, 30, 30);;
    protected  int id = 1;
    private  Tile tile;

    @Test
    public void Tile_Test(){
        tile = new Tile(texture, id);

    }

    @Test
    public void TiletickTest(){
        Tile_Test();
        tile.tick();

    }

    @Test
    public void isSolidTest(){
        Tile_Test();
        assertEquals(false,tile.isSolid());
    }

    @Test
    public void getIdTest(){
        Tile_Test();
        assertEquals(1,tile.getId());
    }



}
