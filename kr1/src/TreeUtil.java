import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class TreeUtil {
    public static List<Tree> sortByAgeInDescendingOrder(List<Tree> trees) throws EmptyListException {
        if (trees.isEmpty()) {
            throw new EmptyListException("List is empty.");
        }
        return trees.stream()
                .sorted(Comparator.comparing(Tree::getAge).reversed().thenComparing(Tree::getName))
                .toList();
    }

    public static int countTreesMatchingType(List<Tree> trees, TreeType type) throws EmptyListException {
        if (trees.isEmpty()) {
            throw new EmptyListException("List is empty.");
        }
        return trees.stream()
                .filter(tree -> tree.getType().equals(type))
                .toList().size();
    }

    public static List<Tree> sortByEfficiencyOverAge(List<Tree> trees) throws EmptyListException {
        if (trees.isEmpty()) {
            throw new EmptyListException("List is empty.");
        }

        Comparator<Tree> comp = (tree1, tree2) -> {
            double tree1Relation = tree1.countEfficiency() / tree1.getAge();
            double tree2Relation = tree2.countEfficiency() / tree2.getAge();
            return Double.compare(tree2Relation, tree1Relation);
        };
        return trees.stream().sorted(comp).toList();
    }

    public static List<String> getNamesStartingWithCInDescendingOrder(List<Tree> trees) throws EmptyListException {
        if (trees.isEmpty()) {
            throw new EmptyListException("List is empty.");
        }

        return trees.stream()
                .map(Tree::getName)
                .filter(name -> name.startsWith("C"))
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static int contains(List<Tree> trees, Tree tree) throws EmptyListException {
        if (trees.isEmpty()) {
            throw new EmptyListException("List is empty.");
        }

        Comparator<Tree> comp = Comparator
                .comparing(Tree::getName)
                .thenComparing(Tree::getAge);
        trees.sort(comp);

        return Collections.binarySearch(trees, tree, comp);
    }

    public static List<Tree> readType1TreesFromFile(String fileName) throws FileNotFoundException, IllegalArgumentException {
        List<Tree> result = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 4) {
                int age = Integer.parseInt(tokens[0]);
                int amountOfWood = Integer.parseInt(tokens[3]);
                result.add(new ForestTree(age, tokens[1], TreeType.valueOf(tokens[2]), amountOfWood));
            } else {
                throw new IllegalArgumentException("Incorrect size of input.");
            }
        }
        scanner.close();
        return result;
    }

    public static List<Tree> readType2TreesFromFile(String fileName) throws FileNotFoundException {
        List<Tree> result = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 5) {
                int age = Integer.parseInt(tokens[0]);
                double weight = Double.parseDouble(tokens[3]);
                double period = Double.parseDouble(tokens[4]);
                result.add(new FruitTree(age, tokens[1], TreeType.valueOf(tokens[2]), weight, period));
            } else {
                throw new IllegalArgumentException("Incorrect size of input.");
            }
        }
        scanner.close();
        return result;
    }
}
