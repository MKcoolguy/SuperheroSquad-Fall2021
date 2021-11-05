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
}
