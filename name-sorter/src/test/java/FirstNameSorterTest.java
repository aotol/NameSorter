import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import function.FirstNameLastNameSorter;
import function.NameFormatException;

public class FirstNameSorterTest {

    @Test
    public void testSortSuccess() throws NameFormatException {
        FirstNameLastNameSorter firstNameSorter = new FirstNameLastNameSorter();
        List<String> names = Arrays.asList("John Smith", "David Brown", "Alice Johnson", "David Allen");

        List<String> sortedNames = firstNameSorter.sort(names);

        List<String> expectedSortedNames = Arrays.asList("David Allen", "David Brown", "Alice Johnson", "John Smith");
        assertEquals(expectedSortedNames, sortedNames);
    }

    @Test
    public void testSortEmptyList() throws NameFormatException {
        FirstNameLastNameSorter firstNameSorter = new FirstNameLastNameSorter();
        List<String> names = Arrays.asList();

        List<String> sortedNames = firstNameSorter.sort(names);

        List<String> expectedSortedNames = Arrays.asList();
        assertEquals(expectedSortedNames, sortedNames);
    }

    @Test
    public void testSortWithOneName() throws NameFormatException {
        FirstNameLastNameSorter firstNameSorter = new FirstNameLastNameSorter();
        List<String> names = Arrays.asList("John Smith");

        List<String> sortedNames = firstNameSorter.sort(names);

        List<String> expectedSortedNames = Arrays.asList("John Smith");
        assertEquals(expectedSortedNames, sortedNames);
    }

    @Test
    public void testSortWithInvalidTooLongNameFormat() {
        FirstNameLastNameSorter firstNameSorter = new FirstNameLastNameSorter();
        List<String> tooLongName = Arrays.asList("A1 A2 A3 A4 John");

        assertThrows(NameFormatException.class, () -> firstNameSorter.sort(tooLongName));
    }

    @Test
    public void testSortWithInvalidTooShortNameFormat() {
        FirstNameLastNameSorter firstNameSorter = new FirstNameLastNameSorter();
        List<String> tooShortName = Arrays.asList("John", "Lu Kai");

        assertThrows(NameFormatException.class, () -> firstNameSorter.sort(tooShortName));
    }
}
