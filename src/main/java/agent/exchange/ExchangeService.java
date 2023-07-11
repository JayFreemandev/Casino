package agent.exchange;

import java.util.Optional;

public interface ExchangeService {
    Optional<Double> convertCurrency(double amount, Currency sourceCurrency, Currency targetCurrency);
}