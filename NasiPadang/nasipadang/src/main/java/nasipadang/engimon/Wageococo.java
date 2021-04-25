package nasipadang.engimon;
import nasipadang.entities.creatures.Skill;
import nasipadang.gfx.Assets;

public class Wageococo extends SEngimon{

    public Wageococo(int id){

        super(Assets.wageococo, id) ;
        spesies = "Wageococo";
        slogan = "Jangan berani main main sama tanah dan air.";
        element = 'N';
        skillunik = new Skill("Ground Steam", 12, element);

    }

}
