package entities.creatures;

import java.util.ArrayList;
import java.util.Scanner;
import gfx.Assets;
import java.awt.Graphics;

import Game.Handler;
import Game.Inventory;
import states.GameState;
import states.State;
import tiles.Tile;
import entities.Entity ;
import java.lang.Math;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author epatatuah
 */
public class Player extends Creature{

    //Engimon
    private Inventory<Engimon> engiInvent;
    //Skill Item
    private Inventory<Skill> skillInvent;
    private int maxInventCapacity = 49;
    private AktifEngimon aktifEngimon ;
    
    public Player(Handler handler, float x, float y){
        super(handler, x,y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT  );
        aktifEngimon = new AktifEngimon(handler, x+Creature.DEFAULT_CREATURE_WIDTH,y, 7);
        engiInvent = new Inventory<Engimon>(handler);
        skillInvent = new Inventory<Skill>(handler);
    }

    // SPEK 1: Menampilkan list dari commands yang tersedia
    public void showAllCommand(){
        //drawImage(gambarInvent)

        //W
        //A
        //S
        //D
        //showListEngimon
        //I (Inventory)
        //

        //Inventory V_KEY_I (I)
        //Battle V_KEY_BATTLE
        //Breeding V_KEY_BREED
    }

    public void showInventory(){
        int engiInventSize = engiInvent.getPlayerInventory().size();
        int skillInventSize = skillInvent.getPlayerInventory().size();
        if (engiInventSize > 0 && skillInventSize > 0){
            for (int i = 0; i<engiInventSize; i++){
                System.out.println("AdaEngi " + i);
            }
        }
        if (skillInventSize > 0){
            for (int i = 0; i<skillInventSize; i++){
                System.out.println("AdaSkill " + i);
            }
        }
    }

    // SPEK 3: Menampilkan list engimon yang dimiliki
    public void showEngimonList(){
        int inventSize = engiInvent.getPlayerInventory().size();
        if (inventSize > 0){
            for (int i = 0; i<inventSize; i++){
                System.out.println("AdaEngi " + i);
            }
        }
    }

    // SPEK 4: Menampilkan data lengkap suatu engimon di inventory (setiap atribut
    //kelas dan setiap atribut skillnya)
    // 1. juga harus menampilkan nama parent beserta spesies mereka
    public void showEngimonData(){
        Engimon chosenEngimon = new Engimon(handler, 200, 340, 2);
        System.out.println("Nama: " + chosenEngimon.getNama());
        System.out.println("Spesies: " + chosenEngimon.getSpesies());
        System.out.println("Parentname1: " + chosenEngimon.getParentname1());
        System.out.println("Parentname2: " + chosenEngimon.getParentname2());
        System.out.println("Parentspesies1: " + chosenEngimon.getParentspesies1());
        System.out.println("Parentspesies2: " + chosenEngimon.getParentspesies2());
        System.out.println("Level: " + chosenEngimon.getLevel());
        System.out.println("Life: " + chosenEngimon.getLife());
        System.out.println("Experience: " + chosenEngimon.getExperience());
        System.out.println("Cumulative Exp: " + chosenEngimon.getCummulativeExp());
        System.out.println("MaxExp: " + chosenEngimon.getMaxExp());
        System.out.println("Element: " + chosenEngimon.getElement());
        System.out.println("Slogan: " + chosenEngimon.getSlogan());
        //System.out.println("EngiSkill: " + chosenEngimon.getEngiSkill());
        System.out.println("idSpesies: " + chosenEngimon.getIdSpesies());
    }

    // SPEK 5: Mengecek dan mengganti active Engimon
    public void changeActiveEngimon(){

    }

    // SPEK 6: Menampilkan list skill item yang dimiliki beserta informasi mengenai atribut skill tersebut (base power
    //dan elemen yang bisa learn skill tersebut)
    public void showItemSkillList(){
        int inventSize = skillInvent.getPlayerInventory().size();
        if (inventSize > 0){
            for (int i = 0; i<inventSize; i++){
                System.out.println("AdaItemSkill " + i);
            }
        }
    }

    // SPEK 7: Menggunakan list skill item pada suatu engimon
    public void useItemSkill(){

    }

    // SPEK 8: Melaksanakan breeding antara 2 engimon
    public void breed(){

    }

