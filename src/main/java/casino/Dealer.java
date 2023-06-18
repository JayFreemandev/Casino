package casino;

public class Dealer {
    private CasinoDesk casinoDesk;

    public Dealer(CasinoDesk casinoDesk) {
        this.casinoDesk = casinoDesk;
    }

    public CasinoDesk getCasinoDesk(){
        return casinoDesk;
    }
}
