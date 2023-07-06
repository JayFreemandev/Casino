package transaction;

import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class BankStatementCSVParserTest {
    BankStatementParser parser = new BankStatementCSVParser();

    @Test
    public void parseOneCorrectLine(){
        // given
        final String line = "03-05-2023,-22000,콤푸 식권";

        // when
        BankTransaction bankTransaction = parser.parseFrom(line);

        // then
        BankTransaction expected = new BankTransaction(LocalDate.of(2023, Month.MAY, 03), -22000, "콤푸 식권");
        assertEquals(expected.getDate(), bankTransaction.getDate());
        assertEquals(expected.getAmount(), bankTransaction.getAmount(), 0.001);
        assertEquals(expected.getDescription(), bankTransaction.getDescription());
    }
}
