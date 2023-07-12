package casino;

import casino.casino.Chip;
import casino.casino.ChipColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@Nested
@DisplayName("Chip 테스트")
public class ChipTest {

    @Test
    @DisplayName("원하는 칩의 색깔을 가져오는가?")
    public void testGetChipColor() {
        // Given
        Chip chip = new Chip(ChipColor.RED);

        // When
        ChipColor color = chip.getChipColor();

        // Then
        assertEquals(ChipColor.RED, color);
    }

    @Test
    @DisplayName("원하는 칩의 가격이 정상적으로 계산 되는가?")
    public void testCalculateChipFee() {
        // Given
        Chip chip = new Chip(ChipColor.RED, 10L);

        // When
        long chipFee = chip.calculateChipFee(chip);

        // Then
        assertEquals(50L, chipFee);
    }
}
