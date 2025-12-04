package main;

import java.util.HashMap;

import main.models.Player;
import main.models.Room;

public class SaveManager {

    /**
     * Saves the player's current state to a file.
     * STUDENT-TODO: You decide the file format. A simple .txt file is fine.
     * You need to save:
     * 1. Player's current health.
     * 2. Player's current room ID.
     * 3. The items in the player's inventory (e.g., by name or ID).
     */
    public void saveGame(Player player) {
        System.out.println("Saving game...");
        // STUDENT-TODO: Implement file writing logic here.
        System.out.println("Game saved!");
    }

    /**
     * Loads the player's state from a file.
     * STUDENT-TODO: You need to read the file you created in saveGame().
     * 1. Create a new Player object.
     * 2. Set their health.
     * 3. Find their room from the 'allRooms' map and set their current room.
     * 4. Re-create their inventory items (you may need to search all items in all rooms to find them by name).
     * @param allRooms A map of all rooms, to help link the player to their loaded room.
     * @return A configured Player object.
     */
    public Player loadGame(HashMap<Integer, Room> allRooms) {
        System.out.println("Loading game...");
        // STUDENT-TODO: Implement file reading logic here.
        // For now, just return null as a placeholder.
        System.out.println("No save file found. Starting new game.");
        return null; 
    }
}