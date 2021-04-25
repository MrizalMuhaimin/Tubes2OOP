package nasipadang.engimon;

import nasipadang.entities.creatures.Skill;
import nasipadang.gfx.Assets;
public class Geococo extends SEngimon {

    public Geococo(int id) {

        super(Assets.geococo, id);
        spesies = "Geococo";
        slogan = "Semua yang dari tanah kembali ke tanah";
        element = 'G';
        skillunik = new Skill("Meteor",14 ,element);

    }

}
