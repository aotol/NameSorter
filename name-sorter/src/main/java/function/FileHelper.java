package function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/**
 * Business class for processing text file
 */
public class FileHelper {
    /**
     * Read filePath line by line and convert into List
     * @param filePath The path to the file
     * @return
     * @throws IOException
     */
    public List<String> readFileToList(String filePath) throws IOException {
        System.out.println("Current working directory is: " + System.getProperty("user.dir"));
        List<String> result = Files.readAllLines(Paths.get(filePath));
        return result;
    }

    /**
     * Write list of string into assigned file
     * @param filePath
     * @param nameList
     * @throws IOException
     */
    public void writeListToFile(String filePath, List<String> nameList) throws IOException {
        Files.deleteIfExists(Paths.get(filePath));
        File file = new File(filePath);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            fileWriter.write(name);
            if (i + 1 < nameList.size()) {
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
    }
}
