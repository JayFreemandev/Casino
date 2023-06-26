package transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

public class BankAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("정팔이의 총 지출은  " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("정팔이의 1월 지출은 " + bankStatementProcessor.calculateTotalInMonth(JANUARY));
        System.out.println("정팔이의 2월 지출은 " + bankStatementProcessor.calculateTotalInMonth(FEBRUARY));
        System.out.println("정팔이의 총 급여는 " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}