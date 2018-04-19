package Advertisement;

import java.util.Scanner;

public class AddAdsSubmenu extends MainMenu {
    static boolean exit;

    public static void runMenu() throws Exception {
        System.out.println("\nWhat kind of advertisement would you like to add? ");
        System.out.println("1\t For rent");
        System.out.println("2\t For sale");
        System.out.println("3\t Searching for inmate");
        System.out.println("4\t Back to main menu");
        System.out.println("0\t Exit program");
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 4) {
            try {
                System.out.print("\nEnter your choice: ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid selection. Please, try again. ");
            }
        }
        performAction(choice);
    }

    public static void performAction(int choice) throws Exception {
        switch (choice) {
            case 0:
                exit = true;
                DbManagement.writeToFile();
                System.out.println("Exiting the program.");
                System.out.println("Good bye!");
                break;
            case 1:
                ForRent.addForRent();
                break;
            case 2:
                ForSale.addForSale();
                break;
            case 3:
                SearchRoommate.addSearchMate();
                break;
            case 4:
                exit = true;
                break;
            default:
                System.out.println("An unknown error has occurred.");
        }
    }
}
