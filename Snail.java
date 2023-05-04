import java.util.ArrayList;

public class Snail {
    String name;  
    String shellColor;
    double water;
    double food;
    double calcium;
    double health;
    boolean inShell;
    boolean steppedOn;
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
    Snail(String name, Map map) {
        this.name=name;
        this.water=10;
        this.food=10;
        this.health=10;
        System.out.println("You're a snail. Your name is " + this.name + " . Snails are hermaphrodites, so you are neither male or female. " + 
                        "You are currently holding 1/14th of your body weight in water. It's important to maintain this water level as it helps you produce slime, essential for movement, protection, and reproduction. Your shell, made of calcilum, is looking #fiiinne, and is utalizing a fibonaccii swirl for top notch structural intelligence. ");
        System.out.println("type 'my options' to see what you can do");
        this.inventory=new ArrayList<>();
        this.map = map;
        this.x=0;
        this.y=0;
        this.inShell = false;
        this.current=this.map.map[x][y];
        }
    /**
     * 
     * @return health points
     */
    public boolean myHealth() {
        return !(this.health>0);
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
        if(this.food<1){
            this.health =- 1;
        }
        if(this.water<1){
            this.health =- 1;
        }
        if(this.health<0) {
            throw new RuntimeException("You have died.");
        }
    }

    public Boolean steppedOn(){
        if (this.x==2 && this.y==2){
            steppedOn = true;
        }
        return steppedOn;
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
            System.out.println("You have drunken water! Your water is now at " + this.water);
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
        if(this.steppedOn = true){
            System.out.println("You are unable to retreat into your shell because you currently don't have one.");
            this.inShell = false;
        }
        else {
            this.inShell = true;
            System.out.println("You are safe. In fact, you are so comfortable that if you wished, you could stay here for up to 7 years. Snails have been documented to take multi-year long hibernations when climate renders the habitat unliveable. This can happen when it becomes really dry, or when it snows. They slow their heart beat and simply... take a break, until they sense the humidity is more favorable. Then, sometimes after several years, they re-emerge.");
        }
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
            System.out.println("You have eaten the" + p + ". Your food level is now" + this.food);
        }
        else if(this.current.plants.get(p).isPoison()) {
            this.health=-9;
            throw new RuntimeException("You ate poison. Your health has decreased by 9. You will either die, or must eat and drink to restore your health.");
        }
        else if(this.current.plants.get(p).hasCalcium()){
            this.steppedOn = false;
            System.out.println("Your shell has been restored!");
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
        if(!this.current.plants.get(s).isPlantable) {
            throw new RuntimeException("You cannot pick up that plant");
        }
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
    /**
     * prints options
     */
    public void options() {
        System.out.println("You are" + this.name + " the snail. Type 'pickup' to pick up an object. \n Type 'drop' to drop an object. \n Type 'smell' to smell a plant to check if it's poisonous. \n Type 'eat' to eat an object. \n Type 'go north', 'go south', 'go east', 'go west' to move. \nType 'health' to see your health points. \n Type 'retreat' to retreat into your shell if you feel danger.");
    }
    /**
     * go north
     */
    public void goNorth() {
        if(this.y>=0 && y<2) {
            this.y+=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
            this.food=-1;
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }
    /**
     * go south
     */
    public void goSouth() {
        if(this.y>=0) {
            this.y-=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
            this.food=-1;
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }

    /**
     * go east
     */
    public void goEast() {
        if(this.x>=0) {
            this.x+=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
            this.food=-1;
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }
    /**
     * go west
     */
    public void goWest() {
        if(this.x>=0) {
            this.x-=1;
            this.current=this.map.map[x][y];
            this.current.description();
            this.current.humidityEffect(this);
            this.food=-1;
        }
        else{
            throw new RuntimeException("You have reached an endless forest. You are wandering. Turn back or try going a different direction");
        }
    }
    /**
     * "gives" food to injured snail
     * @param s
     */
    public void helpSnail(String s) {
        if(!(this.x == 0)) {
            throw new RuntimeException("No snail to help here!");
        }
        if(!(this.y == 1)) {
            throw new RuntimeException("No snail to help here!");
        }
        if(this.current.dropped.contains(s)) {
            System.out.println("You feed the snail the" + s +". They start to look revitalized. Snails can actually regenerate their antennae, and it seems this snail needed some extra nourishment to start to heal themselves. The snail gives you a wave of their good antennae and shoots you what you swear is... a wink? Scandelous. The snail turns, and begins to slowly make their way away.");
        }
    }
    /**
     * checks if you can help the snail
     */
    public void canHelpSnail() {
        if(this.x==0 && this.y==1) {
            System.out.println("You decide to help the snail. It seems it needs some food. go find a plant, and pick it up. Come back and drop it in front of the snail, and type 'feed snail' when you've gotten the food. ");
        }
        else {
            System.out.println("no snail to be seen here!");
        }
    }

    public void layEggs() {
        this.produceSlime();
    }
}
