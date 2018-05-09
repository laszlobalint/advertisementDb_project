package Advertisement;

import Advertisement.adtype.ForRent;
import Advertisement.adtype.ForSale;
import Advertisement.adtype.SearchRoommate;
import Advertisement.dbaccess.SaveDataDb;
import Advertisement.menu.*;
import Advertisement.user.DbManagement;

public class Main {
    public static SaveDataDb saveDataDb = new SaveDataDb();
    public static AddAdsSubmenu addAdsSubmenu = new AddAdsSubmenu(saveDataDb);
    public static BrowseAdsSubmenu browseAdsSubmenu = new BrowseAdsSubmenu(saveDataDb);
    public static DbManagement dbManagement = new DbManagement();
    public static DeleteAdsSubmenu deleteAdsSubmenu = new DeleteAdsSubmenu(saveDataDb);
    public static EditAdsSubmenu editAdsSubmenu = new EditAdsSubmenu(saveDataDb);
    public static ForRent forRent = new ForRent();
    public static ForSale forSale = new ForSale();
    public static SearchRoommate searchRoommate = new SearchRoommate();

    public static void main(String[] args) throws Exception {
        MainMenu mainMenu = new MainMenu(saveDataDb);
        DbManagement.dbConnector.connect();
        dbManagement.loadUsers();
        forRent.loadForRent();
        forSale.loadForSale();
        searchRoommate.loadSearchMate();
        mainMenu.runMenu();
    }
}
