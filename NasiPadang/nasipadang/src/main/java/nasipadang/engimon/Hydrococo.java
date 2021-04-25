package nasipadang.engimon;

import nasipadang.entities.creatures.Skill;
import nasipadang.gfx.Assets;

public class Hydrococo extends SEngimon{

    public Hydrococo(int num){

        super(Assets.hydrococo, num);
        spesies = "Hydrococo";
        slogan = "air air air!";
        element = 'W';
        skillunik = new Skill("Waterball", 11, element);

    }
}
