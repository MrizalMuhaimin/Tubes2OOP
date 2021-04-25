package nasipadang.engimon;

import nasipadang.entities.creatures.Skill;
import nasipadang.gfx.Assets;
public class Icycoco extends SEngimon{

    public Icycoco(int id){

        super(Assets.icycoco, id);
        spesies = "Icycoco";
        slogan = "ice, dingiin!!!";
        element = 'I';
        skillunik = new Skill("Icespike",10 ,element);

    }
}
