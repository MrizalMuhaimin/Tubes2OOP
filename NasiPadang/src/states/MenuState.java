package states;


import Game.Game;
import entities.Entity;
import states.State;
import java.awt.Graphics;
import java.util.ArrayList;

import Game.Handler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epatatuah
 */
public class MenuState extends State{
    public MenuState(Handler handler){
        super(handler);
    }
    
    @Override
    public void tick(){
        if (handler.getMouseManager().isLeftPressed()){
            State.setState(handler.getGame().gameState);
        }
    }
    
    @Override
    public void render(Graphics g){
        
    }

    public ArrayList<Entity> getWildEngi() { return GameState.getWorld().getEntityManager().getEntities(); }
}
