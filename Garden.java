import java.util.Set;
public class Garden extends Location{
    public Garden(String description, String situation) {
        super(description, situation, 10, true);
    }
    public void plant(String s) {
        Plant p = new Plant(s, true);
        this.plants.put(s, p);
        System.out.println("You have planted " + s);
    }
    
    public void description() {
        if(!this.hasPlayed) {
            System.out.println(this.situation);
            this.hasPlayed=true;
        }
        System.out.println(this.description + "the humidity is " + this.humidity);
        Set<String> setOfKeys = this.plants.keySet();
        if(this.plants.size()>0){
            System.out.println("You see the following plants that you have planted");
        }
        if(this.plants.size() == 0) {
            System.out.println("You haven't planted any plants here yet. Go collect some plants and you can plant them from your inventory by typing 'plant'");
        }
        else{
            for(String s : setOfKeys) {
                System.out.println(s);
            }
        }   
        }
    }

