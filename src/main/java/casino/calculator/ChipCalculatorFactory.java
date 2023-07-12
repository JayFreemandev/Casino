package casino.calculator;

import casino.casino.ChipColor;
import casino.global.CasinoExceptionConstant;

import java.util.HashMap;
import java.util.Map;

public class ChipCalculatorFactory {
    private static final Map<ChipColor, ChipCalculator> calculatorMap = new HashMap<>();

    private ChipCalculatorFactory() {
    }

    static {
        calculatorMap.put(ChipColor.RED, new RedChipCalculator());
        calculatorMap.put(ChipColor.BLACK, new BlackChipCalculator());
        calculatorMap.put(ChipColor.GOLD, new GoldChipCalculator());
    }

    public static ChipCalculator createChipCalculator(ChipColor chipColor) {
        ChipCalculator calculator = calculatorMap.get(chipColor);
        if (calculator == null) {
            throw new IllegalArgumentException(CasinoExceptionConstant.INVALID_CHIP_COLOR + chipColor);
        }
        return calculator;
    }

    // if else 반복문
/*    public static ChipCalculator createChipCalculator(ChipColor chipColor) {
        if (chipColor == ChipColor.RED) {
            return new RedChipCalculator();
        } else if (chipColor == ChipColor.BLACK) {
            return new BlackChipCalculator();
        } else if (chipColor == ChipColor.GOLD) {
            return new GoldChipCalculator();
        } else {
            throw new IllegalArgumentException("잘못된 칩 종류 입니다!: " + chipColor);
        }
    }*/

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