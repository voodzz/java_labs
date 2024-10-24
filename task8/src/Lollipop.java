public class Lollipop extends Candy{
    private final LollipopColor color;

    public Lollipop(Double weight, Double percentOfSugar, LollipopColor color) {
        super(weight, percentOfSugar);
        this.color = color;
    }

    public LollipopColor getColor() {
        return color;
    }
}
