public class Candy {
    private Double weight;
    private Double percentOfSugar;

    public Candy() {
        weight = 0.;
        percentOfSugar = 0.;
    }

    public Candy(Double weight, Double percentOfSugar) {
        this.weight = weight;
        this.percentOfSugar = percentOfSugar;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPercentOfSugar() {
        return percentOfSugar;
    }

    public void setPercentOfSugar(Double percentOfSugar) {
        this.percentOfSugar = percentOfSugar;
    }
}
