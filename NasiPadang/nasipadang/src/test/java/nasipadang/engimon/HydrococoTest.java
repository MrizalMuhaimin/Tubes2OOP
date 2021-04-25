package nasipadang.engimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydrococoTest {
    private Hydrococo H = new Hydrococo(0);
    @Test
    public void Elefire_Test(){
        Hydrococo He = new Hydrococo(0);
    }
    @Test
    public void spesiesTest(){
        assertEquals("Hydrococo",H.spesies);
    }

    @Test
    public void getIdTest(){
        assertEquals(0,H.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("air air air!",H.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('W',H.element);
    }


}
