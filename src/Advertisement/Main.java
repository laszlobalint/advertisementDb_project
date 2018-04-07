package Advertisement;

import com.sun.xml.internal.txw2.output.DataWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        DbManagement db = new DbManagement();
        MainMenu mainMenu = new MainMenu();
        DbManagement.loadUsers();
        mainMenu.runMenu();
    }
}
