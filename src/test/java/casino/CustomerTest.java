package casino;

import casino.casino.Chip;
import casino.casino.ChipColor;
import casino.customer.Customer;
import casino.customer.CustomerBelonging;
import casino.global.CasinoConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.*;

@Nested
@DisplayName("Customer 테스트")
public class CustomerTest {

    @Test
    @DisplayName("돈에 맞게 칩을 구매할 수 있는가?")
    public void testBuyChip() {

        // Given
        Chip chip = new Chip(ChipColor.RED, (long) CasinoConstant.RED_CHIP_MULTIPLIER);
        CustomerBelonging customerBelonging = new CustomerBelonging(50L);
        customerBelonging.setChip(chip);
        Customer customer = new Customer(customerBelonging);

        // When
        Long chipPrice = customer.buyChipFactoryVersion(chip);

        // Then
        assertEquals(50L, Optional.ofNullable(chipPrice));
    }

    @Test
    @DisplayName("돈이 없다면 칩을 구매할 수 없다")
    public void testBuyChipWithInsufficientFunds() {

        // Given
        Chip chip = new Chip(ChipColor.RED);
        CustomerBelonging customerBelonging = new CustomerBelonging(50L);
        Customer customer = new Customer(customerBelonging);

        // When/Then
        assertThrows(IllegalStateException.class, () -> customer.buyChipFactoryVersion(chip));
    }
}