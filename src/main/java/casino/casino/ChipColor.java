package casino.casino;

import casino.global.CasinoConstant;

import java.util.Arrays;
import java.util.function.Function;

public enum ChipColor {
    RED(chip -> chip.getFee() * CasinoConstant.RED_CHIP_MULTIPLIER),
    BLACK(chip -> chip.getFee() * CasinoConstant.BLACK_CHIP_MULTIPLIER),
    GOLD(chip -> chip.getFee() * CasinoConstant.GOLD_CHIP_MULTIPLIER);

    private final Function<Chip, Long> feeCalculator;

    ChipColor(Function<Chip, Long> feeCalculator) {
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
