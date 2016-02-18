package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_ {

    public static final String[][] BUTTON_TEXTS = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"0", ".", "/", "="}
    };
    public static final Font BTN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 24);

    private final JTextField outputDigits;

    public Calculator_() {
        outputDigits = new JTextField(10);
        outputDigits.setEnabled(false);
        outputDigits.setFont(BTN_FONT.deriveFont(Font.PLAIN));
        JPanel btnPanel = new JPanel(new GridLayout(BUTTON_TEXTS.length,
                BUTTON_TEXTS[0].length));

        for (int i = 0; i < BUTTON_TEXTS.length; i++) {
            for (int j = 0; j < BUTTON_TEXTS[i].length; j++) {
                JButton btn = new JButton(BUTTON_TEXTS[i][j]);
                btn.setFont(BTN_FONT);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        outputDigits.setText(((JButton) e.getSource()).getText());
                    }
                });
                btnPanel.add(btn);
            }
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(outputDigits, BorderLayout.PAGE_START);
        mainPanel.add(btnPanel, BorderLayout.CENTER);


        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
