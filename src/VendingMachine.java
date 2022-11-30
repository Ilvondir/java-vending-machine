import javax.swing.*;

public class VendingMachine extends JFrame {

    private JPanel mainPanel;

    public VendingMachine() {
        super("Snack Vending Machine");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100, 100, 400, 300);
    }

    public static void main(String[] args) {
        VendingMachine mySnackMachine = new VendingMachine();
        mySnackMachine.setVisible(true);
    }
}
