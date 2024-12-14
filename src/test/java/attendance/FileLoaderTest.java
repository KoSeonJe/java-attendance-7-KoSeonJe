package attendance;

import attendance.infra.FileLoader;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileLoaderTest {

    @Test
    void loadFile() {
        FileLoader fileLoader = new FileLoader();
        List<String> files = fileLoader.loadFile("attendances.csv");
        System.out.println(files);
    }
}
