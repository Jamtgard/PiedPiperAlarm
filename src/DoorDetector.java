import java.util.Scanner;

public class DoorDetector extends Sensor{

    private int correctPin = 1995;

    public DoorDetector(String sensorName, boolean activated, boolean triggered) {
        super(sensorName, activated, triggered);
    }

    @Override
    public void setTriggered(boolean triggered) {
        super.setTriggered(triggered);
        if (triggered) {
            System.out.println("Dörrdetektorn har utlösts! Vänligen ange PIN-koden för att inaktivera.");
            Scanner scanner = new Scanner(System.in);
            int inputPassword = scanner.nextInt();

            if (inputPassword == correctPin) {
                super.setTriggered(false);
                System.out.println("PIN-koden är korrekt. Välkommen in.");
            } else {
                System.out.println("Fel PIN-kod. Dörrdetektorn förblir utlösts.");
            }
        }
    }

    public int getCorrectPin(){return correctPin;}
    public void setCorrectPassword(){this.correctPin = correctPin;}

}
