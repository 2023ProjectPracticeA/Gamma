package step7_G4;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Font;

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
        txt1.addActionListener(e -> calculate());
        add(txt1, gbc);

        gbc.weightx = 0.0;

        String[] operators = { "+", "-", "×", "÷" };
        operatorBox = new JComboBox<String>(operators);
        operatorBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                calculate();
            }
        });
        operatorBox.setRenderer(new CenteredComboBoxRenderer());
        add(operatorBox, gbc);

        gbc.weightx = 1.0;

        txt2 = new JTextField();
        txt2.addActionListener(e -> calculate());
        add(txt2, gbc);

        gbc.weightx = 0.0;

        JLabel equalsLabel = new JLabel("=");
        equalsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(equalsLabel, gbc);

        gbc.weightx = 1.0;

        txt3 = new JTextField();
        txt3.setEditable(false);
        add(txt3, gbc);

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
        }

        txt3.setText("" + d);
    }

    public static void main(String[] args) {
        new ProgG41Calc1("Calculator");
    }
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
