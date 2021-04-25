package nasipadang.gfx;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage character, grass, water, tundra, mountain;
    public static BufferedImage engiball, hydrococo, icycoco, hotcoco,geococo,elecoco,elefirecoco,wicycoco,wageococo;
    public static BufferedImage changeActiveEngimonScreen;
    public static BufferedImage inventoryScreen;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/world.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/world1.png"));
        SpriteSheet charSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Character.png"));
        SpriteSheet engiSheet = new SpriteSheet(ImageLoader.loadImage("/textures/engimon.png"));
        SpriteSheet engiBallSheet = new SpriteSheet(ImageLoader.loadImage("/textures/engiball.png"));
        SpriteSheet changeActiveEngimonScreenSheet = new SpriteSheet(ImageLoader.loadImage("/textures/changeActiveEngimon.png"));

        //untuk inventory nnti
        //inventoryScreen = ImageLoader.loadImage("/textures/inventory_preset.png");
        changeActiveEngimonScreen =  changeActiveEngimonScreenSheet.crop(0,0,1080, 1080);
        character = charSheet.crop(0, 0, width, height);
        grass = sheet.crop(32, 192, width, height);
        water = sheet.crop(0, 416, width, height);
        tundra = sheet1.crop(64, 64, width, height);
        mountain = sheet1.crop(96, 64, width,height);
        engiball = engiBallSheet.crop(5, 60, 56, 56);
        hydrococo = engiSheet.crop(340,0,55,55) ;
        icycoco = engiSheet.crop(280,220,55,55);
        hotcoco = engiSheet.crop(170,0,55,55) ;
        geococo = engiSheet.crop(505,110,55,55) ;
        elecoco = engiSheet.crop(225,55,55,55) ;
        elefirecoco = engiSheet.crop(785,390,55,55);
        wicycoco = engiSheet.crop(728,335,55,55);
        wageococo = engiSheet.crop(840,560,55,55) ;

    }
}
