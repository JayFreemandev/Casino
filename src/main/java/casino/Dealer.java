package casino;

import casino.chip.Chip;

public class Dealer {
    private final Casino casino;

    private final Chip chip;

    public Dealer(
            Casino casino,
            Chip chip) {
        this.casino = casino;
        this.chip = chip;
    }

    public Casino getCasino(){
        return casino;
    }

    public Chip changeChip(Customer customer){
        Long chipPrice = customer.buyChipFactoryVersion(chip);
        if(chipPrice > chip.getFee()){
            return new Chip();
        }

        casino.plusAmount(chipPrice);
        return casino.getChip();
    }
}
