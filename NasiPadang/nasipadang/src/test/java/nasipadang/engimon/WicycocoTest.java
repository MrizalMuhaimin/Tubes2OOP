package nasipadang.engimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WicycocoTest {
    private Wicycoco W = new Wicycoco(6);
    @Test
    public void Elefire_Test(){
        Wicycoco He = new Wicycoco(6);
    }
    @Test
    public void sloganTest(){
        assertEquals("Wicycoco",W.spesies);
    }

    @Test
    public void getIdTest(){
        assertEquals(6,W.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("Water Ice basah dingin !!!",W.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('S',W.element);
    }




}
