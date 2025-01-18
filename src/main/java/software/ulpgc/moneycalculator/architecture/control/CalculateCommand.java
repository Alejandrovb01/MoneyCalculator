package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculator.apps.windows.view.CurrencySelector;
import software.ulpgc.moneycalculator.apps.windows.view.SwingAmountField;
import software.ulpgc.moneycalculator.apps.windows.view.SwingMoneyDisplay;

public class CalculateCommand implements Command {
    private final SwingAmountField amountField;
    private final CurrencySelector currencySelectorTo;
    private final CurrencySelector currencySelectorFrom;
    private final ExchangeRateLoader exchangeRateLoader;
    private final SwingMoneyDisplay moneyDisplay;

    public CalculateCommand(SwingAmountField amountField, CurrencySelector currencySelectorFrom, CurrencySelector currencySelectorTo, ExchangeRateLoader exchangeRateLoader, SwingMoneyDisplay moneyDisplay) {
        this.amountField = amountField;
        this.currencySelectorFrom = currencySelectorFrom;
        this.currencySelectorTo = currencySelectorTo;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        try {
            double inputAmount = amountField.get();
            Currency currencyFrom = currencySelectorFrom.get();
            Currency currencyTo = currencySelectorTo.get();

            ExchangeRate exchangeRate = exchangeRateLoader.loadExchangeRate(currencyFrom, currencyTo);
            String result = String.valueOf(inputAmount * exchangeRate.rate());

            moneyDisplay.show(result);

        } catch (NumberFormatException e) {
            moneyDisplay.show("Invalid amount.");
        }
    }
}
