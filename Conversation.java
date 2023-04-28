import java.util.Scanner;
public class Conversation {
    int responseNum = 0;
    boolean active;
    public void Conversation() {
        this.active=true;
    }
    
    public void response(String response, Snail me) {
        Scanner userInput = new Scanner(System.in);
        if(response.equals("options")) {
            me.current.options(me);
        }
        if(response.equals("health")) {
            System.out.println(me.myHealth());
        }
        if(response.equals("description")) {
            me.current.description();
        }
        if(response.equals("go north")) {
            try{me.goNorth();} catch(Exception e) {
                System.out.println(e);
            }

        }
        if(response.equals("go east")) {
            try{me.goEast();} catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(response.equals("go west")) {
            try{me.goWest();} catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(response.equals("go south")) {
            try {me.goSouth();} catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
         if(response.equals("smell")) {
            System.out.println("what plant would you like to smell?");
            String plant = userInput.nextLine();
            me.smell(plant);
            }
        if(response.equals("eat")) {
            System.out.println("what plant would you like to eat?");
            String plant = userInput.nextLine();
            try{
                me.eat(plant);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        if(response.equals("drink")) {
            try{
                me.hydrate();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(response.equals("help snail")) {
            me.canHelpSnail();
        }
        if(response.equals("feed snail")) {
            System.out.println("What have you decided to feed the snail?");
            String plant = userInput.nextLine();
            me.helpSnail(plant);
        }
        if(response.equals("go south"))
        try {me.goSouth();} catch(Exception e) {
            System.out.println(e);
        }
        if(response.equals("retreat")) {
            me.retreat();
        }
        if(response.equals("pickup")) {
            System.out.println("what plant would you like to pick up?");
            String plant = userInput.nextLine();
            me.pickUp(plant);
        }
        else {
            System.out.println("I don't understand. Try again, or type 'options' to see what you can do");
        }
        //if(response.equals("quit")) {
          //  System.out.println("Thanks for playing");
            //this.active=false;
        //}
    }
    
    public static void main(String[] args) {
        Location forest = new Location("A forest", 11, false);
        Location marsh = new Location("A marsh", 12, true);
        Garden garden = new Garden("Beautiful garden. Injured Snail");
        Location desert = new Location("desert", 0, false);
        Location tropic = new Location("tropical forest", 13, true);
        Map map = new Map();
        map.map[0][0] = forest;
        map.map[1][0] = marsh;
        map.map[0][1] = garden;
        map.map[1][1] = desert;
        Conversation convo = new Conversation();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome. Type your snail's name to begin.");
        String name = userInput.nextLine();
        Snail me = new Snail(name, map);
        boolean active = true;
        while(active) {
            String response = userInput.nextLine();
            response=response.toLowerCase();
            if(response.equals("quit")) {
                active = false;
            }
            convo.response(response, me);
        }
    }
}

