package agent.agent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AgentGroup {

    private final List<Agent> agents;

    public AgentGroup(final List<Agent> agents) {
        this.agents= new ArrayList<>(agents);
    }

    public List<Agent> getAllAgents() {
        return Collections.unmodifiableList(agents);
    }

    public Optional<Agent> findAgentByName(final String name) {
        return agents.stream().filter(agent -> agent.getAgentName().equals(name)).findFirst();
    }
}
