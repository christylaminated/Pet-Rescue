import java.util.LinkedList;
import java.util.Objects;

public class ChinchillaZone extends Zones implements Zoneable{
    LinkedList<Chinchilla> chinchillas = new LinkedList<>();
    public int pellets=0;
    public int hay=0;
    public ChinchillaZone(LinkedList<Chinchilla> chinchillas){
            this.chinchillas = chinchillas;
    }
    public LinkedList<? extends Petable> getPets(){
        return this.chinchillas;
    }
/**
    Allows abstradct methods to be written in Zones.java to work with every animalZone.
 */

   /* @Override
    public Petable heaviestPet() {
        return null;
    }*/
/**
 Computes the age of the chinchillas in human years (real years times 10 for chinchillas)
 */

    public int inHumanYears(String petName) {
        for(Chinchilla chin: chinchillas){
        if(chin.name.equals(petName)){
            return chin.getAge()*10;
        }
    }
return -1;
    }
/**
    Adds the quantity of either pellets or hay to the pantry.
 */
    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if(Objects.equals(foodName, "pellets")){
            pellets=pellets+foodAmt;
        }
        if(Objects.equals(foodName, "hay")){
            hay=hay+foodAmt;
        }


        return this;
    }

    /**
     *feeds all the chinchillas in the ChinchillaZone and updates the remaining number of pellets and hay.
     *
     */
    @Override
    public Zoneable feedZone() {
        for(Chinchilla chin: chinchillas){
            pellets = pellets - chin.eats("pellets");
            hay = hay - chin.eats("hay");
        }
        return this;
    }

    /*@Override
    public Petable getPet(String petName) {
        return null;
    }*/
    /**
     Tells the user how many pieces of food are in the ChinchillaZone pantry
     */

    @Override
    public String getPantryLabel() {
        if(hay<0&&pellets<0){
            return "Chinchilla: "+"0"+" pellets, "+"0"+" hay";
        }
        if(hay<0){
            return "Chinchilla: "+"0"+" pellets, "+hay+" hay";
        }
        if(pellets<0){
            return "Chinchilla: "+pellets+" pellets, "+"0"+" hay";
        }

        return "Chinchilla: "+pellets+" pellets, "+hay+" hay";
    }
    /**
     Returns the closest pet using a for each loop to compare the distance from the provided coordinates to each pet
     and updates the closest pet everytime a pet is closer, once the linkedlist has been completely traversed it returns
     the closest pet.
     */
    @Override
    public String closestPet(int x, int y) {
        double minDistance = Double.MAX_VALUE;
        String closestPetName = "No Pets Found"; // Initialize with a message in case no pets are found

        for (Chinchilla chinchilla : chinchillas) {
            Coord2D chinchillaLocation = chinchilla.getLocation();
            double distance = Math.sqrt(Math.pow(x - chinchillaLocation.x, 2) + Math.pow(y - chinchillaLocation.y, 2));

            if (distance < minDistance) {
                minDistance = distance;
                closestPetName = chinchilla.getName();
            }
        }

        return closestPetName;
    }

}


//pets in zone, get pet, heaviest pet