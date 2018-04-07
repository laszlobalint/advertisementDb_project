package Advertisement;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        DbManagement db = new DbManagement();
        MainMenu mainMenu = new MainMenu();
        DbManagement.loadUsers();
        mainMenu.runMenu();
    }
}
