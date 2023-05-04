package gui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class GuiFib extends JFrame {
    private JPanel rootPanel;
    private JLabel lbl_1;
    private JTextField txtNum;
    private JButton btn_gen;
    private JTextArea generatedNubersFibonacciTextArea;
    private JScrollBar horScroll;
    private JScrollBar vertScroll;

    public GuiFib() throws HeadlessException {
        init();
    }

    private void init() {
        add(rootPanel);
        setTitle("Fibonacci Numbers.");
        setBounds(0, 0, 400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //init txt
        PlainDocument docNum = (PlainDocument) txtNum.getDocument();
        docNum.setDocumentFilter(new DigitFilter());
    }


    class DigitFilter extends DocumentFilter {
        public static final String DECIMAL_DIGITS = "\\d+";

        private String regEx;

        public DigitFilter() {
            this.regEx = DECIMAL_DIGITS;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

            if (string.matches(regEx)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            if (string.matches(regEx)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }
    }
}
