package casino.chip;

public class RedChipCalculator implements ChipCalculator {
    @Override
    public long calculateChipFee(Chip chip) {
        long fee = chip.getFee();
        // RED 칩의 계산 로직
        return fee * 5;
    }
}