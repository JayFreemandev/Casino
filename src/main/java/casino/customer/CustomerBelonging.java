package casino.customer;

import casino.casino.Chip;

public class CustomerBelonging {
    private Long amount;
    private Chip chip;

    public CustomerBelonging(long amount) {
        this(null, amount);
    }

    public CustomerBelonging(Chip chip, long amount) {
        this.amount = amount;
        this.chip = chip;
    }

    public boolean hasMoney() {
        return amount != null;
    }

    public boolean hasChip() {
        return chip != null;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Chip getChip() {
        return chip;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
