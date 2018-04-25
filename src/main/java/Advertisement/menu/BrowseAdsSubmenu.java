package Advertisement.menu;

import Advertisement.adtype.ForRent;
import Advertisement.adtype.ForSale;
import Advertisement.adtype.SearchRoommate;

import java.util.Map;
import java.util.Scanner;

import static Advertisement.Main.dbManagement;
import static Advertisement.adtype.ForRent.rentAds;
import static Advertisement.adtype.ForSale.saleAds;
import static Advertisement.adtype.SearchRoommate.searchAds;
import static Advertisement.user.DbManagement.users;

public class BrowseAdsSubmenu extends MainMenu {
    boolean exit;

    public void runMenu() throws Exception {
        System.out.println("\nHow do you want to search? ");
        System.out.println("1\t Show all for rent ads ");
        System.out.println("2\t Show all for sale ads ");
        System.out.println("3\t Show all inmate search ads ");
        System.out.println("4\t Search by user ID ");
        System.out.println("5\t Search by advertisement ID ");
        System.out.println("6\t Back to main menu ");
        System.out.println("0\t Exit program ");
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

    public void performAction(int choice) throws Exception {
        switch (choice) {
            case 0:
                exit = true;
                dbManagement.writeToFile();
                System.out.println("Exiting the program. ");
                System.out.println("Good bye! ");
                break;
            case 1:
                System.out.println("\nAll for rent ads in the database: \n");
                for (Map.Entry <Integer, ForRent> entry : rentAds.entrySet()) {
                    System.out.println(entry.getValue().toString());
                }
                break;
            case 2:
                System.out.println("\nAll for sale ads in the database: \n");
                for (Map.Entry <Integer, ForSale> entry : saleAds.entrySet()) {
                    System.out.println(entry.getValue().toString());
                }
                break;
            case 3:
                System.out.println("\nAll search for inmates ads in the database: \n");
                for (Map.Entry <Integer, SearchRoommate> entry : searchAds.entrySet()) {
                    System.out.println(entry.getValue().toString());
                }
                break;
            case 4:
                System.out.println("\nShow advertisements by user ID: \n");
                Scanner kb = new Scanner(System.in);
                int id = -1;
                while (id < 0 || id > users.lastKey()) {
                    try {
                        System.out.print("\nGive a Advertisement.user ID: ");
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
                for (ForSale sale : saleAds.values()) {
                    if (sale.getUserId() == id) {
                        System.out.println(sale.toString() + "\n");
                    }
                }

                for (SearchRoommate search : searchAds.values()) {
                    if (search.getUserId() == id) {
                        System.out.println(search.toString() + "\n");
                    }
                }
                break;
            case 5:
                System.out.println("\nShow advertisements by advertisement ID: \n");
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

                for (ForSale sale : saleAds.values()) {
                    if (sale.getId() == id) {
                        System.out.println(sale.toString() + "\n");
                    }
                }

                for (SearchRoommate search : searchAds.values()) {
                    if (search.getId() == id) {
                        System.out.println(searchAds.toString() + "\n");
                    }
                }
                break;
            case 6:
                exit = true;
                break;
            default:
                System.out.println("An unknown error has occurred. ");
        }
    }
}
