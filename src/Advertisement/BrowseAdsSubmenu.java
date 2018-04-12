package Advertisement;

import java.util.Map;
import java.util.Scanner;

import static Advertisement.ForRent.rentAds;

public class BrowseAdsSubmenu extends MainMenu {
    static boolean exit;

    public static void runMenu() throws Exception {
        System.out.println("\nHow do you want to search? ");
        System.out.println("1\t Show all for rent ads");
        System.out.println("2\t Show all for sale ads");
        System.out.println("3\t Show all roommate search ads");
        System.out.println("4\t Search by user ID");
        System.out.println("5\t Search by advertisement ID");
        System.out.println("6\t Back to main menu");
        System.out.println("0\t Exit program");
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 6) {
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
                DbManagement.writeToFileUsers();
                System.out.println("Exiting the program.");
                System.out.println("Good bye!");
                break;
            case 1:
                System.out.println("\nAll for rent ads in the database:\n");
                for (Map.Entry<Integer, ForRent> entry : rentAds.entrySet()) {
                    System.out.println(entry.getValue().toString());
                }
                    break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("\nShow advertisements by user ID:\n");
                Scanner kb = new Scanner(System.in);
                int id = -1;
                while (id < 0 || id > DbManagement.users.lastKey()) {
                    try {
                        System.out.print("\nGive a user ID: ");
                        id = Integer.parseInt(kb.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid selection. Give an existing user ID. ");
                    }
                }
                    for (ForRent rent : rentAds.values()) {
                        if (rent.getUserId() == id) {
                            System.out.println(rent.toString() + "\n");
                        }
                    }
                    /*
                    for (ForSell sell : sellAds.values()) {
                        if (sell.getUserId == id) {
                            System.out.println(sell.toString() + "\n");
                        }
                    }
                    for (SearchRoommate mate : mateAds.values()) {
                        if (mate.getUserId == id) {
                            System.out.println(mate.toString() + "\n");
                        }
                    }
                    */
                break;
            case 5:
                System.out.println("\nShow advertisements by advertisement ID:\n");
                Scanner sb = new Scanner(System.in);
                id = -1;
                while (id < 0 || id > 1000) {
                    try {
                        System.out.print("\nGive an advertisement ID: ");
                        id = Integer.parseInt(sb.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid selection. Give an existing user ID. ");
                    }
                }
                for (ForRent rent : rentAds.values()) {
                    if (rent.getId() == id) {
                        System.out.println(rent.toString() + "\n");
                    }
                }
                    /*
                    for (ForSell sell : sellAds.values()) {
                        if (sell.getId == id) {
                            System.out.println(sell.toString() + "\n");
                        }
                    }
                    for (SearchRoommate mate : mateAds.values()) {
                        if (mate.getId == id) {
                            System.out.println(mate.toString() + "\n");
                        }
                    }
                    */
                break;
            case 6:
                exit = true;
                break;
            default:
                System.out.println("An unknown error has occurred.");
        }
    }
}
