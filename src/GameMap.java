import java.util.ArrayList;

public class GameMap {

    public static ArrayList<Rooms> rooms = new ArrayList<>();

    public static void addRoom(Rooms room){
        rooms.add(room);
    }

    public static ArrayList<Rooms> getRooms(){
        return rooms;
    }


    public void getRoom(String direction){
        if (direction.equals("0")){
            System.out.println("You cannot go this way, please type a different direction.");
        }
        else if (direction != "0"){
            int playerLocation = Integer.parseInt(direction)-1;
            if (rooms.get(playerLocation).isVisitedRoom()){
                System.out.println("You have a feeling of deja vu, something about this room seems familiar...");
            }
            if (direction.equals(rooms.get(playerLocation).getRoomID())){
                Player.setPlayerLocation(playerLocation);
            }
        }
    }
}
