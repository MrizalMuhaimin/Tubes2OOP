package nasipadang.entities.creatures;
import java.util.ArrayList;


import nasipadang.game.Handler;
import nasipadang.engimon.SEngimon;
import nasipadang.gfx.Assets;

import java.awt.*;
import java.util.Random;

public class Engimon extends Creature {

    private String nama ;
    private String Spesies ;
    private String parentname1 ;
    private String parentname2 ;
    private String parentspesies1 ;
    private String parentspesies2 ;
    protected Integer level ;
    private Integer Life ; // dari nol sampai 3
    private Integer experience ;
    private Integer cummulativeExp ;
    private final Integer maxExp = 5000 ;
    private Character element ;
    private String slogan ;
    private ArrayList<Skill> EngiSkill ;
    protected int idSpesies;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesies() {
        return Spesies;
    }

    public void setSpesies(String spesies) {
        Spesies = spesies;
    }

    public String getParentname1() {
        return parentname1;
    }

    public void setParentname1(String parentname1) {
        this.parentname1 = parentname1;
    }

    public String getParentname2() {
        return parentname2;
    }

    public void setParentname2(String parentname2) {
        this.parentname2 = parentname2;
    }

    public String getParentspesies1() {
        return parentspesies1;
    }

    public void setParentspesies1(String parentspesies1) {
        this.parentspesies1 = parentspesies1;
    }

    public String getParentspesies2() {
        return parentspesies2;
    }

    public void setParentspesies2(String parentspesies2) {
        this.parentspesies2 = parentspesies2;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getCummulativeExp() {
        return cummulativeExp;
    }

    public void setCummulativeExp(Integer cummulativeExp) {
        this.cummulativeExp = cummulativeExp;
    }

    public Integer getMaxExp() {
        return maxExp;
    }

    public Character getElement() {
        return element;
    }

    public void setElement(Character element) {
        this.element = element;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public ArrayList<Skill> getEngiSkill() {
        return EngiSkill;
    }

    public void setEngiSkill(ArrayList<Skill> engiSkill) {
        EngiSkill = engiSkill;
    }

    public Integer getLife() {
        return Life;
    }

    public void setLife(Integer life) {
        Life = life;
    }

        public void levelup(){
        level = experience % 100 ;
    }

    public void addSkill(Skill skill){
        EngiSkill.add(skill) ;
    }

    public int getIdSpesies() { return idSpesies; }

    public void PrintAll() {
        System.out.println("nama engimon   : " + nama);
        System.out.println("spesies engimon    : " + Spesies );
        System.out.println("parent engimon : " + parentname1 + " dan "+ parentname2 );
        System.out.println("parent spesies engimon : " + parentspesies1 + " dan " + parentspesies2);
        System.out.println("elemen engimon    : " + element );
        System.out.println("level engimon  : " + level );
        System.out.println("exp engimon    : " + experience );
        System.out.println("bahasa engimon : " + slogan );
        System.out.println("cummulative : " + cummulativeExp);
        System.out.println("Skill: ");
//        for(int i = 0 ; i < EngiSkill.size() ; i++){
//            System.out.println(EngiSkill.get(i).getNamaSkill());
//        }
    }
    // jika sudah mencapai maxcummulative maka engimon mat
    public Engimon maxcummulative(){
        return null ;
    }

    public boolean isMultipleElement(){
        return (element == 'L' || element == 'S' || element == 'N');
    }

    public boolean isMountainsElement(){
        return (element == 'F' || element == 'L');
    }

    public boolean isSeaElement(){
        return (element == 'W' || element == 'N' || element == 'S');
    }

    public boolean isGrasslandElement(){ return (element == 'E' || element == 'G' || element == 'L' || element == 'N'); }

    public boolean isTundraElement(){
        return (element == 'I' || element == 'S');
    }

    public void addExperience(int exp1){
        experience+=exp1;
        cummulativeExp += exp1;
    }

    public Engimon(Handler handler, float x, float y, int id){
        super(handler, x,y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT  );
        this.nama = "xxx" ;
        this.Spesies = SEngimon.sengimons[idSpesies].spesies ;
        this.parentname1 = "xxxx" ;
        this.parentname2 = "xxxxx" ;
        this.parentspesies1 = "xxxxx" ;
        this.parentspesies2 = "xxxx" ;
        level = 1;
        Life = 3 ;
        experience = 0 ;
        cummulativeExp = 0 ;
        this.slogan = SEngimon.sengimons[idSpesies].slogan;
        element = SEngimon.sengimons[idSpesies].element ;
        EngiSkill = new ArrayList<Skill>() ;
        EngiSkill.add(SEngimon.sengimons[idSpesies].skillunik);
        idSpesies = id;
    }

    private void getInput(){
        int r;
        Random random = new Random();
        xMove = 0;
        yMove = 0;

        r = random.nextInt(20);
        //System.out.println(counter);
        if (r == 0){
            yMove = -speed;
        }
        else if (r == 1){
            yMove = speed;
        }
        else if (r == 2){
            xMove = -speed;
        }
        else if (r == 3){
            xMove = speed;
        }
        else {

        }
    }


    @Override
    public void tick(){
        getInput();
        move();
    }

    @Override
    public void render(Graphics g){
        //g.drawImage(Assets.wageococo, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(String.valueOf(level), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
        SEngimon.sengimons[this.idSpesies].render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
    }
}
