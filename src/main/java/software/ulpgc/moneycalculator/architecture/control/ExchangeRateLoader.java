package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate loadExchangeRate(Currency from, Currency to);
}
