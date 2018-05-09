package Advertisement.dbaccess;

import Advertisement.adtype.ForRent;
import Advertisement.adtype.ForSale;
import Advertisement.adtype.SearchRoommate;
import Advertisement.user.Users;

import java.sql.SQLException;

import static Advertisement.adtype.ForRent.rentAds;
import static Advertisement.adtype.ForSale.saleAds;
import static Advertisement.adtype.SearchRoommate.searchAds;
import static Advertisement.dbaccess.DbConnector.conn;
import static Advertisement.dbaccess.DbConnector.prepStmnt;
import static Advertisement.user.DbManagement.users;

public class SaveDataDb implements DataService {
    private Integer isForStudents;
    private Integer isSmoking;
    private Integer isMan;
    private Integer isMortgaged;

    public void insertUsers() throws SQLException {
        String truncate = "TRUNCATE TABLE users";
        prepStmnt = conn.prepareStatement(truncate);
        prepStmnt.execute();
        prepStmnt.close();
        System.out.println("Adding user profiles to MySQL database...");
        String query = "INSERT INTO users (name, username, password, dateOfBirth, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
        for (Users uP : users.values()) {
            prepStmnt = conn.prepareStatement(query);
            prepStmnt.setString(1, uP.getName());
            prepStmnt.setString(2, uP.getUsername());
            prepStmnt.setString(3, uP.getPassword());
            prepStmnt.setString(4, uP.getDateOfBirth());
            prepStmnt.setString(5, uP.getPhone());
            prepStmnt.setString(6, uP.getEmail());
            prepStmnt.execute();
            prepStmnt.close();
        }
    }

    public void insertForRent() throws SQLException {
        String truncate = "TRUNCATE TABLE rentAds";
        prepStmnt = conn.prepareStatement(truncate);
        prepStmnt.execute();
        prepStmnt.close();
        System.out.println("Adding for rent advertisements to MySQL database...");
        String query = "INSERT INTO rentAds (userId, text, county, cautionMonths, monthlyRent, currentExpenses, isSmoking, isForStudents, canBeMoved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        for (ForRent rA : rentAds.values()) {
            prepStmnt = conn.prepareStatement(query);
            if (rA.isSmoking()) {
                isSmoking = 1;
            } else {
                isSmoking = 0;
            }
            if (rA.isForStudents()) {
                isForStudents = 1;
            } else {
                isForStudents = 0;
            }
            prepStmnt.setString(1, String.valueOf(rA.getUserId()));
            prepStmnt.setString(2, rA.getText());
            prepStmnt.setString(3, rA.getCounty());
            prepStmnt.setString(4, String.valueOf(rA.getCautionMonths()));
            prepStmnt.setString(5, String.valueOf(rA.getMonthlyRent()));
            prepStmnt.setString(6, String.valueOf(rA.getCurrentExpenses()));
            prepStmnt.setString(7, String.valueOf(isSmoking));
            prepStmnt.setString(8, String.valueOf(isForStudents));
            prepStmnt.setString(9, rA.getCanBeMoved());
            prepStmnt.execute();
            prepStmnt.close();
        }
    }

    public void insertForSale() throws SQLException {
        String truncate = "TRUNCATE TABLE saleAds";
        prepStmnt = conn.prepareStatement(truncate);
        prepStmnt.execute();
        prepStmnt.close();
        System.out.println("Adding for sale advertiesements to MySQL database...");
        String query = "INSERT INTO saleAds (userId, text, county, wasBuilt, price, isMortgaged, canBeMoved) VALUES (?, ?, ?, ?, ?, ?, ?)";
        for (ForSale fS : saleAds.values()) {
            prepStmnt = conn.prepareStatement(query);
            if (fS.isMortgaged()) {
                isMortgaged = 1;
            } else {
                isMortgaged = 0;
            }
            prepStmnt.setString(1, String.valueOf(fS.getUserId()));
            prepStmnt.setString(2, fS.getText());
            prepStmnt.setString(3, fS.getCounty());
            prepStmnt.setString(4, String.valueOf(fS.getWasBuilt()));
            prepStmnt.setString(5, String.valueOf(fS.getPrice()));
            prepStmnt.setString(6, String.valueOf(isMortgaged));
            prepStmnt.setString(7, fS.getCanBeMoved());
            prepStmnt.execute();
            prepStmnt.close();
        }
    }

    public void insertSearchMate() throws SQLException {
        String truncate = "TRUNCATE TABLE searchAds";
        prepStmnt = conn.prepareStatement(truncate);
        prepStmnt.execute();
        prepStmnt.close();
        System.out.println("Adding looking for flatmates advertisements to MySQL database...");
        String query = "INSERT INTO searchAds (userId, text, county, cautionMonths, monthlyRent, isSmoking, isForStudents, currentInmate, isMan, canBeMoved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        for (SearchRoommate sM : searchAds.values()) {
            prepStmnt = conn.prepareStatement(query);
            if (sM.isSmoking()) {
                isSmoking = 1;
            } else {
                isSmoking = 0;
            }
            if (sM.isForStudents()) {
                isForStudents = 1;
            } else {
                isForStudents = 0;
            }
            if (sM.isMan()) {
                isMan = 1;
            } else {
                isMan = 0;
            }
            prepStmnt.setString(1, String.valueOf(sM.getUserId()));
            prepStmnt.setString(2, sM.getText());
            prepStmnt.setString(3, sM.getCounty());
            prepStmnt.setString(4, String.valueOf(sM.getCautionMonths()));
            prepStmnt.setString(5, String.valueOf(sM.getMonthlyRent()));
            prepStmnt.setString(6, String.valueOf(isSmoking));
            prepStmnt.setString(7, String.valueOf(isForStudents));
            prepStmnt.setString(8, String.valueOf(sM.getCurrentInmate()));
            prepStmnt.setString(9, String.valueOf(isMan));
            prepStmnt.setString(10, sM.getCanBeMoved());
            prepStmnt.execute();
            prepStmnt.close();
        }
    }
}