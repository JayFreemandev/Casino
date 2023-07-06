package comp.csv;

import comp.parser.CompStatementParser;
import comp.domain.CompTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CompStatementCSVParser implements CompStatementParser {
    // 05-04-2023
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CompStatementCSVParser() {
    }

    public CompTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        return new CompTransaction(date, amount, columns[2]);
    }

    public List<CompTransaction> parseLinesFrom(final List<String> lines) {
        final List<CompTransaction> compTransactions = new ArrayList<>();
        for (String line : lines) {
            compTransactions.add(parseFrom(line));
        }
        return compTransactions;
    }
}
