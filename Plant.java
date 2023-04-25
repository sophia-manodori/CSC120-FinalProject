public class Plant {
    String name;
    boolean isPoison;
    double size;

    public Plant(String name, boolean isPoison, double size) {
        this.name=name;
        this.isPoison=isPoison;
        this.size=size;
    }
    public Plant(String name, boolean isPoison) {
        this.name=name;
        this.isPoison=isPoison;
        this.size=5;
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
    //public void eat() {
      //  this.size-= 1;
    //}
}
