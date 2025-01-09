public class Cat extends Pets implements Petable {
    boolean hasBeenPetToday;
/**
Constructor, supers the common parameters across all animal objects allowing the methods to be written for all animals
in a single class (Pets.java)
 */
    public Cat(String name, int age, int weightInOz, Coord2D location, boolean hasBeenPetToday) {
        super(name, age, weightInOz, location);
        this.hasBeenPetToday = hasBeenPetToday;
    }

/**
Feeds the cat according to its attributes; If the eats method is run with cans and the cat has been pet it
eats two cans, else if it hasn't been pet today it only eats one can of food, if it's run with "treats" the cat eats
one treat plus an extra treat for every 8 ounces it weighs.
 */
    public int eats(String foodLabel) {

        if (foodLabel.equals("cans") & hasBeenPetToday) {
            return 2;
        } else if (foodLabel.equals("cans") & !hasBeenPetToday) {
            return 1;
        }else if(foodLabel.equals("treats")){
            return 1 + (getWeightInOz()/8);
        } else {return 0;
        }
    }
}
