import java.util.LinkedList;

import static java.lang.Math.abs;
/**
 * The PetRescue class implements the PetRescueable interface and represents a pet rescue organization.
 * It stores information about various pets, such as birds, dogs, and cats, as well as the pet of the month.
 * The class provides methods for performing operations related to these pets and managing the organization's resources.
 */

public class PetRescue implements PetRescueable{
    public int thisPellets= 0;
    public int thisHay = 0;
    public String petOfTheMonth;
    public LinkedList<Integer> birdWeights = new LinkedList<>();
    public LinkedList<Integer> dogYears = new LinkedList<>();
    public LinkedList<Coord> catCoords = new LinkedList<>();
    /**
     * Constructs a new PetRescue object with the specified pet information.
     *
     * @param birdWeights   A list of bird weights in ounces.
     * @param dogYears      A list of dog ages.
     * @param petOfTheMonth String of the pet of the month.
     * @param catCoords     A list of coordinates for cats.
     */
    public PetRescue(LinkedList<Integer> birdWeights,
                     LinkedList<Integer> dogYears,
                     String petOfTheMonth,
                     LinkedList<Coord> catCoords){
        this.birdWeights = birdWeights;
        this.dogYears = dogYears;
        this.petOfTheMonth = petOfTheMonth;
        this.catCoords = catCoords;
    }

    /**
     * Searches the birds in the pet rescue
     * @return the size of the biggest bird in oz or 0 if there are no birds
     */
    public int biggestBird() {
        //Checks if birdWeights is empty before operating on birdWeights
        if(birdWeights.isEmpty()){
            return 0;
        }
        /**Traverses through birdWeights, compares each integer of birdWeights to the integer "biggestbird", and
         replaces the integer value of biggestbird with the new integer of index i of birdWeihgts if i is  greater than the current value of
         biggestbird.

         */
        int biggestbird = birdWeights.getFirst();
        for(int i:birdWeights){
            if(i>biggestbird){
                biggestbird=i;
            }
        }
        return biggestbird;
    }

    /**
     * Transforms the dog records in the pet rescue
     * @return a list of ages in the same order as the dog records,
     *         but each age is converted into human years by multiplying by 7
     */
    public LinkedList<Integer> inHumanYears() {
        LinkedList<Integer> inHumanYears = new LinkedList<>();
        /**
         * Checks that dogYears is not empty before operating on dogYears
         */
        if(dogYears.isEmpty()){
            return inHumanYears;
        }
        /**
         * traverses through dogYears using a for each loop, and multiplies the object at each  index by 7
         * and adds the resultant product to a parallel linkedList called, inHumanYears
         */
        for(int i:dogYears){
            inHumanYears.add(7*i);
        }
        return inHumanYears;
    }

    /**
     * Awards the pet of the month with a title and/or a credential for their accomplishments
     * @param title Can be a title like "Dr." or "Capt."
     *              or the empty string "" if no title to be added
     * @param credential a degree or honor including but not limited to "MD", "PhD", or "Esq."
     *                   or the empty string "" if no credential to be added
     * effects: modifies the name on record of the form "TITLE name, CREDENTIAL"
     * multiple space separated titles can be added with the newest first
     * multiple space separated credentials can be added after the comma with the newest last.
     */
    public void bestowHonor(String title, String credential) {
        //uses nested if else to prevent edge cases from breaking the method
        //for each loop to see if "," already in petofmonth;
        if (!petOfTheMonth.contains(",")&&!title.isEmpty() && !credential.isEmpty()){
            String holder = petOfTheMonth;
            petOfTheMonth = title + " " + holder + ", " + credential;
        }
        else if (!title.isEmpty() && !credential.isEmpty()){
            String holder = petOfTheMonth;
            petOfTheMonth = title+ " " + holder + " " + credential;

        }
        else if (title.isEmpty()&&!credential.isEmpty()){
            // System.out.println("title is empty, credential is not empty");
            if (!petOfTheMonth.contains(",")){
                String holder = petOfTheMonth;
                petOfTheMonth = holder + ", " + credential;
            }
            else{
                String holder = petOfTheMonth;
                petOfTheMonth = holder + " " + credential;

            }
        }
        else if (!title.isEmpty()&&credential.isEmpty()){
            String holder = petOfTheMonth;
            petOfTheMonth = title + " " + holder;
        }


    }

