package main.models;

public class Item extends GameEntity {
    double weight; 

    public Item(String name, String description, double weight) {
        super(name, description);
        this.weight = weight;
    }
}
