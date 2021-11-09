import java.io.Serializable;
import java.util.HashMap;

public class GameMap implements Serializable {

    public static HashMap<Integer, Rooms> rooms = new HashMap<>();
    public static HashMap<Integer, Puzzles> puzzles = new HashMap<>();
    public static HashMap<String, GameItem> items = new HashMap<>();

    public HashMap<Integer, Rooms> getRooms() {
        return rooms;
    }

    public static void addRoom(int roomid, Rooms room) {
        rooms.put(roomid, room);
    }
    
    public static void setPuzzles(HashMap<Integer, Puzzles> new_puzzles) {
    	puzzles = new_puzzles;
    }
    
    public static HashMap<Integer, Puzzles> getPuzzles() {
    	return puzzles;
    }
    
    public static void setItems(HashMap<String, GameItem> new_items) {
    	items = new_items;
    }
    
    public static HashMap<String, GameItem> getItems() {
    	return items;
    }

    public static void addItem(String itemId, GameItem item) {
        items.put(itemId, item);
    }

//    public void getRoom(String direction){
//        if (direction.equals("0")){
//            System.out.println("You cannot go this way, please type a different direction.");
//        }
//        else if (direction != "0"){
//            int playerLocation = Integer.parseInt(direction)-1;
//            if (rooms.get(playerLocation).isVisitedRoom()){
//                System.out.println("You have a feeling of deja vu, something about this room seems familiar...");
//            }
//            if (direction.equals(rooms.get(playerLocation).getRoomID())){
//                Player.setPlayerLocation(playerLocation);
//            }
//        }
//    }
}
