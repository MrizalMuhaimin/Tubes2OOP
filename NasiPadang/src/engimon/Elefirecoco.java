package engimon;
import entities.creatures.Skill;
import gfx.Assets;
public class Elefirecoco extends SEngimon {

    public Elefirecoco(int id){

        super(Assets.elefirecoco,id) ;
        spesies = "Elefirecoco";
        slogan = "Bzz aku si panas dan cepat.";
        element = 'L';
        skillunik = new Skill("Fire Thunder Bomb",10 ,element);

    }
}
