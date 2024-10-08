public class Sensor {

    private String sensorName;
    private boolean activated;
    private boolean triggered;

    //-----------------------------------Konstruktor------------------------------------------------------------------\\

    public Sensor(String sensorName, boolean activated, boolean triggered){
        this.sensorName = sensorName;
        this.activated = activated;
        this.triggered = triggered;
    }

    //-----------------------------------Metoder----------------------------------------------------------------------\\

    public void activate(){this.activated = true;}
    public void deactivate(){this.activated = false;}

    public boolean isActivated(){return activated;}
    public boolean isTriggered() {return triggered;}

    public String getSensorName() {return sensorName;}
    public void setSensorName(String sensorName) {this.sensorName = sensorName;}

    public void setActivated(boolean activated) {this.activated = activated;}
    public void setTriggered(boolean triggered) {this.triggered = triggered;}

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorName='" + sensorName + '\'' +
                ", activated=" + activated +
                ", triggered=" + triggered +
                '}';
    }
}

