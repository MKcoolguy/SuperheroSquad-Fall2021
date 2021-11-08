import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
public class Player extends Entity {

    private boolean itemEquipped; //checks to see whether player has item equipped or not
    private static int roomID;
    public int movesMade = 0; //counter for amount of times a player goes to a different room

    public Player(String id, String name, int health, int healthMax, String desc, int stength, int entityLocation, HashMap<String, Queue<GameItem>> inventory) {
        super(id, name, health, healthMax, desc, stength, entityLocation, inventory);
    }

    public Player() {
        super();
    }


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

    public void pickupItem(GameItem item) {
        //if item is already in inventory then just add one more to the count
        if (getInventory().containsKey(item.getItemName())) {
           getInventory().get(item.getItemName()).add(item);
        }
        //if item doesn't exist in inventory
        else {
            Queue <GameItem> queue = new LinkedList<>();
            queue.add(item);
            getInventory().put(item.getItemName(), queue);
        }
        System.out.println(item.getItemName() + " has been picked up and added to your inventory");
        //remove item from map
    }

    public void inspectItem(GameItem item) {
        if (getInventory().containsKey(item.getItemName())){
            System.out.println(item.getItemDesc() + " Effect: " + item.getItemPower() + ". Type: " + item.getItemType());
        }
    }

    //shows users health,
    public void checkStats(){
            System.out.println("Health : " + getHealth() + "/" + getHealthMax());
            System.out.println("Attack : " + getStength());
    }

    public void checkInventory(){
            if (getInventory().size() == 0) {
                System.out.println("You do not have any items in your inventory");
            } else {
                UserInterface.displayInventory(getInventory());
            }
        }

    public void equipItem(Player player, String itemName, GameMap map) {

        if (player.getInventory().containsKey(itemName) && getInventory() != null) {
            GameItem item = player.getInventory().get(itemName).peek();

            if (item.getItemType().equalsIgnoreCase("equippable")) {
                if (!isItemEquipped()) {
                    System.out.println("You have equipped: " + item.getItemName());
                    setItemEquipped(true);
                    //set effect here
                    Equippable e = (Equippable) item;
                    e.setEquippableEffect(player, e.getItemPower(), map);
                    System.out.println(e.getItemPower());

                } else {
                    System.out.println("Unequip your current item before trying to equip " + item);
                }
            } else {
                System.out.println("Cannot equip " + itemName + " because it is not of equippable type");
            }
        }

        else {
            System.out.println(itemName + " doesn't exist in inventory");
        }
    }

