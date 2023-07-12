package casino;

import casino.casino.Casino;
import casino.casino.Chip;
import casino.casino.ChipColor;
import casino.casino.Dealer;
import casino.customer.Customer;
import casino.customer.CustomerBelonging;
import casino.global.CasinoConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Nested
@DisplayName("Dealer 테스트")
public class DealerTest {

    @Test
    @DisplayName("돈받고 칩을 정확하게 건내주는가")
    public void testChangeChip() {
        // Given
        Casino casino = new Casino(100L);
        Chip chip = new Chip(ChipColor.RED, (long) CasinoConstant.RED_CHIP_MULTIPLIER);
        Customer customer = new Customer(new CustomerBelonging(200L));
        Dealer dealer = new Dealer(casino, chip);

        // When
        Chip changedChip = dealer.changeChip(customer);

        // Then
        assertNotNull(changedChip);
        assertEquals(chip, changedChip);
        assertEquals(150L, Optional.ofNullable(casino.getAvailableAmount()));
    }

    @Test
    @DisplayName("돈이 없다면 칩을 주면 안된다")
    public void testChangeChipWithInsufficientFunds() {
        // Given
        Casino casino = new Casino(100L);
        Chip chip = new Chip(ChipColor.RED, (long) CasinoConstant.RED_CHIP_MULTIPLIER);
        Customer customer = new Customer(new CustomerBelonging(200L));
        Dealer dealer = new Dealer(casino, chip);

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> dealer.changeChip(customer));
    }
}
