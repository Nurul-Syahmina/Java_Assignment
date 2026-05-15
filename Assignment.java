import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Person 4 - Main class: builds GUI and connects all encoding logic
public class Assignment {

    public static void main(String[] args) {

        // Set up the frame
        JFrame frame = new JFrame("Group 11 - String Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null); // centre on screen

        // Create a panel with grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // UI Elements
        JLabel label = new JLabel("Enter text to encode (lowercase & digits):");
        JTextField inputField = new JTextField();
        JButton encodeButton = new JButton("Encode");

        // Output Labels
        JLabel countOutput = new JLabel("Character Count: -");
        JLabel shiftOutput = new JLabel("Final Shift Used: -");
        JLabel resultOutput = new JLabel("Encoded Result: -");

        // Connect the Button to the Logic in Encoded.java
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                Encoded obj = new Encoded(input);

                // Step 1: Validation - reject invalid characters
                if(!obj.checkStringValidity(input)) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Use only lowercase, numbers and spaces.", "Error", JOptionPane.ERROR_MESSAGE);
                    inputField.setText("");       // clear field so user can retype
                    inputField.requestFocus(); 
                    return;
                }

                // Step 2: Count non-space characters
                int count = obj.countCharacters(input);

                // Step 3: Get group shift from hidden groupID
                int groupShift = obj.generateShift();

                // Step 4: finalShift = groupShift + charCount
                int finalShift = groupShift + count;

                // Step 5: Apply cipher to produce encoded string
                String result = obj.applyCipher(input, finalShift);

                // Update output labels
                countOutput.setText("Character Count (no spaces): " + count);
                shiftOutput.setText("Final Shift (Group + Count): " + finalShift);
                resultOutput.setText("Encoded Result: " + result);
            }
        });

        // Add everything to the panel
        panel.add(label);
        panel.add(inputField);
        panel.add(encodeButton);
        panel.add(countOutput);
        panel.add(shiftOutput);
        panel.add(new JLabel("--- Output ---"));
        panel.add(resultOutput);

        frame.add(panel);
        frame.setVisible(true);
    }
}

