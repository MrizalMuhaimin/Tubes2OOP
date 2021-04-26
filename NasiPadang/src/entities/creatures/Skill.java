package entities.creatures;

public class Skill {
    private String namaSkill ;
    private Integer base ;
    private Integer Mlevel ;
    private final Integer maxMlevel = 3 ;
    private Character Elements ;

    public Skill(){
        namaSkill = "XXX" ;
        base = 0 ;
        Mlevel = 0 ;
        Elements = 'x' ;
    }

    public Skill(String nama, Integer val, Character x) {
        Mlevel = 1 ;
        base = val ;
        namaSkill = nama ;
        Elements = x ;

    }

    public void incrementMLevel() {

    }

    public String getNamaSkill() {
        return namaSkill;
    }

    public void setNamaSkill(String namaSkill) {
        this.namaSkill = namaSkill;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getMlevel() {
        return Mlevel;
    }

    public void setMlevel(Integer mlevel) {
        Mlevel = mlevel;
    }

    public Integer getMaxMlevel() {
        return maxMlevel;
    }

    public Character getElements() {
        return Elements;
    }

    public void setElements(Character elements) {
        Elements = elements;
    }
}
