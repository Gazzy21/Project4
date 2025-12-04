package main.models;

import java.util.ArrayList;

public class Player extends Creature {
    ArrayList<Item> inventory;

    public Player(String name, String description, int health, Room currentRoom) {
        this(name, description, health, currentRoom, new ArrayList<>());  // creates empty inventory
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("You picked up the " + item.getName() + ".");
    }


    public void dropItem(Item item) {
        if (inventory.remove(item)) {
            currentRoom.addItem(item);
            System.out.println("You dropped the " + item.getName() + ".");
        } else {
            System.out.println("You don't have that item.");
        }
    }
    
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You are carrying nothing.");
            return;
        }

        System.out.println("You are carrying:");
        for (Item item : inventory) {
            System.out.println("- " + item.getName());
        }
    }

    public Item getItemByName(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

}
