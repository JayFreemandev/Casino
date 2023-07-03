package casino.chip;

public class ChipCalculatorFactory {
    public static ChipCalculator createChipCalculator(ChipColor chipColor) {
        if (chipColor == ChipColor.RED) {
            return new RedChipCalculator();
        } else if (chipColor == ChipColor.BLACK) {
            return new BlackChipCalculator();
        } else if (chipColor == ChipColor.GOLD) {
            return new GoldChipCalculator();
        } else {
            throw new IllegalArgumentException("잘못된 칩 종류 입니다!: " + chipColor);
        }
    }

    // Java 12 Switch version
/*    public static ChipCalculator createChipCalculator2(ChipColor chipColor) {
        return switch (chipColor) {
            case RED -> new RedChipCalculator();
            case BLACK -> new BlackChipCalculator();
            case GOLD -> new GoldChipCalculator();
            default -> throw new IllegalArgumentException("잘못된 칩 종류 입니다!: " + chipColor);
        };
    }*/
}