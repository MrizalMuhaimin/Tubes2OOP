package nasipadang.engimon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElecocoTest {
    private Elecoco E =  new Elecoco(3);
    @Test
    public void Eleco_Test(){
        Elecoco El = new Elecoco(3);
    }

    @Test
    public void spesiesTest(){
        assertEquals("Elecoco",E.spesies);
    }

    @Test
    public void getIdElecoTest(){
        assertEquals(3,E.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("Kesetrum ga kang?",E.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('E',E.element);
    }
}
