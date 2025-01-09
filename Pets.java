public abstract class Pets implements Petable {
    public String name;
    public int age;
    public int weightInOz;
    public Coord2D location;

    public Pets(String name, int age, int weightInOz, Coord2D location) {//constructor
        this.name = name;
        this.age = age;
        this.weightInOz = weightInOz;
        this.location = location;
    }

    //getName(), getAge,
    public String getName(){
        return name;
    }//pulls the name field from the Pet object
    public int getAge(){
        return age;
    }//pulls the age field from the Pet object
    public int getWeightInOz(){
        return weightInOz;
    }//pulls the weightInOz filed from the Pet object
    public Coord2D getLocation(){
        return location;
    }//pulls the Coord2D location from the Pet object
}
