public class ForestTree extends Tree {

    private int amountOfWood;
    private final double CONST = 2.;

    public ForestTree(int age, String name, TreeType type, int amountOfWood) {
        super(age, name, type);
        this.amountOfWood = amountOfWood;
    }

    @Override
    public double countEfficiency() {
        return age * CONST * amountOfWood;
    }

    @Override
    public String toString() {
        return name + ' ' + age + ' ' + type + ' ' + amountOfWood + '\n';
    }
}
