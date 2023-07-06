package transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import transaction.analyzer.BankAnalyzer;
import transaction.parser.BankStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("BankAnalyzer 테스트")
public class BankAnalyzerTest {
    private BankAnalyzer bankAnalyzer;
    private BankStatementParser bankStatementParser;

    @BeforeEach
    public void setUp() {
        bankAnalyzer = new BankAnalyzer();
        bankStatementParser = mock(BankStatementParser.class);
    }

    @Test
    @DisplayName("입력 파일을 분석하는 테스트")
    public void analyzeFile() throws IOException {
        // given
        String fileName = "bank-data-simple.csv";
        Path path = Paths.get("src/main/resources/", fileName);
        List<String> lines = Files.readAllLines(path);

        // when
        bankAnalyzer.analyze(fileName, bankStatementParser);

        // then
        verify(bankStatementParser).parseLinesFrom(lines);
    }
}