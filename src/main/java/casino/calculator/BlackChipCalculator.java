package casino.calculator;

import casino.casino.Chip;
import casino.global.CasinoConstant;

public class BlackChipCalculator implements ChipCalculator {
    @Override
    public long calculateChipFee(Chip chip) {
        return chip.getFee() * CasinoConstant.BLACK_CHIP_MULTIPLIER;
    }
}