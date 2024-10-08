public class SmokeDetector extends Sensor{

    private Sprinkler sprinkler;


    public SmokeDetector(String sensorName, boolean activated, boolean triggered) {
        super(sensorName, activated, triggered);
        this.sprinkler = new Sprinkler("Sprinklern", true, false);
    }

    public void setTriggered(boolean triggered) {
        super.setTriggered(triggered);
        if (triggered) {
                sprinkler.setTriggered(true);
        }
    }

    public Sprinkler getSprinkler() {return sprinkler;}
    public void setSprinkler(Sprinkler sprinkler) {this.sprinkler = sprinkler;}

}
