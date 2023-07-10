package agent;

import java.util.HashMap;
import java.util.Map;

public class CasinoAgentManagementSystem {
    private final Map<String, AgentImporter> extensionToImporter = new HashMap<>();

    public CasinoAgentManagementSystem() {
        extensionToImporter.put("reservation", new ReservationAgentImporter());
        extensionToImporter.put("meal", new MealAgentImporter());
        extensionToImporter.put("currency", new CurrencyAgentImporter());
    }


}