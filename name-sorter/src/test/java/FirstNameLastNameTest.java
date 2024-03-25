import static org.junit.Assert.assertEquals;

import org.junit.Test;

import function.FirstNameLastName;

public class FirstNameLastNameTest {
    @Test
    public void testToString() {
        FirstNameLastName firstNameLastName = new FirstNameLastName(new String[] {"A1", "A2"}, "A3");
        String actualFirstNameLastNameString = firstNameLastName.toString();
        String expectedFirstNameLastNameString = "A1 A2 A3";
        assertEquals(expectedFirstNameLastNameString, actualFirstNameLastNameString);
    }
}
