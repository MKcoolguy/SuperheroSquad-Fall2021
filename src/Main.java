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
    
     public void readRoom() throws FileNotFoundException {
    	Scanner scanner = new Scanner(new File("src/GamesRooms.txt"));
    	while (scanner.hasNext()) {
    		while (scanner.hasNextLine()) {
                String roomNum = scanner.nextLine().trim();
                if (roomNum.trim().equals("")) {
                    roomNum = scanner.nextLine().trim();
                }
                String roomName = scanner.nextLine().trim();
                String roomDesc = scanner.nextLine().trim();
                String roomDirection = scanner.nextLine().trim();
    	}
    	
    }
    scanner.close();
}
    public static void readMonster() throws FileNotFoundException {
    	Scanner scanner = new Scanner(new File("src/Monsters.txt"));
    	
    		while (scanner.hasNextLine()) {
                String monsterNum = scanner.nextLine().trim();
                if (monsterNum.trim().equals("")) {
                    monsterNum = scanner.nextLine().trim();
   
                }
                String monsterName = scanner.nextLine().trim();
                String monsterDesc = scanner.nextLine().trim();
                int monsterHp = Integer.parseInt(scanner.nextLine().trim());
                String monsterItemCarried = scanner.nextLine().trim();  // attack / Hp potion
                
    }
  }
    
    
}
