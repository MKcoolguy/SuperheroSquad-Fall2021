public abstract class Entity {

    private int id;
    private String name;
    private int health;
    private int healthMax;
    private String desc;
    private int stength;
    //private Map OR Arraylist<> inventory; need item class before I can initialize inventory
    private int entityLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStength() {
        return stength;
    }

    public void setStength(int stength) {
        this.stength = stength;
    }

    public int getEntityLocation() {
        return entityLocation;
    }

    public void setEntityLocation(int entityLocation) {
        this.entityLocation = entityLocation;
    }

    public abstract int dealDamage();
}
