import java.io.Serializable;
import java.util.ArrayList;

public abstract class GameItem implements Serializable    {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String itemName;
    private String itemDesc;
    private String itemType;
    private String itemPower;
    private int itemLocation;
    private ArrayList<GameItem> items;

    public GameItem(String id, String itemName, String itemDesc, String itemType, String itemPower, int itemLocation) {
        this.id = id;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemType = itemType;
        this.itemPower = itemPower;
        this.itemLocation = itemLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemPower() {
        return itemPower;
    }

    public void setItemPower(String itemPower) {
        this.itemPower = itemPower;
    }

    public ArrayList<GameItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<GameItem> items) {
        this.items = items;
    }

    public int getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(int itemLocation) {
        this.itemLocation = itemLocation;
    }

    @Override
    public String toString() {
        return "GameItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", items=" + items +
                ", itemLocation='" + itemLocation + '\'' +
                '}';
    }
}
