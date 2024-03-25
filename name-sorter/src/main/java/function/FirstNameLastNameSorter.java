package function;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Businss class for sortting names
 * 
 */
public class FirstNameLastNameSorter {

    /**
     * Sport name in a name list
     * @param names: A string list that contains given name(s) and last name
     * @return Sorted name list, which is sorted by last name and then given name(s)
     * @throws NameFormatException
     */
    public List<String> sort(List<String> names) throws NameFormatException {
        NameFormatHelper nameFormatHelper = new NameFormatHelper();
        List<FirstNameLastName> firstNameLastNameList = nameFormatHelper.stringListToFistNameLastNameList(names);
        Collections.sort(firstNameLastNameList, new Comparator<FirstNameLastName>() {
            public int compare(FirstNameLastName left, FirstNameLastName right)  {
                int result = left.getLastName().compareTo(right.getLastName());
                for (int i = 0; result == 0 && i < left.getFirstNames().length; i++) {
                    //If the name has the same last name, start comparing the given names
                    if (i < right.getFirstNames().length) {
                        result = left.getFirstNames()[i].compareTo(right.getFirstNames()[i]);   //Conpare the given names
                    } else {
                        result = 1; //If 2 name has the same last name and the given names are same, the longer given name win
                    }
                }
                return result;
            }
        });
        List<String> fistNameLastNameStringList = nameFormatHelper.fistNameLastNameListToStringList(firstNameLastNameList);
        return fistNameLastNameStringList;
    }

}
