package Advertisement.dbaccess;

import Advertisement.adtype.ForRent;
import Advertisement.adtype.ForSale;
import Advertisement.adtype.SearchRoommate;
import Advertisement.user.Users;

import java.sql.SQLException;
import java.util.Map;
import java.util.NavigableMap;

public interface DataService {
    void insertUsers(NavigableMap<Integer, Users> users) throws SQLException;
    void insertForRent(Map<Integer, ForRent> rentAds) throws SQLException;
    void insertForSale(Map <Integer, ForSale> saleAds) throws SQLException;
    void insertSearchMate(Map <Integer, SearchRoommate> searchAds) throws SQLException;
}
