package nasipadang.worlds;


import java.awt.Graphics;
import nasipadang.tiles.*;
import nasipadang.utils.Utils;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import nasipadang.entities.EntityManager;
import nasipadang.entities.creatures.Player;
import java.util.Random;
import nasipadang.entities.creatures.Engimon;

/**
 *
 * @author epatatuah
 */
public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private EntityManager entityManager ;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler,0,0)) ;
        Random random = new Random();
        loadWorld(path);

        int randomX, randomY;
        for (int i = 0; i < 8; i++){
            randomX = random.nextInt(width * 64 - 64);
            randomY = random.nextInt(height * 64 - 64);
            entityManager.addEntity(new Engimon(handler, randomX, randomY, i));
        }



        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);


    }

    public void tick(){
        entityManager.tick() ;
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null){
            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
            }
        }
    }

    public int getSpawnX() { return spawnX; }

    public int getSpawnY() { return spawnY; }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
