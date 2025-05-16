import java.util.*;

/**
 *  Menu Class for COMP1007 Assignment - This class deals with displaying the interactive menu
 * 
 *
 * author:  Caelan Leo-Ngu
 */
public class Main 
{   
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MissionController controller = new MissionController(sc);
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuSelection(sc);
            
            switch (choice) 
            {
                case 1:
                    controller.viewMissions();
                    break;
                case 2:
                    controller.viewMannedMissions();
                    break;
                case 3:
                    controller.viewUnmannedMissions();
                    break;
                case 4:
                    controller.viewMissionAstronauts();
                    break;
                case 5:
                    controller.addMission();
                    break;
                case 6:
                    controller.editExistingMission();
                    break;
                case 7:
                    controller.viewMissionSuccessRateSummary();
                    break;
                case 8:
                    controller.viewAstronautsByNationality();
                    break;
                case 9:
                    System.out.println("Exiting Mission Command and Control. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    public static void displayMenu()
    {
        System.out.println(
        "=============================================" + 
        "\n   Welcome to Mission Command and Control" +
        "\n=============================================" +
        "\nYour options for this system are listed below" +
        "\n1) View all missions" +
        "\n2) View all manned missions" +
        "\n3) View all unmanned missions." +
        "\n4) View a mission's astronauts." +
        "\n5) Add a new mission." +
        "\n6) Edit an existing mission." +
        "\n7) Summary of missions' success rates (average, highest, lowest)." +
        "\n8) List astronauts for a given nationality." +
        "\n9) Exit Mission Command and Control");
    }
    public static int getMenuSelection(Scanner sc) 
    {
        int userChoice = 0;

        do {
            try 
            {
                System.out.print("Please enter menu selection: ");
                userChoice = sc.nextInt();

                // check if user input is a valid menu option.
                if(userChoice < 1 || 8 < userChoice) 
                {
                    System.out.println("Invalid selection. Please enter an integer between 1-8.");
                    userChoice = 0;
                }
            }
            catch (InputMismatchException e) 
            {
                System.out.println("Please enter an integer.");
                sc.next();
            }
        } while (userChoice < 1 || userChoice > 9 );

        return userChoice;
    }
}   

