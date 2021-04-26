package Game;

import entities.creatures.Engimon;
import entities.creatures.Skill;

import java.awt.Graphics;
import java.util.ArrayList;

public class Inventory<T> {
    private Handler handler;
    private boolean active = false;
    private ArrayList<T> playerInventory;

    public Inventory(Handler handler){

        this.handler = handler;
        this.playerInventory = new ArrayList<T>();
    }

    public void addItem(T item){
            playerInventory.add(item);
    }

    public void deleteItem(T item){
        if (playerInventory.size() > 0) {
            playerInventory.remove(item);
        }

    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<T> getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(ArrayList<T> playerInventory) {
        this.playerInventory = playerInventory;
    }

    public void printInventory(){
        int hitung = 0;
        if (this.playerInventory.size() > 0) {
            for (T item : this.playerInventory) {
                hitung += 1;
                System.out.println("ADA BERAPA ITEM : " + hitung);
            }
        } else {
            System.out.println("Kosong Gan");
        }
    }


    public void tick(){
        if (handler.getKeyManager().inventory){
            active = !active;
            printInventory();
        }
        if (!active){
            return;
        }
    }

    public void render(Graphics g){
        if (!active){
            return;
        }
    }
}
