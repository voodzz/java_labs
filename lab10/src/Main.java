import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            MySet<Integer> set1 = new MySet<>();
            set1.add(1);
            set1.add(3);
            set1.add(1);
            set1.add(1);
            set1.add(2);
            set1.add(3);
            set1.add(4);
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
        } catch (IteratorOutOfBoundsException exception) {
            System.err.println(exception.toString());
        }
    }
}