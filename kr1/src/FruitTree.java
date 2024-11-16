public class FruitTree extends Tree {
    private double mass;
    private double periodOfKeeping;
    private final double CONST = 3.;

    public FruitTree(int age, String name, TreeType type, double mass, double periodOfKeeping) {
        super(age, name, type);
        this.mass = mass;
        this.periodOfKeeping = periodOfKeeping;
    }

    @Override
    public double countEfficiency() {
        return age * CONST * (mass / periodOfKeeping);
    }

    @Override
    public String toString() {
        return name + ' ' + age + ' ' + type + ' ' + mass + ' ' + periodOfKeeping + '\n';
    }
}
