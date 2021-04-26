package entities;


import java.awt.Graphics;
import Game.Game;
import Game.Handler;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epatatuah
 */
public abstract class Entity {
    
    protected Handler handler; 
    protected float x, y;
    protected int width, height;
    protected Rectangle bound ;
    
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bound = new Rectangle(0,0,width-10,height-10);
    }

    
    public abstract void tick();
    
    public abstract void render(Graphics g);

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue ;
            }
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset))){
                return true ;
            }
        }
        return false ;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x+ bound.x + xOffset), (int)(y + bound.y + yOffset), bound.width, bound.height) ;
    }

    public float getX(){
        return x;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getY(){
        return y;
    }

    public void setY(float y){
        this.y = y;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public Handler getHandler() { return handler; }

    
}
