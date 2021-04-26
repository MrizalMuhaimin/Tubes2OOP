package engimon;

import entities.creatures.Skill;
import gfx.Assets;

public class Hotcoco extends SEngimon{

    public Hotcoco(int id){

        super(Assets.hotcoco, id) ;
        spesies = "Hotcoco";
        slogan = "panas panas panaaas!";
        element = 'F';
        skillunik = new Skill("Fireball",10, element);

    }
}
