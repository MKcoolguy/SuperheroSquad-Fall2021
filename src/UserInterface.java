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

    public static void displayStatus(int movesMade, int playerHP ) {
        System.out.println("+--------------------+");
        System.out.println("Status");
        System.out.println("+--------------------+");
        System.out.println("Moves made : " + movesMade);
        System.out.println("Player HP : " + playerHP);
        System.out.println("+--------------------+");
    
    }
    public static void displayHelp() {
    	System.out.println("+--------------------+");
        System.out.println("HELP");
        System.out.println("All commands are NOT case sensitive.");
        System.out.println("+--------------------+");
        System.out.println("MENU COMMANDS");
        System.out.println("+--------------------+");
        System.out.println("Start menu or Main Menu, this command will send the player back to the start screen.");
        System.out.println("Status, This command allows the player to see score,moves made,players hp and back");
        System.out.println("Restart, This command refreshes the game ");
        System.out.println("Help, this command shows all the commands in the game.");
        System.out.println("M or Menu, This command shows the menu " );
        System.out.println("Quit, this command allows the player to quit the game.");
        System.out.println("+--------------------+");
        System.out.println("ITEM COMMANDS");
        System.out.println("+--------------------+");
        System.out.println("I or Inventory, This command shows the players inventory, it shows what items the player has" );
        System.out.println("Equip, This command allows the player to equip the item" );
        System.out.println("Unequip, This command allows the player to unequip the item" );
        System.out.println("Drop, This command allows the player to drop their item " );
        System.out.println("Use, This command allows the player to use an item " );
        System.out.println("Inspect, This command allows the player to inspect the item");
        System.out.println("+--------------------+");
        System.out.println("MONSTER COMMANDS");
        System.out.println("+--------------------+");
        System.out.println("fight, This command allows the player to fight a monster");
        System.out.println("flee, This command allows the player to run away from the monster");
        System.out.println("+--------------------+");
        System.out.println("PUZZLE COMMANDS");
        System.out.println("+--------------------+");
        System.out.println("Solve Puzzle, this command allows the player to interact with a puzzle");
        System.out.println("Answer Puzzle, this command allows the player to answer a puzzle.");
        System.out.println("Hint, this command will display a hint about the puzzle to the player.");
        System.out.println("Ignore Puzzle, this command will take you out of the puzzle environment and send you back to the room.");
        System.out.println("+--------------------+");
        System.out.println("ROOM/GENERAL COMMANDS");
        System.out.println("+--------------------+");
        System.out.println("Explore or Explore room, this command allows the player to explore the contents of a room.");
        System.out.println("Check stats, this command will display the players health and attack stats.");
        System.out.println("Save, this command allows the player to save the game.");
        System.out.println("Exit, this command allows the player to exit the game.");
        System.out.println("+--------------------+");
        System.out.println("NAVIGATION COMMANDS");
        System.out.println("+--------------------+");
        System.out.println("North or N, This command allows the player to move North " );
        System.out.println("South or S, This command allows the player to move South" );
        System.out.println("East or E, This command allows the player to move East" );
        System.out.println("West or W, This command allows the player to move West" );
        System.out.println("+--------------------+");
    }
}
