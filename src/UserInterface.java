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
        System.out.println("explore room");
        System.out.println("Status");
        System.out.println("Inventory ");
        System.out.println("reload ");
        System.out.println("m" );
        System.out.println("menu" );
        System.out.println("i" );
        System.out.println("inventory" );
        System.out.println("check stats" );
        System.out.println("explore" );
        System.out.println("exit" );
        System.out.println("use" );
        System.out.println("fight");
        System.out.println("inspect");
        System.out.println("flee");
        System.out.println("equip" );
        System.out.println("unequip" );
        System.out.println("drop" );
        System.out.println("North" );
        System.out.println("north" );
        System.out.println("N" );
        System.out.println("n" );
        System.out.println("South" );
        System.out.println("south" );
        System.out.println("S" );
        System.out.println("s" );
        System.out.println("East" );
        System.out.println("east" );
        System.out.println("E" );
        System.out.println("e" );
        System.out.println("West" );
        System.out.println("west" );
        System.out.println("W" );
        System.out.println("w" );
        System.out.println("Quit");
        System.out.println("+--------------------+");
    
    }
}
