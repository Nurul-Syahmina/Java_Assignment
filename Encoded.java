public class Encoded {
    // Attributes
    private String inputText;
    private int charCount;
    private String resultText;
    private final String groupID = "G04/SE-G11";

    // Constructors (Person 4)
    public Encoded() {}

    public Encoded(String inputText) {
        this.inputText = inputText;
    }

    // Validation (Person 1)
    public boolean checkStringValidity(String inputText) {
        // (Person 1 can edit)
        return false;
    }

    // Count (Person 1)
    public int countCharacters(String inputText) {
        // (Person 1 can edit)
        return 0;
    }

    // Shift logic (Person 2)
    public int generateShift() {
        // (Person 2 can edit)
        return 0;
    }

    // Encoding (Person 3)
    public String applyCipher(String inputText, int shift) {
        // (Person 3 can edit)
        return "";
    }
}
