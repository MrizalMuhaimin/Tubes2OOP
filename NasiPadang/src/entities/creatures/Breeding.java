package entities.creatures;

import entities.Entity;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import engimon.SEngimon;

public class Breeding {
    private Engimon child;
    private Engimon parentA;
    private Engimon parentB;

    public Breeding(Engimon A, Engimon B) {
        if (A.getLevel() >= 4 && B.getLevel() >= 4 && A.getNama() != B.getNama()){
            parentA = A;
            parentB = B;
            child = new Engimon(parentA.getHandler(), 0, 0 , resultingSpesiesElements());
            inheritSkill();

            // Level parent berkurang 3
            parentA.setLevel(parentA.getLevel()-3);
            parentB.setLevel(parentB.getLevel()-3);

            child.setParentname1(parentA.getNama());
            child.setParentname2(parentB.getNama());
            child.setParentspesies1(parentA.getSpesies());
            child.setParentspesies2(parentB.getSpesies());

            // memberikan nama pada engimon hasil breeding
            Scanner input = new Scanner(System.in);
            System.out.print("Elemen anak hasil breeding adalah ");
            System.out.println(child.getElement());
            System.out.print("Spesies anak hasil breeding adalah ");
            System.out.println(child.getSpesies());
            System.out.print("Masukkan nama anak hasil breeding: ");
            String childName = input.nextLine();
            child.setNama(childName);
            input.close();

        } else {
            if (A.getNama() == B.getNama()){
                System.out.println("Kedua parent tidak boleh sama");
            } else {
                System.out.println("Level parent tidak cukup");
            }
        }
    }

    public Engimon getChild(){
        return child;
    }
    public Engimon getParentA(){
        return parentA;
    }
    public Engimon getParentB() { return parentB; }

    public int resultingSpesiesElements() {

        Random random = new Random();
        int r;
        int id = 0;
        String elementA;
        String elementB;
        Battle breedElement = new Battle(parentA, parentB);

        // cek multiple elemen
        if (parentA.isMultipleElement()){
            r = random.nextInt(2);
            elementA = breedElement.getElementsPlayer().get(r);
        } else {
            elementA = breedElement.getElementsPlayer().get(0);
        }
        if (parentB.isMultipleElement()){
            r = random.nextInt(2);
            elementB = breedElement.getElementsLawan().get(r);
        } else {
            elementB = breedElement.getElementsLawan().get(0);
        }

        // jika elemen kedua parent sama
        if (elementA == elementB){

            r = random.nextInt(2);
            if (r == 0){
                id = parentA.getIdSpesies();
            } else {
                id = parentB.getIdSpesies();
            }
        }
        // jika elemen kedua parent beda
        else {

            if (breedElement.elementAdvChart(elementA, elementB) != 1) {
                if (breedElement.elementAdvChart(elementA, elementB) > 1) {
                    id = parentA.getIdSpesies();
                } else {
                    id = parentB.getIdSpesies();
                }
            }
            // jika kedua elemen memiliki element advantage yang sama
            else {
                if ((elementA == "Fire" && elementB == "Electric") || (elementB == "Fire" && elementA == "Electric")) {
                    id = 5;
                } else if ((elementA == "Water" && elementB == "Ice") || (elementB == "Water" && elementA == "Ice")) {
                    id = 6;
                } else { //((elementA == "Water" && elementB == "Ground") || (elementB == "Water" && elementA == "Ground"))
                    id = 7;
                }
            }
        }

        return id;
    }

    public void inheritSkill() {
        ArrayList<Skill> parentASkills = parentA.getEngiSkill();
        ArrayList<Skill> parentBSkills = parentB.getEngiSkill();
        int idxA = parentASkills.indexOf(SEngimon.sengimons[child.getIdSpesies()]);
        int idxB = parentBSkills.indexOf(SEngimon.sengimons[child.getIdSpesies()]);

        // jika parent mempunyai skill unik anak
        if (idxA != -1) {
            child.getEngiSkill().remove(SEngimon.sengimons[child.getIdSpesies()]);
            if (idxB != -1) {
                if (parentASkills.get(idxA).getMlevel() > parentBSkills.get(idxB).getMlevel()) {
                    child.getEngiSkill().add(parentASkills.get(idxA));
                    parentASkills.remove(parentASkills.get(idxA));
                } else {
                    child.getEngiSkill().add(parentBSkills.get(idxB));
                    parentBSkills.remove(parentBSkills.get(idxB));
                }
            } else {
                child.getEngiSkill().add(parentASkills.get(idxA));
                parentASkills.remove(parentASkills.get(idxA));
            }
        } else if (idxB != -1) {
            child.getEngiSkill().remove(SEngimon.sengimons[child.getIdSpesies()]);
            child.getEngiSkill().add(parentBSkills.get(idxB));
            parentBSkills.remove(parentBSkills.get(idxB));
        }

        while (child.getEngiSkill().size() < 4 && (parentASkills.size() + parentBSkills.size() > 0)) {
            Skill maksMlevel = new Skill();
            for (Skill parentSkill : parentASkills) {
                if (parentSkill.getMlevel() > maksMlevel.getMlevel()){
                    maksMlevel = parentSkill;
                }
            }
            for (Skill parentSkill : parentBSkills) {
                if (parentSkill.getMlevel() > maksMlevel.getMlevel()){
                    maksMlevel = parentSkill;
                }
            }

            idxA = parentASkills.indexOf(maksMlevel);
            idxB = parentBSkills.indexOf(maksMlevel);

            // jika skill dimiliki kedua parent
            if ((idxA != -1) && (idxB != -1)) {
                if (parentASkills.get(idxA).getMlevel() == parentBSkills.get(idxB).getMlevel()){
                    maksMlevel.incrementMLevel();
                }
            }
            child.getEngiSkill().add(maksMlevel);

            if (idxA != -1) {
                parentASkills.remove(maksMlevel);
            }
            if (idxB != -1) {
                parentBSkills.remove(maksMlevel);
            }
        }
    }
}
