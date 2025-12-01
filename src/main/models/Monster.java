package main.models;

import main.interfaces.Interactable;

public class Monster extends Creature implements Interactable {
    int damage; 
    Item loot; 

    public Monster(String name, String description, int health, Room currentRoom, int damage, Item loot) {
        super(name, description, health, currentRoom);
        this.damage = damage;
        this.loot = loot;
    }
}
