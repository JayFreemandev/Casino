package casino.chip;

public class Chip {
    private ChipColor chipColor;
    private Long fee;

    public Chip() {
    }

    public Long getFee() {
        return fee;
    }

    public ChipColor getChipColor() {
        return chipColor;
    }

    public long calculateChipFee(Chip chip) {
        ChipColor chipColor = chip.getChipColor();
        long fee = chip.getFee();

        if (chipColor == ChipColor.RED) {
            fee = fee * 5;
        } else if (chipColor == ChipColor.BLACK) {
            fee = fee * 10;
        } else if (chipColor == ChipColor.GOLD) {
            fee = fee * 100;
        }

        return fee;
    }
}
