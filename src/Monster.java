import java.io.Serializable;

public class Monster extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Monster(int id, String name, int health, int healthMax, String desc, int stength, int entityLocation) {
		super(id, name, health, healthMax, desc, stength, entityLocation);
	}

	@Override
	public int dealDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
