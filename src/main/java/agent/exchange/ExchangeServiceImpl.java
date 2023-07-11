package agent.exchange;

import agent.exception.AgentException;
import agent.exception.AgentExceptionType;

import java.util.List;
import java.util.Optional;

public class ExchangeServiceImpl implements ExchangeService {
    private final List<ExchangeRate> exchangeRates;

    private ExchangeServiceImpl(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    @Override
    public Optional<Double> convertCurrency(double amount, Currency sourceCurrency, Currency targetCurrency) {
        ExchangeRate exchangeRate = findExchangeRate(sourceCurrency, targetCurrency);
        if (exchangeRate != null) {
            double convertedAmount = exchangeRate.convertCurrency(amount);
            return Optional.of(convertedAmount);
        }
        return Optional.empty();
    }

    private ExchangeRate findExchangeRate(Currency sourceCurrency, Currency targetCurrency) {
        return exchangeRates.stream()
                .filter(rate -> rate.hasCurrencyPair(sourceCurrency, targetCurrency))
                .findFirst()
                .orElseThrow(() ->  new AgentException(AgentExceptionType.CONVERSION_FAILED));
    }
}
