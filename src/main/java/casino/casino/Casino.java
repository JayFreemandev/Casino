package casino.casino;

import casino.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Casino {
    private Long amount;
    private final List<Chip> chips = new ArrayList<>();

    public Casino(Long amount, Chip... chips) {
        this.amount = amount;
        this.chips.addAll(Arrays.asList(chips));
    }

    public Chip addChips() {
        return chips.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
