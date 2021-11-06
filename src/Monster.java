import java.io.Serializable;
import java.util.HashMap;
import java.util.Queue;

public class Monster extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Monster(int id, String name, int health, int healthMax, String desc, int stength, int entityLocation, HashMap<String, Queue<GameItem>> inventory) {
		super(id, name, health, healthMax, desc, stength, entityLocation, inventory);
	}

	@Override
	public int dealDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
