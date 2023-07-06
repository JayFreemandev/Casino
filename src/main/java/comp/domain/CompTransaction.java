package comp.domain;

import java.time.LocalDate;
import java.util.Objects;

public class CompTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public CompTransaction(
            final LocalDate date,
            final double amount,
            final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "콤푸 기록{" +
                "날짜=" + date +
                ", 금액=" + amount +
                ", 설명='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompTransaction that = (CompTransaction) o;
        return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
