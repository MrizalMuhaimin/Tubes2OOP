package nasipadang.entities.creatures;

import nasipadang.display.Display;
import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngimonTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);
    private Engimon En = new Engimon(handler,30,30,2);

    @Test
    public void Engimon_Test(){
        Engimon E = new Engimon(handler,30,30,2);
    }


    @Test
    public void renderTest(){
        Display display  = new Display("Nasi Padang", 300, 150);
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        Graphics g ;
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        Engimon E = new Engimon(handler,30,30,2);
        E.render(g);

    }
    @Test
    public void setNameTest(){
        En.setNama("Rizal");
        assertEquals("Rizal",En.getNama());


    }
    @Test
    public void setName(){
        En.setSpesies("mamalia");
        assertEquals("mamalia",En.getSpesies());


    }
    @Test
    public void setPerentname1(){
        En.setParentname1("hidro");
        assertEquals("hidro",En.getParentname1());
    }
    @Test
    public void setPerentname2(){
        En.setParentname2("fire");
        assertEquals("fire",En.getParentname2());
    }

    @Test
    public void setPerentSpesies1(){
        En.setParentspesies1("mamut");
        assertEquals("mamut",En.getParentspesies1());
    }
    @Test
    public void setPerentSpesies2(){
        En.setParentspesies2("kucing");
        assertEquals("kucing",En.getParentspesies2());
    }
    @Test
    public void getLevel(){
        En.setLevel(10);
        assertEquals(10,En.getLevel());
    }

    @Test
    public void setEoerience(){
        En.setExperience(30);
        assertEquals(30,En.getExperience());
    }

    @Test
    public void setCummulativeExp(){
        En.setCummulativeExp(30);
        assertEquals(30,En.getCummulativeExp());
    }
    @Test
     public void getMaeExp(){
        int val = En.getMaxExp();
        assertEquals(5000,val);
    }

    @Test
    public void setElement(){
        En.setElement('L');
        assertEquals('L',En.getElement());
    }

    @Test
    public void setSlogan(){
        En.setSlogan("Ayo belajar buat ujian");
        assertEquals("Ayo belajar buat ujian", En.getSlogan());
    }
    @Test
    public void getSkill(){
        ArrayList<Skill> n = En.getEngiSkill();
    }

    @Test
    public void setLive(){
        En.setLife(2);
        assertEquals(2,En.getLife());
    }

    @Test
    public void leveup(){
        En.levelup();
    }

    @Test
    public void idSpeseie(){
        assertEquals(2,En.getIdSpesies());
    }
    @Test
    public void TestPrinAll(){
        En.PrintAll();
    }
    @Test
    public void AddSkill(){
        Skill n = new Skill();
        En.addSkill(n);
    }
    @Test
    public void ismultipefalse(){
        boolean a = En.isMultipleElement();
        assertEquals(false,a);
    }

    @Test
    public void ismultipettue(){
        En.setElement('L');
        boolean a = En.isMultipleElement();
        assertEquals(true,a);
    }

}
