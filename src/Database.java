import java.sql.*;

public class Database {
    public static Connection connect() throws SQLException {
        Connection connection = null;
        String username = "root";
        String password = "";
        String host = "jdbc:mysql://localhost/java_vending_machine";

        try {
            connection = DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            System.out.println("Blad polaczenia z baza");
            throw new SQLException(e.getMessage());
        } finally {
            return connection;
        }
    }

        public static void getProducts() {
            try {
                Connection connect = connect();
                String query = "select * from stuff";
                Statement stat = connect.createStatement();
                ResultSet rs = stat.executeQuery(query);

                int i = 0;
                while (rs.next()) {

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
