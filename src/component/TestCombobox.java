package component;


import component.ComboSuggestionUI;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCombobox {
    public static void main(String[] args) {
        // Create a JFrame for the test
        JFrame frame = new JFrame("ComboSuggestionUI Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a JPanel to hold the JComboBox
        JPanel panel = new JPanel(new BorderLayout());

        // Create a JComboBox and set the custom UI
        String[] items = {"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setEditable(true);
        comboBox.setUI(new ComboSuggestionUI());

        // Add the JComboBox to the panel
        panel.add(comboBox, BorderLayout.NORTH);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
