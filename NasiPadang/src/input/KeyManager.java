/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author epatatuah
 */
public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public boolean up, down, left, right, command, inventory, battle, breed, showEngimonList, showEngimonData, changeActiveEngimon, showItemSkillList, useItemSKill;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        command = keys[KeyEvent.VK_C];
        inventory = keys[KeyEvent.VK_I];
        battle = keys[KeyEvent.VK_B];
        breed = keys[KeyEvent.VK_F];
        showEngimonList = keys[KeyEvent.VK_1];
        showEngimonData = keys[KeyEvent.VK_2];
        changeActiveEngimon = keys[KeyEvent.VK_3];
        showItemSkillList = keys[KeyEvent.VK_4];
        useItemSKill = keys[KeyEvent.VK_5];


    }
    
    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed!");
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
}
