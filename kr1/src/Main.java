import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Tree> trees;
            List<Tree> type1 = TreeUtil.readType1TreesFromFile("input1.txt");
            List<Tree> type2 =  TreeUtil.readType2TreesFromFile("input2.txt");
            type1.addAll(type2);
            trees = type1;
            System.out.println(TreeUtil.sortByAgeInDescendingOrder(trees));
            System.out.println();
            System.out.println(TreeUtil.countTreesMatchingType(trees, TreeType.DECIDUOUS));
            System.out.println();
            System.out.println(TreeUtil.sortByEfficiencyOverAge(trees));
            System.out.println();
            System.out.println(TreeUtil.getNamesStartingWithCInDescendingOrder(trees));
            System.out.println();
            System.out.println(TreeUtil.contains(trees, new FruitTree(40, "Template", TreeType.DECIDUOUS, 400, 3.1)));
            Frame frame = new Frame("Application");
        } catch (EmptyListException | FileNotFoundException | IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
    }
}