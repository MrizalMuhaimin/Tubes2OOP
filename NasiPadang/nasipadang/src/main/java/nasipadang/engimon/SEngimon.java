package nasipadang.engimon;

import nasipadang.entities.creatures.Skill;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SEngimon {

    public static SEngimon[] sengimons = new SEngimon[256];
    public static SEngimon Hydrococoengimon = new Hydrococo(0);
    public static SEngimon Icycocoengimon = new Icycoco(1);
    public static SEngimon Hotcocoengimon = new Hotcoco(2);
    public static SEngimon Elecocoengimon = new Elecoco(3);
    public static SEngimon Geococoengimon = new Geococo(4);
    public static SEngimon Elefirecocoengimon = new Elefirecoco(5);
    public static SEngimon Wicycocoengimon = new Wicycoco(6);
    public static SEngimon Wageococoengimon = new Wageococo(7);

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public String spesies;
    public String slogan;
    public Character element;
    public Skill skillunik;

    public SEngimon(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        sengimons[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
