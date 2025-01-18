package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.apps.windows.view.CurrencySelector;
import software.ulpgc.moneycalculator.architecture.model.Currency;

public class InvertCommand implements Command {
    private final CurrencySelector currencySelectorTo;
    private final CurrencySelector currencySelectorFrom;

    public InvertCommand(CurrencySelector currencySelectorFrom, CurrencySelector currencySelectorTo) {
        this.currencySelectorFrom = currencySelectorFrom;
        this.currencySelectorTo = currencySelectorTo;
    }
    @Override
    public void execute() {
        Currency currencyFrom = currencySelectorFrom.get();
        Currency currencyTo = currencySelectorTo.get();
        currencySelectorFrom.set(currencyTo);
        currencySelectorTo.set(currencyFrom);
    }
}
