package ru.academyit.javacore.lesson12.homework.task;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Calculator extends JFrame {

    MainCalculatorTextField mainTextField = new MainCalculatorTextField(600, 300);

    public Calculator() throws HeadlessException {

        // set frame's properties
        setBounds(0,0,600, 600);
        setResizable(false);

        // frame's layouts
        var contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

        var topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        var buttonPanel = new JPanel(new GridLayout(4,4));

        // add frame's components
        topPanel.add(mainTextField);

        Collection<JButton> buttons = new ArrayList<>();

        for (int i = 9; i >= 0; i--) {
            var btn = new JButton(String.valueOf(i));
            btn.setActionCommand("add " + i);
            buttons.add(btn);
        }

        for (JButton button : buttons) {
            buttonPanel.add(button);
        }

        contentPane.add(topPanel);
        contentPane.add(buttonPanel);

        // setup mainTextField
        mainTextField.setText("123");

        // add frame's listeners
        addKeyListener(new MainKeyListener(this));
        setFocusable(true);

//        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

//    private static JTextField getMainTextField() {
//        var field = new JTextField();
//        field.setFont(new Font(null, Font.ITALIC, 20));
//        field.setSize(500, 200);
//        field.setEditable(false);
//        field.setHorizontalAlignment(JTextField.LEFT);
////        field.setBorder(BorderFactory.createEmptyBorder());
//        return field;
//    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }

    public void calculate() {
        mainTextField.setText("result");
    }
}
