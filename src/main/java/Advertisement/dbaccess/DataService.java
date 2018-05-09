package Advertisement.dbaccess;

import java.sql.SQLException;

public interface DataService {
    void insertUsers() throws SQLException;
    void insertForRent() throws SQLException;
    void insertForSale() throws SQLException;
    void insertSearchMate() throws SQLException;
}
