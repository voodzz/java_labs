import java.io.FileWriter;
import java.io.IOException;

abstract class Series {
    double firstElement;
    double delta;
    int numberOfElements;

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
        StringBuffer result = new StringBuffer("[");
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
}