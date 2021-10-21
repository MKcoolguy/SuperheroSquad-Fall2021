import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public void readItems() {
        File file = new File("src/GameItems.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String itemNum = scanner.nextLine().trim();
                if (itemNum.trim().equals("")) {
                    itemNum = scanner.nextLine().trim();
                }
                String itemName = scanner.nextLine().trim();
                String itemType = scanner.nextLine().trim();
                String itemPower = scanner.nextLine().trim();
                String itemRooms = scanner.nextLine().trim();
                System.out.println(itemNum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
