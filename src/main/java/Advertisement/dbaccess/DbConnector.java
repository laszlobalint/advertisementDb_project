package Advertisement.dbaccess;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DbConnector {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_PATH = "jdbc:mysql://localhost/advertisements?verifyServerCertificate=false&useSSL=true";
    private String username;
    private String password;
    static Connection conn;
    private static Statement stat;
    static PreparedStatement prepStmnt;
    ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
            .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLUE)
            .build();

    public DbConnector(String name, String pass) {
        username = name;
        password = pass;
    }

    public void connect() throws Exception {
        Class.forName(DRIVER);
        cp.clear();
        cp.print(cp.getDateFormatted(), Ansi.Attribute.NONE, Ansi.FColor.CYAN, Ansi.BColor.BLACK);
        cp.clear();
        System.out.println("\nConnecting to MySQL database and loading data... \n");
        conn = DriverManager.getConnection(DB_PATH, username, password);
        stat = conn.createStatement();
    }

    public void closeConnection() throws Exception {
        stat.close();
        conn.close();
    }
}
