package ru.academyit.javacore.lesson12.homework.task;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class MainTextField extends JTextField {

    public MainTextField(int width, int height) {
        super();
        setFont(new Font(null, Font.ITALIC, 20));
        setSize(width, height);
        setEditable(false);
        setHorizontalAlignment(JTextField.LEFT);
    }




}
