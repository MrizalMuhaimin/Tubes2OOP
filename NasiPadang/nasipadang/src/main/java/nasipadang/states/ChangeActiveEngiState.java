package nasipadang.states;

import nasipadang.game.Handler;
import nasipadang.gfx.Assets;
import nasipadang.ui.ClickListener;
import nasipadang.ui.UIImageButton;
import nasipadang.ui.UIManager;


import nasipadang.entities.Entity;


import java.awt.*;
import java.util.ArrayList;
import nasipadang.worlds.World ;

public class ChangeActiveEngiState extends State {

    private UIManager uiManager;

    public ChangeActiveEngiState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager );

        uiManager.addObject(new UIImageButton(160, 22, 300, 300, Assets.changeActiveEngimonScreen, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

    public ArrayList<Entity> getWildEngi() { return GameState.getWorld().getEntityManager().getEntities(); }

}

