package Advertisement;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        DbManagement db = new DbManagement();
        MainMenu mainMenu = new MainMenu();
        AddAdsSubmenu adsSubmenu = new AddAdsSubmenu();
        BrowseAdsSubmenu browseAdsSubmenu = new BrowseAdsSubmenu();
        DbManagement.loadUsers();
        ForRent.loadForRent();
        ForSale.loadForSale();
        SearchRoommate.loadSearchMate();
        mainMenu.runMenu();
    }
}
