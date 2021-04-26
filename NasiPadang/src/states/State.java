package states;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Game.Game;
import java.awt.Graphics;
import java.util.ArrayList;
import  entities.Entity ;
import worlds.World;

import Game.Handler;
import entities.Entity;
import entities.creatures.Engimon;

/**
 *
 * @author epatatuah
 */
public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    protected Handler handler;
   
    public State(Handler handler){
        this.handler = handler;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);

    public abstract ArrayList<Entity> getWildEngi();
    
}