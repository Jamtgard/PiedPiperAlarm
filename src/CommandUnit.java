import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CommandUnit {

    Scanner scanner = new Scanner(System.in);
    List<Space> listOfSpaces = new ArrayList<>();

    private Sirens siren1 = new Sirens("Siren 1", true, false);
    private Sirens siren2 = new Sirens("Siren 2", true, false);

    //-----------------------------------Objekt-----------------------------------------------------------------------\\

    Space space1 = new Space("Garaget", 0, 1, 1, 1);
    Space space2 = new Space("Vardagsrummet", 0,2,1,1);
    Space space3 = new Space("Hallen", 0,1,1,1);
    Space space4 = new Space("Köket", 0,1,1,0);
    Space space5 = new Space("Sovrum nr1", 0,2,1,0);
    Space space6 = new Space("Sovrum nr2",0,1,1,0);
    Space space7 = new Space("Sovrum nr3",0,1,1,0);
    Space space8 = new Space("Sovrum nr4",0,2,1,0);
    Space space9 = new Space("Sovrum nr5",0,1,1,0);
    Space space10 = new Space("Trädgård Framsida",1,0,0,0);
    Space space11 = new Space("Trädgård baksida",1,0,0,0);

    //-----------------------------------Konstruktor------------------------------------------------------------------\\

    public CommandUnit(){

        listOfSpaces.add(space1);
        listOfSpaces.add(space2);
        listOfSpaces.add(space3);
        listOfSpaces.add(space4);
        listOfSpaces.add(space5);
        listOfSpaces.add(space6);
        listOfSpaces.add(space7);
        listOfSpaces.add(space8);
        listOfSpaces.add(space9);
        listOfSpaces.add(space10);
        listOfSpaces.add(space11);

        space1.addSensor();
        space2.addSensor();
        space3.addSensor();
        space4.addSensor();
        space5.addSensor();
        space6.addSensor();
        space7.addSensor();
        space8.addSensor();
        space9.addSensor();
        space10.addSensor();
        space11.addSensor();

    }

    //-----------------------------------Metod:-Choose-Space----------------------------------------------------------\\

    public int chooseSpace() {
        boolean validChoice = false;
        int userChoice = 0;

        System.out.println("Vänligen välj ett av följande rum: ");
        for (int i = 0; i < listOfSpaces.size(); i++) {
            System.out.println((i + 1) + ". " + listOfSpaces.get(i).getSpaceName());
        }

        while (!validChoice) {
            System.out.print("val: ");
            userChoice = scanner.nextInt();

            if (userChoice < 1 || userChoice >= listOfSpaces.size() +1) {
                System.out.println("Ogiltigt val av rum. Vänligen välj ett rum enligt listan ovan.");
            } else {
                validChoice = true;
            }
        }
        System.out.println("Du valde rum: " + listOfSpaces.get(userChoice - 1).getSpaceName());
        return userChoice -1;
    }

    //-----------------------------------Metod:-Choose-Sensor---------------------------------------------------------\\

    public int chooseSensor(int i){
        int userChoice = 0;
        int j = 0;

        System.out.println("Vänligen välj en av följande sensorer: ");
        for (Sensor sensor : listOfSpaces.get(i).getListOfSensorsInSpace()){
            System.out.println((j + 1) + ". " + sensor.getSensorName());
            j++;
        }
        System.out.print("val: ");
        userChoice = scanner.nextInt();
        return userChoice -1;
    }

    //-----------------------------------Metoder:-Trigger-Specific-&-Random-Alarm-------------------------------------\\

    public void triggerSpecificAlarm(){

        Scanner methodScanner = new Scanner(System.in);

        int selectedSpaceIndex = chooseSpace();
        int selectedSensorIndex = (chooseSensor(selectedSpaceIndex));

        Sensor selectedSensor = listOfSpaces.get(selectedSpaceIndex).getListOfSensorsInSpace().get(selectedSensorIndex);
        System.out.println("Alarm utlösts i rum: " + listOfSpaces.get(selectedSpaceIndex).getSpaceName() + " - " + selectedSensor.getSensorName());
        selectedSensor.setTriggered(true);
        System.out.println("Klicka Enter för att gå vidare");
        methodScanner.nextLine();

    }

    public void triggerRandomActiveAlarm() {

        Random random = new Random();
        Scanner methodScanner = new Scanner(System.in);

        Space selectedSpace;
        List<Sensor> activeSensors = new ArrayList<>();

        do {
            int randomSpaceIndex = random.nextInt(listOfSpaces.size());
            selectedSpace = listOfSpaces.get(randomSpaceIndex);

            activeSensors = new ArrayList<>();
            for (Sensor sensor : selectedSpace.getListOfSensorsInSpace()) {
                if (sensor.isActivated() || sensor instanceof SmokeDetector) {
                    activeSensors.add(sensor);
                }
            }
        } while (activeSensors.isEmpty());

        int randomActiveSensorIndex = random.nextInt(activeSensors.size());
        Sensor selectedActiveSensor = activeSensors.get(randomActiveSensorIndex);

        System.out.println("Alarm utlöst i rum: " + selectedSpace.getSpaceName() + " - " + selectedActiveSensor.getSensorName());
        selectedActiveSensor.setTriggered(true);
        triggerBothSirens();
        System.out.println("Klicka Enter för att gå vidare");
        methodScanner.nextLine();
    }

    //-----------------------------------Metoder:-Aktivera-Inaktivera-------------------------------------------------\\

    public void activateAlarm() {
        for (Space space : listOfSpaces) {
            for (Sensor sensor : space.getListOfSensorsInSpace()) {
                if (!(sensor instanceof SmokeDetector)) {
                    sensor.activate();
                }
            }
        }
        System.out.println("Alla detektorer har aktiverats. (Exklusive Rökdektetktorerna som alltid är aktiva)");
        System.out.println("Vänligen klicka Enter för att gå tillbaka");
        scanner.nextLine();
    }

    public void deactivateAlarm(){
        for (Space space : listOfSpaces){
            for (Sensor sensor : space.getListOfSensorsInSpace()){
                if (!(sensor instanceof SmokeDetector)){
                    sensor.deactivate();
                }
            }
        }
        System.out.println("Alla detektorer har inaktiverats. (Exklusive rökdetektorerna som alltid är aktiva)");
        System.out.println("Vänligen klicka Enter för att gå tillbaka");
        scanner.nextLine();
    }

    //-----------------------------------Metoder:-Silence-All-Alarms--------------------------------------------------\\

    public void silenceAllTriggeredAlarms() {
        boolean checkIfAnyAlarmTriggered = false;

        for (Space space : listOfSpaces) {
            for (Sensor sensor : space.getListOfSensorsInSpace()) {
                if (sensor.isTriggered()) {
                    sensor.setTriggered(false);
                    System.out.println("Alarmet i rummet " + space.getSpaceName() + " har stängts av: " + sensor.getSensorName());
                    checkIfAnyAlarmTriggered = true;
                    silenceBothSirens();
                }
            }
        }

        if (!checkIfAnyAlarmTriggered) {
            System.out.println("Inget alarm har ännu utlösts.");
        }

        System.out.println("Vänligen klicka Enter för att gå tillbaka");
        scanner.nextLine();
    }

    //-----------------------------------Metoder:-Silence-&-Trigger-Sirens--------------------------------------------\\

    public void silenceBothSirens() {
        siren1.silenceSirens();
        siren2.silenceSirens();
    }
    public void triggerBothSirens() {
        siren1.setTriggered(true);
        siren2.setTriggered(true);
    }

    //-----------------------------------Getters-&-Setters------------------------------------------------------------\\

    public Space getSpace1() {return space1;}
    public void setSpace1(Space space1) {this.space1 = space1;}

    public Space getSpace2() {return space2;}
    public void setSpace2(Space space2) {this.space2 = space2;}

    public Space getSpace3() {return space3;}
    public void setSpace3(Space space3) {this.space3 = space3;}

    public Space getSpace4() {return space4;}
    public void setSpace4(Space space4) {this.space4 = space4;}

    public Space getSpace5() {return space5;}
    public void setSpace5(Space space5) {this.space5 = space5;}

    public Space getSpace6() {return space6;}
    public void setSpace6(Space space6) {this.space6 = space6;}

    public Space getSpace7() {return space7;}
    public void setSpace7(Space space7) {this.space7 = space7;}

    public Space getSpace8() {return space8;}
    public void setSpace8(Space space8) {this.space8 = space8;}

    public Space getSpace9() {return space9;}
    public void setSpace9(Space space9) {this.space9 = space9;}

    public Space getSpace10() {return space10;}
    public void setSpace10(Space space10) {this.space10 = space10;}

    public Space getSpace11() {return space11;}
    public void setSpace11(Space space11) {this.space11 = space11;}

    public List<Space> getListOfSpaces() {return listOfSpaces;}
    public void setListOfSpaces(List<Space> listOfSpaces) {this.listOfSpaces = listOfSpaces;}

    //-----------------------------------Override-To-String-----------------------------------------------------------\\

    @Override
    public String toString() {
        return "CommandUnit{" +
                "listOfSpaces=" + listOfSpaces +
                ", space1=" + space1 +
                ", space2=" + space2 +
                ", space3=" + space3 +
                ", space4=" + space4 +
                ", space5=" + space5 +
                ", space6=" + space6 +
                ", space7=" + space7 +
                ", space8=" + space8 +
                ", space9=" + space9 +
                ", space10=" + space10 +
                ", space11=" + space11 +
                '}';
    }
}
