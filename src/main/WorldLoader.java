package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import main.models.Room;

/**
 * This class is responsible for reading the .csv files
 * and creating all the Room, Item, and Monster objects.
 */
public class WorldLoader {

    private final String roomsFilePath;
    private final String objectsFilePath;

    public WorldLoader(String roomsFilePath, String objectsFilePath) {
        this.roomsFilePath = roomsFilePath;
        this.objectsFilePath = objectsFilePath;
    }

    /**
     * Loads all rooms from the rooms.csv file.
     * @return A HashMap mapping the Room ID (Integer) to the Room object.
     */
    public HashMap<Integer, Room> loadRooms() {
        HashMap<Integer, Room> rooms = new HashMap<>();
        File file = new File(roomsFilePath);

        try (Scanner fileScanner = new Scanner(file)) {
            // Skip the header line
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            // Read each room line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String description = data[2].replace("\"", ""); // Remove quotes

                // Create the exits map
                HashMap<String, Integer> exits = new HashMap<>();
                exits.put("north", Integer.parseInt(data[3]));
                exits.put("south", Integer.parseInt(data[4]));
                exits.put("east", Integer.parseInt(data[5]));
                exits.put("west", Integer.parseInt(data[6]));

                // Create the Room object and add it to the map
                Room room = new Room(id, name, description, exits);
                rooms.put(id, room);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: Rooms file not found at " + roomsFilePath);
            return null;
        } catch (Exception e) {
            System.err.println("Error loading rooms: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        System.out.println("Successfully loaded " + rooms.size() + " rooms.");
        return rooms;
    }

    /**
     * Loads all objects (Items and Monsters) from the objects.csv file
     * and places them into their starting rooms.
     * @param rooms The map of all rooms, which will be modified.
     */
    public void loadObjects(HashMap<Integer, Room> rooms) {
        File file = new File(objectsFilePath);

        try (Scanner fileScanner = new Scanner(file)) {
            // Skip the header line
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                String type = data[0].toUpperCase();
                String name = data[1];
                String description = data[2].replace("\"", "");
                int locationId = Integer.parseInt(data[3]);
                int value = Integer.parseInt(data[4]);

                // Find the room where this object belongs
                Room targetRoom = rooms.get(locationId);
                if (targetRoom == null) {
                    System.err.println("Warning: Object '" + name + "' refers to non-existent room ID " + locationId);
                    continue;
                }

                // Create the correct object based on its type
                switch (type) {
                    case "KEY":
                        targetRoom.addItem(new Key(name, description, value));
                        break;
                    case "WEAPON":
                        targetRoom.addItem(new Weapon(name, description, value));
                        break;
                    case "POTION":
                        targetRoom.addItem(new Potion(name, description, value));
                        break;
                    case "MONSTER":
                        // Assuming 15 HP for all goblins, and 'value' is damage
                        Monster monster = new Monster(name, description, 15, value);
                        targetRoom.addMonster(monster);
                        break;
                    default:
                        System.err.println("Warning: Unknown object type '" + type + "'");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Objects file not found at " + objectsFilePath);
        } catch (Exception e) {
            System.err.println("Error loading objects: " + e.getMessage());
            e.printStackTrace();
        }
    }
}