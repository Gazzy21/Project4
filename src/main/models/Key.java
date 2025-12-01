package main.models;

public class Key extends Item{
    int KeyID; 

    public Key(String name, String description, double weight, int KeyID) {
        super(name, description, weight);
        this.KeyID = KeyID;
    }
}
