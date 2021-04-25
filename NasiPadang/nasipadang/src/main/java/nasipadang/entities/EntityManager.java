package nasipadang.entities;

import nasipadang.game.Handler;
import nasipadang.entities.creatures.Engimon;
import nasipadang.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Player player ;
    private Handler handler ;
    private ArrayList<Entity> entities ;

    public EntityManager(Handler handler, Player player){
        this.handler = handler ;
        this.player = player ;
        entities = new ArrayList<Entity>() ;

    }

    public void tick(){
        for( int i = 0 ; i < entities.size();i++){
            Entity e = entities.get(i);
            e.tick();
        }
        player.tick();
    }

    public void render(Graphics g){
        for( int i = 0 ; i < entities.size();i++){
            Entity e = entities.get(i);
            e.render(g);
        }
        player.render(g) ;
    }

    public void addEntity(Entity e){
        entities.add(e) ;
    }

    // GETTER dan SETTER

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
