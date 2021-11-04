import java.util.Scanner;
public class Player extends Entity {

    private int hp;
    private boolean itemEquipped; //checks to see whether player has item equipped or not

    private static int roomID;
    GameMap map = new GameMap();

    public static int getPlayerLocation(){
        return roomID;
    }

    public static void setPlayerLocation(int room){
        roomID = room;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isItemEquipped() {
        return itemEquipped;
    }

    public void setItemEquipped(boolean itemEquipped) {
        this.itemEquipped = itemEquipped;
    }

    Scanner sc = new Scanner(System.in);
    
    /*public void pickupItem(String item) {
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
    }*/

    public void inspectItem(String input, GameItem item) {
        for (int i = 0; i < item.getItems().size(); i++){
            if (input.equalsIgnoreCase(item.getItems().get(i).getItemName())){
                System.out.println(item.getItems().get(i).getItemDesc());
            }
        }
    }

    public void checkStatus(String input){
        if (input.equalsIgnoreCase("status")){
            System.out.println("You have " + getHp() + " HP.");
        }
    }

    public void checkInventory(String input, Player player){
        if (input.equalsIgnoreCase("inventory")){
            if (player.getInventory().size() == 0){
                System.out.println("You do not have any items in your inventory");
            } else {
                System.out.println("Items in your inventory: ");
                for (int i = 0; i < player.getInventory().size(); i++){
                    System.out.println(player.getInventory().get(i).getItemName());
                }
            }
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
        if (player.getInventory().contains(item)) {
            if (item.getItemType().equalsIgnoreCase("consumable")) {
                //setEffect here
                player.getInventory().remove(item);
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
    public void drop (Player player, GameItem item, GameMap map) {
        if (player.getInventory().contains(item)) {
            getInventory().remove(item);
            map.getRooms().get(getPlayerLocation()).setItem(true);
            System.out.println("You have dropped a: " + item.getItemName() + ".");
        }
        else {
            System.out.println("Inventory does not contain " + item.getItemName() + ".");
        }
    }

    //corresponds to the fight command, brings you to battle environment.
    public void fight() {
       if(map.getRooms().get(getPlayerLocation()).hasMonster()){
    		System.out.println("There is a monster in the room, type Inspect to examin it");
    	    	String response = sc.nextLine();
    	    	if(response.equalsIgnoreCase("inspect")) {
    	    		System.out.println();  //monster name,des,power
    	    	}
    	    	System.out.println("fight or flee ?");
    	    	 if (response.equalsIgnoreCase("flee")) {
    	    	map.getRooms().get(getPlayerLocation()).setMonster(false);
    	    	}
    	    	 else {
    	    		 // fight here
    	    	 }
    	} 
        
        

    }



    @Override
    public int dealDamage() {
        return getStength();
    }
}
