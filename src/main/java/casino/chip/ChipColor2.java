package casino.chip;

import java.util.Arrays;
import java.util.function.Function;

public enum ChipColor2 {
    RED(chip -> chip.getFee() * 5),
    BLACK(chip -> chip.getFee() * 10),
    GOLD(chip -> chip.getFee() * 100);

    private final Function<Chip, Long> feeCalculator;

    ChipColor2(Function<Chip, Long> feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public long calculateChipFee(Chip chip) {
        return feeCalculator.apply(chip);
    }

    public static ChipColor getColor(String color) {
        return Arrays.stream(ChipColor.values())
                .filter(chipColor -> chipColor.name().equalsIgnoreCase(color))
                .findFirst()
                .orElse(null);
    }
}
