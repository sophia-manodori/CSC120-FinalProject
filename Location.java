import java.util.ArrayList;
public class Location {
    private double humidity;
    private String description;
    boolean containsWater;
    private ArrayList<Plant> plants;
    ArrayList<String> dropped;
    private ArrayList<String> situation;

    Location(String description, double humidity, boolean containsWater) {
        this.description=description;
        this.humidity=humidity;
        this.containsWater=containsWater;
        this.plants=new ArrayList<>();
        this.situation=new ArrayList<>();
        this.dropped=new ArrayList<>();
    }

    public void description() {
        System.out.println(this.description + "the humidity is " + this.humidity);
        System.out.println("You see the following plants:");
        for(int i = 0; i < this.plants.size(); i++) {
            System.out.println((i+1)+ ". " + this.plants.get(i).name);
        }
    }

    public boolean hasPlant(Plant s) {
        return this.plants.contains(s);
    }
    public void removePlant(Plant s) {
        this.plants.remove(s);
    }

    public void addPlant(Plant s) {

    }

    public static void main(String[] args) {
        Plant lilly = new Plant("Lilly", false, 5);
        Plant lilac = new Plant("Lilac", true, 5);
        Location lake = new Location("A beatiful lake, surrounded by trees.", 80, true);
        lake.plants.add(lilly);
        lake.plants.add(lilac);
        lake.description();
    }
}