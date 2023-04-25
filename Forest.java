import java.util.Set;
public class Forest extends Location{
    Snail snail;
    public Forest(String description) {
        super(description, 10.0, false);
        this.description = "you are in a large forest with big trees in the middle is a large fig tree. You can try to climb the tree but it will drain you energy and therefore your health but the fruit will restore it.";
    }
    public void plants(String s) {
        Plant hemlock = new Plant("hemlock", true, 1, true);
        Plant figTree = new Plant("Fig Tree", false, 20, false);
        Plant fig = new Plant("fallen fig", false, 1, false);
        this.plants.put(s, hemlock);
        this.plants.put(s, figTree);
        this.plants.put(s, fig);
    }
    public void description() {
        System.out.println(this.description + "the humidity is " + this.humidity);
        System.out.println("you see the following plants around");
        Set<String> setOfKeys = this.plants.keySet();
        System.out.println("some of the figs have dropped on the ground. They are very rich in calcium");
        if(this.plants.size() == 0) {
            System.out.println("");
        }
        else{
            for(String s : setOfKeys) {
                System.out.println(s);
            }
        }
    }

}
