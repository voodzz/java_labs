package Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {
    private LogObserver logObserver;
    private CurrentKeyObserver currentKeyObserver;
    private KeySubject keySubject;

    public Frame() {
        setTitle("Task1. Observer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setFocusable(true);

        logObserver = new LogObserver();
        currentKeyObserver = new CurrentKeyObserver();
        keySubject = new KeySubject();
        keySubject.attach(logObserver);
        keySubject.attach(currentKeyObserver);

        setLayout(new GridLayout(1, 2));
        add(currentKeyObserver);
        add(logObserver);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keySubject.notifyObservers(KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        setVisible(true);
    }
}
