package main.models;

public class Key extends Item{
    protected int keyID; 

    public Key(String name, String description, double weight, int KeyID) {
        super(name, description, weight);
        this.keyID = KeyID;
    }

    public int getKeyID() {
        return keyID;
    }
}
