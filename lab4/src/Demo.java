import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 7};
        System.out.println("array:" + Arrays.toString(array));

        MyContainer myContainer = new MyContainer(array);
        myContainer.add(1);
        System.out.println(myContainer.toString());
    }
}
