import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JTextField inputField;
    private JComboBox<String> currencyOptions;
    private JLabel resultLabel;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter amount in USD:"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);
        add(inputPanel);

        // Options Panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.add(new JLabel("Convert to:"));
        String[] currencies = {"INR (Indian Rupee)", "EUR (Euro)", "GBP (British Pound)"};
        currencyOptions = new JComboBox<>(currencies);
        optionsPanel.add(currencyOptions);
        add(optionsPanel);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        buttonPanel.add(convertButton);
        add(buttonPanel);

        // Result Panel
        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel("Converted Amount: ");
        resultPanel.add(resultLabel);
        add(resultPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Input and Conversion Logic
            double usdAmount = Double.parseDouble(inputField.getText());
            String selectedCurrency = (String) currencyOptions.getSelectedItem();
            double convertedAmount = 0;

            switch (selectedCurrency) {
                case "INR (Indian Rupee)":
                    convertedAmount = usdAmount * 82.50; // Example rate
                    break;
                case "EUR (Euro)":
                    convertedAmount = usdAmount * 0.92; // Example rate
                    break;
                case "GBP (British Pound)":
                    convertedAmount = usdAmount * 0.78; // Example rate
                    break;
            }

            // Display Result
            resultLabel.setText("Converted Amount: " + convertedAmount + " " + selectedCurrency.split(" ")[0]);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Enter a valid amount!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter converter = new CurrencyConverter();
            converter.setVisible(true);
        });
    }
}
