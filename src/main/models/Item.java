package main.models;

public class Item extends GameEntity {
    protected double weight; 

    public Item(String name, String description, double weight) {
        super(name, description);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}
