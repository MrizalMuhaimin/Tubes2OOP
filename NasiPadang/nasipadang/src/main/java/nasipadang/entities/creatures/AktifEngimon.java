package nasipadang.entities.creatures;

import nasipadang.game.Handler;
import nasipadang.engimon.SEngimon;
import nasipadang.gfx.Assets;
import nasipadang.tiles.Tile;

import java.awt.*;

public class AktifEngimon extends Engimon {
    public AktifEngimon(Handler handler, float x, float y, int id) {
        super(handler, x, y, id);
    }

    @Override
    public boolean isValidTile() {
        return (x+xMove >= Tile.TILEWIDTH && x+xMove <= handler.getWorld().getWidth() * Tile.TILEWIDTH - Tile.TILEWIDTH
                && y+yMove >= 0 && y+yMove <= handler.getWorld().getHeight() * Tile.TILEHEIGHT - Tile.TILEHEIGHT);
    }

    @Override
    public void render(Graphics g) {
        SEngimon.sengimons[idSpesies].render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
        g.drawImage(Assets.engiball, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 16, 16, null);
    }
}
