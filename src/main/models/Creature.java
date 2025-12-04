package main.models;

public class Creature extends GameEntity {
    protected int health; 
    protected Room currentRoom;

    public Creature(String name, String description, int health, Room currentRoom) {
        super(name, description);
        this.health = health;
        this.currentRoom = currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    
    //Returns true if the creature is still alive.
    public boolean isAlive() {
        return health > 0;
    }
}

