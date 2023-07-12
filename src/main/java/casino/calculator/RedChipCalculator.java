package casino.calculator;

import casino.casino.Chip;
import casino.global.CasinoConstant;

public class RedChipCalculator implements ChipCalculator {
    @Override
    public long calculateChipFee(Chip chip) {
        return chip.getFee() * CasinoConstant.RED_CHIP_MULTIPLIER;
    }
}