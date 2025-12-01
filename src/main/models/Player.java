package main.models;

import java.util.ArrayList;

public class Player extends Creature {
    ArrayList<Item> inventory;

    void addItem(Item item) {
        inventory.add(item);
    }
    void dropItem(Item item) {
        inventory.remove(item);
    }
    ArrayList<Item> showInventory() {
        return inventory;
    }
}
