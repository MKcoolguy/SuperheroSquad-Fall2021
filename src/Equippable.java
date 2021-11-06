public class Equippable extends GameItem{

    private int equippableEffect;

    public Equippable(String id, String itemName, String itemDesc, String itemType, String itemPower, int itemLocation) {
        super(id, itemName, itemDesc, itemType, itemPower, itemLocation);
    }


    public int getEquippableEffect() {
        return equippableEffect;
    }

    public void setEquippableEffect(int equippableEffect) {
        this.equippableEffect = equippableEffect;
    }
}
