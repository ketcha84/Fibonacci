package gui;

import controller.FibNums;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.math.BigInteger;

public class GuiFib extends JFrame {
    private JPanel rootPanel;
    private JLabel lbl_1;
    private JTextField txtNum;
    private JButton btn_gen;
    private JTextArea txtGenNums;
    private JScrollBar horScroll;
    private JScrollBar vertScroll;

    public GuiFib() throws HeadlessException {
        init();
        initBtn();
    }

    private void initBtn() {
        btn_gen.addActionListener(e -> generateSequence());
    }

    private void generateSequence() {
        BigInteger[] arr = FibNums.fibNums(Integer.parseInt(txtNum.getText()));
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length - 1; i++) {
            builder.append(arr[i]).append("\n");
        }
        builder.append(arr[arr.length - 1]);
        txtGenNums.setText(builder.toString());
        builder = null;
        arr = null;
    }

    private void init() {
        add(rootPanel);
        setTitle("Fibonacci Numbers.");
        setBounds(0, 0, 800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //init txt
        PlainDocument docNum = (PlainDocument) txtNum.getDocument();
        docNum.setDocumentFilter(new DigitFilter());
    }


    static class DigitFilter extends DocumentFilter {
        public static final String DECIMAL_DIGITS = "\\d+";

        private final String regEx;

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
