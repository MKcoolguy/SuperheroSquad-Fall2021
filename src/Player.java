public class Player extends Entity {

    private int hp;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void pickupItem(String item) {
        for (int i = 0; i < getItems().size(); i++){
            if (item.equalsIgnoreCase(getItems().get(i).getItemName())){
                player.getInventory().add(getItems().get(i));
                items.remove(getItems().get(i));
                // need to set the item to false so that it is removed from the room.
                for (i = 0; i < player.getInventory().size(); i++){
                    if (item.equalsIgnoreCase(player.getInventory().get(i).getItemName())){
                        System.out.println(player.getInventory().get(i).getItemName() + " has been picked up and added to your inventory");
                    }
                }
            }
        }
    }

    public void inspectItem(String item) {
        for (int i = 0; i < getItems().size(); i++){
            if (item.equalsIgnoreCase(getItems().get(i).getItemName())){
                System.out.println(getItems().get(i).getItemDesc());
            }
        }
    }

    public void dropItem(String item) {
        for (int i = 0; i < player.getInventory().size(); i++){
            if (item.equalsIgnoreCase(player.getInventory().get(i).getItemName())){
                items.add(player.getInventory().get(i));
                // need to set the item location to the room the player is in
                player.getInventory().remove(i);
                // need to set the item to true so that an item is added to the room the player is in.
                for (i = 0; i < getItems().size(); i++){
                    if (item.equalsIgnoreCase(getItems().get(i).getItemName())){
                        System.out.println(getItems().get(i).getItemName() + " has been dropped and removed from your inventory");
                    }
                }
            }
        }
    }

    public void equipItem(String item) {
        setStength();
        //get item damage and set it as argument
        System.out.println("You have equipped: " + item);
    }

    public void unequipItem(String item) {
        setStength();
        //set player default strength as argument
        System.out.println("You have unequipped: " + item);
    }

    public void consumeItem(String item, int consumableEffect, String consumableType) {

    }

    @Override
    public int dealDamage() {
        return getStength();
    }
}
