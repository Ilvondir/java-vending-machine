import javax.swing.*;

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
    private JButton a5ZłButton;
    private JButton a2ZłButton;
    private JButton a1ZłButton;
    private JButton a50GrButton;
    private JButton a20GrButton;
    private JButton a10GrButton;
    private JButton a5GrButton;
    private JButton a2GrButton;
    private JButton a1GrButton;

    public VendingMachine() {
        super("Snack Vending Machine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(0, 0, 960, 540);
    }

    public static void main(String[] args) {
        VendingMachine mySnackMachine = new VendingMachine();
        mySnackMachine.setVisible(true);
    }
}
