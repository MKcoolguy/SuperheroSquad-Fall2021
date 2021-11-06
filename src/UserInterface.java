import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class UserInterface {

    private static String title;
    private String [] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public static String getTitle() {
        return title;
    }

    public void setTile(String title) {
        this.title = title;
    }

    public static void displayMenu() {
        String [] message = {"Restart","Status","Help", "Quit"};
        System.out.println("+--------------------+");
        System.out.println("Main Menu");
        System.out.println("+--------------------+");
        for (String s: message) {
            System.out.println(s);
        }
        System.out.println("+--------------------+");
    }

    public static void displayStartMenu() {
        String [] message = {"Start","Status","Help","Quit"};
        System.out.println("+--------------------+");
        System.out.println("Welcome to Adventure South Game");
        System.out.println("+--------------------+");
        System.out.println("Main Menu");
        System.out.println("+--------------------+");
        for (String s: message) {
            System.out.println(s);
        }
        System.out.println("+--------------------+");
    }

    public static void displayInventory(HashMap<String, Queue<GameItem>> inventory) {
        System.out.println("+--------------------+");
        System.out.println("Inventory");
        System.out.println("+--------------------+");
        for (Map.Entry<String, Queue<GameItem>> entry : inventory.entrySet()) {
            //prints each item in inventory with quantity
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }
        System.out.println("+--------------------+");
    }

    public static void displayStatus(int score, int movesMade, int playerHP ) {
        System.out.println("+--------------------+");
        System.out.println("Status");
        System.out.println("+--------------------+");
        System.out.println("Score : " + score);
        System.out.println("Moves made : " + movesMade);
        System.out.println("Player HP : " + playerHP);
        System.out.println("Back");
        System.out.println("+--------------------+");
    
    }
    public static void displayHelp() {
    	System.out.println("+--------------------+");
        System.out.println("Help");System.out.println("+--------------------+");
        System.out.println("Start");
        System.out.println("Start menu");
        System.out.println("Main Menu");
        System.out.println("explore room, This command allows the player to explore the room");
        System.out.println("Status, This command allows the player to see score,moves made,players hp and back");
        System.out.println("Inventory, This command shows the players inventory, it shows what items the player has ");
        System.out.println("reload, This command refreshes the game ");
        System.out.println("m, This command shows the menu " );
        System.out.println("menu, This command shows the menu" );
        System.out.println("i, This command shows the players inventory, it shows what items the player has" );
        System.out.println("check stats, This command shows the players stats " );
        System.out.println("explore, This command allows the player to explore the room" );
        System.out.println("exit, This command allows the player to exit the game" );
        System.out.println("use, This command allows the player to use an item " );
        System.out.println("fight, This command allows the player to fight a monster");
        System.out.println("inspect, This command allows the player to inspect the item");
        System.out.println("flee, This command allows the player to run away from the monster");
        System.out.println("equip, This command allows the player to equip the item" );
        System.out.println("unequip, This command allows the player to unequip the item" );
        System.out.println("drop, This command allows the player to drop their item " );
        System.out.println("North, This command allows the player to move North " );
        System.out.println("north, This command allows the player to move North" );
        System.out.println("N, This command allows the player to move North" );
        System.out.println("n, This command allows the player to move North" );
        System.out.println("South, This command allows the player to move South" );
        System.out.println("south, This command allows the player to move South" );
        System.out.println("S, This command allows the player to move South" );
        System.out.println("s, This command allows the player to move South" );
        System.out.println("East, This command allows the player to move East" );
        System.out.println("east, This command allows the player to move East" );
        System.out.println("E, This command allows the player to move East" );
        System.out.println("e, This command allows the player to move East" );
        System.out.println("West, This command allows the player to move West" );
        System.out.println("west, This command allows the player to move West" );
        System.out.println("W, This command allows the player to move West" );
        System.out.println("w, This command allows the player to move West" );
        System.out.println("Quit, This command allows the player to quit the game");
        System.out.println("+--------------------+");
    
    }
}
