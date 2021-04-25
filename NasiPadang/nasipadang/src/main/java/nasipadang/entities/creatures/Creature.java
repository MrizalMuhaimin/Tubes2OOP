package nasipadang.entities.creatures;


import nasipadang.entities.Entity;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import nasipadang.tiles.Tile;
import nasipadang.worlds.World;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;
    
    public Creature(Handler handler, float x, float y,  int width, int height){
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;  
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    public void move(){
        if (isValidTile() && !checkEntityCollisions(xMove,0f)) {
            x += xMove;}
        if (isValidTile() && !checkEntityCollisions(0f,yMove)){
            y += yMove;
        } else {
            System.out.println("Nabrak gan!!!!");
        }
    }

    public boolean isValidTile(){
        return (x+xMove >= 0 && x+xMove <= handler.getWorld().getWidth() * Tile.TILEWIDTH - Tile.TILEWIDTH
                && y+yMove >= 0 && y+yMove <= handler.getWorld().getHeight() * Tile.TILEHEIGHT - Tile.TILEHEIGHT);
    }
    
    //GETTERS SETTERS
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
}
