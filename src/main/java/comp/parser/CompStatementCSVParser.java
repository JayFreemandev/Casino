package comp.parser;

import comp.parser.CompStatementParser;
import comp.comp.CompTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompStatementCSVParser implements CompStatementParser {
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
        return lines.stream()
                .map(this::parseFrom)
                .collect(Collectors.toList());
    }
}
