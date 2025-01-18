package software.ulpgc.moneycalculator.apps;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FixerApiClient {
    public static final String key = "5c039ec5d80b94f9402662fcc114a7d1";

    public static String loadSymbolsFromJson() throws IOException {
        URL url = new URL("http://data.fixer.io/api/symbols?access_key=" + key);
        try (InputStream inputStream = url.openStream()) {
            return new String(inputStream.readAllBytes());
        }
    }

    public static String loadRatesFromJson() throws IOException {
        URL url = new URL("http://data.fixer.io/api/latest?access_key=" + key);
        try (InputStream inputStream = url.openStream()) {
            return new String(inputStream.readAllBytes());
        }
    }
}
