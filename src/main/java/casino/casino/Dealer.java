package casino.casino;

import casino.customer.Customer;

public class Dealer {
    private final Casino casino;

    private final Chip chip;

    public Dealer(Casino casino, Chip chip) {
        this.casino = casino;
        this.chip = chip;
    }

    public Chip changeChip(Customer customer) {
        Long chipPrice = customer.buyChipFactoryVersion(chip);
        if (chipPrice > chip.getFee()) {
            throw new IllegalArgumentException();
        }

        casino.plusAmount(chipPrice);
        return casino.addChips();
    }
}
