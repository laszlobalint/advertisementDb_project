package Advertisement.menu;

import Advertisement.dbaccess.DataService;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.util.Scanner;

import static Advertisement.Main.*;
import static Advertisement.user.DbManagement.activeUser;

public class MainMenu {
    private final DataService dataService;
    private boolean exit;

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
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.GREEN).background(Ansi.BColor.BLACK)
                .build();
        cp.println("");
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
        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.RED).background(Ansi.BColor.BLACK)
                .build();
        cp.println("");
        System.out.println("+---------------------------------------+");
        System.out.println("+            Welcome to my              +");
        System.out.println("+             real estate               +");
        System.out.println("+            agents databes!             +");
        System.out.println("+---------------------------------------+");
        cp.clear();
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
                    dbManagement.exitProcedure();
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
                    dbManagement.exitProcedure();
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
                    System.out.println(activeUser.toString());
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
