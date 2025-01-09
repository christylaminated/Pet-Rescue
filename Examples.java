import org.junit.Test;

import java.util.LinkedList;

import static java.lang.Math.abs;
import static org.junit.Assert.*;

public class Examples {

    public Examples(){

    }
    //WHY DOES .ADD ONLY WORK IN @TEST???
    /*@Test
    public void testSuperPetRescue(){
        LinkedList<Zoneable> zones = new LinkedList<>(); //list of all zones

        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("christy", 8, 9, new Coord2D(2,3), true));
        cats.add(new Cat("blue", 2, 3, new Coord2D(4,2), false));
        cats.add(new Cat("trade", 3,2,new Coord2D(1,3), true));



        LinkedList<Bird> birds = new LinkedList<>();
        birds.add(new Bird("pull", 2,7,new Coord2D(3,5), true));
        birds.add(new Bird("poo", 7,5,new Coord2D(4,9), false));
        birds.add(new Bird("ali", 3,2,new Coord2D(5,3), true));


        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        chinchillas.add(new Chinchilla("ariv", 4, 2, new Coord2D(4,2), 8));
        chinchillas.add(new Chinchilla("christy", 2, 8, new Coord2D(9,1), 3));
        chinchillas.add(new Chinchilla("jyoti", 3, 2, new Coord2D(9,2), 3));


        CatZone catz = new CatZone(cats);
        BirdZone birdz = new BirdZone(birds);
        ChinchillaZone chinchillaz = new ChinchillaZone(chinchillas);

        zones.add(catz);
        zones.add(birdz);
        zones.add(chinchillaz);
        SuperPetRescue allzones = new SuperPetRescue(zones);
        assertEquals(9,allzones.totalPets());
        assertEquals("christy", allzones.getHeaviestPetsName());



    }*/
    @Test
    public void testSuperPetRescue() {
        LinkedList<Zoneable> zones = new LinkedList<>(); // List of all zones

        // Cats in CatZone
        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("christy", 8, 9, new Coord2D(2, 3), true));
        cats.add(new Cat("blue", 2, 3, new Coord2D(4, 2), false));
        cats.add(new Cat("trade", 3, 2, new Coord2D(1, 3), true));

        // Birds in BirdZone
        LinkedList<Bird> birds = new LinkedList<>();
        birds.add(new Bird("pull", 2, 7, new Coord2D(3, 5), true));
        birds.add(new Bird("poo", 7, 5, new Coord2D(4, 9), false));
        birds.add(new Bird("ali", 3, 2, new Coord2D(5, 3), true));

        // Chinchillas in ChinchillaZone
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        chinchillas.add(new Chinchilla("ariv", 4, 20, new Coord2D(4, 2), 8));
        chinchillas.add(new Chinchilla("christy", 2, 8, new Coord2D(9, 1), 3));
        chinchillas.add(new Chinchilla("jyoti", 3, 2, new Coord2D(9, 2), 3));

        CatZone catz = new CatZone(cats);
        BirdZone birdz = new BirdZone(birds);
        ChinchillaZone chinchillaz = new ChinchillaZone(chinchillas);

        zones.add(catz);
        zones.add(birdz);
        zones.add(chinchillaz);

        SuperPetRescue allzones = new SuperPetRescue(zones);

        // Ensure that the total number of pets is correct
        assertEquals(9, allzones.totalPets());

