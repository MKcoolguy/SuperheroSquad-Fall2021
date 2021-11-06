import java.util.ArrayList;

public class Consumable extends GameItem{

    private int consumableEffect;
    private String consumableType; //to determine whether its attack or HP potion

    public Consumable(String id, String itemName, String itemDesc, String itemType, String itemPower, int itemLocation) {
        super(id, itemName, itemDesc, itemType, itemPower, itemLocation);
    }


    public int getConsumableEffect() {
        return consumableEffect;
    }

    public void setConsumableEffect(int consumableEffect) {
        this.consumableEffect = consumableEffect;
    }

    public String getConsumableType() {
        return consumableType;
    }

    public void setConsumableType(String consumableType) {
        this.consumableType = consumableType;
    }
}
