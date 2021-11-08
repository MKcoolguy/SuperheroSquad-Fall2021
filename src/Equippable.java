import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Equippable extends GameItem {

    private String equippableEffect;

    public Equippable(String id, String itemName, String itemDesc, String itemType, String itemPower, int itemLocation) {
        super(id, itemName, itemDesc, itemType, itemPower, itemLocation);
    }


    public String getEquippableEffect() {
        return equippableEffect;
    }

    public void setEquippableEffect(Player player, String equippableEffect, GameMap map) {
        if (equippableEffect.trim().equalsIgnoreCase("Player wins the game")) {

            for (Map.Entry<Integer, Rooms> entry : map.getRooms().entrySet()) {
                //System.out.println(entry.getKey()); //room number
                //System.out.println(entry.getValue());//room objects

                if (entry.getValue().getItems().size() != 0) {
                    Iterator<GameItem> iter = entry.getValue().getItems().iterator();
                    while (iter.hasNext()) {
                        player.pickupItem(iter.next());
                        iter.remove();
                    }
                }
                //remove every monster
            }
            player.setHealth(1000);
        }
        else if (equippableEffect.trim().equalsIgnoreCase("Player can skip current room")) {
            Iterator<GameItem> iter = GameMap.rooms.get(player.getPlayerLocation()).getItems().iterator();//room.getItems().iterator();
            while (iter.hasNext()) {
                player.pickupItem(iter.next());
                iter.remove();
            }
            //for each puzzle in room
            Iterator<Puzzles> iter2 = GameMap.rooms.get(player.getPlayerLocation()).getPuzzles().iterator();
            while (iter2.hasNext()) {
                iter2.remove();
            }
            player.setHealth(250);
        }
    }
}
