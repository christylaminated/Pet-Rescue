public class Bird extends Pets implements Petable {

    public boolean wingsClipped;

    public Bird(String name, int age, int weightInOz, Coord2D location, boolean wingsClipped) {
        super(name, age, weightInOz, location);
        this.wingsClipped = wingsClipped;
    }//Constructor


    @Override
    //eats method specific to birds.

    public int eats(String foodLabel) {
        if (foodLabel.equals("seeds")) {
            return 1;
        } else {
            return 0;
        }
    }
}