import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        DrawingPanel dp = new DrawingPanel();
        fr.add(dp);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(200, 100, 500, 400);
        fr.setVisible(true);
    }
}