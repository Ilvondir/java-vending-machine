import jaco.mp3.player.MP3Player;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

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
    private JButton a8Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton buyButton;
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

    private String buttonSoundPath = "src/audio/button.mp3";
    private MP3Player player = new MP3Player(new File(buttonSoundPath));

    private MP3Player coinPlayer = new MP3Player(new File("src/audio/coin.mp3"));

    public VendingMachine() throws SQLException {
        super("Snack Vending Machine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setIconImage(icon.getImage());
        this.setBounds(0, 0, 1210, 540);
        moneyField.setFont(new Font("Digital-7", Font.PLAIN, 120));
        moneyField.setBorder(new LineBorder(Color.BLACK, 4));
        moneyField.setHorizontalAlignment(JTextField.CENTER);
        numberField.setFont(new Font("Digital-7", Font.PLAIN, 120));
        numberField.setBorder(new LineBorder(Color.BLACK, 4));
        numberField.setHorizontalAlignment(JTextField.CENTER);
        createTable();

        a1GrButton.addActionListener(e -> coinButton(0.01));
        a2GrButton.addActionListener(e -> coinButton(0.02));
        a5GrButton.addActionListener(e -> coinButton(0.05));
        a10GrButton.addActionListener(e -> coinButton(0.10));
        a20GrButton.addActionListener(e -> coinButton(0.20));
        a50GrButton.addActionListener(e -> coinButton(0.50));
        a1ZlButton.addActionListener(e -> coinButton(1.00));
        a2ZlButton.addActionListener(e -> coinButton(2.00));
        a5ZlButton.addActionListener(e -> coinButton(5.00));

        a1Button.addActionListener(e -> numericButton("1"));
        a2Button.addActionListener(e -> numericButton("2"));
        a3Button.addActionListener(e -> numericButton("3"));
        a4Button.addActionListener(e -> numericButton("4"));
        a5Button.addActionListener(e -> numericButton("5"));
        a6Button.addActionListener(e -> numericButton("6"));
        a7Button.addActionListener(e -> numericButton("7"));
        a8Button.addActionListener(e -> numericButton("8"));
        a9Button.addActionListener(e -> numericButton("9"));
        a0Button.addActionListener(e -> numericButton("0"));

        cancelButton.addActionListener(e -> {
            double status = Double.parseDouble(moneyField.getText());
            moneyField.setText("0.00");
            numberField.setText("");

            Rest cancelRest = new Rest(status);
            new MessageWindow(cancelRest.spend());
        });
    }

    public void numericButton(String num) {
        player.play();
        String txt = numberField.getText();
        if (txt.length()<2) txt += num;
        else txt = num;
        numberField.setText(txt);
    }

    public void coinButton(double value) {
        double status = Double.parseDouble(moneyField.getText());
        int money = (int)((status+0.00001)*100);
        money += value*100;

        moneyField.setText(String.format(Locale.US, "%.2f", money/100.0));

        coinPlayer.play();
    }


    public void createTable() {
        ArrayList<Product> stuffList = Database.getProducts();

        String[] columns = {"Producer", "Name", "Volume",  "Number", "Price", "Remaining"};

        int i = 0;
        for (Object e : stuffList) i++;
        String[][] rows = new String[i][6];

        i=0;
        for (Product e : stuffList) {
            if (e instanceof Food) {
                rows[i][0] = ((Food) e).getProducer();
                rows[i][1] = ((Food) e).getName();
                rows[i][2] = "---";
                rows[i][3] = ((Food) e).getNumber();
                rows[i][4] = String.valueOf(((Food) e).getPrice());
                rows[i][5] = String.valueOf(((Food) e).getRemaining());

            } else {
                rows[i][0] = ((Drink) e).getProducer();
                rows[i][1] = ((Drink) e).getName();
                rows[i][2] = String.valueOf(((Drink) e).getVolume());
                rows[i][3] = ((Drink) e).getNumber();
                rows[i][4] = String.valueOf(((Drink) e).getPrice());
                rows[i][5] = String.valueOf(((Drink) e).getRemaining());
            }
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(rows, columns);
        stuffTable.setModel(model);
    }

    public static void main(String[] args) throws SQLException {
        VendingMachine mySnackMachine = new VendingMachine();
        mySnackMachine.setVisible(true);
        new MessageWindow("Nie");
    }
}
