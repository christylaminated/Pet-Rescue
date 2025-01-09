public class Chinchilla extends Pets implements Petable{
    int dustBathResidueInOz;
    public Chinchilla(String name, int age, int weightInOz, Coord2D location,  int dustBathResidueInOz){
        super(name, age, weightInOz, location);
        this.dustBathResidueInOz = dustBathResidueInOz;
    }


@Override
public int getWeightInOz(){
        return dustBathResidueInOz+weightInOz;
}
    @Override
    public int eats(String foodLabel) {
        if(foodLabel.equals("pellets")){
            return 3;
        }else if(foodLabel.equals("hay")){
            return 1;
        }else{
            return 0;
        }
    }
}
//
