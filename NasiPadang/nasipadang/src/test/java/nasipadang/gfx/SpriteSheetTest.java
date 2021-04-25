package nasipadang.gfx;

import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

public class SpriteSheetTest {
    private static final int width = 32, height = 32;
    public static BufferedImage grass, water, dirt;
    private SpriteSheet sheet;

    @Test
    public  void SpriteSheet_Test(){
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/world.png"));

    }
    @Test
    public void lingkunganTest() {
        SpriteSheet_Test();
        grass = sheet.crop(32, 192, width, height);
        water = sheet.crop(0, 416, width, height);
        dirt = sheet.crop(224, 160, width, height);
    }

}

