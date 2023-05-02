import java.util.Set;
public class Forest extends Location{
    Snail snail;
    public Forest(String description) {
        super(description, 10.0, false);
        this.description = "you are in a large forest with big trees in the middle is a large twisting tree lots of branches that would take a while to climb. It has fruit hanging from the branches";
        Plant fig = new Plant("fallen fig", "some of the fruit has dropped from the tree. they are rich in calcium and can help to restore a shell", false, false);
        Plant hemlock = new Plant("hemlock", "a small tree with little white flowers", true, true);
        this.addPlant(fig);
        this.addPlant(hemlock);
    }
    public void description() {
        System.out.println(this.description + "the humidity is " + this.humidity);
        System.out.println("you see the following plants:");
        Set<String> setOfKeys = this.plants.keySet();
        for(String s : setOfKeys) {
            System.out.println(plants.get(s).description);
        }
    }
}

