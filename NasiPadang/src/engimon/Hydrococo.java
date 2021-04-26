package engimon;

import entities.creatures.Skill;
import gfx.Assets;

public class Hydrococo extends SEngimon{

    public Hydrococo(int num){

        super(Assets.hydrococo, num);
        spesies = "Hydrococo";
        slogan = "air air air!";
        element = 'W';
        skillunik = new Skill("Waterball", 11, element);

    }
}
