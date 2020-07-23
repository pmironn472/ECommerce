package domain.properties;

import domain.properties.curency.Currency;
import domain.properties.curency.CurrencyProvider;

public class Money {

    private static CurrencyProvider currencyProvider = CurrencyProvider.getInstance();


    private Currency currencyCode;
    private Float amount;

    public Money(Float amount) {
        this.amount = amount;
        this.currencyCode = Currency.baseCurrency;
    }


    public Money(String currencyCode, Float amount) {
        this.currencyCode = currencyProvider.getCurrency(currencyCode);
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currencyCode;
    }

    public void setCurrency(Currency currency) {
        this.currencyCode = currency;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }


    public Money toCurrency(String currency) {


        Currency currency1 = currencyProvider.getCurrency(currency);

        if (currencyCode.getCode().equals("EUR"))
            return new Money(currency1.getCode(), amount * (float) currency1.getRate());
        else
            return new Money(currency,amount  * (float)currency1.getRate());


    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currencyCode);
    }
}
