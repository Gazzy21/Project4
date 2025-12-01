package main.models;

import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private int roomID;
    private String name, description; 

    HashMap<String, Integer> exits;
    ArrayList<Item> ItemsInRoom;
    ArrayList<Monster> monstersInRoom;
}
