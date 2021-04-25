package nasipadang.engimon;

import nasipadang.gfx.ImageLoader;
import nasipadang.gfx.SpriteSheet;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SEngimonTest {
    private SpriteSheet engiSheet =  new SpriteSheet(ImageLoader.loadImage("/textures/engimon.png"));;
    private BufferedImage icycoco = engiSheet.crop(280,220,55,55);
    private   SEngimon SE = new SEngimon(icycoco,1);

    @Test
    public void SEngimon_Test(){
        SEngimon S = new SEngimon(icycoco,1);

    }
    @Test
    public void renderTest(){
        assertEquals(1,SE.getId());
    }

}
