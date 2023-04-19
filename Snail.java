import java.util.ArrayList;

public class Snail {
    String name;  
    String shellColor;
    double water;
    double food;
    double calcium;
    boolean inShell;
    
    ArrayList<String> inventory;

    Snail(String name, double water, double food) {
        this.name=name;
        this.water=water;
        this.food=food;
        this.inventory= new ArrayList<>();
    }
    /**
     * constructor with set values for food and water. 
     * @param name
     */
    Snail(String name) {
        this.name=name;
        this.water=10;
        this.food=10;
        System.out.println("You're a snail. Your name is " + this.name + " . Snails are hermaphrodites, so you are neither male or female. " + 
                        "You are currently holding 1/14th of your body weight in water. It's important to maintain this water level as it helps you produce slime, essential for movement, protection, and reproduction. Your shell, made of calcilum, is looking #fiiinne, and is utalizing a fibonaccii swirl for top notch structural intelligence. ");
        System.out.println("type 'my options' to see what you can do");
        }
    /**
     * snail gets dehydrated (possibly from dry environment)
     */
    public void dehydrate() {
        this.water=this.water*0.9;
        System.out.println("You've lost some water mass!");
    }
    /**
     * snail drinks water at given location
     * @param s
     */
    public double hydrate(Location s) {
        if(this.water>10) {
            throw new RuntimeException("You are already fully hydrated!");
        }
        else if(s.containsWater) {
            this.water = this.water * 1.2;
        }
        else {
            throw new RuntimeException("There is no water at this location");
        }
        return this.water;
    }
    /**
     * eats a plant, removes it if too small from location
     * @param s
     * @return
     */
    public double eat(Plant s, Location l) {
        if(this.food<10 && l.hasPlant(s)) {
            this.food+=1;
            s.eat();
         }
        if(s.size < 1) {
            l.removePlant(s);
        }
        else if(s.isPoison()) {
            throw new RuntimeException("You ate poison. You have died.");
        }
        else {
            throw new RuntimeException("You are already full!");
        }
        return this.food;
    }
    /**
     * checks if plant is poisonous
     * @param s
     * @return true if plant is poisonous
     */
    public boolean smell(Plant s) { 
        return s.isPoison();
    }
    /**
     * adds plant name to inventory
     * @param p
     */
    public void pickUp(Plant p) {
        if(!this.inventory.contains(p.name)){
        this.inventory.add(p.name);}
        else {
            throw new RuntimeException("You are small. It's best not to pick up several of the same things, for storage reasons. ");
        }
    }
    /**
     * adds string to inventory
     * @param s
     */
    public void pickUp(String s) {
        if(!this.inventory.contains(s)){
            this.inventory.add(s);}
        else {
             throw new RuntimeException("You are small. It's best not to pick up several of the same things, for storage reasons. ");
        }
    }
    /**
     * removes string from inventory and deposits it into to location inventory
     * @param s
     * @param l
     */
    public void drop(String s, Location l) {
        if(this.inventory.contains(s)) {
            this.inventory.remove(s);
            l.dropped.add(s); //adds to location dropped so we can check for certain situations
        }else {
            throw new RuntimeException("You can't drop something you don't have!");
        }
    }
    /**
     * Produces slime for hydration maintenence and movement
     */
    public void produceSlime() {
        this.dehydrate();
        System.out.println("You've produced slime! You slime is used to maintain moisture and to help facilitate friction between your foot and the ground.");
    }
    /**
     * produces poison slime
     */
    public void producePoison(){
        this.dehydrate();
        System.out.println("You've produced poison slime. You now will poison anyone who eats you, and you will smell quite un-appetizing.");
    }

    public void mate() {

    }

    public void layEggs() {
        this.produceSlime();
    }
}
