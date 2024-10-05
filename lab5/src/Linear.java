public class Linear extends Series {
    Linear() {
        super();
    }

    Linear(double firstElement, double delta, int numberOfElements) {
        super(firstElement, delta, numberOfElements);
    }

    @Override
    public double findElementJ(int j) {
        return firstElement + (j - 1) * delta;
    }
}
