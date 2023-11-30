package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    String url = "jdbc:postgresql://localhost:5432/db_sinar_harapan_makmur";
    String username = System.getenv("USERNAME_DB");
    String password = System.getenv("PASSWORD_DB");
    private static Connection con;

    public Connection startConnect() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        return con;
    }

}