package nasipadang.entities.creatures;

import nasipadang.game.Game;
import nasipadang.game.Handler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);
    private Engimon En1 = new Engimon(handler,30,30,1);
    private Engimon En2 = new Engimon(handler,30,30,2);

    @Test
    public void Battle_Test(){
        En1.setElement('W');
        En2.setElement('L');
        Battle B = new Battle(En1, En2);


    }
    @Test
    public void elementAdvChar(){
        En1.setElement('W');
        En2.setElement('L');
        Battle B = new Battle(En1, En2);
        float val = B.elementAdvChart("Water","Fire");
        assertEquals(2,val);

    }
    @Test
    public  void testprintAll(){
        En1.setElement('W');
        En2.setElement('L');
        Battle B = new Battle(En1, En2);
        B.printElement();

    }
    @Test
    public void getElementAdvantagePlayerTest(){
        En1.setElement('W');
        En2.setElement('L');
        Battle B = new Battle(En1, En2);
        float val1 = B.getElementAdvantagePlayer();
        assertEquals(2.0,val1);

    }
    @Test
    public void hitungPowerPlayerTest(){
        En1.setElement('W');
        En2.setElement('L');
        Battle B = new Battle(En1, En2);
        float val1 = B.hitungPowerPlayer();
        assertEquals(13.0,val1);

    }


}
