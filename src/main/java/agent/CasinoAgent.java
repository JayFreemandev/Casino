package agent;

import java.util.Map;

public class CasinoAgent {
    private final Map<String, String> attributes;

    public CasinoAgent(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String attributeName) {
        return attributes.get(attributeName);
    }

    public static void main(String[] args) {

    }
}