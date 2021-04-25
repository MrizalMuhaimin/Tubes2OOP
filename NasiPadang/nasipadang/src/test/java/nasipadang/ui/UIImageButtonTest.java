package nasipadang.ui;
import java.awt.*;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nasipadang.game.Game;
import nasipadang.game.Handler;
import nasipadang.gfx.Assets;
import nasipadang.states.State;
import nasipadang.ui.ClickListener;
import org.junit.jupiter.api.Test;


public class UIImageButtonTest {
    private Game game = new Game("Nasi Padang",300,150);
    private Handler handler = new Handler(game);
    @Test
    public void UIImageButton_Test(){
        UIManager uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager );

        uiManager.addObject(new UIImageButton(160, 22, 300, 300, Assets.changeActiveEngimonScreen, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
            }
        }));
    }


}
