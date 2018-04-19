package Advertisement;

import java.util.Scanner;

public class DeleteAdsSubmenu extends MainMenu {
    static boolean exit;

    public static void runMenu() throws Exception {
        System.out.println("\nWhat kind of advertisement do you want to delete? ");
        System.out.println("1\t My for rent advertisements");
        System.out.println("2\t My for sell advertisements");
        System.out.println("3\t My search for inmates advertisements");
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
                ForRent.deleteForRent();
                break;
            case 2:
                ForSale.deleteForSale();
                break;
            case 3:
                SearchRoommate.deleteSearchMate();
                break;
            case 4:
                exit = true;
                break;
            default:
                System.out.println("An unknown error has occurred.");
        }
    }
}
