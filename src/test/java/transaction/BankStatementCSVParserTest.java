package transaction;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import transaction.csv.BankStatementCSVParser;
import transaction.domain.BankTransaction;
import transaction.parser.BankStatementParser;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

@DisplayName("BankStatementCSVParser 테스트")
public class BankStatementCSVParserTest {
    private BankStatementParser parser;

    @BeforeEach
    void setUp() {
        parser = new BankStatementCSVParser();
    }

    @Test
    @DisplayName("한 줄의 정상적인 데이터를 파싱하는 테스트")
    public void parseOneCorrectLine() {
        // given
        String line = "03-05-2023,-22000,마라탕";

        // when
        parser = new BankStatementCSVParser();
        BankTransaction bankTransaction = parser.parseFrom(line);

        // then
        LocalDate expectedDate = LocalDate.of(2023, Month.MAY, 3);
        double expectedAmount = -22000;
        String expectedDescription = "마라탕";

        assertEquals("날짜가 일치하지 않습니다.", expectedDate, bankTransaction.getDate());
        assertEquals("금액이 일치하지 않습니다.", expectedAmount, bankTransaction.getAmount(), 000.1);
        assertEquals("설명이 일치하지 않습니다.", expectedDescription, bankTransaction.getDescription());
    }
}
