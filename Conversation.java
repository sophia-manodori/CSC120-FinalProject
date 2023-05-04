import java.util.Scanner;
public class Conversation {
    int responseNum = 0;
    boolean active;
    public Conversation() {
        this.active=true;
    }
    
    public void response(Snail me, Scanner userInput) {
        String response = userInput.nextLine();
        if(response.equals("options")) {
            me.current.options(me);
        }
        else if(response.equals("health")) {
            System.out.println(me.myHealth());
        }
        else if(response.equals("description")) {
            me.current.description();
        }
        else if(response.equals("go north")) {
            try{me.goNorth();} catch(Exception e) {
                System.out.println(e);
            }
        }
        else if(response.equals("go east")) {
            try{me.goEast();} catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(response.equals("go west")) {
            try{me.goWest();} catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(response.equals("go south")) {
            try {me.goSouth();} catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(response.equals("smell")) {
            System.out.println("what plant would you like to smell?");
            String plant = userInput.nextLine();
            me.smell(plant);
            }
        else if(response.equals("eat")) {
            System.out.println("what plant would you like to eat?");
            String plant = userInput.nextLine();
            try{
                me.eat(plant);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        else if(response.equals("drink")) {
            try{
                me.hydrate();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(response.equals("help snail")) {
            try {
                me.canHelpSnail();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(response.equals("feed snail")) {
            System.out.println("What have you decided to feed the snail?");
            String plant = userInput.nextLine();
            try {
                me.helpSnail(plant);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(response.equals("go south"))
             try {
                me.goSouth();
            } 
             catch(Exception e) {
            System.out.println(e);
            }
        else if(response.equals("retreat")) {
            me.retreat();
        }
        else if(response.equals("emerge")) {
            me.emerge();
        }
        else if(response.equals("pickup")) {
            System.out.println("what plant would you like to pick up?");
            String plant = userInput.nextLine();
            me.pickUp(plant);
        }
        else if(response.equals("quit")) {
            System.out.println("Thanks for playing");
            this.active=false;
        }
        else{
            System.out.println("I don't understand. Try again, or type 'options' to see what you can do");
        }
    }
    
    public static void main(String[] args) {
        Location forest = new Location("You are in a lush forest. Surrounded by large maple trees and damp soil beneath you. Dappled light shines through the leaves. A path stretches out to the east and another to the north the rest is forest.", 11, false);
        Plant shitake = new Plant("Shitake", "A patch of brown mushrooms growing from the base of a tree.", false, false, false);
        Plant ivy = new Plant("Poison Ivy", "A spiraling plant with three shiny leaves at every arm", true, true, false);
        Plant moss = new Plant("Moss", "Short little patches of soft green fronds, damp with dew", false, true, false);
        forest.addPlant(shitake);
        forest.addPlant(moss);
        forest.addPlant(ivy);
        Garden garden = new Garden("You find yourself in a beautiful garden with flourishing plants. There are paths to the north, south, and east. Injured Snail");
        Location lake = new Location("You are on the shores of a great lake stretching as far as the eye can see to the north and west. The lake is a stunning site and lots of plants are growing in the shallows and around the shore. Paths behind you flow to the north and east. ", 10, true);
        Plant waterweed = new Plant("common waterweed", "a weed growing in the water", false, false, false);
        Plant iris = new Plant("iris", "a plant with several violet-blue flowers with yellow-based sepals that emerge on sturdy stalks among tall sword-like leaves growing along the shore", false, true, false);
        Plant lilies = new Plant("lilies", "large white flowers", false, true, false);
        lake.addPlant(lilies);
        lake.addPlant(iris);
        lake.addPlant(waterweed);
        Location marsh = new Location("You are in a wet marsh with lots of tall grasses. A path with large trees carves to the east. There is a similar path to the west. There is also a dry dusty little trail to the north. ", "There is a large bird hunting overhead. If you don't hide it will probably kill you",12, true);
        Plant cordgrass = new Plant("Cordgrass", "tall grass growing everywhere across the marsh", false, true, false);
        marsh.addPlant(cordgrass);
        Forest denseForest = new Forest("large forest with big trees");
        Location meadow = new Location("You are in a large meadow with lots of colorful wildflowers. A small creek cuts through the center. There paths heading in all directions", 10, true);
        Plant sunflower = new Plant("sunflower", "large flowers with thick stems. they have yellow petals that radiate drom a brown center", false,true,false);
        Plant marigolds = new Plant("marigolds","the flowers have tiny florets surrounded by many layers of delicate, ruffled, bright petals and a thick hollow stem with fernlike leaves. The flowers range from red to orange to yellow", false, true, false);
        Plant delphiniums = new Plant("delphiniums", "", true, true, false);
        Plant dahlias = new Plant("dahlias", "beautiful flowers that are in all colors", false, true, false);
        Plant dandelions = new Plant("dandelions", "a strong weed with small yellow flowers that have numerous little petals", false, true, false);
        Plant chrysanthemums = new Plant("chrysanthemums", "large bushy flowers in many colors", false, true, false);
        meadow.addPlant(chrysanthemums);
        meadow.addPlant(sunflower);
        meadow.addPlant(marigolds);
        meadow.addPlant(delphiniums);
        meadow.addPlant(dahlias);
        meadow.addPlant(dandelions);
        Location mountainTop = new Location("You have some how made your way to the top of a tall mountain. You are above the tree line and not much grows here due to the high altitude. the air is thin and dry but you can see for miles and miles. To the north there is nothing but endless forest streaching on forever, to the south you can see a large meadow with splashes of bright flowers and plants and further south is a marsh with birds flying over, to the west is a grand lake and south of that you see a garden, to the east is a small town with houses in neat rows down streets and further south of that is a tropical forest. ", 0, false)
        Location desert = new Location("a sandy dry desert suck the moisture out of you as you enter it", 0, false);
        Location street = new Location ("a street lined with houses ", "an foot steps on you and crushes your shell find calcium rich food to repair it. there might be some fruit near by that has calcium", 3, false);
        Plant tulip = new Plant("Tulip","large, showy and brightly colored flowers planted along the street",false, 4, true);
        Plant rose = new Plant("roses", "lovely bushes with large flowers in red growing in front of the white picket fences in every yard", false, true, false)
        street.addPlant(tulip);
        street.addPlant(rose);
        Map map = new Map();
        map.map[0][0] = forest;
        map.map[0][1] = garden;
        map.map[0][2] = lake;
        map.map[1][0] = marsh;
        map.map[1][1] = meadow;
        map.map[1][2] = mountainTop;
        map.map[2][0] = denseForest;
        map.map[2][1] = desert;
        map.map[2][2] = street;
        Conversation convo = new Conversation();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome. Type your snail's name to begin.");
        String name = userInput.nextLine();
        Snail me = new Snail(name, map);
        while(convo.active) {
            
            //if(response.equals("quit")) {
            //    active = false;
            //}
            convo.response(me, userInput);
        }
        userInput.close();
    }
}

