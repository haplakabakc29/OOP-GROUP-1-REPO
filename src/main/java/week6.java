import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class week6 extends JFrame {
    private JPanel itemsPanel;
    private JLabel totalLabel;
    private double grandTotal = 0.0;

    public week6() {
        setTitle("Shopping Cart");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Shopping Cart", SwingConstants.CENTER);
        header.setFont(new Font("Monospaced", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(header, BorderLayout.NORTH);

        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        totalLabel = new JLabel("Total: $0.00", SwingConstants.RIGHT);
        totalLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton checkoutBtn = new JButton("Proceed to Checkout");
        checkoutBtn.setFont(new Font("Monospaced", Font.BOLD, 14));
        checkoutBtn.setBackground(Color.WHITE);
        checkoutBtn.setFocusPainted(false);

        bottomPanel.add(totalLabel);
        bottomPanel.add(checkoutBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        addItemToCart("Product A", 50.00);
        addItemToCart("Product B", 80.00);
        addItemToCart("Product C", 120.00);

        setVisible(true);
    }

    private void addItemToCart(String name, double price) {
        JPanel row = new JPanel(new BorderLayout());
        row.setMaximumSize(new Dimension(400, 80));
        row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel iconLbl = new JLabel("[X]");
        JLabel nameLbl = new JLabel(name);
        
        iconLbl.setFont(new Font("Monospaced", Font.BOLD, 14));
        nameLbl.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        leftPanel.add(iconLbl); 
        leftPanel.add(nameLbl);
        row.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton minusBtn = new JButton("-");
        JLabel qtyLabel = new JLabel("1");
        JButton plusBtn = new JButton("+");
        
        minusBtn.setFont(new Font("Monospaced", Font.BOLD, 12));
        plusBtn.setFont(new Font("Monospaced", Font.BOLD, 12));
        qtyLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        
        JLabel qtyTitle = new JLabel("Qty: ");
        qtyTitle.setFont(new Font("Monospaced", Font.PLAIN, 14));

        plusBtn.addActionListener(e -> {
            int qty = Integer.parseInt(qtyLabel.getText());
            qtyLabel.setText(String.valueOf(qty + 1));
            updateGrandTotal(price);
        });

        minusBtn.addActionListener(e -> {
            int qty = Integer.parseInt(qtyLabel.getText());
            if (qty > 0) {
                qtyLabel.setText(String.valueOf(qty - 1));
                updateGrandTotal(-price);
            }
        });

        rightPanel.add(qtyTitle);
        rightPanel.add(minusBtn);
        rightPanel.add(qtyLabel);
        rightPanel.add(plusBtn);
        row.add(rightPanel, BorderLayout.EAST);

        itemsPanel.add(row);
        updateGrandTotal(price); 
        itemsPanel.revalidate();
    }

    private void updateGrandTotal(double amount) {
        grandTotal += amount;
        totalLabel.setText(String.format("Total: $%.2f", grandTotal));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new week6());
    }
}