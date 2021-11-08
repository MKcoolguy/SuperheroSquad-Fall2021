import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Rooms implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //Room attributes
    private int roomID;
    private String roomName;
    private String roomDesc;
    private HashMap<String, Integer> exitRooms; //possibleExits;
    private ArrayList<GameItem> items = new ArrayList<>();
    private ArrayList<Puzzles> puzzles = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<Monster>();

    // Rooms constructor

    public Rooms(int roomID, String roomName, String roomDesc, HashMap<String, Integer> exitRooms) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomDesc = roomDesc;
        this.exitRooms = exitRooms;
    }
    //comment
    //Rooms getters and setters

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public HashMap<String, Integer> getExitRooms() {
        return this.exitRooms;
    }

    public void setExitRooms(HashMap<String, Integer> exitRooms) {
        this.exitRooms = exitRooms;
    }

    public ArrayList<GameItem> getItems() {
        return items;
    }

    public void addItems(GameItem item) {
        getItems().add(item);
    }

    public ArrayList<Puzzles> getPuzzles() {
        return puzzles;
    }

    public void addPuzzles(Puzzles puzzle) {
        getPuzzles().add(puzzle);
    }

    public void setPuzzles(ArrayList<Puzzles> puzzles) {
        this.puzzles = puzzles;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void addMonster(Monster monster) {
        getMonsters().add(monster);
    }
    
    public void explore() {
		System.out.println("+--------------------+");
    	// Show adjacent rooms
    	HashMap<String, Integer> exitRooms = this.getExitRooms();
    	String[] dir = {"North", "East", "South", "West"};
    	List<String> directions = Arrays.asList(dir);
		System.out.println("ADJACENT ROOMS:");
    	if (exitRooms.size() > 0) {
        	for (HashMap.Entry<String, Integer> entry : exitRooms.entrySet()) {
        		String key = entry.getKey();
        		int value = entry.getValue();
        		if (directions.contains(entry.getKey())) {
        			System.out.println(key);
        		}
        	}
    	} else {
    		System.out.println("There are no exits for this room"); // In theory, should never show up
    	}
    	
    	// Show items
    	ArrayList<GameItem> items = this.getItems();
		System.out.println("-----");
		System.out.println("ITEMS");
    	if (items.size() > 0) {
    		for (int i = 0; i < items.size(); i++) {
    			System.out.println(items.get(i).getItemName());
    		}
    	} else {
    		System.out.println("There are no items in this room");
    	}
    	
    	// Show monsters TODO, need Monster implementation, can probably copy Show Items section and modify it for Monsters
        ArrayList<Monster> monsters = this.getMonsters();
        System.out.println("-----");
        System.out.println("Monsters");
        if (items.size() > 0) {
            for (int i = 0; i < monsters.size(); i++) {
                System.out.println(monsters.get(i).getName());
            }
        } else {
            System.out.println("There are no Monsters in this room");
        }
    	
    	// Show puzzles
    	ArrayList<Puzzles> puzzles = this.getPuzzles();
    	int puzzles_amount = puzzles.size();
		System.out.println("-----");
		System.out.println("PUZZLES");
    	if (puzzles_amount > 0) {
    		System.out.println("There "+(puzzles_amount == 1 ? "is" : "are")+" "+puzzles_amount+" puzzle"+(puzzles_amount == 1 ? "" : "s")+" in this room!");
    	} else {
    		System.out.println("There are no puzzles in this room");
    	}
    	System.out.println("+--------------------+");
    }
    public  void addMonsterToRoom(Monster monster) {
    	monsters.add(monster);
    }
    public boolean hasMonster() {
		
    	return !monsters.isEmpty();
    }
    public Monster getMonster() {
    	return monsters.get(0);     
    }
    public Monster removeMonster() {
    	return monsters.remove(0);     
    }
    
}
