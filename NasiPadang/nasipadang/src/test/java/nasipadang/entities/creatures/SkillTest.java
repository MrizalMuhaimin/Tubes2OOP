package nasipadang.entities.creatures;

import com.sun.jdi.IntegerValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTest {
    private Skill S = new Skill("Fire",20,'W');
    @Test
    public void Skill_test(){
        Skill s = new Skill();
    }

    @Test
    public void Skill(){
        Skill s = new Skill("Fire",20,'W');

    }

    @Test
    public void getnameSkill(){
        Skill s = new Skill("Fire",20,'W');
        assertEquals("Fire",s.getNamaSkill());

    }
    @Test
    public void setnameSkill(){
        Skill s = new Skill("Fire",20,'W');
        s.setNamaSkill("Fire2");
        assertEquals("Fire2",s.getNamaSkill());

    }
    @Test
    public void getBase() {
        assertEquals(20,S.getBase());

    }

    @Test
    public void setBase() {
        S.setBase(10);
        assertEquals(10,S.getBase());
    }
    @Test
    public void getMlevel(){
        assertEquals(1,S.getMlevel());

    }
    @Test
    public void setMlevel() {
        S.setMlevel(2);
        assertEquals(2,S.getMlevel());
    }
    @Test
    public void getMaxMlevel() {
        assertEquals(3,S.getMaxMlevel());
    }

    @Test
    public void getElements() {
        assertEquals('W',S.getElements());


    }
    @Test
    public void setElements() {
        S.setElements('L');
        assertEquals('L',S.getElements());

    }


}
