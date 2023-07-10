package agent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReservationAgentImporter implements AgentImporter {

    @Override
    public CasinoAgent importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put("path", file.getPath());

        // Read reservation details from the file and populate the attributes

        return new CasinoAgent(attributes);
    }
}