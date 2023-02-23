package ru.academyit.javacore.lesson11.homework.task03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Доработать фрейм из урока. Добавить кнопки для вычисления операции сложения, вычитания, умножения и деления.
//        Результат нужно вывести на сам фрейм в компоненте JLabel(используйте метод setText).

public class MyFrame extends JFrame {
    JLabel text1, text2, labelResult;
    JTextField field1, field2;
    JButton btnPlus, btnMinus, btnMul, btnDiv, btnOK;

    JPanel panel1, panel2, panel3;

    Operation operation = Operation.NO_OPERATION;

    final Dimension mainFrameDimension = new Dimension(300, 280);

    enum Operation {
        NO_OPERATION,
        PLUS,
        MINUS,
        MUL,
        DIV
    }

    MyFrame() {
        setTitle("Тестовое окно");
        setSize(mainFrameDimension.width, mainFrameDimension.height);
        setResizable(false);
        setLocationRelativeTo(null);//для вывода окна по центру

        text1 = getLabel("Первое число");
        text2 = getLabel("Второе число");
        labelResult = getLabel("Результат:");

        field1 = new JTextField(10);
        field2 = new JTextField(10);

        var operActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnPlus || e.getSource() == btnDiv || e.getSource() == btnMinus || e.getSource() == btnMul) {
                    try {
                        operation = Operation.valueOf(e.getActionCommand());
                    } catch (IllegalArgumentException ignore) {
                    }
                }
            }
        };

        btnPlus = new JButton("+");
        btnPlus.setActionCommand("PLUS");
        btnPlus.addActionListener(operActionListener);
        btnMinus = new JButton("-");
        btnMinus.setActionCommand("MINUS");
        btnMinus.addActionListener(operActionListener);
        btnMul = new JButton("*");
        btnMul.setActionCommand("MUL");
        btnMul.addActionListener(operActionListener);
        btnDiv = new JButton("/");
        btnDiv.setActionCommand("DIV");
        btnDiv.addActionListener(operActionListener);

        btnOK = new JButton("OK");

        btnOK.addActionListener(e -> {
            if (e.getSource() == btnOK) {
                switch (operation) {
                    case NO_OPERATION:
                        break;
                    case PLUS:
                        showResult(String.valueOf(Double.parseDouble(field1.getText()) + Double.parseDouble(field2.getText())));
                        break;
                    case MINUS:
                        showResult(String.valueOf(Double.parseDouble(field1.getText()) - Double.parseDouble(field2.getText())));
                        break;
                    case MUL:
                        showResult(String.valueOf(Double.parseDouble(field1.getText()) * Double.parseDouble(field2.getText())));
                        break;
                    case DIV:
                        showResult(String.valueOf(Double.parseDouble(field1.getText()) / Double.parseDouble(field2.getText())));
                        break;
                }
            }
        });

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        container.add(text1);
        container.add(field1);
        container.add(text2);
        container.add(field2);

        container.add(labelResult);

        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel1.add(btnPlus);
        panel1.add(btnMinus);
        panel1.add(btnMul);
        panel1.add(btnDiv);

        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel2.add(btnOK);


        panel3 = new JPanel(new GridLayout(2, 1));
        panel3.add(panel1);
        panel3.add(panel2);
        container.add(panel3);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Формирует компонент JLabel установленного стиля.
     *
     * @param text текст компонента
     * @return объект JLabel
     */
    static JLabel getLabel(String text) {
        var label = new JLabel(text);
        label.setFont(new Font("verdana", Font.BOLD | Font.ITALIC, 20));
        label.setForeground(Color.gray);
        label.setToolTipText("Подсказка...");
        return label;
    }

    /**
     * Фрмирует строку с результатом
     *
     * @param s строка результата
     */
    void showResult(String s) {
        labelResult.setText("Результат: " + s);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
