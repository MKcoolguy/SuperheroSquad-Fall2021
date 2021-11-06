import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Entity {

    private int id;
    private String name;
    private int health;
    private int healthMax;
    private String desc;
    private int stength;
    private HashMap<String, Queue<GameItem>> inventory;
    private int entityLocation;

    public Entity(int id, String name, int health, int healthMax, String desc, int stength, int entityLocation) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.healthMax = healthMax;
        this.desc = desc;
        this.stength = stength;
        this.entityLocation = entityLocation;
    }

    public Entity() {

    }

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

//    public ArrayList<GameItem> getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(ArrayList<GameItem> inventory) {
//        this.inventory = inventory;
//    }


    public HashMap<String, Queue<GameItem>> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Queue<GameItem>> inventory) {
        this.inventory = inventory;
    }

    public int getEntityLocation() {
        return entityLocation;
    }

    public void setEntityLocation(int entityLocation) {
        this.entityLocation = entityLocation;
    }

    public abstract int dealDamage();
}
