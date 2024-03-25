package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameFormatHelper {
    public List<FirstNameLastName> stringListToFistNameLastNameList(List<String> names) throws NameFormatException {
        if (names == null) {
            throw new NameFormatException("Name list is null");
        } else {
            List<FirstNameLastName> fistNameLastNameList = new ArrayList<FirstNameLastName>();
            for (String name : names) {
                String[] rawFrstNameLastName = name.trim().split( "\\s+");
                if (rawFrstNameLastName.length <2 || rawFrstNameLastName.length > 4) {
                    throw new NameFormatException("A valid name should has a last name and has up to 3 given names. The value provided is: " + rawFrstNameLastName);
                } else {
                    int lastNameIndex = rawFrstNameLastName.length - 1;
                    String[] firstName = Arrays.copyOfRange(rawFrstNameLastName, 0, lastNameIndex);
                    String lastName = rawFrstNameLastName[lastNameIndex];
                    FirstNameLastName firstNameLastName = new FirstNameLastName(firstName, lastName);
                    fistNameLastNameList.add(firstNameLastName);
                }
            }
            return fistNameLastNameList;
        }
    }

    public List<String> fistNameLastNameListToStringList(List<FirstNameLastName> fistNameLastNameList) throws NameFormatException {
        if (fistNameLastNameList == null) {
            throw new NameFormatException("Name list is null");
        } else {
            List<String> firstNameLastNameStringList = new ArrayList<String>();
            for (FirstNameLastName firstNameLastName : fistNameLastNameList) {
                String firstNameLastNameString = firstNameLastName.toString();
                firstNameLastNameStringList.add(firstNameLastNameString);
            }
            return firstNameLastNameStringList;
        }
    }
}
