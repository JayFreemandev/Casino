package casino;

public class Dealer {
    private final CasinoDesk casinoDesk;

    public Dealer(CasinoDesk casinoDesk) {
        this.casinoDesk = casinoDesk;
    }

    public CasinoDesk getCasinoDesk(){
        return casinoDesk;
    }
}
