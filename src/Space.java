import java.util.ArrayList;
import java.util.List;

public class Space {

    private String spaceName;
    private int numOfMovementDetector;
    private int numOfWindowDetector;
    private int numOfSmokeDetector;
    private int numOfDoorDetector;
    private List<Sensor> listOfSensorsInSpace = new ArrayList<>();

    //-----------------------------------Konstruktor------------------------------------------------------------------\\

    public Space(String spaceName, int numOfMovementDetector, int numOfWindowDetector, int numOfSmokeDetector, int numOfDoorDetector){
        this.spaceName = spaceName;
        this.numOfMovementDetector = numOfMovementDetector;
        this.numOfWindowDetector = numOfWindowDetector;
        this.numOfSmokeDetector = numOfSmokeDetector;
        this.numOfDoorDetector = numOfDoorDetector;
    }

    //-----------------------------------Metoder:-Add-Sensor----------------------------------------------------------\\

    public void addSensor() {
        for (int i = 0; i < numOfMovementDetector; i++) {
            MovementDetector movementDetector = new MovementDetector("Rörelsedetekor", false, false);
            listOfSensorsInSpace.add(movementDetector);
        }
        for (int j = 0; j < numOfWindowDetector; j++) {
            WindowDetector windowDetector = new WindowDetector("Fönsterdetektor", false, false);
            listOfSensorsInSpace.add(windowDetector);
        }
        for (int k = 0; k < numOfSmokeDetector; k++) {
            SmokeDetector smokeDetector = new SmokeDetector("Rökdetektor", true, false);
            listOfSensorsInSpace.add(smokeDetector);
        }
        for (int l = 0; l < numOfDoorDetector; l++) {
            DoorDetector doorDetector = new DoorDetector("Dörrdetektor", false, false);
            listOfSensorsInSpace.add(doorDetector);
        }
    }

    //-----------------------------------Getters-&-Setters------------------------------------------------------------\\

    public String getSpaceName() {return spaceName;}
    public void setSpaceName(String spaceName) {this.spaceName = spaceName;}

    public int getNumOfMovementDetector() {return numOfMovementDetector;}
    public void setNumOfMovementDetector(int numOfMovementDetector) {this.numOfMovementDetector = numOfMovementDetector;}

    public int getNumOfWindowDetector() {return numOfWindowDetector;}
    public void setNumOfWindowDetector(int numOfWindowDetector) {this.numOfWindowDetector = numOfWindowDetector;}

    public int getNumOfSmokeDetector() {return numOfSmokeDetector;}
    public void setNumOfSmokeDetector(int numOfSmokeDetector) {this.numOfSmokeDetector = numOfSmokeDetector;}

    public int getNumOfDoorDetector() {return numOfDoorDetector;}
    public void setNumOfDoorDetector(int numOfDoorDetector) {this.numOfDoorDetector = numOfDoorDetector;}

    public List<Sensor> getListOfSensorsInSpace() {return listOfSensorsInSpace;}
    public void setListOfSensorsInSpace(List<Sensor> listOfSensorsInSpace) {this.listOfSensorsInSpace = listOfSensorsInSpace;}

    @Override
    public String toString() {
        return "Space{" +
                "spaceName='" + spaceName + '\'' +
                ", numOfMovementDetector=" + numOfMovementDetector +
                ", numOfWindowDetector=" + numOfWindowDetector +
                ", numOfSmokeDetector=" + numOfSmokeDetector +
                ", numOfDoorDetector=" + numOfDoorDetector +
                ", listOfSensorsInSpace=" + listOfSensorsInSpace +
                '}';
    }
}
