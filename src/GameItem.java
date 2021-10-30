import java.util.ArrayList;

public abstract class GameItem {

    private int id;
    private String itemName;
    private String itemType;
    private String itemDesc;
    private ArrayList<GameItem> items;
    private String itemLocation; //why not make this int?

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public ArrayList<GameItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<GameItem> items) {
        this.items = items;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public void pickupItem(String item) {

    }

    public void inspectItem(String item) {
        for (int i = 0; i < getItems().size(); i++){
            if (item.equalsIgnoreCase(getItems().get(i).getItemName())){
                System.out.println(getItems().get(i).getItemDesc());
            }
        }
    }

    public void dropItem(String item) {
        
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
