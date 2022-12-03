import java.sql.*;

public class Database {
    public static void connect() throws SQLException {
        Connection connection;
        String username = "root";
        String password = "";
        String host = "jdbc:mysql://localhost/java_vending_machine";

        try {
            connection = DriverManager.getConnection(username, password, host);
        } catch (SQLException e) {
            System.out.println("Blad polaczenia z baza");
            System.out.println(e.getMessage());
        }
    }
}
