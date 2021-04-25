package nasipadang.utils;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static nasipadang.utils.Utils.loadFileAsString;
import static nasipadang.utils.Utils.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {
    @Test
    public void UtilStringTest(){
        String path = loadFileAsString("src/main/resources/worlds/world1.txt");

    }

    @Test
    public void parseIntTest_succses(){
        int val = parseInt("1");
        assertEquals(1,val);


    }
}
