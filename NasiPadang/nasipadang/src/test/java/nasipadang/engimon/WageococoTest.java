package nasipadang.engimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WageococoTest {
    private Wageococo W = new Wageococo(7);
    @Test
    public void Elefire_Test(){
        Wageococo He = new Wageococo(7);
    }
    @Test
    public void sloganTest(){
        assertEquals("Wageococo",W.spesies);
    }

    @Test
    public void getIdTest(){
        assertEquals(7,W.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("Jangan berani main main sama tanah dan air.",W.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('N',W.element);
    }

}
