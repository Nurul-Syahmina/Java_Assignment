public class Encoded {
    // Attributes
    private String inputText;    // stores the user's input
    private int charCount;       // number of non-space characters
    private String resultText;   // stores the encoded output
    private final String groupID = "G04/SE-G11";    // secret key, hidden from user

    // ---- Constructors (Contributed by Syahmina) ----

    // Default constructor
    public Encoded() {}

    // Constructor that accepts input text
    public Encoded(String inputText) {
        this.inputText = inputText;
    }

    // ---- Validation (Contributed by Arlyssa) ----

    // Returns true if input only contains lowercase letters, digits and spaces
    public boolean checkStringValidity(String inputText) {

        // Reject null or empty input
        if (inputText == null || inputText.length() == 0) {
            return false;
        }

        // Check each character one by one
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);

            boolean isLowercase = (c >= 'a' && c <= 'z');
            boolean isDigit = (c >= '0' && c <= '9');
            boolean isSpace = (c == ' ');

            // If character is not lowercase, digit or space - invalid
            if (!isLowercase && !isDigit && !isSpace) {
                return false;
            }
        }

        return true; // all characters are valid
    }

    // ---- Character Count (Contributed by Arlyssa) ----

    // Counts and returns number of non-space characters
    public int countCharacters(String inputText) {
        int count = 0;

        for (int i = 0; i < inputText.length(); i++) {
            if (inputText.charAt(i) != ' ') { // skip spaces
                count++;
            }
        }

        return count;
    }

    // ---- Shift Generation (Contributed by Ryea) ----

    // Generates a fixed group shift value (1-10) from the hidden groupID
    // Uses hashCode() to produce a unique number for this group
    public int generateShift() {
        int groupShift = Math.abs(groupID.hashCode()) % 10 + 1;
        return groupShift; // always same value for same groupID
    }
    
    // ---- Encoding (Contributed by Bruce) ----

    // Encodes the input string using the given shift value
    // Letters: shifted within a-z using % 26
    // Digits : shifted within 0-9 using % 10
    // Spaces : unchanged
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
