package main.models;

public class Weapon extends Item {
    int damage;

    public Weapon(String name, String description, double weight, int damage) {
        super(name, description, weight);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}
