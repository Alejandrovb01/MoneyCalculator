package software.ulpgc.moneycalculator.apps.windows.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencySelector extends JPanel implements CurrencySelector {
    private JComboBox<Currency> currencySelector;

    @Override
    public CurrencySelector initialize(List<Currency> currencies) {
        add(createCurrencySelector(currencies));
        return this;
    }

    private Component createCurrencySelector(List<Currency> currencies) {
        JComboBox<Currency> selector = new JComboBox<>();
        for (Currency currency : currencies) selector.addItem(currency);
        this.currencySelector = selector;
        return selector;
    }

    @Override
    public Currency get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());
    }

    public void set(Currency currency) {
        currencySelector.setSelectedItem(currency);
    }
}
