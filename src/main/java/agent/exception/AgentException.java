package agent.exception;

import static agent.global.AgentConstant.EXCEPTION_CLASS_CREATE_EXCEPTION_MESSAGE;

public class AgentException extends RuntimeException {
    private final AgentExceptionType exceptionType;

    private AgentException(){
        throw new IllegalStateException(EXCEPTION_CLASS_CREATE_EXCEPTION_MESSAGE);
    }

    public AgentException(AgentExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
