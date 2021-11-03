public class Rooms {
    //Room attributes
    // Testing
    private String roomID;
    private String roomName;
    private String roomDesc;
    private String north;
    private String south;
    private String east;
    private String west;
    private boolean monster;
    private boolean item;
    private boolean puzzle;
    private boolean visitedRoom;


    // Rooms constructor

    public Rooms(String roomID, String roomName, String roomDesc, String north, String south, String east, String west, boolean monster, boolean item, boolean puzzle, boolean visitedRoom) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomDesc = roomDesc;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.monster = monster;
        this.item = item;
        this.puzzle = puzzle;
        this.visitedRoom = false;
    }


    //Rooms getters and setters

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
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

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public boolean hasMonster() {
        return monster;
    }

    public void setMonster(boolean monster) {
        this.monster = monster;
    }

    public boolean hasItem() {
        return item;
    }

    public void setItem(boolean item) {
        this.item = item;
    }

    public boolean hasPuzzle() {
        return puzzle;
    }

    public void setPuzzle(boolean puzzle) {
        this.puzzle = puzzle;
    }

    public boolean isVisitedRoom() {
        return visitedRoom;
    }

    public void setVisitedRoom(boolean visitedRoom) {
        this.visitedRoom = visitedRoom;
    }
}
