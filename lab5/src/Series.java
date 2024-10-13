import java.io.FileWriter;
import java.io.IOException;

abstract class Series {
    protected double firstElement;
    protected double delta;
    protected int numberOfElements;

    Series() {
        firstElement = 0;
        delta = 0;
        numberOfElements = 0;
    }

    Series(double firstElement, double delta, int numberOfElements) {
        this.firstElement = firstElement;
        this.delta = delta;
        this.numberOfElements = numberOfElements;
    }

    public abstract double findElementJ(int j);

    public double findSum() {
        double sum = 0;
        for (int i = 1; i <= numberOfElements; ++i) {
            sum += findElementJ(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 1; i <= numberOfElements; ++i) {
            if (i != numberOfElements) {
                result.append(findElementJ(i)).append(", ");
            } else {
                result.append(findElementJ(i)).append("]");
            }
        }
        return result.toString();
    }

    public void printToFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath, false);
        writer.write("Elements of the series: " + toString() + '\n');
        writer.write("Sum of the series: " + findSum());
        writer.close();
    }

    void setFirstElement(double firstElement) {
        this.firstElement = firstElement;
    }
    public void setDelta(double delta) {
        this.delta = delta;
    }
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
}