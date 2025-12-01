import java.util.ArrayList;

public class Player extends Creature {
    ArrayList<Item> inventory;

    addItem(Item item) {
        inventory.add(item);
    }
    dropItem(Item item) {
        inventory.remove(item);
    }
    showInventory() {
        return inventory;
    }
}
