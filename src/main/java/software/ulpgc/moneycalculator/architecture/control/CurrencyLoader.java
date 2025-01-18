package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> loadCurrency();
}
