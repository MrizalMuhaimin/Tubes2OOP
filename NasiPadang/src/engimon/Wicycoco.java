package engimon;

import entities.creatures.Skill;
import gfx.Assets;

public class Wicycoco extends SEngimon{

    public Wicycoco(int id){

        super(Assets.wicycoco, id) ;
        spesies = "Wicycoco";
        slogan = "Water Ice basah dingin !!!";
        element = 'S';
        skillunik = new Skill("Icy Rain",10 ,element);

    }
}
