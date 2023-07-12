package agent;

import agent.agent.Agent;
import agent.agent.AgentGroup;
import agent.agent.AgentService;
import agent.agent.AgentServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("AgentServiceImpl 클래스 테스트")
class AgentServiceImplTest {
    @Test
    @DisplayName("이름으로 Agent 검색")
    public void testFindAgentByName() {
        // Given
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent("이상구", null, null, null));
        agents.add(new Agent("양정팔", null, null, null));
        AgentGroup agentGroup = new AgentGroup(agents);
        AgentService agentService = new AgentServiceImpl(agentGroup);

        // When
        Optional<Agent> foundAgent = agentService.findAgentByName("양정팔");

        // Then
        assertTrue(foundAgent.isPresent());
        assertEquals("양정팔", foundAgent.get().getAgentName());
    }

    @Test
    @DisplayName("모든 Agent 반환")
    public void testGetAllAgents() {
        // Given
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent("이상구", null, null, null));
        agents.add(new Agent("양정팔", null, null, null));
        AgentGroup agentGroup = new AgentGroup(agents);
        AgentService agentService = new AgentServiceImpl(agentGroup);

        // When
        List<Agent> allAgents = agentService.getAllAgents();

        // Then
        assertEquals(2, allAgents.size());
        assertTrue(allAgents.contains(new Agent("이상구", null, null, null)));
        assertTrue(allAgents.contains(new Agent("양정팔", null, null, null)));
    }
}