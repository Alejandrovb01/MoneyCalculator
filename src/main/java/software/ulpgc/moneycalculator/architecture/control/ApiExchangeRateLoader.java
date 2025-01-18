package software.ulpgc.moneycalculator.architecture.control;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.model.ExchangeRate;
import static software.ulpgc.moneycalculator.apps.FixerApiClient.loadRatesFromJson;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class ApiExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate loadExchangeRate(Currency from, Currency to) {
        return new ExchangeRate(from, to, LocalDate.now(), calculateRate(from.code(), to.code()));
    }

    private double calculateRate(String from, String to) {
        try {
            Map<String, JsonElement> rates = toMap(loadRatesFromJson());
            double fromRate = rates.get(from).getAsDouble();
            double toRate = rates.get(to).getAsDouble();

            return (1.0 / fromRate) * toRate;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.err.println("API access key is no longer valid: " + e.getMessage());
            System.exit(1);
            return 0;
        }
    }

    private Map<String, JsonElement> toMap(String json) {
        Map<String, JsonElement> rates = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        return rates;
    }
}