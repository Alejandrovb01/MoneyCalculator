package software.ulpgc.moneycalculator.architecture.control;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static software.ulpgc.moneycalculator.apps.FixerApiClient.loadSymbolsFromJson;

public class ApiCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> loadCurrency() {
        try {
            return toList(loadSymbolsFromJson());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.err.println("API access key is no longer valid: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }

    private List<Currency> toList(String json) {
        List<Currency> list = new ArrayList<>();
        Map<String, JsonElement> symbols = new Gson().fromJson(json, JsonObject.class).get("symbols").getAsJsonObject().asMap();
        for (String symbol : symbols.keySet())
            list.add(new Currency(symbol, symbols.get(symbol).getAsString()));
        return list;
    }
}
