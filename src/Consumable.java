import java.io.Serializable;
import java.util.ArrayList;

public class Consumable extends GameItem implements Serializable {

    private String consumableEffect;
    private String consumableType; //to determine whether its attack or HP potion

    public Consumable(String id, String itemName, String itemDesc, String itemType, String itemPower, int itemLocation) {
        super(id, itemName, itemDesc, itemType, itemPower, itemLocation);
    }


    public String getConsumableEffect() {
        return consumableEffect;
    }

    public void setConsumableEffect(Player player, String consumableEffect, int currentRoom) {

        if (consumableEffect.equalsIgnoreCase("50 Attack for current room")) {
                player.setStength(player.getStength() + 50);
        }
        else if (consumableEffect.trim().endsWith("HP")) {
            player.setHealth(250 + player.getHealth());
        }
    }

    public String getConsumableType() {
        return consumableType;
    }

    public void setConsumableType(String consumableType) {
        this.consumableType = consumableType;
    }
}
