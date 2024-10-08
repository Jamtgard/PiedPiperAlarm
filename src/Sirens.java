public class Sirens extends Sensor{

    public Sirens(String sensorName, boolean activated, boolean triggered) {
        super(sensorName, activated, triggered);
    }

    @Override
    public void setTriggered(boolean triggered) {
        if (triggered && !isTriggered()) {
            super.setTriggered(true);
            triggerSirens();
        }
    }

    private void triggerSirens() {
        System.out.println(getSensorName() + " vid centralenheten ringer!");
    }

    public void silenceSirens() {
        setTriggered(false); // Tysta sirenen
        System.out.println("Sirenerna vid centralenheten har slutat ringa.");
    }

}
