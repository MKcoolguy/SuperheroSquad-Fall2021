import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Player extends Entity {

    private boolean itemEquipped; //checks to see whether player has item equipped or not
    private static int roomID;

    public int getPlayerLocation(){
        return roomID;
    }

    public void setPlayerLocation(int room){
        roomID = room;
    }

    public boolean isItemEquipped() {
        return itemEquipped;
    }

    public void setItemEquipped(boolean itemEquipped) {
        this.itemEquipped = itemEquipped;
    }

    
    public void pickupItem(Player player, GameItem item) {
        //if item is already in inventory then just add one more to the count
        if (player.getInventory().containsKey(item.getItemName())) {
            player.getInventory().get(item.getItemName()).add(item);
        }
        //if item doesn't exist in inventory
        else {
            Queue <GameItem> queue = new LinkedList<>();
            queue.add(item);
            player.getInventory().put(item.getItemName(), queue);
        }
        System.out.println(item.getItemName() + " has been picked up and added to your inventory");
        //remove item from map
    }

    public void inspectItem(String input, GameItem item) {
        for (int i = 0; i < item.getItems().size(); i++){
            if (input.equalsIgnoreCase(item.getItems().get(i).getItemName())){
                System.out.println(item.getItems().get(i).getItemDesc());
            }
        }
    }

    //shows users health,
    public void checkStats(){
            System.out.println("Health : " + getHealth() + "/" + getHealthMax());
            System.out.println("Attack : " + getStength());
    }

    public void checkInventory(String input, Player player){
            if (player.getInventory().size() == 0){
                System.out.println("You do not have any items in your inventory");
            } else {
                UserInterface.displayInventory(player.getInventory());
            }
        }

    /*public void dropItem(String item) {
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
    }*/

    public void equipItem(GameItem item) {
        if (item.getItemType().equalsIgnoreCase("equippable")) {
            if (!isItemEquipped()) {
                System.out.println("You have equipped: " + item.getItemName());
                setItemEquipped(true);
                //set effect here
            }
            else {
                System.out.println("Unequip your current item before trying to equip " + item.getItemName());
            }
        }
        else {
            System.out.println("Cannot equip " + item.getItemName() + " because it is not of equippable type");
        }
    }

    public void unequipItem(String item) {
        if (isItemEquipped()) {
            System.out.println(item + " has been unequipped.");
            setItemEquipped(false);
            //set effect here
        }
        else {
            System.out.println("No item currently equipped.");
        }
    }

    //consumeItem method corresponds to the "use" command
    public void consumeItem(Player player, GameItem item) {
        if (player.getInventory().containsKey(item.getItemName())) {
            if (item.getItemType().equalsIgnoreCase("consumable")) {
                //setEffect here
                if (player.getInventory().get(item.getItemName()).size() == 1) { //if there's only one of the item then remove entirely from inventory.
                    player.getInventory().remove(item.getItemName());
                }
                else {
                    player.getInventory().get(item.getItemName()).poll(); //remove only one if there's more than one item
                }
            }
            else {
                System.out.println("This item can't be used since it's not a consumable.");
            }
        }
        else {
            System.out.println("Inventory does not contain: " + item.getItemName());
        }
    }

    //drop method corresponds to the drop command
    public void drop (Player player, String item, GameMap map) {
        if (player.getInventory().containsKey(item)) {
            //add back to map.
            getInventory().remove(item);
            //map.getRooms().get(getPlayerLocation()).setItem(true);
            System.out.println("You have dropped a: " + item + ".");
        }
        else {
            System.out.println("Inventory does not contain " + item + ".");
        }
    }

    //corresponds to the fight command, brings you to battle environment.
    public void fight(Scanner sc, GameMap map) {
       //if(map.getRooms().get(getPlayerLocation()).hasMonster()){
    		System.out.println("There is a monster in the room, type Inspect to examine it");
    	    	String response = sc.nextLine();
    	    	if(response.equalsIgnoreCase("inspect")) {
    	    		System.out.println();  //monster name,des,power
    	    	}
    	    	System.out.println("fight or flee ?");
    	    	 if (response.equalsIgnoreCase("flee")) {
    	    	//map.getRooms().get(getPlayerLocation()).setMonster(false);
    	    	}
    	    	 else {
    	    		 // fight here
    	    	 }
    	}


    @Override
    public int dealDamage() {
        return getStength();
    }
}
