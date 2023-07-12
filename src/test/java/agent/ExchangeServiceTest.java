package agent;

import agent.exchange.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("ExchangeService 테스트")
public class ExchangeServiceTest {
    @Test
    @DisplayName("USD -> KRW 환전")
    public void testConvertCurrency() {
        // Given
        List<ExchangeRate> exchangeRates = new ArrayList<>();
        exchangeRates.add(new ExchangeRate(new CurrencyPair(Currency.USD, Currency.KRW), 1100.0));
        ExchangeService exchangeService = new ExchangeServiceImpl(exchangeRates);

        // When
        Optional<Double> convertedAmount = exchangeService.convertCurrency(100.0, Currency.USD, Currency.KRW);

        // Then
        assertTrue(convertedAmount.isPresent());
        assertEquals(110000.0, convertedAmount.get());
    }
}