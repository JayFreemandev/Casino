package agent.global;

public class AgentConstant {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 Utility 클래스입니다.";

    private AgentConstant() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }

    public static final String RESERVATION = "reservation";
    public static final String MEAL = "meal";
    public static final String CURRENCY = "currency";

    /* 번들 모듈 */
    public static final String EXCEPTION_MESSAGE_BUNDLE = "CasinoxceptionMessages";
}
