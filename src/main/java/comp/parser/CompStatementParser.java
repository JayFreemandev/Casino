package comp.parser;

import comp.domain.CompTransaction;

import java.util.List;

public interface CompStatementParser {
    CompTransaction parseFrom(String line);

    List<CompTransaction> parseLinesFrom(List<String> lines);
}
