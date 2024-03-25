package function;
/**
 * Name object. Contains last name and first name (given name)
 * A name may contain multiple given names
 */
public class FirstNameLastName {
    private String[] firstNames;
    private String lastName;

    public FirstNameLastName(String[] firstNames, String string) {
        this.firstNames = firstNames;
        this.lastName = string;
    }

    public String[]  getFirstNames() {
        return firstNames;
    }
    public void setFirstNames(String[]  givenNames) {
        this.firstNames = givenNames;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Convert class to string
     */
    public String toString() {
        return String.join(" ", firstNames) + " " + lastName;
    }
}
