package casino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CasinoDesk {
    private Long amount;
    private final List<Chip> chips = new ArrayList<>();

    public CasinoDesk(Long amount, Chip... chips) {
        this.amount = amount;
        this.chips.addAll(Arrays.asList(chips));
    }

    public Chip getChip(){
        return chips.remove(0);
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }
}
