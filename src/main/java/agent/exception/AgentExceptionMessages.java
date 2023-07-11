package agent.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class AgentExceptionMessages {
    private static final String BUNDLE_NAME = "AgentExceptionMessages";
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault());

    public static String getMessage(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (Exception e) {
            throw new AgentException(AgentExceptionType.INVALID_ERROR_MESSAGE);
        }
    }
}