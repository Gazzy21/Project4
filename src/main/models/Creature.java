package main.models;

public class Creature extends GameEntity {
    int health; 
    Room currentRoom;

    public Creature(String name, String description, int health, Room currentRoom) {
        super(name, description);
        this.health = health;
        this.currentRoom = currentRoom;
    }
}
