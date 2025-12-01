import java.util.HashMap;

public class Room {
    private int roomID;
    private String name, description; 

    HashMap<String, Integer> exits;
    ArrayList<Item> ItemsInRoom;
    ArrayList<Monster> monstersInRoom;
}
