package nasipadang.states;

import nasipadang.game.Game;
import java.awt.Graphics;
import java.util.ArrayList;
import nasipadang.entities.Entity ;
import nasipadang.worlds.World;

import nasipadang.game.Handler;
import nasipadang.entities.Entity;
import nasipadang.entities.creatures.Engimon;

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