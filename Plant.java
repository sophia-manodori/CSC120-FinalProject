public class Plant {
    String name;
    boolean isPoison;
    double size;

    public Plant(String name, boolean isPoison, double size) {
        this.name=name;
        this.isPoison=isPoison;
        this.size=size;
    }

    public boolean isPoison() {
        return this.isPoison;
    }
    public void eat() {
        this.size-= 1;
    }
}
