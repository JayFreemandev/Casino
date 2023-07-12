package casino.casino;

import casino.calculator.ChipCalculator;
import casino.calculator.ChipCalculatorFactory;

public class Chip {
    private ChipColor chipColor;
    private Long fee;

    public Chip() {
    }

    public Chip(ChipColor chipColor) {
        this.chipColor = chipColor;
    }

    public Long getFee() {
        return fee;
    }

    public ChipColor getChipColor() {
        return chipColor;
    }

    public long calculateChipFee(Chip chip) {
        ChipCalculator calculator = ChipCalculatorFactory.createChipCalculator(chip.getChipColor());
        return calculator.calculateChipFee(chip);
    }
}
