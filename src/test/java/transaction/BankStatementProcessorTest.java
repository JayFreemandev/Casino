package transaction;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import transaction.analyzer.BankStatementProcessor;
import transaction.domain.BankTransaction;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@DisplayName("BankStatementProcessor 클래스 테스트")
public class BankStatementProcessorTest {
    private BankStatementProcessor processor;
    private List<BankTransaction> transactions;

    @Test
    @DisplayName("총 금액을 계산")
    public void calculateTotalAmount() {
        // given
        transactions = Arrays.asList(
                new BankTransaction(LocalDate.of(2023, Month.MAY, 3), -22000, "마라탕"),
                new BankTransaction(LocalDate.of(2023, Month.MAY, 4), 5000, "커피"),
                new BankTransaction(LocalDate.of(2023, Month.MAY, 5), -10000, "점심")
        );
        processor = new BankStatementProcessor(transactions);

        // when
        double totalAmount = processor.calculateTotalAmount();

        // then
        assertEquals(-27000, totalAmount, 0.001);
    }

    @Test
    @DisplayName("월의 총 금액을 계산")
    public void calculateTotalInMonth() {
        // given
        transactions = Arrays.asList(
                new BankTransaction(LocalDate.of(2023, Month.MAY, 3), -22000, "마라탕"),
                new BankTransaction(LocalDate.of(2023, Month.MAY, 4), 5000, "커피"),
                new BankTransaction(LocalDate.of(2023, Month.MAY, 5), -10000, "점심")
        );
        processor = new BankStatementProcessor(transactions);

        // when
        double totalInMay = processor.calculateTotalInMonth(Month.MAY);

        // then
        assertEquals(-27000, totalInMay, 0.001);
    }

    @Test
    @DisplayName("카테고리의 총 금액을 계산")
    public void calculateTotalForCategory() {
        // given
        transactions = Arrays.asList(
                new BankTransaction(LocalDate.of(2023, Month.MAY, 3), -22000, "마라탕"),
                new BankTransaction(LocalDate.of(2023, Month.MAY, 4), 5000, "커피"),
                new BankTransaction(LocalDate.of(2023, Month.MAY, 5), -10000, "점심")
        );
        processor = new BankStatementProcessor(transactions);

        // when
        double totalForFood = processor.calculateTotalForCategory("마라탕");

        // then
        assertEquals(-22000, totalForFood, 0.001);
    }
}