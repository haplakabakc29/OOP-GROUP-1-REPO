package paymentpart;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPart extends JFrame {

    private JLabel mainTitle, methodLabel;
    private JPanel card;
    private JRadioButton cardInfoRadio;
    private JTextField cardNumberField, expiryField, cvvField;
    private JButton confirmButton;

    public PaymentPart() {
        setTitle("Payment Page");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        mainTitle = new JLabel("Payment Page", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.ITALIC, 22));
        mainTitle.setBounds(100, 20, 350, 30);
        add(mainTitle);

        card = new JPanel();
        card.setLayout(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(Color.BLACK, 2));
        card.setBounds(100, 60, 350, 340);
        add(card);

        methodLabel = new JLabel("Select Payment Method");
        methodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        methodLabel.setBounds(20, 15, 200, 20);
        card.add(methodLabel);

        cardInfoRadio = new JRadioButton("Card Info");
        cardInfoRadio.setBackground(Color.WHITE);
        cardInfoRadio.setSelected(true);
        cardInfoRadio.setBounds(20, 50, 100, 20);
        card.add(cardInfoRadio);

        cardNumberField = new JTextField("Card Number");
        cardNumberField.setBounds(40, 80, 270, 35);
        card.add(cardNumberField);

        expiryField = new JTextField("Expiry Date");
        expiryField.setBounds(40, 125, 150, 35);
        card.add(expiryField);

        cvvField = new JTextField("CVV");
        cvvField.setBounds(200, 125, 110, 35);
        card.add(cvvField);

        confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(40, 260, 270, 40);
        card.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                OrderConfirmaPart successScreen = new OrderConfirmaPart();
                successScreen.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        PaymentPart payment = new PaymentPart();
        payment.setVisible(true);
    }
}