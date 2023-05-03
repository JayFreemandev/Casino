package transaction;

import org.junit.Assert;
import org.junit.Test;
import transaction.BankStatementCSVParser;
import transaction.BankStatementParser;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    public void parseOneCorrectLine() throws Exception{
        final String line = "2023-05-03, -22000, 마라탕";
        final BankTransaction result = bankStatementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2023, Month.MAY, 03), -22000, "마라탕");
        final double tolerance = 0.0d;
        Assert.assertEquals(expected.getDate(),result.getDate());
        Assert.assertEquals(expected.getAmount(),result.getAmount());
        Assert.assertEquals(expected.getDescription(),result.getDescription());
    }
}