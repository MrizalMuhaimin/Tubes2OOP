package states;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Entity;
import entities.creatures.Player;
import entities.creatures.Engimon;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


import tiles.Tile;
import worlds.World;
import Game.Handler;
/**
 *
 * @author epatatuah
 */
public class GameState extends State {
    
    private Player player;
    private static World world;
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "resources/worlds/world1.txt");
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
