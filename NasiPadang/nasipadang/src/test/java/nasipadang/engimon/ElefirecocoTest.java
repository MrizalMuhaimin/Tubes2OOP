package nasipadang.engimon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElefirecocoTest {
    private Elefirecoco E = new Elefirecoco(5);
    @Test
    public void Elefire_Test(){
        Elefirecoco E = new Elefirecoco(5);
    }
    @Test
    public void spesiesTest(){
        assertEquals("Elefirecoco",E.spesies);
    }

    @Test
    public void getIdTest(){
        assertEquals(5,E.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("Bzz aku si panas dan cepat.",E.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('L',E.element);
    }


}
