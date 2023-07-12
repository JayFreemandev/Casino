package comp.analyzer;

import comp.comp.CompTransaction;
import comp.parser.CompStatementParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

public class CompAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final CompStatementParser compStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<CompTransaction> compTransactions = compStatementParser.parseLinesFrom(lines);
        final CompStatementProcessor compStatementProcessor = new CompStatementProcessor(compTransactions);
        collectSummary(compStatementProcessor);
    }

    private static void collectSummary(CompStatementProcessor compStatementProcessor) {
        System.out.println("콤푸 기록 총 합계: " + compStatementProcessor.calculateTotalAmount());
        System.out.println("콤푸 기록 1월 합계: " + compStatementProcessor.calculateTotalInMonth(JANUARY));
        System.out.println("콤푸 기록 2월 합계: " + compStatementProcessor.calculateTotalInMonth(FEBRUARY));
        System.out.println("콤푸 기록 카테고리별 합계: " + compStatementProcessor.calculateTotalForCategory("마일리지"));
    }
}