package agent;

import java.io.File;
import java.io.IOException;

public interface AgentImporter {
    CasinoAgent importFile(File file) throws IOException;
}