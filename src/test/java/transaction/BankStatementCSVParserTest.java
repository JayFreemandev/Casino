package transaction;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    BankStatementParser parser = new BankStatementCSVParser();

    @Test
    public void parseOneCorrectLine() throws Exception {
        // given
        final String line = "03-05-2023,-22000,마라탕";

        // when
        BankTransaction bankTransaction = parser.parseFrom(line);

        // then
        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50d, "콤푸 식권");
        assertThat(bankTransaction.getDate()).isEqualTo(expected.getDate());
        assertThat(bankTransaction.getAmount()).isEqualTo(expected.getAmount());
        assertThat(bankTransaction.getDescription()).isEqualTo(expected.getDescription());
    }
}