        // Ensure that the heaviest pet is "christy" (from CatZone)
        assertEquals("ariv", allzones.getHeaviestPetsName());
    }




    @Test
    public void testBirdEats(){
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        assertEquals(1,b.eats("seeds"));
    }
    @Test
    public void testBirdAge() {
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        assertEquals(4, b.getAge());

    }
    @Test
    public void testCatEatsYesPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),true);
        assertEquals(2,c.eats("cans"));
    }

    @Test
    public void testCatEatsTreatsBaby(){
        Cat c = new Cat("Kitten",4,6,new Coord2D(2,2),true);
        assertEquals(1,c.eats("treats"));
    }


    @Test
    public void testChinchillaWeightInOz(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(24, ch.getWeightInOz());
    }





    @Test
    public void birdZoneTestClosestClipped(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.closestPet(4,5));
    }

    @Test
    public void birdZoneTestHeaviest1Bird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.heaviestPet().getName());
    }

    @Test
    public void animalGetName(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Christy",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals("Blue", b.getName());
        assertEquals("Christy", c.getName());
        assertEquals("Dusty", ch.getName());
    }


    @Test
    public void testCatZone(){
        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("Christy", 3, 3, new Coord2D(3,4), true));
        cats.add(new Cat("Bob", 2, 1, new Coord2D(6,2), false));
        CatZone cz = new CatZone(cats);

        assertEquals(2, cz.petsInZone() );
        //assertEquals(18, cz.inHumanYears("Christy"));

    }

    @Test
    public void testBirdZone(){
        LinkedList<Bird> birds = new LinkedList<>();
        birds.add(new Bird("Christy", 3, 3, new Coord2D(3,4), true));
        birds.add(new Bird("Bob", 2, 1, new Coord2D(6,2), false));
        BirdZone cz = new BirdZone(birds);

        assertEquals(2, cz.petsInZone() );
        assertEquals(27, cz.inHumanYears("Christy"));

    }

    @Test
    public void testNoBirdsinZone(){
        LinkedList<Bird> birds = new LinkedList<>(); // No birds in the BirdZone
        BirdZone bz = new BirdZone(birds);

        assertEquals(0, bz.petsInZone());
        assertEquals(-1, bz.inHumanYears("Christy"));
    }


    @Test
    public void testChinchillaZone(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        chinchillas.add(new Chinchilla("Christy", 3, 5, new Coord2D(2,4), 4));
        chinchillas.add(new Chinchilla("ariv", 4, 7, new Coord2D(3,4), 3));
        chinchillas.add(new Chinchilla("arul", 8, 2, new Coord2D(8,9), 1));
        ChinchillaZone cz = new ChinchillaZone(chinchillas);
        assertEquals(3, cz.petsInZone());
        assertEquals(30, cz.inHumanYears("Christy"));
    }

    @Test
    public void testCatZonePetable(){
        LinkedList<Zoneable> zones = new LinkedList<>(); //list of all zones
        LinkedList<Cat> cats = new LinkedList<>(); //list of petable
        Cat c = new Cat("Christy", 3, 3, new Coord2D(3,4), true);
        Cat r = new Cat("blue", 2, 5, new Coord2D(4,9), false);

        cats.add(c);
        cats.add(r);
        CatZone cz = new CatZone(cats);

       // assertEquals(r, cz.heaviestPet());
      //  assertEquals(c, cz.getPet("Christy"));
       // assertEquals("Cat: 0 cans, 0 treats", cz.getPantryLabel());
        assertEquals("Christy", cz.closestPet(3,4));
        assertEquals("blue", cz.closestPet(5,8));
    }

    @Test
    public void testBirdZonePetable(){
        LinkedList<Zoneable> zones = new LinkedList<>(); //list of all zones
        LinkedList<Bird> birds = new LinkedList<>(); //list of petable
        Bird c = new Bird("Christy", 3, 3, new Coord2D(3,4), true);
        Bird r = new Bird("blue", 2, 5, new Coord2D(4,9), false);

        birds.add(c);
        birds.add(r);
        BirdZone cz = new BirdZone(birds);
        assertEquals(r, cz.heaviestPet());
        assertEquals(c, cz.getPet("Christy"));
        assertEquals("Bird: 0 seeds", cz.getPantryLabel());
        assertEquals("Christy", cz.closestPet(3,4));
        assertEquals("blue", cz.closestPet(5,8));


    }

    @Test
    public void testChinchillaZonePetable(){
        // LinkedList<Zoneable> zones = new LinkedList<>(); //list of all zones
        LinkedList<Chinchilla> emptychin = new LinkedList<>();
        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        Chinchilla c= new Chinchilla("Christy", 3, 5, new Coord2D(2,4), 4);
        Chinchilla r = new Chinchilla("ariv", 4, 7, new Coord2D(3,4), 3);
        chinchillas.add(c);
        chinchillas.add(r);
        ChinchillaZone cz = new ChinchillaZone(chinchillas);
        ChinchillaZone emp = new ChinchillaZone(emptychin);

        assertEquals(r, cz.heaviestPet());
        assertEquals(c, cz.getPet("Christy")); //tjis one dpesnt work
        assertEquals("Christy", cz.closestPet(2,4));
        assertEquals("ariv", cz.closestPet(5,8));
        assertEquals(null, emp.getPet("Christy"));

    }
    @Test
    public void catZoneTestFeedZoneWithCat(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Blue",1,3,new Coord2D(2,2),true));
        CatZone cz = new CatZone(cats);
        assertEquals(cz, cz.feedZone());

    }
    @Test
    public void birdZoneTestFeedZoneWithBird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(bz, bz.feedZone());
    }

    @Test
    public void chinchillaZoneTestFeedZoneWithChinchilla(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Blue",1,3,new Coord2D(2,2),4));
        ChinchillaZone bz = new ChinchillaZone(chinchillas);
        assertEquals(bz, bz.feedZone());

    }




    @Test
    public void testCatZoneFeed(){ //restock, feed, feed zone, generate pantry label
        // LinkedList<Zoneable> zones = new LinkedList<>(); //list of all zones

        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("christy", 8, 9, new Coord2D(2,3), true));
        cats.add(new Cat("blue", 2, 3, new Coord2D(4,2), false));
        cats.add(new Cat("trade", 3,2,new Coord2D(1,3), true));



        LinkedList<Bird> birds = new LinkedList<>();
        birds.add(new Bird("pull", 2,7,new Coord2D(3,5), true));
        birds.add(new Bird("poo", 7,5,new Coord2D(4,9), false));
        birds.add(new Bird("ali", 3,2,new Coord2D(5,3), true));


        LinkedList<Chinchilla> chinchillas = new LinkedList<>();
        chinchillas.add(new Chinchilla("ariv", 4, 2, new Coord2D(4,2), 8));
        chinchillas.add(new Chinchilla("christy", 2, 8, new Coord2D(9,1), 3));
        chinchillas.add(new Chinchilla("jyoti", 3, 2, new Coord2D(9,2), 3));


        CatZone catz = new CatZone(cats);
        BirdZone birdz = new BirdZone(birds);
        ChinchillaZone chinchillaz = new ChinchillaZone(chinchillas);

        //break: cats

        catz.feedZone();
        catz.restockPetFood("pellets", 4);
        catz.feedZone();
        catz.feedZone();
        birdz.restockPetFood("birdfood", 3);
        chinchillaz.restockPetFood("chinfood", 2);



        catz.restockPetFood("cans", 2);
        catz.restockPetFood("cans", 2);
        catz.restockPetFood("treats", 2);

        assertEquals("Cat: 4 cans, 2 treats", catz.getPantryLabel());

        //break: birds
        birdz.restockPetFood("seeds", 2);
        birdz.restockPetFood("seeds", 2);
        birdz.restockPetFood("seeds", 2);

        assertEquals("Bird: 6 seeds", birdz.getPantryLabel());

        //break: chinchillas

        chinchillaz.restockPetFood("pellets", 2);
        chinchillaz.restockPetFood("pellets", 2);
        chinchillaz.restockPetFood("pellets", 2);
        chinchillaz.restockPetFood("hay", 2);

        assertEquals("Chinchilla: 6 pellets, 2 hay", chinchillaz.getPantryLabel());

        chinchillaz.restockPetFood("hay", -2);
        chinchillaz.restockPetFood("pellets", -6);
        assertEquals("Chinchilla: 0 pellets, 0 hay", chinchillaz.getPantryLabel());


        chinchillaz.restockPetFood("hay", -2);
        chinchillaz.restockPetFood("pellets", -6);
        chinchillaz.feedZone();
        assertEquals("Chinchilla: 0 pellets, 0 hay", chinchillaz.getPantryLabel());

    }//76.13





}
