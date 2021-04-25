package nasipadang.engimon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeococoTest {
    private Geococo g = new Geococo(4);
    @Test
    public void Geococo_Test(){
        Geococo geo = new Geococo(4);
    }
    @Test
    public void spesiesTest(){
        assertEquals("Geococo",g.spesies);
    }

    @Test
    public void getIdTest(){
        assertEquals(4,g.id);
    }

    @Test
    public void SloganTest(){
        assertEquals("Semua yang dari tanah kembali ke tanah",g.slogan);

    }

    @Test
    public void ElemenTest(){
        assertEquals('G',g.element);
    }
}
