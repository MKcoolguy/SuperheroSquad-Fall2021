import java.io.Serializable;
import java.util.HashMap;
import java.util.Queue;

public class Monster extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String monsterAttack;   //Butter-butter bodyslam
	String rewardType;  //HP or attack potion

	

	public Monster(String id, String name, int health, int healthMax, String desc, int stength, int entityLocation, HashMap<String, Queue<GameItem>> inventory,String monsterAttack, String rewardType) {
		super(id, name, health, healthMax, desc, stength, entityLocation, inventory);
	      this.monsterAttack = monsterAttack;
	      this.rewardType = rewardType;
	}
	
	

	public String getMonsterAttack() {
		return monsterAttack;
	}

	public void setMonsterAttack(String monsterAttack) {
		this.monsterAttack = monsterAttack;
	}

	
	
	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public GameItem createGameItem() {
		if (rewardType.equalsIgnoreCase("HP Potion")) {
			Consumable c = new Consumable("IT1","HP Potion","A tasty potion that gives some health back","Consumable","+250 HP",0);
			return c;
		}
		else if (rewardType.equalsIgnoreCase("Attack Potion")) {
			Consumable c = new Consumable("IT2","Attack Potion","Holding this bottle makes you feel stronger already. Drink to consume the power.","Consumable","50 Attack for current room",0);
			return c;
		}
		else if (rewardType.equalsIgnoreCase("Plane Ticket")) {
			Equippable e = new Equippable("IT4", "Plane Ticket", "You did it! This ticket lets you go anywhere,anytime. The US is yours to explore.","Equippable", "Player wins the game",478748);
			return e;
		}
		return null;
	}

	@Override
	public int dealDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
