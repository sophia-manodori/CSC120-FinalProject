import java.util.ArrayList;

public class Snail {
    String name;  
    String shellColor;
    double water;
    double food;
    double calcium;
    double health;
    boolean inShell;
    Location current;
    Map map;
    int x;
    int y;
    ArrayList<String> inventory;
    

    Snail(String name, double water, double food, double health, int x, int y) {
        this.name=name;
        this.water=water;
        this.food=food;
        this.health=health;
        this.inShell = false;
        this.inventory= new ArrayList<>();
        this.x=x;
        this.y=y;
    }
    /**
     * constructor with set values for food and water. 
     * @param name
     */
    Snail(String name) {
        this.name=name;
        this.water=10;
        this.food=10;
        this.health=10;
        System.out.println("You're a snail. Your name is " + this.name + " . Snails are hermaphrodites, so you are neither male or female. " + 
                        "You are currently holding 1/14th of your body weight in water. It's important to maintain this water level as it helps you produce slime, essential for movement, protection, and reproduction. Your shell, made of calcilum, is looking #fiiinne, and is utalizing a fibonaccii swirl for top notch structural intelligence. ");
        System.out.println("type 'my options' to see what you can do");
        this.inventory=new ArrayList<>();
        this.x=0;
        this.y=0;
        this.inShell = false;
        this.current=this.map.map[x][y];
        }
    /**
     * 
     * @return health points
     */
    public double myHealth() {
        return this.health;
    }
    /**
     * snail gets dehydrated (possibly from dry environment)
     */
    public void dehydrate() {
        this.water=this.water*0.9;
        System.out.println("You've lost some water mass!");
        if(this.water<1) {
            this.health-=1;
        }
    }
    public void health() {
        if(this.water==10 && this.food==10) {
            this.health = 10;
        }
        if(this.health<0) {
            throw new RuntimeException("You have died.");
        }
    }
    /**
     * snail drinks water at given location
     * @param s
     */
    public double hydrate() {
        if(this.water>10) {
            throw new RuntimeException("You are already fully hydrated!");
        }
        else if(this.current.containsWater) {
            this.water = this.water * 1.2;
            this.health();
        }
        else {
            throw new RuntimeException("There is no water at this location");
        }
        return this.water;
    }
    /**
     * snail retreats into shell
     * @return inShell
     */
    public boolean retreat() {
        this.inShell = true;
        return this.inShell;
    }
    /**
     * snail retreats into shell
     * @return inShell
     */
    public boolean emerge() {
        this.inShell = false;
        return this.inShell;
    }
    /**
     * eats a plant, removes it if too small from location
     * @param s
     * @return
     */
    public double eat(String p) {
        if(this.food<10 && (this.current.hasPlant(p)|| this.inventory.contains(p))) {
            this.food+=1;
            //this.current.plants.get(p).eat();
            this.health();
         }
        else if(this.current.plants.get(p).isPoison()) {
            this.health=-9;
            throw new RuntimeException("You ate poison. Your health has decreased by 9. You will either die, or must eat and drink to restore your health.");
        }
        if(this.food>9) {
            System.out.println("You are already full");
        }
        return this.food;
    }
    /**
     * checks if plant is poisonous
     * @param s
     * @return true if plant is poisonous
     */
    public void smell(String p) { 
        if(this.current.plants.get(p).isPoison()) {
            System.out.println("This smells poisonous");
        } else {
            System.out.println("this plant smells ok");
        }
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
        if(this.current.plants.containsKey(s)) {
            this.inventory.add(s);
        }
        else {
             throw new RuntimeException("You are small. It's best not to pick up several of the same things, for storage reasons. ");
        }
    }
    /**
     * removes string from inventory and deposits it into to location inventory
     * @param s
     * @param l
     */
    public void drop(String s) {
        if(this.inventory.contains(s)) {
            this.inventory.remove(s);
            this.current.dropped.add(s); //adds to location dropped so we can check for certain situations
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
    public void options() {
        System.out.println("You are" + this + " . Type 'pickup' to pick up an object. Type 'drop' to drop an object. Type 'smell' to smell a plant to check if it's poisonous. Type 'eat' to eat an object. Type 'go north' to move. Type 'health' to see your health points");
    }

    public void goNorth() {
        if(this.y<2) {
            this.y+=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }
    
    public void goSouth() {
        if(this.y>0) {
            this.y-=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }

    
    public void goEast() {
        if(this.x<2) {
            this.x+=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }
    public void goWest() {
        if(this.x>0) {
            this.x-=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }

    public void layEggs() {
        this.produceSlime();
    }
}
