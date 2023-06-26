package casino.chip;

public class BlackChipCalculator implements ChipCalculator {
    @Override
    public long calculateChipFee(Chip chip) {
        long fee = chip.getFee();
        // BLACK 칩의 계산 로직
        return fee * 10;
    }
}