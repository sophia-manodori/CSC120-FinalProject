import java.util.Scanner;
public class Conversation {
    int responseNum = 0;
    
    public static void response(String response, Snail me) {
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
                System.out.println(e);
            }
        }
        if(response.equals("go west")) {
            try{me.goWest();} catch(Exception e) {
                System.out.println(e);
            }
        }
        if(response.equals("go south")) {
            try {me.goSouth();} catch(Exception e) {
                System.out.println(e);
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
            me.hydrate();
        }

        if(response.equals("go south"))
        try {me.goSouth();} catch(Exception e) {
            System.out.println(e);
        }
        if(response.equals("pickup")) {
            System.out.println("what plant would you like to pick up?");
            String plant = userInput.nextLine();
            me.pickUp(plant);
        }
    }
    
    public static void main(String[] args) {
        Conversation convo = new Conversation();
        boolean active= true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome. Type your snail's name to begin.");
        String name = userInput.nextLine();
        Snail me = new Snail(name);
        while(active) {
            String response = userInput.nextLine();
            response(response, me);
        }
    }
}

