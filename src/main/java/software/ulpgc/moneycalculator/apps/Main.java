package software.ulpgc.moneycalculator.apps;

import software.ulpgc.moneycalculator.architecture.control.*;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.apps.windows.view.MainFrame;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        List<Currency> currencies = new ApiCurrencyLoader().loadCurrency();
        Command calculateCommand = new CalculateCommand (
                mainFrame.amountField().initialize(),
                mainFrame.currencyDialogFrom().initialize(currencies),
                mainFrame.currencyDialogTo().initialize(currencies),
                new ApiExchangeRateLoader(),
                mainFrame.moneyDisplay());

        Command invertCommand = new InvertCommand(
                mainFrame.currencyDialogFrom(),
                mainFrame.currencyDialogTo()
        );

        mainFrame.add("calculate", calculateCommand)
                 .add("invert currencies", invertCommand);

        mainFrame.setVisible(true);
    }
}
