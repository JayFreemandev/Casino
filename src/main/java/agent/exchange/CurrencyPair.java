package agent.exchange;

import java.util.Objects;

public class CurrencyPair {
    private final Currency sourceCurrency;
    private final Currency targetCurrency;

    public CurrencyPair(Currency sourceCurrency, Currency targetCurrency) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CurrencyPair other = (CurrencyPair) obj;
        return Objects.equals(sourceCurrency, other.sourceCurrency) &&
                Objects.equals(targetCurrency, other.targetCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceCurrency, targetCurrency);
    }
}
