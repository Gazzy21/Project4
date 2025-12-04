package main;

import main.interfaces.Interactable;
import main.models.*;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    // --- Properties ---
    // These are the main components of your game.
    // They MUST be initialized in the constructor.
    private Player player;
    private HashMap<Integer, Room> allRooms;
    private SaveManager saveManager;

    /**
     * Constructor for the Game.
     * STUDENT-TODO: You must initialize the game state here.
     * The game cannot run if 'player' and 'allRooms' are null.
     */
    public Game() {
        System.out.println("Game constructor called...");
        
        // STUDENT-TODO: 1. Initialize the WorldLoader
        // Create a new WorldLoader, passing in the paths to your CSV files
        // (e.g., "world/rooms.csv", "world/objects.csv")
        // WorldLoader loader = new WorldLoader(...);

        WorldLoader loader = new WorldLoader("world/rooms.csv", "world/objects.csv");
        
        // STUDENT-TODO: 2. Load the world
        // a. Call the loader's loadRooms() method and store the result in `this.allRooms`.
        //    this.allRooms = loader.loadRooms();
        // b. Check if `this.allRooms` is null. If it is, print an error and exit the program
        //    (System.exit(1);)
        // c. Call the loader's loadObjects() method, passing in `this.allRooms` to populate them.
        //    loader.loadObjects(this.allRooms);

        this.allRooms = loader.loadRooms();
        
        if (this.allRooms == null) {
            System.exit(1);
        }

        loader.loadObjects(this.allRooms);

        // STUDENT-TODO: 3. Initialize the SaveManager
        // Create a new SaveManager object and store it in `this.saveManager`.
        // this.saveManager = new SaveManager();

        this.saveManager = new SaveManager();

        // STUDENT-TODO: 4. Try to load a saved game
        // a. Call the saveManager's loadGame() method, passing in `this.allRooms`.
        // b. Store the result in `this.player`. (It will be `null` if no save file is found).
        //    this.player = saveManager.loadGame(this.allRooms);

        this.player = saveManager.loadGame(this.allRooms);
        
        // STUDENT-TODO: 5. Create a new player if no save was loaded
        // a. Check if `this.player` is still null.
        // b. If it is, this is a new game!
        //    i. Get the starting room (e.g., `Room startingRoom = allRooms.get(1);`)
        //    ii. Create a new Player object with default values (health, name, etc.)
        //        and store it in `this.player`.
        //    (e.g., this.player = new Player("Hero", "Our valiant hero", 100, startingRoom);)

        if (this.player == null) {
            Room startingRoom = allRooms.get(1);
            this.player = new Player("Hero", "Our valiant hero", 100, startingRoom);
        }
        
        System.out.println("...Game constructor finished. (Hopefully, you initialized everything!)");
    }

    /**
     * The main game loop.
     */
    public void run() {
        // --- This check is crucial ---
        // If the student didn't implement the constructor, the game will exit gracefully.
        if (this.player == null || this.allRooms == null || this.saveManager == null) {
            System.err.println("FATAL ERROR: Game was not initialized correctly in the constructor.");
            System.err.println("Did you forget to implement the STUDENT-TODOs in Game.java's constructor?");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("\nWelcome to the Text Adventure!");
        System.out.println(player.getCurrentRoom().getFullDescription()); 

        while (isRunning) {
            // STUDENT-TODO: Check if the player's health is <= 0.
            // If it is, print a "Game Over" message, set isRunning = false,
            // and `continue` to the next loop iteration to stop the game.
            if (player.getHealth() <= 0) {
                System.out.println("You have died. GAME OVER.");
                isRunning = false;
                continue;
            }
            
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            // --- Command Parsing ---
            String command = "";
            String argument = "";
            
            int firstSpace = input.indexOf(' ');
            if (firstSpace == -1) {
                command = input; // e.g., "look"
            } else {
                command = input.substring(0, firstSpace); // e.g., "get"
                argument = input.substring(firstSpace + 1); // e.g., "rusty key"
            }


            switch (command) {
                case "quit":
                case "exit":
                    isRunning = false;
                    break;
                case "look":
                    // STUDENT-TODO: Get the player's current room and
                    // print its full description.
                    System.out.println("STUDENT-TODO: Implement 'look'");
                    break;
                case "go":
                    // STUDENT-TODO: Implement 'go'
                    // 1. Check if 'argument' (e.g., "north") is empty. If so, print "Go where?"
                    // 2. Get the player's current room.
                    // 3. Get the room's exits (a HashMap).
                    // 4. Check if the 'argument' direction exists as a key in the exits map.
                    //    - If not, print "You can't go [direction]."
                    // 5. If it does exist, get the 'nextRoomId' (Integer) from the exits map.
                    //    - If 'nextRoomId' is -1, print "There is no path to the [direction]."
                    //    - If 'nextRoomId' is a valid ID:
                    //        a. Get the new Room object from the `allRooms` HashMap.
                    //        b. Tell the player to `moveTo(newRoom)`.
                    //        c. Print the new room's full description.

                    if (argument.isEmpty()) {
                        System.out.println("Go where?");
                        break;
                    }

                    System.out.println("STUDENT-TODO: Implement 'go " + argument + "'");
                    break;
                case "get":
                case "take":
                    // STUDENT-TODO: Implement 'get'
                    // 1. Check if 'argument' is empty. If so, print "Get what?"
                    // 2. Get the player's current room.
                    // 3. Try to remove the item from the room: `Item item = currentRoom.removeItem(argument)`
                    // 4. Check if the 'item' you got back is null.
                    //    - If it is null, print "There is no '[argument]' here."
                    //    - If it's not null, add the 'item' to the player's inventory.
                    System.out.println("STUDENT-TODO: Implement 'get " + argument + "'");
                    break;
                case "drop":
                    // STUDENT-TODO: Implement 'drop'
                    // 1. Check if 'argument' is empty. If so, print "Drop what?"
                    // 2. Try to remove the item from the player's inventory: `Item item = player.dropItem(argument)`
                    // 3. Check if the 'item' you got back is not null.
                    //    - If it's not null, add the 'item' back to the current room.
                    System.out.println("STUDENT-TODO: Implement 'drop " + argument + "'");
                    break;
                case "inventory":
                case "i":
                    // STUDENT-TODO: Call the player's `showInventory()` method.
                    System.out.println("STUDENT-TODO: Implement 'inventory'");
                    break;
                case "interact":
                case "use":
                case "attack":
                    // STUDENT-TODO: Implement 'interact'
                    // 1. Check if 'argument' is empty. If so, print "Interact with what?"
                    
                    // 2. Check if the 'argument' is a MONSTER in the current room.
                    //    a. Get the monster from the room: `Monster monster = player.getCurrentRoom().getMonster(argument)`
                    //    b. If 'monster' is not null, it's an 'Interactable'. Call its `interact(player)` method.
                    //    c. `return` or `break` so you don't check for items.

                    // 3. If it's not a monster, check if it's an ITEM in the player's INVENTORY.
                    //    a. Get the item from the player: `Item item = player.getItem(argument)`
                    //    b. If 'item' is not null:
                    //       i. Check if it's an 'Interactable': `if (item instanceof Interactable)`
                    //       ii. If it is, cast it and call its method: `((Interactable) item).interact(player);`
                    //       iii. If it's not, print "You can't use the [item name] like that."
                    //    d. `return` or `break`.

                    // 4. If you've checked for monsters and inventory items and found nothing,
                    //    print "You can't find a '[argument]' to interact with."
                    System.out.println("STUDENT-TODO: Implement 'interact " + argument + "'");
                    break;
                case "save":
                    // This one is simple!
                    saveManager.saveGame(player);
                    break;
                case "help":
                    System.out.println("Commands: go <dir>, get <item>, drop <item>, look, inventory, interact <target>, save, quit");
                    break;
                default:
                    System.out.println("Unknown command. Type 'help' for a list.");
            }
        }
        
        System.out.println("\nThanks for playing!");
        scanner.close();
    }
    
    // --- Main Method (Complete) ---
    // This starts the game.
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}