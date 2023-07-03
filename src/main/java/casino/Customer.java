package casino;

import casino.chip.Chip;
import casino.chip.ChipCalculator;
import casino.chip.ChipCalculatorFactory;

public class Customer {
    private final CustomerBelonging customerBelonging;

    public Customer(CustomerBelonging customerBelonging) {
        this.customerBelonging = customerBelonging;
    }

    public CustomerBelonging getCustomerBelonging(){
        return customerBelonging;
    }

    public Long buyChipFactoryVersion(Chip chip){
        if(customerBelonging.hasMoney()){
            ChipCalculator chipCalculator = ChipCalculatorFactory.createChipCalculator(chip.getChipColor());
            return chipCalculator.calculateChipFee(chip);
        }else{
            return 0L;
        }
    }
}
