package main.models;

import main.interfaces.Interactable;

public class Potion extends Item implements Interactable {
    private int healAmount; 

    public Potion(String name, String description, double weight, int healAmount) {
        super(name, description, weight);
        this.healAmount = healAmount;
    }

    @Override
    public void interact(Player player) {
        // STUDENT-TODO: Implement combat logic.
        // 1. Print something like "You attack the Goblin!"
        // 2. The player attacks the monster.
        // 3. The monster attacks the player.
        // 4. Check if the monster is defeated.
        player.setHealth(player.getHealth() + healAmount);

        System.out.println("You drank the " + getName() +
                           " and healed " + healAmount + " HP.");

        // Remove potion from inventory after use
        player.getInventory().remove(this);
    }
}
