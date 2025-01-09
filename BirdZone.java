import java.util.LinkedList;
import java.util.Objects;

public class BirdZone extends Zones{
    LinkedList<Bird> birds = new LinkedList<>();
    public int seeds=0;
    public BirdZone(LinkedList<Bird> birds){
        this.birds = birds;
    }
    public LinkedList<? extends Petable> getPets(){
        return this.birds;
    }//allows abstract methods for any type of zone
    //to be wrtiten and work with the abstract class Zones1


    /*public Petable getPet(String petName) {
        return null;
    }*/
/*
Returns the Bird(s) ages in human years by multiplying by 9.
 */


    public int inHumanYears(String petName) {
        /*
        for(Petable i: this.getPets()){
            if(i.getName().equals(petName)){
                return i;
            }
        }
         */
        //*9
        for(Bird bird: birds){
            if(bird.name.equals(petName)){
                return bird.getAge()*9;
            }
        }


        return -1;
    }
    /**
    Restocks the Birds Pet Food with the Food Seeds.
     */

    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if(Objects.equals(foodName, "seeds")){
            seeds=seeds+foodAmt;
        }
        return this;
    }
/**
    Feeds the Birds in the zone and updates the quantity of seeds remaing after feeding.
 */
    @Override
    public Zoneable feedZone() {
//for each loop through each bird to feed it, each birth subtract by the acmount it each
        for(Bird bird: birds){
            seeds=seeds-1;
        }
        return this;
    }
/**
    Tells the user what type of food and how much is in the pantry.
 */

    @Override
    public String getPantryLabel() {
        if(seeds<0){
            return "Bird: 0 seeds";
        }
        return "Bird: " +seeds+" seeds";
    }
    /**
    Returns the closestPet to the coordinates passed as a paramter.
    This is performed by using a for each loop to compare the distance of each Bird in the BirdZone from the provided
    coordinates, and changes the closest distance if the next Bird is closer than the current closest bird, once the
    whole LinkedList has been traversed, it returns the closest bird.
     */

    @Override
    public String closestPet(int x, int y) {
        //if bird is not clipped, has z coordinate of 2
      //  if(birds.getFirst().wingsClipped)
        double minDistance = Double.MAX_VALUE;
        String closestPetName = "No Pets Found"; // Initialize with a message in case no pets are found

        for (Bird bird : birds) {
            Coord2D birdLocation = bird.getLocation();
            double distance = Math.sqrt(Math.pow(x - birdLocation.x, 2) + Math.pow(y - birdLocation.y, 2));
            if(!bird.wingsClipped){
                distance=distance+2;
            }
            if (distance < minDistance) {
                minDistance = distance;
                closestPetName = bird.getName();
            }
        }

        return closestPetName;
    }

}
