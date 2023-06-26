package casino.chip;

public class GoldChipCalculator implements ChipCalculator {
    @Override
    public long calculateChipFee(Chip chip) {
        long fee = chip.getFee();
        // GOLD 칩의 계산 로직
        return fee * 100;
    }
}