import jaco.mp3.player.MP3Player;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

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

    private final MP3Player buttonPlayer = new MP3Player(new File("src/audio/button.mp3"));
    private final MP3Player coinPlayer = new MP3Player(new File("src/audio/coin.mp3"));
    private final MP3Player buyPlayer = new MP3Player(new File("src/audio/submit.mp3"));
    private final MP3Player cancelPlayer = new MP3Player(new File("src/audio/cancel.mp3"));

    public VendingMachine() {
        super("Snack Vending Machine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(0, 0, 1210, 540);

        URL iconURL = getClass().getResource("img/icon.png");
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(iconURL));
        this.setIconImage(icon.getImage());

        MP3Player backgroundPlayer = new MP3Player(new File("src/audio/background.mp3"));
        backgroundPlayer.setRepeat(true);
        backgroundPlayer.play();

        DefaultTableModel model = createTable();

        moneyField.setFont(new Font("Digital-7", Font.PLAIN, 120));
        moneyField.setBorder(new LineBorder(Color.BLACK, 4));
        moneyField.setHorizontalAlignment(JTextField.CENTER);
        numberField.setFont(new Font("Digital-7", Font.PLAIN, 120));
        numberField.setBorder(new LineBorder(Color.BLACK, 4));
        numberField.setHorizontalAlignment(JTextField.CENTER);

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
            cancelPlayer.play();
            Rest cancelRest = new Rest(status);
            new MessageWindow("<html>" + cancelRest.spend());
        });

        buyButton.addActionListener(e -> {
            String selectedNumber = numberField.getText();
            if (!selectedNumber.equals("")) {
                buyPlayer.play();
                buyProduct(model, selectedNumber);
            }
        });
    }

    public void numericButton(String num) {
        buttonPlayer.play();
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

    public DefaultTableModel createTable() {
        Database stuffDatabase = new Database("jdbc:mysql://localhost/java_vending_machine", "root", "");
        ArrayList<Product> stuffList = stuffDatabase.getProducts();

        String[] columns = {"Producer", "Name", "Volume",  "Number", "Price", "Remaining"};

        String[][] rows = new String[stuffList.size()][6];

        int i=0;
        for (Product e : stuffList) {
            if (e instanceof Food) {
                rows[i][0] = e.getProducer();
                rows[i][1] = e.getName();
                rows[i][2] = "---";
                rows[i][3] = e.getNumber();
                rows[i][4] = String.valueOf(e.getPrice());
                rows[i][5] = String.valueOf(e.getRemaining());

            } else {
                rows[i][0] = e.getProducer();
                rows[i][1] = e.getName();
                rows[i][2] = String.valueOf(((Drink) e).getVolume());
                rows[i][3] = e.getNumber();
                rows[i][4] = String.valueOf(e.getPrice());
                rows[i][5] = String.valueOf(e.getRemaining());
            }
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(rows, columns);
        stuffTable.setModel(model);
        stuffTable.getColumnModel().getColumn(0).setPreferredWidth(180);
        stuffTable.getColumnModel().getColumn(1).setPreferredWidth(220);
        return model;
    }

    public void buyProduct(DefaultTableModel model, String number) {

        double money = Double.parseDouble(moneyField.getText());

        int index = -1;

        for (int i=0;i<model.getRowCount();i++) {
            String num = String.valueOf(model.getValueAt(i, 3));
            if (number.equals(num)) index = i;
        }

        if (index>-1) {
            String remaining = (String) model.getValueAt(index, 5);
            double price = Double.parseDouble(String.valueOf(model.getValueAt(index, 4)));

            double status = Double.parseDouble(moneyField.getText());
            moneyField.setText("0.00");
            numberField.setText("");
            Rest rest;

            if (price <= money) {
                rest = new Rest(status - price);
                new MessageWindow("<html>Udało się kupić produkt<br>o numerze " + number + ".<br><br>" + rest.spend());
                int rem = Integer.parseInt(remaining);
                rem--;

                if (rem>0) model.setValueAt(String.valueOf(rem), index, 5);
                else model.removeRow(index);
            } else {
                rest = new Rest(status);
                new MessageWindow("<html>Nie stać Cię na produkt<br>o numerze " + number + ".<br><br>" + rest.spend());
            }

        } else {
            double status = Double.parseDouble(moneyField.getText());
            moneyField.setText("0.00");
            numberField.setText("");

            Rest rest = new Rest(status);
            new MessageWindow("<html><span style=\"text-align: center\">Nie odnaleziono produktu<br>o numerze " + number + ".</span><br><br>" + rest.spend());
        }
    }

    public static void main(String[] args) {
        VendingMachine mySnackMachine = new VendingMachine();
        mySnackMachine.setVisible(true);
    }
}
