package casino;

import casino.casino.Casino;
import casino.casino.Chip;
import casino.casino.ChipColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Nested
@DisplayName("Casino 테스트")
public class CasinoTest {

    @Test
    @DisplayName("칩의 색깔과 가격이 정상적으로 추가 되는가?")
    public void testAddChips() {
        // Given
        Casino casino = new Casino(100L, new Chip(ChipColor.RED));

        // When
        Chip addedChip = casino.addChips();

        // Then
        assertNotNull(addedChip);
    }

    @Test
    @DisplayName("금액이 올바르게 차감 되는가?")
    public void testMinusAmount() {
        // Given
        Casino casino = new Casino(100L);

        // When
        casino.minusAmount(50L);

        // Then
        long availableAmount = casino.getAvailableAmount();
        assertEquals(50L, availableAmount);
    }

    @Test
    @DisplayName("금액이 올바르게 추가 되는가?")
    public void testPlusAmount() {
        // Given
        Casino casino = new Casino(100L);

        // When
        casino.plusAmount(50L);

        // Then
        long availableAmount = casino.getAvailableAmount();
        assertEquals(150L, availableAmount);
    }
}
