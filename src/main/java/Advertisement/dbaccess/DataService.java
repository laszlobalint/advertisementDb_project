package Advertisement.dbaccess;

import Advertisement.user.Users;

import java.sql.SQLException;
import java.util.NavigableMap;

public interface DataService {
    void insertUsers(NavigableMap<Integer, Users> users) throws SQLException;
    void insertForRent() throws SQLException;
    void insertForSale() throws SQLException;
    void insertSearchMate() throws SQLException;
}
