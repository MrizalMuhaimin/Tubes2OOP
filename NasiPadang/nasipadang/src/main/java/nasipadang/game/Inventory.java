package nasipadang.game;


import nasipadang.entities.creatures.Engimon;
import nasipadang.entities.creatures.Skill;

import java.awt.Graphics;
import java.util.ArrayList;

public class Inventory<T> {
    private Handler handler;
    private boolean active = false;
    private ArrayList<T> playerInventory;
    private int maxCapacity;

    public Inventory(Handler handler, int maxCapacity){

        this.handler = handler;
        this.maxCapacity = maxCapacity;
        this.playerInventory = new ArrayList<T>();
    }

    public void addItem(T item){
        if (playerInventory.size() <= maxCapacity){
            playerInventory.add(item);
        }

    }

    public void deleteItem(T item){
        if (playerInventory.size() > 0) {
            playerInventory.remove(item);
        }

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
