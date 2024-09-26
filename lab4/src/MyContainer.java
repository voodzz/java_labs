import java.util.Arrays;

public class MyContainer {
    private int[] array;
    private int size = 0;

    @Override
    public String toString() {
        return "MyContainer{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public MyContainer(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public void add(int value) {
        array[size++] = value;
    }
}