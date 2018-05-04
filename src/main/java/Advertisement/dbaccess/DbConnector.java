package Advertisement.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DbConnector {
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_PATH = "jdbc:mysql://localhost/advertisements?verifyServerCertificate=false&useSSL=true";
    String username;
    String password;
    static Connection conn = null;
    static Statement stat = null;
    static PreparedStatement prepStmnt = null;

    public DbConnector(String name, String pass) {
        username = name;
        password = pass;
    }

    public void connect() throws Exception {
        Class.forName(DRIVER);
        System.out.println("Connecting... ");
        conn = DriverManager.getConnection(DB_PATH, username, password);
        stat = conn.createStatement();
    }

    public void closeConnection() throws Exception {
        stat.close();
        conn.close();
    }
}
