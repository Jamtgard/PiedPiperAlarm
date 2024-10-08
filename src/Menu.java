import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    CommandUnit commandUnit = new CommandUnit();

    public Menu(){}

    public void program(){
        boolean running = true;

        while (running){
            clearScreen();
            System.out.println("Meny:");
            System.out.println("1: Aktivera alarm.");
            System.out.println("2: Inaktivera alarm.");
            System.out.println("3: Testa specifikt alarm.");
            System.out.println("4: Testa ett slumpmässigt aktivt alarm.");
            System.out.println("5: Stäng av alla utlösta alarm");
            System.out.println("6: Avsluta programmet.");
            System.out.print("Val: ");

            int userChoice = scanner.nextInt();

            switch(userChoice) {
                case 1:
                    clearScreen();
                    commandUnit.activateAlarm();
                    break;
                case 2:
                    clearScreen();
                    commandUnit.deactivateAlarm();
                    break;
                case 3:
                    clearScreen();
                    commandUnit.triggerSpecificAlarm();
                    break;
                case 4:
                    clearScreen();
                    commandUnit.triggerRandomActiveAlarm();
                    break;
                case 5:
                    clearScreen();
                    commandUnit.silenceAllTriggeredAlarms();
                    break;
                case 6:
                    running = false;
                    clearScreen();
                    System.out.println("Programmet avslutas");
                    break;
                default:
                    clearScreen();
                    System.out.println("Felaktig inmatning, försök igen.");
            }
        }
    }

    public void clearScreen(){
        for (int i = 0; i < 30; i++){
            System.out.println(" ");
        }
    }
}
