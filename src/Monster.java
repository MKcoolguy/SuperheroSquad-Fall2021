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

	@Override
	public int dealDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
