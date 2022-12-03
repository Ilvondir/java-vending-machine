import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.URL;
import java.sql.*;

public class VendingMachine extends JFrame {

    private JPanel mainPanel;
    private JTable stuffTable;
    private JTextField moneyField;
    private JTextField numberField;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton buyButton;
    private JButton a8Button1;
    private JButton a4Button;
    private JButton a7Button1;
    private JButton a0Button;
    private JButton cancelButton;
    private JButton a5ZlButton;
    private JButton a2ZlButton;
    private JButton a1ZlButton;
    private JButton a50GrButton;
    private JButton a20GrButton;
    private JButton a10GrButton;
    private JButton a5GrButton;
    private JButton a2GrButton;
    private JButton a1GrButton;

    private URL iconURL = getClass().getResource("img/icon.png");
    private ImageIcon icon = new ImageIcon(iconURL);

    public VendingMachine() throws SQLException {
        super("Snack Vending Machine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setIconImage(icon.getImage());
        this.setBounds(0, 0, 960, 540);
        moneyField.setFont(new Font("Digital-7", Font.PLAIN, 120));
        moneyField.setBorder(new LineBorder(Color.BLACK, 4));
        numberField.setFont(new Font("Digital-7", Font.PLAIN, 120));
        numberField.setBorder(new LineBorder(Color.BLACK, 4));
        createTable();
    }

    public void createTable() throws SQLException {
        String[] columnsNames = {"Distributor", "Name", "Number", "Price", "Remaining"};
        String[][] rows = new String[44][5];

        Connection conn = Database.connect();
        String sql = "select Producer, Name, Number, Price, Remaining from stuff";

        Statement stat = conn.createStatement();
        ResultSet results = stat.executeQuery(sql);

        int i = 0;
        while (results.next()) {
            String prod = results.getString("Producer");
            String name = results.getString("Name");
            String number = results.getString("Number");
            String price = results.getString("Price");
            String remaining = results.getString("Remaining");

            rows[i][0] = prod;
            rows[i][1] = name;
            rows[i][2] = number;
            rows[i][3] = price;
            rows[i][4] = remaining;

            i++;
        }


        DefaultTableModel tmodel = new DefaultTableModel(rows, columnsNames);

        stuffTable.setModel(tmodel);
    }

    public static void main(String[] args) throws SQLException {
        VendingMachine mySnackMachine = new VendingMachine();
        mySnackMachine.setVisible(true);

        Database.connect();
    }
}
