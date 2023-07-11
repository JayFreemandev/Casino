package agent.exception;

public enum AgentExceptionType {

    INVALID_ERROR_MESSAGE("INVALID_ERROR_MESSAGE"),
    INVALID_CUSTOMER("INVALID_CUSTOMER"),
    INVALID_ROOM("INVALID_ROOM"),
    RESERVATION_FAILED("RESERVATION_FAILED"),
    CONVERSION_FAILED("CONVERSION_FAILED"),
    MEAL_PREPARATION_FAILED("MEAL_PREPARATION_FAILED");

    private final String key;

    AgentExceptionType(String key) {
        this.key = key;
    }

    public String getMessage() {
        return AgentExceptionMessages.getMessage(key);
    }
}