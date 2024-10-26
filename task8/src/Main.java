import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Candy> candies = new ArrayList<>();

        // "Создать несколько объектов-конфет".
        Candy milkChocolate = new Chocolate(100., 50., ChocolateType.MILK);
        Candy whiteChocolate = new Chocolate(150., 60., ChocolateType.WHITE);
        Candy yellowLollipop = new Lollipop(200., 70., LollipopColor.YELLOW);
        Candy redLollipop = new Lollipop(250., 80., LollipopColor.RED);
        Candy orangeLollipop = new Lollipop(300., 90., LollipopColor.ORANGE);
        candies.add(milkChocolate);
        candies.add(whiteChocolate);
        candies.add(yellowLollipop);
        candies.add(redLollipop);
        candies.add(orangeLollipop);

        // "Собрать детский подарок с определением его веса".
        Present present = new Present(candies);
        System.out.println("Weight of the present: " + present.getWeight() + "g\n");

        // "Провести сортировку конфет в подарке на основе одного из параметров".
        System.out.println("Candies sorted by weight:\n" + (new Present(present.sortByWeight())) + '\n');

        // "Найти конфеты в подарке, соответствующую заданному диапазону содержания сахара".
        System.out.println("Candies with percent of sugar in range [50, 70]:\n" +
                (new Present(present.findCandyByPercentOfSugar(50., 70.))));
    }
}