public class Sprinkler extends Sensor{


    public Sprinkler(String sensorName, boolean activated, boolean triggered) {
        super(sensorName, activated, triggered);
    }

    @Override
    public void setTriggered(boolean triggered) {
        super.setTriggered(triggered);
        if (triggered) {
            System.out.println("Sprinklersystemet har startats.");
        }
    }

}
