import java.sql.*;
import java.util.ArrayList;

public class Database {
        public static ArrayList<Product> getProducts() {
            ArrayList<Product> list = new ArrayList<>();

            Connection connection = null;
            String username = "root";
            String password = "";
            String host = "jdbc:mysql://localhost/java_vending_machine";

            try {
                connection = DriverManager.getConnection(host, username, password);
                String query = "select * from stuff";
                Statement stat = connection.createStatement();
                ResultSet results = stat.executeQuery(query);

                int i = 0;
                while (results.next()) {
                    String producer = results.getString("Producer");
                    String name = results.getString("Name");
                    String number = results.getString("Number");
                    double price = results.getDouble("Price");
                    double volume = results.getDouble("Volume");
                    int remaining = results.getInt("Remaining");
                    int type = results.getInt("Type_ID");

                    if (type==1) {
                        Food f = new Food(producer, name, number, price, remaining);
                        list.add(f);
                    } else {
                        Drink d = new Drink(producer, name, number, price, volume, remaining);
                        list.add(d);
                    }
                }

                return list;

            } catch (SQLException e) {
                System.out.println("Nie udalo sie polaczyc z baza produktow.");
                list.add(new Drink("Sink", "Woda niegazowana", "11", 2.00, 0.5, 10));
                list.add(new Food("Dirt", "Marchew", "12", 1.50,  5));
                return list;
            }
        }
}
