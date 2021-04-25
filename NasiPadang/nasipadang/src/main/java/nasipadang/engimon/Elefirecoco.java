package nasipadang.engimon;

import nasipadang.entities.creatures.Skill;
import nasipadang.gfx.Assets;
public class Elefirecoco extends SEngimon {

    public Elefirecoco(int id){

        super(Assets.elefirecoco,id) ;
        spesies = "Elefirecoco";
        slogan = "Bzz aku si panas dan cepat.";
        element = 'L';
        skillunik = new Skill("Fire Thunder Bomb",10 ,element);

    }
}
