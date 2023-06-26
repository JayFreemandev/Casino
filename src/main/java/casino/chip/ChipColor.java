package casino.chip;

import java.util.Arrays;

public enum ChipColor {
    RED(10L, "RED"),
    BLACK(30L, "BLACK"),
    GOLD(50L, "GOLD");
    private final Long fee;
    private final String color;

    ChipColor(
            Long fee,
            String color) {
        this.fee = fee;
        this.color = color;
    }

    public ChipColor getColor(String color) {
        return Arrays.stream(ChipColor.values())
            .filter(chipColor -> chipColor.color.equalsIgnoreCase(color))
            .findFirst()
            .orElse(null);
    }
}
