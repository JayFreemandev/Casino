package agent.agent;

import java.util.List;
import java.util.Optional;

public class AgentServiceImpl implements AgentService {
    private final AgentGroup agentGroup;

    public AgentServiceImpl(AgentGroup agentGroup) {
        this.agentGroup = agentGroup;
    }

    @Override
    public Optional<Agent> findAgentByName(String name) {
        return agentGroup.findAgentByName(name);
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentGroup.getAllAgents();
    }
}