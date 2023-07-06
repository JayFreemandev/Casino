package comp;

import comp.analyzer.CompAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import comp.parser.CompStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("CompAnalyzer 테스트")
public class CompAnalyzerTest {
    private CompAnalyzer compAnalyzer;
    private CompStatementParser compStatementParser;

    @BeforeEach
    public void setUp() {
        //compAnalyzer = new compAnalyzer();
        compStatementParser = mock(CompStatementParser.class);
    }

    @Test
    @DisplayName("입력 파일을 분석하는 테스트")
    public void analyzeFile() throws IOException {
        // given
        String fileName = "bank-data-simple.csv";
        Path path = Paths.get("src/main/resources/", fileName);
        List<String> lines = Files.readAllLines(path);

        // when
        compAnalyzer.analyze(fileName, compStatementParser);

        // then
        verify(compStatementParser).parseLinesFrom(lines);
    }
}