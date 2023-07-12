package comp.analyzer;

import comp.comp.CompTransaction;

import java.time.Month;
import java.util.List;
import java.util.Optional;

public class CompStatementProcessor {
    private final List<CompTransaction> compTransactions;

    public CompStatementProcessor(List<CompTransaction> compTransactions) {
        this.compTransactions = compTransactions;
    }

    public double calculateTotalAmount() {
        return compTransactions.stream()
                .mapToDouble(CompTransaction::getAmount)
                .sum();
    }

    public double calculateTotalInMonth(final Month month) {
        return compTransactions.stream()
                .filter(transaction -> transaction.getDate().getMonth() == month)
                .mapToDouble(CompTransaction::getAmount)
                .sum();
    }

    public double calculateTotalForCategory(final String category) {
        return compTransactions.stream()
                .filter(transaction -> transaction.getDescription().equals(category))
                .mapToDouble(CompTransaction::getAmount)
                .sum();
    }

    public Optional<CompTransaction> findFirstTransactionByCategory(String category) {
        return compTransactions.stream()
                .filter(transaction -> transaction.getDescription().equals(category))
                .findFirst();
    }

    // 병렬
    public Optional<CompTransaction> findAnyTransactionAboveAmount(double amount) {
        return compTransactions.parallelStream()
                .filter(transaction -> transaction.getAmount() > amount)
                .findAny();
    }
}