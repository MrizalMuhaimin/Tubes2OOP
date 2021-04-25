package nasipadang.engimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IcycocoTest {
    private Icycoco I = new Icycoco(1);
    @Test
    public void Elefire_Test(){
        Icycoco He = new Icycoco(1);
    }
    @Test
    public void spesiesTest(){
        assertEquals("Icycoco",I.spesies);
    }

    @Test
    public void getIdTest(){
        assertEquals(1,I.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("ice, dingiin!!!",I.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('I',I.element);
    }
}
