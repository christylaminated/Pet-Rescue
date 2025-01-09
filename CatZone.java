import java.util.LinkedList;
import java.util.Objects;

import static java.lang.Math.abs;

public class CatZone extends Zones implements Zoneable{
    public int cans=0;
    public int treats = 0;
    LinkedList<Cat> cats;
    public CatZone(LinkedList<Cat> cats){
        this.cats=cats;

    }
    public LinkedList<? extends Petable> getPets(){
        return this.cats;
    }
/**
Allows the Zones class methods to work across all animal zones.
 */


    /*@Override
    public Petable heaviestPet() {
        return null;
    }*/

/**
    Returns the cat age in human years (6 human years for every year the cat is alive) and returns -1 if there is no
    cat
 */
    @Override
    public int inHumanYears(String petName) {
        if(cats.isEmpty()){
            return -1;
        }

        Cat cat = (Cat) getPet(petName);
        return cat.age*6;
    }
/**
    Refills  the pantry specific to cat's food (cans of food and treats)
 */
    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if(Objects.equals(foodName, "cans")){
            cans=cans+foodAmt;
        }
        if(Objects.equals(foodName, "treats")){
            treats=treats+foodAmt;
        }


        return this;
    }
/**
    Feeds the cats in the zone and updates the amount of cans and treats remaining after feeding all the cats.
 */
    @Override
    public Zoneable feedZone() {

        for(Cat cat: cats){
            cans = cans - cat.eats("cans");
            treats = treats - cat.eats("treats");
        }
        return this;
    }


    /*public Petable getPet(String petName) {
        return null;
    }*/
/**
    Tells the user how many pieces of food are in the catZone pantry
 */
    @Override
    public String getPantryLabel() {
        if(cans<0&&treats<0){
            return "Cat: "+"0"+" cans, "+"0"+" treats";
        }
        if(cans<0){
            return "Cat: "+"0"+" cans, "+treats+" treats";
        }
        if(treats<0){
            return "Cat: "+cans+" cans, "+"0"+" treats";
        }

        return "Cat: "+cans+" cans, "+treats+" treats";
    }

    /**
    Returns the closest pet using a for each loop to compare the distance from the provided coordinates to each pet
    and updates the closest pet everytime a pet is closer, once the linkedlist has been completely traversed it returns
    the closest pet.
     */
    @Override
    public String closestPet(int x, int y) {
        String petname = "No Pets Found";
        if(cats.isEmpty()){
            return "No Pets Found";
        }
        else{
            for(Cat cat: cats){
                if(cat.location.x==x&&cat.location.y==y){
                    return cat.name;
                }
            }
        }
        petname = cats.getFirst().name;
        int difference = abs(cats.getFirst().location.x - x) + abs(cats.getFirst().location.y - y);
        int difference2;
        for(Cat cat: cats){
            difference2 = abs(cat.location.x - x) + abs(cat.location.y-y);
            if(difference2<difference){
                petname = cat.name;
                difference = difference2;
            }

        }

        return petname;
    }


}
