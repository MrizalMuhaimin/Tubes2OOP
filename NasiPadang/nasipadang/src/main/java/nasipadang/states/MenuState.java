package nasipadang.states;


import nasipadang.game.Game;
import nasipadang.states.State;
import nasipadang.entities.Entity;
import java.awt.Graphics;
import java.util.ArrayList;
import nasipadang.game.Handler;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

