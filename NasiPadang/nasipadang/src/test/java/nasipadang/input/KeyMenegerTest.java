package nasipadang.input;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyMenegerTest {

    private KeyManager KeyMenegerTest ;

    @Test
    public void KeyMeneger_Test(){
        KeyMenegerTest = new KeyManager();

    }

    @Test
    public void tickTest(){
        KeyMeneger_Test();
        KeyMenegerTest.tick();

    }

}
