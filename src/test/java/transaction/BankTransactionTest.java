package transaction;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import transaction.domain.BankTransaction;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;


@DisplayName("BankTransaction 클래스 테스트")
public class BankTransactionTest {

    @Test
    @DisplayName("BankTransaction 객체의 Getter 테스트")
    public void gettersReturnCorrectValues() {
        // given
        LocalDate date = LocalDate.of(2023, Month.MAY, 3);
        double amount = -22000;
        String description = "마라탕";
        BankTransaction transaction = new BankTransaction(date, amount, description);

        // when
        LocalDate actualDate = transaction.getDate();
        double actualAmount = transaction.getAmount();
        String actualDescription = transaction.getDescription();

        // then
        assertEquals(date, actualDate);
        assertEquals(amount, actualAmount, 0.001);
        assertEquals(description, actualDescription);
    }
}
