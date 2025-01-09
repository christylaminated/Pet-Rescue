import java.util.LinkedList;

public abstract class Zones implements Zoneable {
    public abstract LinkedList<? extends Petable> getPets();
/**
Returns the total number of pets in whatever zone (Bird Cat Chinchilla) calls the method.
 */
    @Override
    public int petsInZone(){
        if(this.getPets().isEmpty()){
            return 0;
        }
        return this.getPets().size();
    }
    public Petable getPet(String petName){
        for(Petable i: this.getPets()){
            if(i.getName().equals(petName)){
                return i;
            }
        }
        return null;
    }
    /**
        Calculaates the heaviest pet in a given petZone using a for each loop that traverses the linked-list and compares
     the weight of each animal to the previous heaviest pet, and if the current pet is heavier the heaviest pet is
     updated to be accurate
     */
    public Petable heaviestPet(){
        if(this.getPets().isEmpty()){
            return null;
        }
        Petable heaviestPet = this.getPets().getFirst();
        int heaviest = 0;
        for(Petable i:this.getPets()){
            if(i.getWeightInOz()>heaviest){
                heaviest = i.getWeightInOz();
                heaviestPet = i;
            }

        }
        return heaviestPet;
    }
/*
    public int petsInZone() {
        if (petList.isEmpty()) {
            return 0;
        } else {
            return petList.size();
        }
    }

 */

   /* public static Pets heaviestPet(LinkedList<Pet> petList) {

        if (petList.isEmpty()) {
            return null;
        }
        Pet Heaviest = petList.get(0);

        for (Pet pet : petList) {
            if(Pet.getWeight())
        }

    }

    */
}


