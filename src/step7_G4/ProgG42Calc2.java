package step7_G4;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Font;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
* 課題番号 ： 第 11 回 演習問題 G4-2
* ファイル名 ： ProgG41Calc1.java
* 作成年月日 ： 2023 年 12 月 5 日
* 学生番号・氏名： 
* グループ ： Γ
*/

public class ProgG42Calc2 extends JFrame {
    JTextField txt1, txt2, txt3;
    JComboBox<String> operatorBox;

    public ProgG42Calc2(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        JLabel calculatorLabel = new JLabel("簡易電卓 グループ Γ: ");
        add(calculatorLabel, gbc);

        gbc.gridwidth = 1;

        txt1 = new JTextField();
        add(txt1, gbc);

        gbc.weightx = 0.0;

        String[] operators = { "+", "-", "×", "÷", "sin", "cos", "tan", "ln", "log" };
        operatorBox = new JComboBox<String>(operators);
        operatorBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String operator = (String) operatorBox.getSelectedItem();
                if (operator.equals("sin") || operator.equals("cos") || operator.equals("tan") || operator.equals("ln") || operator.equals("log")) {
                    txt1.setEnabled(false);
                } else {
                    txt1.setEnabled(true);
                }
                calculate();
            }
        });
        operatorBox.setRenderer(new CenteredComboBoxRenderer());
        add(operatorBox, gbc);

        gbc.weightx = 1.0;

        txt2 = new JTextField();
        txt2.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                calculate();
            }

            public void removeUpdate(DocumentEvent e) {
                calculate();
            }

            public void insertUpdate(DocumentEvent e) {
                calculate();
            }
        });
        add(txt2, gbc);

        gbc.weightx = 0.0;

        JLabel equalsLabel = new JLabel("=");
        equalsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(equalsLabel, gbc);

        gbc.weightx = 1.0;

        txt3 = new JTextField();
        txt3.setEditable(false);
        add(txt3, gbc);

        gbc.weightx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Make the button take up the rest of the row

        // 1. Create the button
        JButton acButton = new JButton("AC");
        acButton.setHorizontalAlignment(JButton.CENTER);

        // 2. Add an action listener to the button
        acButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the text fields
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
            }
        });

        // 3. Add the button to the frame
        add(acButton, gbc);

        pack();
        setVisible(true);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = txt1.getFont();
                float newSize = txt1.getHeight() * 0.5f;
                Font newFont = font.deriveFont(newSize);
                txt1.setFont(newFont);
                operatorBox.setFont(newFont);
                txt2.setFont(newFont);
                equalsLabel.setFont(newFont);
                txt3.setFont(newFont);
                calculatorLabel.setFont(newFont);
            }
        });
    }

    private void calculate() {
        double d = 0, d1 = 0, d2 = 0;
        String operator;

        try {
            d1 = Double.parseDouble(txt1.getText());
        } catch (NumberFormatException ex) {
            txt1.setText("0");
        }

        try {
            d2 = Double.parseDouble(txt2.getText());
        } catch (NumberFormatException ex) {
            txt2.setText("0");
        }

        operator = (String) operatorBox.getSelectedItem();

        if (operator.equals("+"))
            d = d1 + d2;
        else if (operator.equals("-"))
            d = d1 - d2;
        else if (operator.equals("×"))
            d = d1 * d2;
        else if (operator.equals("÷")) {
            if (d2 == 0) {
                txt3.setText("error");
                return;
            } else {
                d = d1 / d2;
            }
        } else if (operator.equals("sin"))
            d = Math.sin(d1);
        else if (operator.equals("cos"))
            d = Math.cos(d1);
        else if (operator.equals("tan"))
            d = Math.tan(d1);
        else if (operator.equals("ln"))
            d = Math.log(d1);
        else if (operator.equals("log"))
            d = Math.log10(d1);

        txt3.setText("" + d);
    }

    public static void main(String[] args) {
        new ProgG42Calc2("Calculator");

        Symbol one = new Symbol(true, "1");
        Symbol two = new Symbol(true, "2");
        Symbol three = new Symbol(true, "3");
        Symbol four = new Symbol(true, "4");
        Symbol five = new Symbol(true, "5");
        Symbol six = new Symbol(true, "6");
        Symbol seven = new Symbol(true, "7");
        Symbol eight = new Symbol(true, "8");
        Symbol nine = new Symbol(true, "9");
        Symbol zero = new Symbol(true, "0");
        Symbol pi = new Symbol(true, "pi");
        Symbol e = new Symbol(true, "e");

        Symbol plus = new Symbol(true, "+");
        Symbol minus = new Symbol(true, "-");
        Symbol times = new Symbol(true, "×");
        Symbol divide = new Symbol(true, "÷");

        Symbol lparen = new Symbol(true, "(");
        Symbol rparen = new Symbol(true, ")");

        Symbol sin = new Symbol(true, "sin");
        Symbol cos = new Symbol(true, "cos");
        Symbol tan = new Symbol(true, "tan");
        Symbol exp = new Symbol(true, "exp");
        Symbol log = new Symbol(true, "log");

        Symbol number = new Symbol(false, "N");
        Symbol operator = new Symbol(false, "O");
        Symbol expression = new Symbol(false, "E");
        Symbol function = new Symbol(false, "F");
        Symbol functionApplication = new Symbol(false, "A");
        Symbol term = new Symbol(false, "T");

        Production N = new Production(number,
                new Symbol[] { one, two, three, four, five, six, seven, eight, nine, zero, pi, e });
        Production O = new Production(operator, new Symbol[] { plus, minus, times, divide });
        Production F = new Production(function, new Symbol[] { sin, cos, tan, exp, log });
        Production A = new Production(functionApplication, new Symbol[] { function, lparen, expression, rparen });
        Production T = new Production(term, new Symbol[] { number, expression, functionApplication });
        Production E1 = new Production(expression, new Symbol[] { term, operator, term });
        Production E2 = new Production(expression, new Symbol[] { lparen, term, rparen });
    }

    class CenteredComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setHorizontalAlignment(CENTER);
            return this;
        }
    }
}
