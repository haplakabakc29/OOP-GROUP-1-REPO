
package paymentpart;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class OrderConfirmaPart extends JFrame {

    private JLabel mainTitle, checkIcon, statusLabel, idLabel;
    private JButton trackButton;
    private JPanel card;

    public OrderConfirmaPart() {
        setTitle("Order Confirmation Screen");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        mainTitle = new JLabel("Order Confirmation", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.ITALIC, 22));
        mainTitle.setBounds(100, 30, 350, 30);
        add(mainTitle);

        card = new JPanel();
        card.setLayout(null); 
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(Color.BLACK, 2));
        card.setBounds(100, 70, 350, 320); 
        add(card);

        checkIcon = new JLabel("✓", SwingConstants.CENTER);
        checkIcon.setFont(new Font("Monospaced", Font.BOLD, 50));
        checkIcon.setBorder(new LineBorder(Color.BLACK, 2, true));
        checkIcon.setBounds(135, 30, 80, 80);
        card.add(checkIcon);

        statusLabel = new JLabel("Order Placed!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 28));
        statusLabel.setBounds(25, 130, 300, 40);
        card.add(statusLabel);

        idLabel = new JLabel("Order ID: #12345", SwingConstants.CENTER);
        idLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        idLabel.setBounds(25, 175, 300, 30);
        card.add(idLabel);

        trackButton = new JButton("Thank You For Ordering");
        trackButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        trackButton.setBackground(Color.WHITE);
        trackButton.setFocusPainted(false);
        trackButton.setBorder(new LineBorder(Color.BLACK, 1));
        trackButton.setBounds(75, 240, 200, 40);
        card.add(trackButton);
    }

    public static void main(String[] args) {
        OrderConfirmaPart gui = new OrderConfirmaPart();
        gui.setVisible(true);
    }
}