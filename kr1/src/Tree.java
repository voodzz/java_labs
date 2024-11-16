public abstract class Tree {
    protected String name;
    protected int age;
    protected TreeType type;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public TreeType getType() {
        return type;
    }

    public Tree(int age, String name, TreeType type) {
        this.age = age;
        this.name = name;
        this.type = type;
    }

    public abstract double countEfficiency();
}
