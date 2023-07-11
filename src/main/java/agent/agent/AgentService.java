package agent.agent;

import java.util.List;
import java.util.Optional;

public interface AgentService {
    Optional<Agent> findAgentByName(String name);

    List<Agent> getAllAgents();
}
