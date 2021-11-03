package lab2;

public class Monster {
	private String name;
	private int level;
	private int health;
	private int damage;
	private int range;
	private int id;
	
	Monster(){
		
	}
	
	Monster(String name, int id, int level, int health, int damage, int range){
		this.id = id;
		this.name = name;
		this.level = level;
		this.health = health;
		this.damage = damage;
		this.range = range;
	}
	
	
	// Getters
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getRange() {
		return range;
	}
	
	// Setters
	public void setID(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
}
