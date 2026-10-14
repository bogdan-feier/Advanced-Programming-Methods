package model;

public class Poultry implements Animal {
    private final double weight;

    public Poultry(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Poultry (" + weight + " kg)";
    }
}
