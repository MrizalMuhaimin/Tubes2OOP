package nasipadang.entities.creatures;

import java.util.ArrayList;

public class Battle{
    protected Engimon player;
    protected Engimon lawan;
    protected ArrayList<String> elementsPlayer; //elemen dari player
    protected ArrayList<String> elementsLawan; //elemen dari lawan
    protected int countElementsPlayer; //jumlah elemen dari player
    protected int countElementsLawan; //jumlah elemen dari lawan

    public Battle(Engimon player, Engimon lawan) {
        this.player = player;
        this.lawan = lawan;
    
        //Inisiasi elemen berdasarkan character 
        if(player.getElement() == 'W'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Water");
            this.countElementsPlayer = 1;
        }else if(player.getElement() == 'I'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Ice");
            this.countElementsPlayer = 1;
        }else if(player.getElement() == 'F'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Fire");
            this.countElementsPlayer = 1;
        }else if(player.getElement() == 'G'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Ground");
            this.countElementsPlayer = 1;
        }else if(player.getElement() == 'E'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Electric");
            this.countElementsPlayer = 1;
        }else if(player.getElement() == 'L'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Fire");
            this.elementsPlayer.add("Electric");
            this.countElementsPlayer = 2;
        }else if(player.getElement() == 'S'){
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Water");
            this.elementsPlayer.add("Ice");
            this.countElementsPlayer = 2;
        }else{
            this.elementsPlayer = new ArrayList<String>();
            this.elementsPlayer.add("Water");
            this.elementsPlayer.add("Ground");
            this.countElementsPlayer = 2;
        }
    
        //Inisiasi elemen lawan
        if(lawan.getElement() == 'W'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Water");
            this.countElementsLawan = 1;
        }else if(lawan.getElement() == 'I'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Ice");
            this.countElementsLawan = 1;
        }else if(lawan.getElement() == 'F'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Fire");
            this.countElementsLawan = 1;
        }else if(lawan.getElement() == 'G'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Ground");
            this.countElementsLawan = 1;
        }else if(lawan.getElement() == 'E'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Electric");
            this.countElementsLawan = 1;
        }else if(lawan.getElement() == 'L'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Fire");
            this.elementsLawan.add("Electric");
            this.countElementsLawan = 2;
        }else if(lawan.getElement() == 'S'){
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Water");
            this.elementsLawan.add("Ice");
            this.countElementsLawan = 2;
        }else{
            this.elementsLawan = new ArrayList<String>();
            this.elementsLawan.add("Water");
            this.elementsLawan.add("Ground");
            this.countElementsLawan = 2;
        }
    }    
    
    //element advantage chart
    public float elementAdvChart(String elementPlayer, String elementLawan){
        if(elementPlayer.equals("Fire")){
            if(elementLawan.equals("Fire")) return 1;
            else if(elementLawan.equals("Water")) return 0;
            else if(elementLawan.equals("Electric")) return 1;
            else if(elementLawan.equals("Ground")) return 0.5f;
            else return 2;
        } else if(elementPlayer.equals("Water")){
            if(elementLawan.equals("Fire")) return 2;
            else if(elementLawan.equals("Water")) return 1;
            else if(elementLawan.equals("Electric")) return 0;
            else if(elementLawan.equals("Ground")) return 1;
            else return 1;
        } else if(elementPlayer.equals("Electric")){
            if(elementLawan.equals("Fire")) return 1;
            else if(elementLawan.equals("Water")) return 2;
            else if(elementLawan.equals("Electric")) return 1;
            else if(elementLawan.equals("Ground")) return 0;
            else return 1.5f;
        } else if(elementPlayer.equals("Ground")){
            if(elementLawan.equals("Fire")) return 1.5f;
            else if(elementLawan.equals("Water")) return 1;
            else if(elementLawan.equals("Electric")) return 2;
            else if(elementLawan.equals("Ground")) return 1;
            else return 0;
        } else{
            if(elementLawan.equals("Fire")) return 0;
            else if(elementLawan.equals("Water")) return 1;
            else if(elementLawan.equals("Electric")) return 0.5f;
            else if(elementLawan.equals("Ground")) return 2;
            else return 1;
        }
    }
    
    //Menampilkan element engimon
    public void printElement(){
        System.out.println("Element Engimon Player: ");
        for(int i = 0; i < this.countElementsPlayer; i++){
            System.out.println(this.elementsPlayer.get(i));
        }
        System.out.println("Element Engimon Lawan: ");
        for(int i = 0; i < this.countElementsLawan; i++){
            System.out.println(this.elementsLawan.get(i));
        }
    }
    
    //Getter element advantage player engimon
    public float getElementAdvantagePlayer(){
        float max = 0;
        for (int i = 0; i < this.countElementsPlayer; i++){
            for(int j = 0; j < this.countElementsLawan; j++){
                if(elementAdvChart(this.elementsPlayer.get(i), this.elementsLawan.get(j)) > max) max = elementAdvChart(this.elementsPlayer.get(i), this.elementsLawan.get(j));
            }
        }
        return max;
    }
    
    //Menghtung power dari player
    public float hitungPowerPlayer(){
        float sum = 0;
        for(Skill skill : this.player.getEngiSkill()){
            sum += skill.getBase() * skill.getMlevel();
        }
    
        return (this.player.getLevel() * this.getElementAdvantagePlayer()) + sum;
    }
    
    //Getter element advantage lawan
    public float getElementAdvantageLawan(){
        float max = 0;
        for (int i = 0; i < this.countElementsLawan; i++){
            for(int j = 0; j < this.countElementsPlayer; j++){
                if(elementAdvChart(this.elementsLawan.get(i), this.elementsPlayer.get(i)) > max) max = elementAdvChart(this.elementsLawan.get(i), this.elementsPlayer.get(i));
            }
        }
        return max;
    }
    
    //Menghitung power lawan
    public float hitungPowerLawan(){
        float sum = 0;
        for(Skill skill : this.lawan.getEngiSkill()){
            sum += skill.getBase() * skill.getMlevel();
        }
        return (this.lawan.getLevel() * this.getElementAdvantageLawan()) + sum;
    }

    //Getter elementsPlayer
    public ArrayList<String> getElementsPlayer(){ return this.elementsPlayer; }

    //Getter elementsPlayer
    public ArrayList<String> getElementsLawan(){ return this.elementsLawan; }

    //Getter player engimon
    public Engimon getPlayer(){
        return this.player;
    }
    
    //Getter engimon lawan
    public Engimon getLawan(){
        return this.lawan;
    }
    
    //Menampilkan power kedua engimon
    public void printPower(){
        System.out.println("Power Level Engimon Player: " + this.hitungPowerPlayer());
        System.out.println("Power Level Engimon Lawan: " + this.hitungPowerLawan());
    }
    
    //Getter pemenang battle
    public Engimon getWinner(){
        if(this.hitungPowerPlayer() >= this.hitungPowerLawan()) return this.player;
        else return this.lawan;
    }
    
    //Menampilkan hasil battle
    public void runResult(){
        if(this.getWinner() == this.getLawan()){
           System.out.println("Yahhh, Kalah");
        }else{
            System.out.println("Yeay, menang");
        }
    }
}