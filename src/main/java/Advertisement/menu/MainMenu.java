package Advertisement.menu;

import Advertisement.dbaccess.DataService;
import Advertisement.dbaccess.DbConnector;

import java.util.Scanner;

import static Advertisement.Main.*;
import static Advertisement.adtype.ForRent.rentAds;
import static Advertisement.adtype.ForSale.saleAds;
import static Advertisement.adtype.SearchRoommate.searchAds;
import static Advertisement.user.DbManagement.activeUser;
import static Advertisement.user.DbManagement.users;

public class MainMenu {
    private DataService dataService;
    DbConnector dbConnector = new DbConnector("root", "toor");
    boolean exit;

    public MainMenu(DataService dataService) {
        this.dataService = dataService;
    }

    public void runMenu() throws Exception {
        printHead();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    public void printMenu() {
        if (!activeUser.isIsLoggedIn()) {
            System.out.println("\nPlease, make your choice: ");
            System.out.println("1\t Registration ");
            System.out.println("2\t Login user ");
            System.out.println("0\t Exit program ");
        } else {
            System.out.println("\nPlease, make your choice: ");
            System.out.println("1\t Registration ");
            System.out.println("2\t Login user ");
            System.out.println("3\t Add new advertisement ");
            System.out.println("4\t Browse advertisements ");
            System.out.println("5\t Edit an advertisement ");
            System.out.println("6\t Delete an advertisement ");
            System.out.println("7\t Logout user ");
            System.out.println("8\t Show user profile ");
            System.out.println("9\t Change user profile ");
            System.out.println("10\t Delete user profile ");
            System.out.println("0\t Exit program ");
        }
    }

    public void printHead() {
        System.out.println("+---------------------------------------+");
        System.out.println("+            Welcome to my              +");
        System.out.println("+             real estate               +");
        System.out.println("+            agents databe!             +");
        System.out.println("+---------------------------------------+");
    }

    public int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        if (!activeUser.isIsLoggedIn()) {
            while (choice < 0 || choice > 2) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = Integer.parseInt(kb.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid selection. Please, try again. ");
                }
            }
            return choice;
        } else {
            while (choice < 0 || choice > 10) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = Integer.parseInt(kb.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid selection. Please, try again. ");
                }
            }
            return choice;
        }
    }

    public void performAction(int choice) throws Exception {
        if (!activeUser.isIsLoggedIn()) {
            switch (choice) {
                case 0:
                    exit = true;
                    dbManagement.writeToFile();
                    dbConnector.connect();
                    dataService.insertUsers(users);
                    dataService.insertForRent(rentAds);
                    dataService.insertForSale(saleAds);
                    dataService.insertSearchMate(searchAds);
                    dbConnector.closeConnection();
                    System.out.println("Exiting the program. ");
                    System.out.println("Good bye! ");
                    break;
                case 1:
                    dbManagement.addUser();
                    break;
                case 2:
                    dbManagement.loginUser();
                    break;
                default:
                    System.out.println("An unknown error has occurred. ");
            }
        } else {
            switch (choice) {
                case 0:
                    exit = true;
                    dbManagement.writeToFile();
                    dbConnector.connect();
                    dataService.insertUsers(users);
                    dataService.insertForRent(rentAds);
                    dataService.insertForSale(saleAds);
                    dataService.insertSearchMate(searchAds);
                    dbConnector.closeConnection();
                    System.out.println("Exiting the program. ");
                    System.out.println("Good bye! ");
                    break;
                case 1:
                    dbManagement.addUser();
                    break;
                case 2:
                    dbManagement.loginUser();
                    break;
                case 3:
                    addAdsSubmenu.runMenu();
                    break;
                case 4:
                    browseAdsSubmenu.runMenu();
                    break;
                case 5:
                    editAdsSubmenu.runMenu();
                    break;
                case 6:
                    deleteAdsSubmenu.runMenu();
                    break;
                case 7:
                    dbManagement.logoutUser();
                    break;
                case 8:
                    System.out.println(dbManagement.activeUser.toString());
                    break;
                case 9:
                    dbManagement.editUser();
                    break;
                case 10:
                    dbManagement.deleteUser();
                    break;
                default:
                    System.out.println("An unknown error has occurred. ");
            }
        }
    }
}
