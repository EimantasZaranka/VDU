package lab1;

abstract class Monster {
	String id;
	int level;
	int baseHealth;
	int baseDmg;

	
	Monster(String id, int level, int baseHealth, int baseDmg){
		this.id= id;
		this.level = level;
		this.baseHealth = baseHealth;
		this.baseDmg = baseDmg;
	}
	
	abstract int calc_dmg();
	abstract void printInfo();
	
	String getID() {return id;}
	int getLVL() {return level;}
	int getHealth() {return baseHealth;}
	int getBaseDmg() {return baseDmg;}

}
