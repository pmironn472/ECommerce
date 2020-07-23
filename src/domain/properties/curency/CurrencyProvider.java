package domain.properties.curency;


import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyProvider {


    private Map<String, Currency> currencies = new HashMap<>() {{
        put("EUR", Currency.baseCurrency);
        put("USD", new Currency("USD", 16.97));
        put("MDL", new Currency("MDL", 19.63));
        put("RUB", new Currency("RUB", 81.96));
        put("RON", new Currency("RON", 4.84));
    }};

    public Currency getCurrency(String code) {
        return currencies.get(code);
    }


    private static class SingletonHolder {
        private static final CurrencyProvider INSTANCE = new CurrencyProvider();
    }

    public static CurrencyProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
