package nasipadang.gfx;



import nasipadang.game.*;
import nasipadang.entities.*;
import nasipadang.tiles.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GameCameraTest {

    private float xOffset = 30, yOffset= 30;
    private  GameCamera gameCame;
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);

    @Test
    public void GameCamera_Test(){
        gameCame = new GameCamera(handler,xOffset,yOffset);

    }

    @Test
    public void getxOffsetTest(){
        GameCamera_Test();
        float val = gameCame.getxOffset();

        assertEquals(30,val);
    }

    @Test
    public void getyOffsetTest(){
        GameCamera_Test();
        float val = gameCame.getyOffset();

        assertEquals(30,val);
    }

    @Test
    public void setxOffsetTest(){
        GameCamera_Test();
        gameCame.setxOffset(20);
        float val = gameCame.getxOffset();


        assertEquals(20,val);
    }

    @Test
    public void setyOffsetTest(){
        GameCamera_Test();
        gameCame.setyOffset(20);
        float val = gameCame.getyOffset();

        assertEquals(20,val);
    }

}
