import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class WordCounter extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        resultLabel = new JLabel("Number of words: 0");

        panel.add(textField);
        panel.add(resultLabel);

        add(panel);
    }

    private void countWords() {
        String text = textField.getText();
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        resultLabel.setText("Number of words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounter().setVisible(true);
            }
        });
    }
}
