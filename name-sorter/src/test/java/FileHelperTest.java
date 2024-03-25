import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import function.FileHelper;

public class FileHelperTest {
    @Test
    public void testReadFileToListSuccess() throws IOException {
        FileHelper fileHelper = new FileHelper();
        List<String> expectedLines = Arrays.asList("John Cena", "Steven Jobs", "Tom & Jery");
        Files.write(Paths.get("test.txt"), expectedLines);

        List<String> actualLines = fileHelper.readFileToList("test.txt");

        assertEquals(expectedLines, actualLines);

        // Clean up the test file
        Files.deleteIfExists(Paths.get("test.txt"));
    }

    @Test
    public void testReadFileToListError() {
        FileHelper fileHelper = new FileHelper();
        assertThrows(IOException.class, () -> fileHelper.readFileToList("nonexistent-file.txt"));
    }

    @Test
    public void testWriteListToFileSuccess() throws IOException {
        FileHelper fileHelper = new FileHelper();
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        fileHelper.writeListToFile("test.txt", names);
        List<String> actualLines = Files.readAllLines(Paths.get("test.txt"));
        assertEquals(names, actualLines);
        // Clean up the test file
        Files.deleteIfExists(Paths.get("test.txt"));
    }

    @Test
    public void testWriteListToFileError() {
        FileHelper fileHelper = new FileHelper();
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        assertThrows(IOException.class, () -> fileHelper.writeListToFile("/invalid-path", names));
    }
}
