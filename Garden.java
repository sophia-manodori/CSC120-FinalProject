public class Garden extends Location{
    public Garden(String description) {
        super(description, 10, true);
    }
    public void plant(Plant s) {
        this.addPlant(s);
    }
    
    public void description() {
        System.out.println(this.description + "the humidity is " + this.humidity);
        System.out.println("You see the following plants:");
        for(int i = 0; i < this.plants.size(); i++) {
            System.out.println(this.plants.get(i));
        }
    }
}
