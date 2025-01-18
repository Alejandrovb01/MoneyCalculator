package software.ulpgc.moneycalculator.apps.windows.view;

import software.ulpgc.moneycalculator.architecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private SwingMoneyDisplay moneyDisplay;
    private SwingAmountField amountField;
    private CurrencySelector currencySelectorFrom;
    private CurrencySelector currencySelectorTo;

    public MainFrame() throws HeadlessException {
        this.setTitle("Money calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes

        gbc.gridx = 0; gbc.gridy = 0;
        this.add(createAmountField(), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        this.add(createMoneyDisplay(), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        this.add(createCurrencySelectorFrom(), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        this.add(createCurrencySelectorTo(), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        this.add(createCalculateButton(), gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        this.add(createInvertButton(), gbc);
    }

    private Component createAmountField() {
        SwingAmountField field = new SwingAmountField();
        this.amountField = field;
        return field;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencySelectorFrom() {
        SwingCurrencySelector selector = new SwingCurrencySelector();
        this.currencySelectorFrom = selector;
        return selector;
    }

    private Component createCurrencySelectorTo() {
        SwingCurrencySelector selector = new SwingCurrencySelector();
        this.currencySelectorTo = selector;
        return selector;
    }

    private Component createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> commands.get("calculate").execute());
        return button;
    }

    private Component createInvertButton() {
        JButton button = new JButton("↑↓");
        button.addActionListener(e -> {
            commands.get("invert currencies").execute();
            commands.get("calculate").execute();
        });

        return button;
    }

    public MainFrame add(String name, Command command) {
        commands.put(name, command);
        return this;
    }

    public SwingAmountField amountField() {
        return amountField;
    }

    public SwingMoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    public CurrencySelector currencyDialogFrom() {
        return currencySelectorFrom;
    }

    public CurrencySelector currencyDialogTo() {
        return currencySelectorTo;
    }
}
