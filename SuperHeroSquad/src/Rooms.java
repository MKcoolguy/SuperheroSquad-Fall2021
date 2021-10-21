public class Rooms{
    //Room attributes
    private String roomID;
    private String roomDesc;
    private boolean visitedRoom;
    private boolean item;
    private boolean puzzle;
    private boolean monster;
    private String north;
    private String south;
    private String east;
    private String west;

    // Rooms constructor
    public Rooms(String roomID, String roomDesc, boolean visitedRoom,boolean item, boolean puzzle, boolean monster, String north, String south, String east, String west) {
        this.roomID = roomID;
        this.roomDesc = roomDesc;
        this.visitedRoom = false;
        this.item = item;
        this.puzzle = puzzle;
        this.monster = monster;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    //Rooms getters and setters
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public boolean isVisitedRoom() {
        return visitedRoom;
    }

    public void setVisitedRoom(boolean visitedRoom) {
        this.visitedRoom = visitedRoom;
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

    public boolean hasMonster(){
        return monster;
    }

    public void setMonster(boolean monster){
        this.monster = monster;
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

}
