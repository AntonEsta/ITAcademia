package ru.academyit.javacore.lesson12.homework.task;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class MainCalculatorTextField extends JTextField {

    public MainCalculatorTextField(int width, int height) {
        super();
        setFont(new Font(null, Font.ITALIC, 20));
        setSize(width, height);
        setEditable(false);
        setHorizontalAlignment(JTextField.LEFT);
    }


    public void addText(char ch) {
        if (ch == ',') {
            ch = '.';
        }
        if (isCanAddChar(ch)) {
            setText(getText() + ch);
        }
    }

    public void delLastChar() {
        try {
            setText(getText(0, getText().length() - 1));
        } catch (BadLocationException ignore) {
        }
    }

    private boolean isCanAddChar(char ch) {
        var str = getText();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1;
             i != -1 && (str.charAt(i) == '.' || (str.charAt(i) >= '0' & str.charAt(i) <= '9'));
             i--) {
            stringBuilder.insert(0, str.charAt(i));
        }

        System.out.println("stringBuilder = " + stringBuilder);


        Double dlValue = null;

        try {
            dlValue = Double.parseDouble(stringBuilder.toString());
        } catch (NumberFormatException ignore) {
        }

        if (dlValue != null && ch == '.') {
            return !stringBuilder.toString().contains(".");
        }

        return true;

//        switch (stringBuilder.toString().strip()) {
//            case "+":
//            case "-":
//            case "/":
//            case "*":
//                return true;
//            default:
//                return false;
//        }

    }

}
