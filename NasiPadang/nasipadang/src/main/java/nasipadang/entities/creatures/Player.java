package nasipadang.entities.creatures;

import java.util.ArrayList;
import java.util.Scanner;
import nasipadang.gfx.Assets;
import java.awt.Graphics;

import nasipadang.game.Handler;
import nasipadang.game.Inventory;
import nasipadang.states.State;
import nasipadang.tiles.Tile;
import nasipadang.entities.Entity ;
import java.lang.Math;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Player extends Creature{

    private Inventory inventory;
    private AktifEngimon aktifEngimon ;
    
    public Player(Handler handler, float x, float y){
        super(handler, x,y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT  );
        aktifEngimon = new AktifEngimon(handler, x+Creature.DEFAULT_CREATURE_WIDTH,y, 7);
        inventory = new Inventory(handler, 49);
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

    // SPEK 3: Menampilkan list engimon yang dimiliki
    public void showEngimonList(){

    }

    // SPEK 4: Menampilkan data lengkap suatu engimon di inventory (setiap atribut
    //kelas dan setiap atribut skillnya)
    // 1. juga harus menampilkan nama parent beserta spesies mereka
    public void showEngimonData(){

    }

    // SPEK 5: Mengecek dan mengganti active Engimon
    public void changeActiveEngimon(){

    }

    // SPEK 6: Menampilkan list skill item yang dimiliki beserta informasi mengenai atribut skill tersebut (base power
    //dan elemen yang bisa learn skill tersebut)
    public void showSkillItemList(){

    }

    // SPEK 7: Menggunakan list skill item pada suatu engimon
    public void useSkillItem(){

    }

    // SPEK 8: Melaksanakan breeding antara 2 engimon
    public void breed(){

    }

    // SPEK 9: battle
    public void battle(Engimon lawan){
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
    }

    public boolean checkSurroundWildEngimon(){

        State gameStateUsed = handler.getGame().gameState;
        ArrayList<Entity> wildEngis = gameStateUsed.getWildEngi();
        for (Entity wildEngi : wildEngis){

                if (wildEngi instanceof Engimon) {
                    if (wildEngi == aktifEngimon){
                        continue ;
                    } else {
                        float xSelisih = Math.abs(this.getX() - wildEngi.getX());
                        float ySelisih = Math.abs(this.getY() - wildEngi.getY());
                        if (xSelisih < 32 && ySelisih < 32) {
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
                        float xSelisih = Math.abs(this.getX() - wildEngi.getX());
                        float ySelisih = Math.abs(this.getY() - wildEngi.getY());

                        if (xSelisih < 32 && ySelisih < 32) {
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
        inventory.tick();
        if (checkSurroundWildEngimon()){
            Engimon lawan = getNearestWildEngimon();
            battle(lawan);
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.character, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        inventory.render(g);
        aktifEngimon.render(g);
    }

    @Override
    public boolean isValidTile() {
        return (x+xMove >= 0 && x+xMove <= handler.getWorld().getWidth() * Tile.TILEWIDTH - Tile.TILEWIDTH*2
                && y+yMove >= 0 && y+yMove <= handler.getWorld().getHeight() * Tile.TILEHEIGHT - Tile.TILEHEIGHT);
    }
}
