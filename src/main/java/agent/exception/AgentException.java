package agent.exception;

public class AgentException extends RuntimeException {
    private final AgentExceptionType exceptionType;

    public AgentException(AgentExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }

    public AgentExceptionType getExceptionType() {
        return exceptionType;
    }
}
