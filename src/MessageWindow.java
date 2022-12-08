import javax.swing.*;

public class MessageWindow extends JFrame {
    private JPanel mainPanel;
    private JButton closeButton;
    private JLabel imageLabel;

    public MessageWindow() {
        super("Message window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(280, 120, 400, 200);
        this.setVisible(true);

        closeButton.addActionListener(e -> dispose());
    }

    private void createUIComponents() {
        imageLabel = new JLabel(new ImageIcon("img/icon.png"));
    }
}
