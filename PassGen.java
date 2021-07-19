import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class PassGen {
    private JButton generateButton;
    private JPanel panel;
    private JTextField outputField;
    private JComboBox optionsBox;
    private JComboBox lengthBox;

    public PassGen() {
        //String[] options = {"Numbers Only", "Characters Only", "Numbers & Characters", "Numbers & Special Characters"};
        String bigChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_=+-/.?<>";
        String C = smallChars + bigChars;
        String NC = numbers + C;
        String NSC = NC + symbols;
        generateButton.addActionListener(e -> {
            String selectedOption = (String) optionsBox.getSelectedItem();
            int length = lengthBox.getSelectedIndex() + 3;
            Random rng = new Random();
            char[] password = new char[length];
            switch (Objects.requireNonNull(selectedOption)) {
                case "Numbers Only" -> {
                    for (int i = 0; i < length; i++) {
                        password[i] = numbers.charAt(rng.nextInt(numbers.length()));
                    }
                    outputField.setText(String.valueOf(password));
                }
                case "Characters Only" -> {
                    for (int i = 0; i < length; i++) {
                        password[i] = C.charAt(rng.nextInt(C.length()));
                    }
                    outputField.setText(String.valueOf(password));
                }
                case "Numbers & Characters" -> {
                    for (int i = 0; i < length; i++) {
                        password[i] = NC.charAt(rng.nextInt(NC.length()));
                    }
                    outputField.setText(String.valueOf(password));
                }
                case "Numbers & Special Characters" -> {
                    for (int i = 0; i < length; i++) {
                        password[i] = NSC.charAt(rng.nextInt(NSC.length()));
                    }
                    outputField.setText(String.valueOf(password));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Password Generator");
        frame.setContentPane(new PassGen().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
