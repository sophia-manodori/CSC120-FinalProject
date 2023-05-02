import java.util.Scanner;
public class Conversation {
    int responseNum = 0;
    boolean active;
    public Conversation() {
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
            try {
                me.canHelpSnail();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(response.equals("feed snail")) {
            System.out.println("What have you decided to feed the snail?");
            String plant = userInput.nextLine();
            try {
                me.helpSnail(plant);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if(response.equals("go south"))
        try {me.goSouth();} catch(Exception e) {
            System.out.println(e);
        }
        if(response.equals("retreat")) {
            me.retreat();
        }
        if(response.equals("emerge")) {
            me.emerge();
        }
        if(response.equals("pickup")) {
            System.out.println("what plant would you like to pick up?");
            String plant = userInput.nextLine();
            me.pickUp(plant);
        }
        if(response.equals("quit")) {
            System.out.println("Thanks for playing");
            this.active=false;
        }
        else{
            System.out.println("I don't understand. Try again, or type 'options' to see what you can do");
        }
        userInput.close();
    }
    
    public static void main(String[] args) {
        Location forest = new Location("You are in a lush forest. Surrounded by large maple trees and damp soil beneath you. Dappled light shines through the leaves.", 11, false);
        Plant shitake = new Plant("Shitake", "A patch of brown mushrooms growing from the base of a tree.", false);
        Plant ivy = new Plant("Poison Ivy", "A spiraling plant with three shiny leaves at every arm", true);
        Plant moss = new Plant("Moss", "Short little patches of soft green fronds, damp with dew", false);
        forest.addPlant(shitake);
        forest.addPlant(moss);
        forest.addPlant(ivy);
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
        while(convo.active) {
            String response = userInput.nextLine();
            response=response.toLowerCase();
            //if(response.equals("quit")) {
            //    active = false;
            //}
            convo.response(response, me);
        }
        userInput.close();
    }
}

