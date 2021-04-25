package nasipadang.display;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DisplayTest {
    private JFrame hopeFrame;
    private  Canvas hopeCanvas;

    private String title = "Nasi Padang";
    private int width = 30, height= 30;
    private Display displayTest;

    @Test
    public void Display_Test(){
        displayTest = new Display(title,width,width);
    }


    @Test
    public void getCanvasTest(){
        Display_Test();
        Canvas resultCanvas = displayTest.getCanvas();

    }
    @Test
    public void getFrameTest(){
        Display_Test();
        JFrame resultJframe = displayTest.getFrame();
    }
}
