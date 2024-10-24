public class Chocolate extends Candy {
    private final ChocolateType type;

    public Chocolate(Double weight, Double percentOfSugar, ChocolateType type) {
        super(weight, percentOfSugar);
        this.type = type;
    }

    public ChocolateType getType() {
        return type;
    }
}
