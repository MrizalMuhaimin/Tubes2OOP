package nasipadang.gfx;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

public class ImageLoaderTest {
    @Test
    public void ImageLoaderBufferImageTest(){
        ImageLoader.loadImage("/textures/character.png");
    }
}
