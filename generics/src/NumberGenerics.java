public class NumberGenerics<T extends Number> {
    T[] array;

    T countSum() {
        Number sum = 0;
        for (T element : array) {
            sum = sum.doubleValue() + ((Number)element).doubleValue();
        }
        return (T)sum;
    }

    double findArithmeticMean() {
        return (double)countSum() / array.length;
    }
}
