package casino.chip;

import java.util.HashMap;
import java.util.Map;

public class ChipCalculatorMapFactory {
    private static final Map<ChipColor, ChipCalculator> calculatorMap = new HashMap<>();

    static {
        calculatorMap.put(ChipColor.RED, new RedChipCalculator());
        calculatorMap.put(ChipColor.BLACK, new BlackChipCalculator());
        calculatorMap.put(ChipColor.GOLD, new GoldChipCalculator());
    }
    public static ChipCalculator createChipCalculator(ChipColor chipColor) {
        ChipCalculator calculator = calculatorMap.get(chipColor);
        if (calculator == null) {
            throw new IllegalArgumentException("잘못된 칩 종류 입니다!: " + chipColor);
        }
        return calculator;
    }
}