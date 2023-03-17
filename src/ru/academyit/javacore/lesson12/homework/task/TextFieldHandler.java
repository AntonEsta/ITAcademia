package ru.academyit.javacore.lesson12.homework.task;

import javax.swing.*;

public class TextFieldHandler {

//    TextField field;
    JTextField field;


    public TextFieldHandler(JTextField field) {
        this.field = field;
    }

    public void addText(char ch) {
        if (ch == ',') {
            ch = '.';
        }
        if (isCanAddChar(ch)) {
            field.setText(field.getText() + ch);
        }
    }

    public void delLastChar() {
        field.setText(field.getText().substring(0, field.getText().length() - 1));
    }

    private boolean isCanAddChar(char ch) {
        var str = field.getText();

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
