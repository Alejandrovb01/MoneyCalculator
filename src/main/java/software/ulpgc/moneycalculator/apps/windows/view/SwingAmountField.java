package software.ulpgc.moneycalculator.apps.windows.view;

import javax.swing.*;
import java.awt.*;

public class SwingAmountField extends JPanel {
    private JTextField amountField;

    public SwingAmountField initialize() {
        add(createAmountField());
        return this;
    }

    private Component createAmountField() {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        this.amountField = textField;
        return textField;
    }

    public double get() {
        return Double.parseDouble(amountField.getText().replace(",", "."));
    }
}