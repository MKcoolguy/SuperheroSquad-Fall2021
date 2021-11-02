import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Puzzles> puzzles = Puzzles.loadPuzzlesFromFile("Puzzles.txt");
		Puzzles.__debugView(puzzles);
	}

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
     public static void readPuzzle() throws FileNotFoundException {
    	Scanner scanner = new Scanner(new File("src/Puzzles.txt"));
    	while (scanner.hasNextLine()) {
    		String puzzleNum = scanner.nextLine().trim();
    		 if (puzzleNum.trim().equals("")) {
                 puzzleNum = scanner.nextLine().trim();

             }
    		 String puzzleLocation = scanner.nextLine().trim();
    		 String puzzleQuestion = scanner.nextLine().trim();
    		 String puzzleAnswer = scanner.nextLine().trim();
    		 String puzzleHint = scanner.nextLine().trim();
    		 int attemptsAllowed = Integer.parseInt(scanner.nextLine().trim());
    		 String outputForIncorrectAns = scanner.nextLine().trim();
    		 // Y/N
    		 String outputForCorrectAns = scanner.nextLine().trim();
    		 String reward = scanner.nextLine().trim();
    		 //hp number 
    	}
    	
    }
	// save and load
	public static void saveGame() throws FileNotFoundException {
		//using seralization 
		//output stream to save
		//object = room ,since everything is in the room
		
		FileOutputStream file = new FileOutputStream("saveGame.txt");  // need to use .Sav file
		try {
			ObjectOutputStream output = new ObjectOutputStream(file);
		   output.flush();
		   output.close();
		   output.writeObject(room);
		System.out.println("Game saved");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
		
		
	}
	public static void loadGame() throws FileNotFoundException {
		//using seralization 
		//input stream to save
		//object = room ,since everything is in the room
		
		FileInputStream fileInput = new FileInputStream("saveGame.txt");  // need to use .Sav file
		try {
			ObjectInputStream input = new ObjectInputStream(fileInput);
		   room = (Room) input.readObject();
		   
		   input.close();
		   
		System.out.println("Game loded");
		
		} catch(Exception e) {
			System.out.println("can't load data");
		}
		
		
		
		
	}
	
	
}
