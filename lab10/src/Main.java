import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            arr.add(3);
            arr.add(1);
            arr.add(1);
            arr.add(2);
            arr.add(3);
            arr.add(4);

            MySet<Integer> set1 = new MySet<>(arr);
            System.out.println(set1);

            MySet<Integer> set2 = new MySet<>();
            set2.add(1);
            set2.add(5);
            set2.add(6);
            set2.add(7);
            set2.add(8);
            set2.add(9);
            set2.add(10);
            System.out.println(set2);

            MySet<Integer> union = set1.uniteWith(set2);
            System.out.println(union);

            MySet<Integer> intersection = set1.intersectWith(set2);
            System.out.println(intersection);

            MySet<Integer> difference = set1.differenceWith(set2);
            System.out.println(difference);

            Frame frame = new Frame();
        } catch (IteratorOutOfBoundsException | FileNotFoundException exception) {
            System.err.println(exception.toString());
        }
    }
}