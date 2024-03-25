import java.io.IOException;
import java.util.List;

import function.FirstNameLastNameSorter;
import function.FileHelper;
import function.NameFormatException;
/**
 * An useful application that is able to sort names in ta text file by last name and then given name (first name)
 * Support to up to 3 given names for a name
 * The output is placed in ./sorted-names-list.txt
 */
public class App {
    public static void main(String[] args) {
        String filePath;
        System.out.println("Checking input formate...");
        if (args == null || args.length != 1) {
            System.out.println("Incorrect input format. Requires 1 argument.");
        } else {
            System.out.println("Checking input formate done.");
            filePath = args[0];
            System.out.println("Reading input file...");
            FileHelper fileHelper = new FileHelper();
            try {
                List<String> nameList = fileHelper.readFileToList(filePath);
                System.out.println("Read input file done.");
                FirstNameLastNameSorter firstNameSorter = new FirstNameLastNameSorter();
                System.out.println("Sorting names...");
                nameList = firstNameSorter.sort(nameList);
                System.out.println("Sorted result:");
                System.out.println();
                for (String name : nameList) {
                    System.out.println(name);
                }
                System.out.println();
                System.out.println("Saving into sorted-names-list.txt...");
                fileHelper.writeListToFile("./sorted-names-list.txt", nameList);
                System.out.println("Save into sorted-names-list.txt is done.");
            } catch (IOException e) {
                System.out.println("The filePath provided is either invalid or the file is corrupted.");
                e.printStackTrace();
            } catch (NameFormatException e) {
                System.out.println("The name format is incorrect");
                e.printStackTrace();
            } finally {
                System.out.println("Sort task is done.");
            }
        }
    }
}
