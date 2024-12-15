package observer;

import javax.swing.*;
import java.awt.*;

public class CurrentKeyObserver extends JPanel implements Observer {
    private JLabel currentKeyLabel;
    public CurrentKeyObserver() {
         setLayout(new BorderLayout());
         currentKeyLabel = new JLabel("");
         currentKeyLabel.setHorizontalAlignment(JLabel.CENTER);
         currentKeyLabel.setSize(this.getWidth(), this.getHeight());
         currentKeyLabel.setFont(new Font("Arial", Font.BOLD, 24));
         add(currentKeyLabel, BorderLayout.CENTER);
    }

    @Override
    public void update(String keyName) {
        currentKeyLabel.setText(keyName);
    }
}
