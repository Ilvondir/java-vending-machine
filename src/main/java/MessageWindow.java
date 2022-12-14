import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class MessageWindow extends JFrame {
    private JPanel mainPanel;
    private JButton closeButton;
    private JLabel imageLabel;
    private JLabel messageLabel;

    public MessageWindow(String msg) {
        super("Message window");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(455, 45, 300, 450);

        URL iconURL = getClass().getResource("img/icon.png");
        ImageIcon icon1 = new ImageIcon(Objects.requireNonNull(iconURL));
        this.setIconImage(icon1.getImage());

        ImageIcon icon = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/icon.png"))).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        imageLabel.setIcon(icon);
        messageLabel.setText(msg);
        this.setVisible(true);
        closeButton.addActionListener(e -> dispose());
    }
}
