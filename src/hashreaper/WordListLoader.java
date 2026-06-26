package hashreaper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordListLoader {
    public List<String> load(String path) throws IOException {
        return Files.readAllLines(Path.of(path));
    }
}
