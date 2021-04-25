package nasipadang.states;

import nasipadang.entities.Entity;
import nasipadang.entities.creatures.Player;
import nasipadang.entities.creatures.Engimon;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


import nasipadang.tiles.Tile;
import nasipadang.worlds.World;
import nasipadang.game.Handler;
/**
 *
 * @author epatatuah
 */
public class GameState extends State {

    private Player player;
    private static World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "src/main/resources/worlds/world1.txt");
        handler.setWorld(world);

    }

    @Override
    public void tick(){
        world.tick();

    }

    @Override
    public void render(Graphics g){
        world.render(g);
    }

    public ArrayList<Entity> getWildEngi() { return world.getEntityManager().getEntities(); }

    public static World getWorld() { return world; }
}