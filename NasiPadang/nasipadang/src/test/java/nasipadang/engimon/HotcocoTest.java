package nasipadang.engimon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotcocoTest {

    private Hotcoco H = new Hotcoco(2);
    @Test
    public void Hotcoco_Test(){
        Hotcoco Hot = new Hotcoco(2);
    }

    @Test
    public void spesiesTest(){
        assertEquals("Hotcoco",H.spesies);
    }


    @Test
    public void getIdHotcocoTest(){
        assertEquals(2,H.id);

    }
    @Test
    public void SloganTest(){
        assertEquals("panas panas panaaas!",H.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('F',H.element);
    }
}

