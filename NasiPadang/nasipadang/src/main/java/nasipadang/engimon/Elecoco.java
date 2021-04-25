package nasipadang.engimon;

import nasipadang.entities.creatures.Skill;
import nasipadang.gfx.Assets;

public class Elecoco extends SEngimon{

    public Elecoco(int id){

        super(Assets.elecoco,id) ;
        spesies = "Elecoco";
        slogan = "Kesetrum ga kang?";
        element = 'E';
        skillunik = new Skill("Thunderbolt",13 ,element);

    }
}
