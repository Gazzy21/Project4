package main.models;

import main.interfaces.Interactable;

public class Monster extends Creature implements Interactable {
    // STUDENT-TODO: Add properties: int damage, Item loot
    protected int damage;
    protected Item loot;

    // STUDENT-TODO: Add a constructor that calls super()
    public Monster(String name, String description, int health, Room currentRoom, int damage, Item loot) {
        super(name, description, health, currentRoom);
        this.damage = damage;
        this.loot = loot;
    }

    public int getDamage() {
        return damage;
    }

    public Item getLoot() {
        return loot;
    }

    @Override
    public void interact(Player player) {
        // STUDENT-TODO: Implement combat logic.
        // 1. Print something like "You attack the Goblin!"
        // 2. The player attacks the monster.
        // 3. The monster attacks the player.
        // 4. Check if the monster is defeated.
        System.out.println("You are now in combat with " + getName() + "!");
        // Player attacks monster 
        int playerDamage = 5; 
        this.health -= playerDamage;
        System.out.println("You hit the " + getName() + " for " + playerDamage + " damage.");

        // Check if the monster died from the hit
        if (!this.isAlive()) {
            System.out.println("The " + getName() + " is defeated!");

            // Drop loot into the current room, if any
            if (loot != null && currentRoom != null) {
                currentRoom.addItem(loot);
                System.out.println("The " + getName() + " dropped " + loot.getName() + ".");
            }

            // Remove this monster from the room (you must implement removeMonster)
            if (currentRoom != null) {
                currentRoom.removeMonster(this);
            }

            return; // combat ends
        }
        System.out.println("The " + getName() + " hits you for " + damage + " damage.");
        player.setHealth(player.getHealth() - damage);

        if (!player.isAlive()) {
            System.out.println("You have been defeated...");
        }

    }
}