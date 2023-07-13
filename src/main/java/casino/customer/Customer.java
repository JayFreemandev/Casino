package casino.customer;

import casino.calculator.ChipCalculatorFactory;
import casino.casino.Chip;
import casino.calculator.ChipCalculator;

public class Customer {
    private final CustomerBelonging customerBelonging;

    public Customer(CustomerBelonging customerBelonging) {
        this.customerBelonging = customerBelonging;
    }

    public Long buyChipFactoryVersion(Chip chip) {
        if (customerBelonging.hasMoney()) {
            ChipCalculator chipCalculator = ChipCalculatorFactory.createChipCalculator(chip.getChipColor());
            return chipCalculator.calculateChipFee(chip);
        } else {
            throw new IllegalStateException();
        }
    }
}
