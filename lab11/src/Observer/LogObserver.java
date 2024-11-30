package Observer;

import javax.swing.*;
import java.awt.*;

public class LogObserver extends JPanel implements Observer {
    private DefaultListModel<String> listModel;
    private JList<String> logList;

    public LogObserver() {
        setLayout(new BorderLayout());
        this.listModel = new DefaultListModel<>();
        logList = new JList<>(listModel);
        add(new JScrollPane(logList), BorderLayout.CENTER);
    }

    @Override
    public void update(String keyName) {
        this.listModel.add(0, "Key " + keyName + " has been pressed!");
    }
}
