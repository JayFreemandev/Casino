package casino;

public class Casino {
    private final Dealer dealer;

    public Casino(Dealer dealer) {
        this.dealer = dealer;
    }

    public void play(Customer customer){
        if(!customer.getCustomerBelonging().hasChip()){
            Chip chip = dealer.getCasinoDesk().getChip();
            customer.getCustomerBelonging().minusAmount(chip.getFee());
            dealer.getCasinoDesk().plusAmount(chip.getFee());
            customer.getCustomerBelonging().setChip(chip);
        }
    }
}
