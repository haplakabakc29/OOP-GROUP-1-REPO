package oop1;

import javax.swing.*;
import java.awt.*;

public class OOP1 extends JFrame {

    public OOP1() {
        setTitle("Gadget Store Homepage");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu homeMenu = new JMenu("Home");
        JMenu productsMenu = new JMenu("Products");
        JMenu contactMenu = new JMenu("Contact Us");
        menuBar.add(homeMenu);
        menuBar.add(productsMenu);
        menuBar.add(contactMenu);
        setJMenuBar(menuBar);

        JLabel headerLabel = new JLabel("Welcome to Gadget Store", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 32));

        JPanel productPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        productPanel.setBorder(BorderFactory.createTitledBorder("Featured Gadgets"));

        productPanel.add(createProductCard("Smartphone", "Latest Android phone", "Buy Now"));
        productPanel.add(createProductCard("Laptop", "High performance laptop", "Buy Now"));
        productPanel.add(createProductCard("Smartwatch", "Track your fitness", "Buy Now"));
        productPanel.add(createProductCard("Headphones", "Noise-cancelling headphones", "Buy Now"));
        productPanel.add(createProductCard("Camera", "Capture your moments", "Buy Now"));
        productPanel.add(createProductCard("Console", "Next-gen gaming console", "Buy Now"));

        JPanel promoPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        promoPanel.setBorder(BorderFactory.createTitledBorder("Hot Deals"));
        promoPanel.add(new JLabel("20% OFF on Smartphones!", JLabel.CENTER));
        promoPanel.add(new JLabel("Flash Sale: Gaming Consoles!", JLabel.CENTER));

        JLabel footerLabel = new JLabel("© 2026 Gadget Store - All Rights Reserved", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        setLayout(new BorderLayout(10, 10));
        add(headerLabel, BorderLayout.NORTH);
        add(productPanel, BorderLayout.CENTER);
        add(promoPanel, BorderLayout.EAST);
        add(footerLabel, BorderLayout.SOUTH);
    }

    private JPanel createProductCard(String title, String description, String buttonText) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel descLabel = new JLabel(description, JLabel.CENTER);
        JButton button = new JButton(buttonText);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(descLabel, BorderLayout.CENTER);
        card.add(button, BorderLayout.SOUTH);
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        return card;
    }

    public static void main(String[] args) {
    OOP1 app = new OOP1();
    app.setVisible(true);
    }
}
