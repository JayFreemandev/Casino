package casino.calculator;

import casino.casino.Chip;
import casino.global.CasinoConstant;

public class GoldChipCalculator implements ChipCalculator {
    @Override
    public long calculateChipFee(Chip chip) {
        return chip.getFee() * CasinoConstant.GOLD_CHIP_MULTIPLIER;
    }
}