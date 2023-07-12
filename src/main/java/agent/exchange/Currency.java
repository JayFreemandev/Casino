package agent.exchange;

public enum Currency {

    USD("USD", "$"),
    KRW("KRW", "W");

    private final String code;
    private final String symbol;

    Currency(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }
}