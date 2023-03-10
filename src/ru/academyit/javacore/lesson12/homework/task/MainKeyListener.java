package ru.academyit.javacore.lesson12.homework.task;

import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener extends KeyAdapter {

    Calculator frame;

    public MainKeyListener(Calculator frame) {
        this.frame = frame;
    }

    private void addTextToFrameMainTextField(KeyEvent keyEvent) {

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_0:
            case KeyEvent.VK_NUMPAD0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_NUMPAD1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_NUMPAD3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_NUMPAD5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_NUMPAD7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_9:
            case KeyEvent.VK_NUMPAD9:
            case KeyEvent.VK_PERIOD:
            case KeyEvent.VK_DIVIDE:
            case KeyEvent.VK_MULTIPLY:
            case KeyEvent.VK_PLUS:
            case KeyEvent.VK_MINUS:
            case KeyEvent.VK_COMMA:
            case KeyEvent.VK_EQUALS:
                frame.mainTextField.addText(keyEvent.getKeyChar());
                break;
            case KeyEvent.VK_BACK_SPACE:
                frame.mainTextField.delLastChar();
                break;
            case KeyEvent.VK_ENTER:
                frame.calculate();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("Key released " + keyEvent.getKeyChar() + " code: " + keyEvent.getKeyCode());
        addTextToFrameMainTextField(keyEvent);
    }
}
