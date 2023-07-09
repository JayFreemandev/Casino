package comp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import comp.csv.CompStatementCSVParser;
import comp.domain.CompTransaction;
import comp.parser.CompStatementParser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("CompStatementParser 테스트")
public class CompStatementCSVParserTest {
    private CompStatementParser parser;

    @BeforeEach
    void setUp() {
        parser = new CompStatementCSVParser();
    }

    @Test
    @DisplayName("한 줄의 정상적인 데이터를 파싱하는 테스트")
    public void parseOneCorrectLine() {
        // given
        String line = "03-05-2023,-22000,마라탕";

        // when
        parser = new CompStatementCSVParser();
        CompTransaction bankTransaction = parser.parseFrom(line);

        // then
        LocalDate expectedDate = LocalDate.of(2023, Month.MAY, 3);
        double expectedAmount = -22000;
        String expectedDescription = "마라탕";

        assertEquals("날짜가 일치하지 않습니다.", expectedDate, String.valueOf(bankTransaction.getDate()));
        assertEquals("금액이 일치하지 않습니다.", expectedAmount);
        assertEquals("설명이 일치하지 않습니다.", expectedDescription, bankTransaction.getDescription());
    }
}
