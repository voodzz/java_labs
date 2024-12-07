package mvc;

import javax.swing.*;

public interface Observer<T extends Comparable<T>> {
    void update(Model<T> model);
}
