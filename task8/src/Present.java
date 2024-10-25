import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Present {
    private ArrayList<Candy> candies;
    private Double weight;
    private Map<Double, Candy> candiesByWeightMap;

    public Present(ArrayList<Candy> candies) {
        this.candies = candies;
        weight = measureWeight();
        candiesByWeightMap = new HashMap<>();
        this.candies.forEach(candy -> {
            candiesByWeightMap.put(candy.getWeight(), candy);
        });
    }

    public Present(Candy[] candies) {
        this.candies = new ArrayList<>(List.of(candies));
        weight = measureWeight();
        candiesByWeightMap = new HashMap<>();
        this.candies.forEach(candy -> {
            candiesByWeightMap.put(candy.getWeight(), candy);
        });
    }

    public Double measureWeight() {
        Double result = 0.;
        for (Candy candy : candies) {
            result += candy.getWeight();
        }
        return result;
    }

    public Iterator<Candy> iterator() {
        return candies.iterator();
    }

    public ArrayList<Candy> sort(Comparator<Candy> comparator) {
        return candies.stream().sorted(comparator).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Candy> findCandyByPercentOfSugar(Double minPercent, Double maxPercent) {
        Predicate<Candy> predicate = candy -> minPercent <= candy.getPercentOfSugar() && candy.getPercentOfSugar() <= maxPercent;
        return candies.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Candy> findByPredicate(Predicate<Candy> predicate) {
        return candies.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
    }

    public Map<String, Double> findWeightAndPercentOfChocolate() {
        Predicate<Candy> predicate = candy -> candy instanceof Chocolate;
        ArrayList<Candy> chocolates = candies.stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));

        int amountOfChocolateInPresent = chocolates.size();
        Double percent = (double) candies.size() / amountOfChocolateInPresent;

        Double weight = 0.;
        for (Candy chocolate : chocolates) {
            weight += chocolate.getWeight();
        }

        Map<String, Double> result = new HashMap<>();
        result.put("Weight", weight);
        result.put("Percent", percent);

        return result;
    }

    public void addCandy(Candy candy) {
        candies.add(candy);
    }

    public ArrayList<Candy> sortByWeight() {
        Comparator<Candy> comparator = Comparator.comparing(Candy::getWeight);
        return candies.stream().sorted(comparator).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Candy> sortByPercentOfSugar() {
        Comparator<Candy> comparator = Comparator.comparing(Candy::getPercentOfSugar);
        return candies.stream().sorted(comparator).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }

    public void setCandies(ArrayList<Candy> candies) {
        this.candies = candies;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Candy candy : candies) {
            if (candy instanceof Chocolate chocolate) {
                String line = chocolate.getType().name().toLowerCase() + " chocolate " +
                        chocolate.getWeight() + ' ' +chocolate.getPercentOfSugar();
                buffer.append(line).append('\n');
            } else if (candy instanceof Lollipop lollipop) {
                String line = lollipop.getColor().name().toLowerCase() + " lollipop " +
                        lollipop.getWeight() + ' ' + lollipop.getPercentOfSugar();
                buffer.append(line).append('\n');
            }
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }
}
