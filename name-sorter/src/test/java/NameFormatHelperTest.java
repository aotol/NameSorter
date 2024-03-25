import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import function.FirstNameLastName;
import function.NameFormatException;
import function.NameFormatHelper;

public class NameFormatHelperTest {
    @Test
    public void testStringListToFistNameLastNameListSuccess() throws NameFormatException {
        NameFormatHelper nameFormatHelper = new NameFormatHelper();
        List<String> names = Arrays.asList("John Jr. Smith", "David Brown", "Alice Johnson", "David Allen");
    
        List<FirstNameLastName> firstNameLastNameList = nameFormatHelper.stringListToFistNameLastNameList(names);
    
        List<FirstNameLastName> expectedFirstNameLastNameList = Arrays.asList(
            new FirstNameLastName(new String[]{"John", "Jr."}, "Smith"),
            new FirstNameLastName(new String[]{"David"}, "Brown"),
            new FirstNameLastName(new String[]{"Alice"}, "Johnson"),
            new FirstNameLastName(new String[]{"David"}, "Allen")
        );
        
        // Compare each element individually
        for (int i = 0; i < expectedFirstNameLastNameList.size(); i++) {
            FirstNameLastName expectedFirstNameLastName = expectedFirstNameLastNameList.get(i);
            FirstNameLastName firstNameLastName = firstNameLastNameList.get(i);
            assertEquals(expectedFirstNameLastName.getLastName(), firstNameLastName.getLastName());
            assertArrayEquals(expectedFirstNameLastName.getFirstNames(), firstNameLastName.getFirstNames());
        }
    }

    @Test
    public void testStringListToFistNameLastNameListWithInvalidNameFormat() {
        NameFormatHelper nameFormatHelper = new NameFormatHelper();
        List<String> names = Arrays.asList("John");

        assertThrows(NameFormatException.class, () -> nameFormatHelper.stringListToFistNameLastNameList(names));
    }

    @Test
    public void testFistNameLastNameListToStringListSuccess() throws NameFormatException {
        NameFormatHelper nameFormatHelper = new NameFormatHelper();
        List<FirstNameLastName> firstNameLastNameList = Arrays.asList(
            new FirstNameLastName(new String[]{"John"}, "Smith"),
            new FirstNameLastName(new String[]{"David"}, "Brown"),
            new FirstNameLastName(new String[]{"Alice"}, "Johnson"),
            new FirstNameLastName(new String[]{"David"}, "Allen")
        );

        List<String> firstNameLastNameStringList = nameFormatHelper.fistNameLastNameListToStringList(firstNameLastNameList);

        List<String> expectedStringList = Arrays.asList("John Smith", "David Brown", "Alice Johnson", "David Allen");
        assertEquals(expectedStringList, firstNameLastNameStringList);
    }

    @Test
    public void testFistNameLastNameListToStringListWithNullList() {
        NameFormatHelper nameFormatHelper = new NameFormatHelper();
        List<FirstNameLastName> firstNameLastNameList = null;

        assertThrows(NameFormatException.class, () -> nameFormatHelper.fistNameLastNameListToStringList(firstNameLastNameList));
    }
}