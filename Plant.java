public class Plant {
    String name;
    boolean isPoison;
    double size;
    boolean isPlantable;

    public Plant(String name, boolean isPoison, double size, boolean isPlantable) {
        this.name=name;
        this.isPoison=isPoison;
        this.size=size;
        this.isPlantable=isPlantable;
    }

    public String toString() {
        if(this.isPoison) {
            return this.name + "is a poisonous plant of size" + this.size;
        }
        else {
            return this.name + "is a non-poisonous plant of size" + this.size;
        }
    }
    public boolean isPoison() {
        return this.isPoison;
    }
    public void eat() {
        this.size-= 1;
    }
}
