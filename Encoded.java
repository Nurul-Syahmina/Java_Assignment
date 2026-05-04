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
        int groupShift = Math.abs(groupID.hashCode()) % 10 + 1;
        return groupShift;
    }
    
// Encoding (Person 3)
public String applyCipher(String inputText, int shift) {
    // StringBuilder is used for efficient string concatenation
    StringBuilder encoded = new StringBuilder();

    // Loop through each character in the input text
    for (int i = 0; i < inputText.length(); i++) {
        char c = inputText.charAt(i);

        if (c >= 'a' && c <= 'z') {
            // Encode lowercase letters:
            // Convert 'a'-'z' to 0–25, add shift, wrap using %26, then convert back
            char newChar = (char) ((c - 'a' + shift) % 26 + 'a');
            encoded.append(newChar);

        } else if (c >= '0' && c <= '9') {
            // Encode digits:
            // Convert '0'-'9' to 0–9, add shift, wrap using %10, then convert back
            char newChar = (char) ((c - '0' + shift) % 10 + '0');
            encoded.append(newChar);

        } else if (c == ' ') {
            // Spaces remain unchanged as per encoding rules
            encoded.append(c);
        }
    }

    // Return the fully encoded string after processing all characters
    return encoded.toString();
}
    
}
