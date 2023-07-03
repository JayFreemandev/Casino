package casino.chip;

import java.util.Arrays;

public enum ChipColor {
    RED {
        @Override
        public long calculateChipFee(Chip chip) {
            long fee = chip.getFee();
            return fee * 5;
        }
    },
    BLACK {
        @Override
        public long calculateChipFee(Chip chip) {
            long fee = chip.getFee();
            return fee * 10;
        }
    },
    GOLD {
        @Override
        public long calculateChipFee(Chip chip) {
            long fee = chip.getFee();
            return fee * 100;
        }
    };

    public abstract long calculateChipFee(Chip chip);

    public ChipColor getColor(String color) {
        return Arrays.stream(ChipColor.values())
                .filter(chipColor -> chipColor.name().equalsIgnoreCase(color))
                .findFirst()
                .orElse(null);
    }
}
