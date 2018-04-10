package Advertisement;

import com.sun.xml.internal.txw2.output.DataWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        DbManagement db = new DbManagement();
        MainMenu mainMenu = new MainMenu();
        AddAdsSubmenu adsSubmenu = new AddAdsSubmenu();
        BrowseAdsSubmenu browseAdsSubmenu = new BrowseAdsSubmenu();
        //String result = Encryption.encrypt("Papilion");
        //System.out.println(result);
        //System.out.println(Encryption.decrypt(result));
        DbManagement.loadUsers();
        ForRent.loadForRent();
        mainMenu.runMenu();
    }
}
