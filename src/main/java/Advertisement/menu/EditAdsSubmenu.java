package Advertisement.menu;

import Advertisement.dbaccess.DataService;

import java.util.Scanner;

import static Advertisement.Main.*;
import static Advertisement.adtype.ForRent.rentAds;
import static Advertisement.adtype.ForSale.saleAds;
import static Advertisement.adtype.SearchRoommate.searchAds;
import static Advertisement.user.DbManagement.users;

public class EditAdsSubmenu extends MainMenu {
    boolean exit;

    public EditAdsSubmenu(DataService dataService) {
        super(dataService);
    }

    public void runMenu() throws Exception {
        System.out.println("\nWhat kind of advertisement would you like to edit? ");
        System.out.println("1\t My for rent advertisement ");
        System.out.println("2\t My for sale advertisement ");
        System.out.println("3\t My looking for inmates advertisements ");
        System.out.println("4\t Back to main menu ");
        System.out.println("0\t Exit program ");
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

    public void performAction(int choice) throws Exception {
        switch (choice) {
            case 0:
                exit = true;
                dbManagement.writeToFile();
                dbConnector.connect();
                saveDataDb.insertUsers(users);
                saveDataDb.insertForRent(rentAds);
                saveDataDb.insertForSale(saleAds);
                saveDataDb.insertSearchMate(searchAds);
                System.out.println("Exiting the program.  ");
                System.out.println("Good bye! ");
                break;
            case 1:
                forRent.editForRent();
                break;
            case 2:
                forSale.editForSale();
                break;
            case 3:
                searchRoommate.editSearchMate();
                break;
            case 4:
                exit = true;
                break;
            default:
                System.out.println("An unknown error has occurred. ");
        }
    }
}
