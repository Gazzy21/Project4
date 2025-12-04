package main.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    // STUDENT-TODO: Add properties: id, name, description
    // STUDENT-TODO: Add properties: HashMap<String, Integer> exits, ArrayList<Item> items, ArrayList<Monster> monsters
    int id;
    String name;
    String description;
    HashMap<String, Integer> exits;
    ArrayList<Item> items;
    ArrayList<Monster> monsters;

    // STUDENT-TODO: Add a constructor
    public Room(int id, String name, String description, HashMap<String, Integer> exits, ArrayList<Item> items, ArrayList<Monster> monsters) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.items = items;
        this.monsters = monsters;
    }

    // STUDENT-TODO: Add getters for all properties
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Integer> getExits() {
        return exits;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    // STUDENT-TODO: Add methods like:
    // public void addItem(Item item) { ... }
    public void addItem(Item item) {
        this.items.add(item);
    }
    // public Item removeItem(String itemName) { ... }
    public Item removeItem(String itemName) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(itemName)) {
                items.remove(i);
                return i;
            }
        }
        return null;
    }
    // public Monster getMonster(String monsterName) { ... }
    public Monster getMonster(String monsterName) {
        for (Monster m : monsters) {
            if (m.getName().equalsIgnoreCase(monsterName)) {
                return m;
            }
        }
        return null;
    }
    // public String getExitsDescription() { ... }
    public String getExitsDescription() {
        return String.join(", ", exits.keySet());
    }
    // public String getFullDescription() { ... } 
    public String getFullDescription() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- ").append(name).append(" ---\n");
        sb.append(description).append("\n");

        if (!items.isEmpty()) {
            sb.append("You see:\n");
            for (Item item : items) {
                sb.append("- ").append(item.getName()).append("\n");
            }
        }
        
        if (!monsters.isEmpty()) {
            sb.append("DANGER! You see:\n");
            for (Monster monster : monsters) {
                sb.append("- ").append(monster.getName()).append("\n");
            }
        }

        sb.append("Exits are: ").append(getExitsDescription());

        return sb.toString();
    }

    //   This should describe the room, its items, and its monsters
    
}