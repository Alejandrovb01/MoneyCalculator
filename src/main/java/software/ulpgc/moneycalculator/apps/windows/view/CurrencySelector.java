package software.ulpgc.moneycalculator.apps.windows.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.util.List;

public interface CurrencySelector {
    CurrencySelector initialize(List<Currency> currencies);
    Currency get();
    void set(Currency currency);
}
