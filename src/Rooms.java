import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
        return exitRooms;
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
}
