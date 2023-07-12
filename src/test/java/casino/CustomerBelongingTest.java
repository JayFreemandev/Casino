package casino;

import casino.casino.Chip;
import casino.casino.ChipColor;
import casino.customer.CustomerBelonging;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Nested
@DisplayName("CustomerBelonging 테스트")
class CustomerBelongingTest {

    @Test
    @DisplayName("돈이 있는지 없는지 확인 되는가?")
    public void testHasMoney() {
        // Given
        CustomerBelonging customerBelonging = new CustomerBelonging(50L);

        // When
        boolean hasMoney = customerBelonging.hasMoney();

        // Then
        assertTrue(hasMoney);
    }

    @Test
    @DisplayName("칩을 가지고 있는지 확인 되는가?")
    public void testHasChip() {
        // Given
        CustomerBelonging customerBelonging = new CustomerBelonging(new Chip(ChipColor.RED), 50L);

        // When
        boolean hasChip = customerBelonging.hasChip();

        // Then
        assertTrue(hasChip);
    }

    @Test
    @DisplayName("원하는 색깔의 칩을 가질 수 있는가?")
    public void testSetChip() {
        // Given
        CustomerBelonging customerBelonging = new CustomerBelonging(50L);
        Chip chip = new Chip(ChipColor.RED);

        // When
        customerBelonging.setChip(chip);

        // Then
        assertEquals(chip, customerBelonging.getChip());
    }
}
