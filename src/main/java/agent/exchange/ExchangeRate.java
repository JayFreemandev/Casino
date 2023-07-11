package agent.exchange;

public class ExchangeRate {
    private final CurrencyPair currencyPair;
    private final double rate;

    public ExchangeRate(CurrencyPair currencyPair, double rate) {
        this.currencyPair = currencyPair;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public boolean hasCurrencyPair(Currency sourceCurrency, Currency targetCurrency) {
        return currencyPair.equals(new CurrencyPair(sourceCurrency, targetCurrency));
    }

    public double convertCurrency(double amount) {
        return amount * rate;
    }
}