    // SPEK 9: battle
    public void battle(){
        if (checkSurroundWildEngimon()){
            Engimon lawan = getNearestWildEngimon();
            Battle battle = new Battle(this.aktifEngimon, lawan);
            //Menampilkan data engimon liar
            lawan.PrintAll();

            //Menampilkan power level
            battle.printPower();

            //Opsi lanjut battle (belum integrasikan dengan GUI, masih terminal based)
            System.out.println("1. Continue");
            System.out.println("2. Cancel");
            System.out.print("Proceed battle ?");
            Scanner input = new Scanner(System.in);
            int masukan = input.nextInt();
            System.out.println(masukan);

            if(masukan == 1){
                //Lanjut Battle
                //Menang
                if(battle.getWinner() == this.aktifEngimon){
                    //Mendapat engimon lawan jika inventory cukup (belum)

                    //Mendapat experience points(hmm sudah)
                    this.aktifEngimon.setExperience(this.aktifEngimon.getExperience() + 30);

                    //Mendapat skill item di slot pertama engimon lawan
                    ArrayList<Skill> skillLawan = lawan.getEngiSkill();
                    this.aktifEngimon.addSkill(skillLawan.get(0));
                    if (skillInvent.getPlayerInventory().size() < (maxInventCapacity - engiInvent.getPlayerInventory().size())){
                        skillInvent.addItem(skillLawan.get(0));
                    }
                    if (engiInvent.getPlayerInventory().size() < (maxInventCapacity - skillInvent.getPlayerInventory().size())){
                        engiInvent.addItem(lawan);
                    }
                    GameState.getWorld().getEntityManager().getEntities().remove(lawan) ;

                } else { //Kalah
                    //Kehilangan 1 life
                    this.aktifEngimon.setLife(this.aktifEngimon.getLife() - 1);
                    if (this.aktifEngimon.getLife() <= 0){
                        //Engimon mati (belum)
                    }
                }

            } else if(masukan == 2){
                //Cancel Battle
            }
            input.close();
        }
    }

    // SPEK 10: Membuang X amount dari suatu skill item atau melepaskan engimon inventory
    public void deleteItem(){

    }

    // SPEK 11: Mengganti nama dari suatu engimon yang ada di inventory
    public void changeEngimonName(){

    }

    // SPEK 12: Save game
    public void saveGame(){

    }

    // SPEK 2: Bergerak ke satu petak ke kiri, kanan, atas, bawah
    private void getInput(){
        xMove = 0;
        yMove = 0;
        aktifEngimon.setxMove(0);
        aktifEngimon.setyMove(0);
        
        if (handler.getKeyManager().up){
            yMove = -speed;
            aktifEngimon.setyMove(-speed) ;
        }
        if (handler.getKeyManager().down){
            yMove = speed;
            aktifEngimon.setyMove(speed);
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
            aktifEngimon.setxMove(-speed);
        }
        if (handler.getKeyManager().right){
            xMove = speed;
            aktifEngimon.setxMove(speed);
        }
        if (handler.getKeyManager().command){
            showAllCommand();
        }
        if (handler.getKeyManager().inventory){
            showInventory();
        }
        if (handler.getKeyManager().battle){
            battle();
        }
        if (handler.getKeyManager().breed){
            breed();
        }
        if (handler.getKeyManager().showEngimonList){
            showEngimonList();
        }
        if (handler.getKeyManager().showEngimonData){
            showEngimonData();
        }
        if (handler.getKeyManager().changeActiveEngimon){
            changeActiveEngimon();
        }
        if (handler.getKeyManager().showItemSkillList){
            showItemSkillList();
        }
        if (handler.getKeyManager().useItemSKill){
            useItemSkill();
        }
    }

    public float calculateDistance(float x, float y, float engiX, float engiY){
        return (float) Math.sqrt((engiY-y)*(engiY-y) + (engiX-x)*(engiX-x));
    }

    public boolean checkSurroundWildEngimon(){

        State gameStateUsed = handler.getGame().gameState;
        ArrayList<Entity> wildEngis = gameStateUsed.getWildEngi();
        for (Entity wildEngi : wildEngis){

                if (wildEngi instanceof Engimon) {
                    if (wildEngi == aktifEngimon){
                        continue ;
                    } else {
                        float distance = calculateDistance(this.getX(), this.getY(), wildEngi.getX(), wildEngi.getY());
                        if (distance < 100) {
                            return true;
                        }
                    }

                }
            }

        return false;

    }

    public Engimon getNearestWildEngimon(){
        if (checkSurroundWildEngimon()){
            State gameStateUsed = handler.getGame().gameState;
            ArrayList<Entity> wildEngis = gameStateUsed.getWildEngi();
            for (Entity wildEngi : wildEngis){
                if (wildEngi instanceof Engimon) {
                    if (wildEngi == aktifEngimon) {
                        continue;
                    } else {
                        float distance = calculateDistance(this.getX(), this.getY(), wildEngi.getX(), wildEngi.getY());
                        if (distance < 60) {
                            return (Engimon) wildEngi;
                        }
                    }
                }

            }
        }
        Engimon defaultEngi = new Engimon(handler, 0, 0, 0);
        return defaultEngi;
    }

    @Override
    public void tick(){
        getInput();
        move();
        aktifEngimon.move();
        handler.getGameCamera().centerOnEntity(this);
        engiInvent.tick();
        skillInvent.tick();

    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.character, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        engiInvent.render(g);
        skillInvent.render(g);
        aktifEngimon.render(g);
    }

    @Override
    public boolean isValidTile() {
        return (x+xMove >= 0 && x+xMove <= handler.getWorld().getWidth() * Tile.TILEWIDTH - Tile.TILEWIDTH*2
                && y+yMove >= 0 && y+yMove <= handler.getWorld().getHeight() * Tile.TILEHEIGHT - Tile.TILEHEIGHT);
    }
}
