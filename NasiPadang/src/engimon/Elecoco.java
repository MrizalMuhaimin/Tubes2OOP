package engimon;

import entities.creatures.Skill;
import gfx.Assets;

public class Elecoco extends SEngimon{

    public Elecoco(int id){

        super(Assets.elecoco,id) ;
        spesies = "Elecoco";
        slogan = "Kesetrum ga kang?";
        element = 'E';
        skillunik = new Skill("Thunderbolt",13 ,element);

    }
}
