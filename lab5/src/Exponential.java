public class Exponential extends Series {
    Exponential() {
        super();
    }

    Exponential(double firstElement, double delta, int numberOfElements) {
        super(firstElement, delta, numberOfElements);
    }

    @Override
    public double findElementJ(int j) {
        return firstElement * Math.pow(delta, j - 1);
    }
}
