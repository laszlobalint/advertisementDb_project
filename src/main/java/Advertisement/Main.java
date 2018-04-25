package Advertisement;

import Advertisement.adtype.ForRent;
import Advertisement.adtype.ForSale;
import Advertisement.adtype.SearchRoommate;
import Advertisement.menu.*;
import Advertisement.user.DbManagement;

public class Main {
    public static AddAdsSubmenu addAdsSubmenu = new AddAdsSubmenu();
    public static BrowseAdsSubmenu browseAdsSubmenu = new BrowseAdsSubmenu();
    public static DbManagement dbManagement = new DbManagement();
    public static DeleteAdsSubmenu deleteAdsSubmenu = new DeleteAdsSubmenu();
    public static EditAdsSubmenu editAdsSubmenu = new EditAdsSubmenu();
    public static ForRent forRent = new ForRent();
    public static ForSale forSale = new ForSale();
    public static SearchRoommate searchRoommate = new SearchRoommate();

    public static void main(String[] args) throws Exception {
        MainMenu mainMenu = new MainMenu();
        dbManagement.loadUsers();
        forRent.loadForRent();
        forSale.loadForSale();
        searchRoommate.loadSearchMate();
        mainMenu.runMenu();
    }
}
