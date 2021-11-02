public class Consumable {

    private int consumableEffect;
    private String consumableType; //to determine whether its attack or HP potion

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
