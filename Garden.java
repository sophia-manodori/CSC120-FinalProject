public class Garden extends Location{
    public Garden(String description) {
        super(description, 10, true);
    }
    public void plant(Plant s) {
        this.addPlant(s);
    }
    
}
