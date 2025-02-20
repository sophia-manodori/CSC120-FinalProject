import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
public class Location {
    protected double humidity;
    protected String description;
    protected String situation;
    protected boolean hasPlayed;
    boolean containsWater;
    protected Hashtable<String, Plant> plants;
    ArrayList<String> dropped;
    //private ArrayList<String> situation;

    Location(String description, String situation, double humidity, boolean containsWater) {
        this.description=description;
        this.humidity=humidity;
        this.containsWater=containsWater;
        this.plants=new Hashtable();
        //this.situation=new ArrayList<>();
        this.dropped=new ArrayList<>();
        this.hasPlayed=false;
        this.situation=situation;
    }
    Location(String description, double humidity, boolean containsWater) {
        this.description=description;
        this.humidity=humidity;
        this.containsWater=containsWater;
        this.plants=new Hashtable();
        //this.situation=new ArrayList<>();
        this.dropped=new ArrayList<>();
        this.hasPlayed=true;
    }

    public void description() {
        System.out.println(this.description + " the humidity is " + this.humidity);
        System.out.println("You see the following plants:");
        Set<String> setOfKeys = this.plants.keySet();
        for(String s : setOfKeys) {
            System.out.println(plants.get(s).name + ": " + plants.get(s).description);
        }
        if(!this.hasPlayed) {
            System.out.println(this.situation);
            this.hasPlayed=true;
        }
    }

    public boolean hasPlant(Plant s) {
        return this.plants.contains(s);
    }
    public boolean hasPlant(String s) {
        return this.plants.containsKey(s);
    }
    public void removePlant(Plant s) {
        if(this.hasPlant(s)) {
            this.plants.remove(s.name);
        }
    }

    public void addPlant(Plant s) {
        if(!this.plants.contains(s)) {
            this.plants.put(s.name, s);
        }
        else {
            throw new RuntimeException("plant is already in there");
        }
    }

    public void humidityEffect(Snail s) {
        if(this.humidity<10) {
            System.out.println("Oh no! It's very dry. You have been dehydrated by the heat.");
            s.dehydrate();
        }
    }
    public void options(Snail s) {
        s.options();
        System.out.println("You can also check if your current location has a plant by typing 'has plant'");
    }

    public static void main(String[] args) {
        Location lake = new Location("A beatiful lake, surrounded by trees.", 80, true);
        lake.description();
    }
}