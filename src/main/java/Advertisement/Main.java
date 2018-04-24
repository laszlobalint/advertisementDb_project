package Advertisement;

import Advertisement.adtype.ForRent;
import Advertisement.adtype.ForSale;
import Advertisement.adtype.SearchRoommate;
import Advertisement.dbaccess.DbConnector;
import Advertisement.dbaccess.SaveDataDb;
import Advertisement.extra.Encryption;
import Advertisement.extra.Serializer;
import Advertisement.menu.*;
import Advertisement.user.DbManagement;

public class Main {
    public static AddAdsSubmenu addAdsSubmenu = new AddAdsSubmenu();
    public static BrowseAdsSubmenu browseAdsSubmenu = new BrowseAdsSubmenu();
    public static DbManagement dbManagement = new DbManagement();
    public static DeleteAdsSubmenu deleteAdsSubmenu = new DeleteAdsSubmenu();
    public static EditAdsSubmenu editAdsSubmenu = new EditAdsSubmenu();
    public static Encryption encryption = new Encryption();
    public static ForRent forRent = new ForRent();
    public static ForSale forSale = new ForSale();
    public static MainMenu mainMenu = new MainMenu();
    public static SearchRoommate searchRoommate = new SearchRoommate();
    public static Serializer serializer = new Serializer();
    public static DbConnector dbConnector = new DbConnector("root", "toor");
    public static SaveDataDb saveDataDb = new SaveDataDb();

    public static void main(String[] args) throws Exception {
        dbManagement.loadUsers();
        forRent.loadForRent();
        forSale.loadForSale();
        searchRoommate.loadSearchMate();
        mainMenu.runMenu();
    }
}