    /**
     * Adds positive or subtracts negative food from the pantry and then prints out a new label for the contents inside
     * assume the initial amount of pellets and hay should be 0
     * @param pellets the amount of pellets to add/subtract
     * @param hay the amount of hay to add/subtract
     * @return a string in the format "Chinchilla: # pellets, # hay"
     * If the storage of pellets or hay goes negative, reset them to 0, and replace # with "unknown"
     */
    public String feedChinchillas(int pellets, int hay) {

        //uses nested if else statements to prevent edge cases from breaking the method.
        String message=""; //initializes message to an empty string.
        if(pellets>=0&&hay>=0){
            thisPellets = thisPellets + pellets; //updates thisPellets value
            thisHay = thisHay + hay; //updates thisHay value
            message = "Chinchilla: "+thisPellets+" pellets, " + thisHay + " hay"; //updates the message
        }
        else if(pellets<0&&hay<0){ //test case for negative pellet and hay values
            if(thisPellets+pellets <0 && thisHay + hay <0){
                thisPellets = 0;
                thisHay = 0;
                message = "Chinchilla: unknown pellets, unknown hay"; //updates the message
            }
            else if(thisPellets+pellets <0 && thisHay + hay >0){ //test case for if pellets are negative but hay isnt
                thisPellets = 0;
                message = "Chinchilla: unknown pellets, " + hay + " hay"; //updates the message
            }
            else if(thisPellets+pellets >0 && thisHay + hay <0){ //test case for if pellets are positive but hay is negative
                thisHay = 0; //sets thisHay to 0 because you can't have a negative amount of hay.
                message = "Chinchilla: "+ pellets + " , unknown hay";//updates message
            }
            else{
                thisPellets = thisPellets + pellets; //updates thisPellets value
                thisHay = thisHay + hay;//updates thisHay value
                message = "Chinchilla: "+thisPellets+" pellets, " + thisHay + " hay";//updates message
            }

        }
        else if(pellets<0&&hay>0){
            if(thisPellets+pellets<0){ //accounts for new pellets still being negative (impossible in reality)
                thisPellets =0; //sets pellets to 0 because you can't  have a negative pellet value
                thisHay = thisHay + hay;//updates hay value
                message = "Chinchilla: unknown pellets, " + thisHay + " hay"; //updates messsage
            }
            else{
                thisPellets = thisPellets + pellets;//updates thisPellets value
                thisHay = thisHay + hay; //updates thisHay value
                message = "Chinchilla: "+thisPellets+" pellets, " + thisHay + " hay"; //updates message
            }

        }
        else if(pellets>0&&hay<0){
            if(thisHay+hay<0){ //accounts for new hay still being negative(impossible in  reality)
                thisPellets = thisPellets + pellets;//updates pellets value
                thisHay=0;//sets hay value to 0 because hay can not be negative
                message = "Chinchilla: " + thisPellets + " pellets, " +  "unknown hay"; //updates message
            }
            else{
                thisPellets = thisPellets + pellets; //updates pellets value
                thisHay = thisHay + hay; //updates thisHay value
                message = "Chinchilla: "+thisPellets+" pellets, " + thisHay + " hay"; //updates message
            }

        }

        return message; 
    }

    /**
     * Finds the closest cat in the rescue to some coordinate
     *
     * @param x the coordinate to find the closest to
     * @param y
     * @return the name of the cat if found or "Conspiciously Catless" if there are no cats.
     */
    public String closestTo(int x, int y) { //need a helper method, 2 tests in examples
        String nameofcat="";
        //checks if catCoords is empty before operating on nonexistant integers
        if(catCoords.isEmpty()){
            return "Conspiciously Catless";
        }
        else{
            for(Coord i: catCoords){
                if(i.x==x&&i.y==y){
                    return i.name;
                }
            }
            nameofcat = smallestDifference(x, y); //sets nameofCat to the closest cat

        }
        return nameofcat; //returns the name of the closest cat
    }


    /**
     * Finds the closest cat in the pet rescue to a specified coordinate by calculating the Euclidean distance.
     *
     * @param x The x-coordinate of the target location.
     * @param y The y-coordinate of the target location.
     * @return The name of the cat that is closest to the specified coordinate.
     */
    public String smallestDifference(int x, int y){
        String nameofcat = catCoords.getFirst().name; //sets first cat as the closest
        int difference = abs(catCoords.getFirst().x - x) + abs(catCoords.getFirst().y - y); //first cat difference
        int difference2; //initialize a new int to store the calculated distance
        for(Coord i: catCoords){ //compare difference with second
            difference2 = abs(i.x-x) + abs(i.y-y); //calculates the distance of the cat cords of index(i)
            if(difference2<difference){ //chcecks if the calculated difference is less than the
                nameofcat = i.name; //replaces nameofcat with new closest cat
                difference = difference2;/*sets the smallest difference to the knew smallest difference to compare
                                          the rest of catCoords to the new smallest difference
                                         */
            }
        }
        return nameofcat;
    }

}
