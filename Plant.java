public class Plant {
    String name;
    boolean isPoison;
    boolean hasCalcium;
    String description;
    boolean isPlantable;

    public Plant(String name, String description, boolean isPoison, double size, boolean isPlantable) {
        this.name=name;
        this.isPoison=isPoison;
        //this.size=size;
        this.description=description;
        this.isPlantable=isPlantable;
    }
    public Plant(String name, String description, boolean isPoison, boolean isPlantable, boolean hasCalcium) {
        this.name=name;
        this.isPoison=isPoison;
        this.description=description; 
        this.hasCalcium = hasCalcium;
       // this.size=5;
    }
    public Plant(String name, boolean isPoison) {
        this.name=name;
        this.isPoison=isPoison;
       // this.size=5;
    }

    public String toString() {
        if(this.isPoison) {
            return this.name + "is a poisonous plant. It looks like" + this.description;
        }
        else {
            return this.name + "is a non-poisonous. It looks like" + this.description;
        }
    }
    public boolean isPoison() {
        return this.isPoison;
    }
    //public void eat() {
      //  this.size-= 1;
    //}
    public boolean hasCalcium(boolean b) {
        return false;
    }
    public boolean hasCalcium() {
        return false;
    }
}