    public void unequipItem(Player player, String item) {
        System.out.println(player.getInventory());
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
    public void consumeItem(String itemName, Player player, int currentRoom) {

        if (getInventory().containsKey(itemName)) {
            GameItem item = getInventory().get(itemName).peek();


            if (item.getItemType().equalsIgnoreCase("consumable")) {
                //setEffect here
                Consumable c = (Consumable) item;
                c.setConsumableEffect(player, item.getItemPower(), currentRoom);


                if (getInventory().get(item.getItemName()).size() == 1) { //if there's only one of the item then remove entirely from inventory.
                    getInventory().remove(item.getItemName());
                }
                else {
                    getInventory().get(item.getItemName()).poll(); //remove only one if there's more than one item
                }
            }
            else {
                System.out.println("This item can't be used since it's not a consumable.");
            }
        }
        else {
            System.out.println("Inventory does not contain: " + itemName);
        }
    }

    //drop method corresponds to the drop command
    public void drop (Player player, String item, Rooms currentRoom) {
        if (player.getInventory().containsKey(item)) {
            //add back to map.
            currentRoom.getItems().add(player.getInventory().get(item).poll());

            if (getInventory().get(item).size() == 0) {
                getInventory().remove(item);
            }

            System.out.println("You have dropped: " + item + ".");
        }
        else {
            System.out.println("Inventory does not contain " + item + ".");
        }
    }

    //corresponds to the fight command, brings you to battle environment.
    public void fight(Scanner sc, GameMap map) {
    	
      	 
 	   if(map.getRooms().get(getPlayerLocation()).hasMonster()){
 		   
 	    	Monster monster = map.getRooms().get(getPlayerLocation()).getMonster();
 	    	
 			System.out.println("There is a monster in the room, type Inspect to examine it");
 		    	String response = sc.nextLine();
 		    	if(response.equalsIgnoreCase("inspect")) {
 		    		
 		    		System.out.println(monster.getName());  //monster name,des,power
 		    		System.out.println(monster.getDesc());
 		    		System.out.println(monster.getMonsterAttack());
 		    	}
 		    	System.out.println("fight or flee ?");

 	            if (response.equalsIgnoreCase("flee")) {

 	            boolean flee = false;
 	            Random rand = new Random();
 		    	//0 means flee successful
 		    	int randNum = rand.nextInt(2);          
 		    
 	            if (randNum == 0) {
 	                //flee
 	            }
 		    	 else {
 		    		 
 		    		 System.out.println("The battle has began");

 	                //loop for battle environment 
 	                 while (monster.getHealth() > 0) {
 	                    
 	                 }
 		    		
 		    		 // fight here
 		    	 }
 	         }//end if flee statemnt 
 	            else if (response.equalsIgnoreCase("fight")){
 	                 //loop for battle environment 
 	                 while (monster.getHealth() > 0) {
 	                    
 	                 }
 	            
 	            }

 		    } //room has monster end
 	            
 	   }
 	
 	    
    public ArrayList<Puzzles> solvePuzzle(Scanner sc, ArrayList<Puzzles> puzzles, HashMap<String, GameItem> items) {
    	if (puzzles.size() > 0) {
    		Puzzles puzzle = puzzles.get(0); // There will only ever be one puzzle in the room
    		int cur_puzzle_attempt = -1;
            int cur_puzzle_max = -1;
            boolean cur_puzzle_solved = false;
            String puzzle_answer = "";
            
            do {
        		if (cur_puzzle_attempt < 0) {
        			// We have not attempted the puzzle yet
        			cur_puzzle_max = puzzle.getAttempts();
        			cur_puzzle_attempt = 0;
        	    	System.out.println("+--------------------+");
                    System.out.println("YOU HAVE BEEN GIVEN A PUZZLE");
        		}
    	    	System.out.println("+--------------------+");
                System.out.println(puzzle.getQuestion());
    	    	System.out.println("+--------------------+");
        		if (cur_puzzle_attempt == cur_puzzle_max - 1) {
            		System.out.println("HINT: "+puzzle.getHint());
        	    	System.out.println("+--------------------+");
        		}
                System.out.print("Enter your answer: "); // Ask the User for their input
                puzzle_answer = sc.nextLine().toUpperCase();
                if (puzzle_answer.equals(puzzle.getAnswer().toUpperCase())) {
                	// Correct answer
                	cur_puzzle_solved = true;
            		System.out.println(puzzle.getMessageCorrect());
            		// Remove puzzle
            		puzzles.remove(0);
            		// Give rewards
            		ArrayList<ArrayList<String>> rewards = puzzle.getRewards();
            		for (int i = 0; i < rewards.size(); i++) {
            			String reward_title = rewards.get(i).get(0);
            			String reward_amount = rewards.get(i).get(1);
            			//int reward_amount = Integer.parseInt(rewards.get(i).get(1));
            			if (reward_title.equals("HP")) {
            				// HP Reward
            				if (reward_amount.equals("FULL")) {
            					this.setHealth(this.getHealthMax());
            					System.out.println("You have been healed to full health!");
            				} else {
            					int health_amount = Integer.parseInt(reward_amount);
            					int healed_amount = 0;
            					if (this.getHealth() + health_amount >= this.getHealthMax()) {
            						healed_amount = this.getHealthMax() - this.getHealth();
            						this.setHealth(this.getHealthMax());
                					System.out.println("You have been healed for "+healed_amount+" HP!");
            					} else {
            						this.setHealth(this.getHealth() + health_amount);
            						healed_amount = health_amount;
                					System.out.println("You have been healed for "+healed_amount+" HP!");
            					}            					
            				}
            			} else {
            				// Item reward
            				for (HashMap.Entry<String, GameItem> entry : items.entrySet()) {
            	        		String key = entry.getKey();
            	        		GameItem value = entry.getValue();
            	        		if (key.equals(reward_title)) {
            	        			if (this.getInventory().containsKey(value.getItemName())) {
            	        	            this.getInventory().get(value.getItemName()).add(value);
            	        	        } else {
            	        	            Queue <GameItem> queue = new LinkedList<>();
            	        	            queue.add(value);
            	        	            this.getInventory().put(value.getItemName(), queue);
            	        	        }
            	        	        System.out.println("You have been rewarded with a "+value.getItemName() + ", which was added to your inventory");
            	        		}
            	        	}
            			}
            		}            		
                } else if (puzzle_answer.equals("HINT")) {
                	// Show hint
            		System.out.println("-----");
            		System.out.println("HINT: "+puzzle.getHint());
                } else if (puzzle_answer.equals("IGNORE") || puzzle_answer.equals("IGNORE PUZZLE") || puzzle_answer.equals("LEAVE") || puzzle_answer.equals("LEAVE PUZZLE")) {
                	// Leave the puzzle
            		System.out.println("-----");
            		System.out.println("You have left the puzzle!");
                	cur_puzzle_solved = true;
                } else {
                	// Incorrect answer
                	cur_puzzle_attempt++;
            		System.out.println("-----");
            		if (cur_puzzle_attempt < cur_puzzle_max) {
            			//System.out.println("The answer you provided is wrong, you still have "+(cur_puzzle_max - cur_puzzle_attempt)+" attempts. Try one more time!");
                		String try_again_answer = "";
                		boolean try_again = false;
                		ArrayList<String> acceptable_answers = puzzle.getAcceptableAnswers();
    					System.out.println(puzzle.getMessageIncorrect()+" ("+String.join("/", acceptable_answers)+")");
                		if (acceptable_answers.size() == 1 && acceptable_answers.get(0).equals("!")) {
                			// Force player to try again in this case
                		} else {
                			do {
                				try_again_answer = sc.nextLine().toUpperCase();
                				if (!acceptable_answers.contains(try_again_answer)) {
                					System.out.println("Invalid answer!");
                					System.out.println(puzzle.getMessageIncorrect()+" ("+String.join("/", acceptable_answers)+")");
                				} else if (try_again_answer.equals("N")) {
                					cur_puzzle_solved = true;
                				}
                			} while(!acceptable_answers.contains(try_again_answer));
                		}
            		} else {
                		System.out.println(puzzle.getMessageFailure());
            		}
                }
    		} while(cur_puzzle_attempt < cur_puzzle_max && !cur_puzzle_solved);
    	}

		return puzzles;
    }

    @Override
    public int dealDamage() {
        return getStength();
    }
}
