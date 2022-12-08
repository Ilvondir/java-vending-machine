import javax.swing.*;
import java.awt.*;

public class MessageWindow extends JFrame {
    private JPanel mainPanel;
    private JButton closeButton;
    private JLabel imageLabel;
    private JLabel messageLabel;

    private ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("img/icon.png")).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

    public MessageWindow(String msg) {
        super("Message window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(280, 120, 400, 200);
        imageLabel.setIcon(icon);
        messageLabel.setText(msg);
        this.setVisible(true);
        closeButton.addActionListener(e -> dispose());
    }
}
