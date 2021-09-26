package lab1;

import java.util.Random;

class Hidra extends Monster{
	
	float skillDmgMultiplier = 0.2f;
	float distanceMultiplier = .3f;
	int landedAttacks;
	int attackRange;
	int timeAttacked;
	
	Hidra(String id, int level, int baseHealth, int baseDmg, int attackRange,
		  int timesAttacked) 
	{
		super(id, level, baseHealth, baseDmg);
		
		Random rnd = new Random();
		
		this.attackRange = attackRange;
		this.timeAttacked = rnd.nextInt(timesAttacked);
		this.landedAttacks = rnd.nextInt(timeAttacked+1);
	}

	int attackDistance() {
		return Math.round(landedAttacks*distanceMultiplier)+attackRange;
	}
	
	float currentDmg() {
		return Math.round((level*skillDmgMultiplier)+baseDmg);
	}
	
	@Override
	int calc_dmg() {
		return Math.round(landedAttacks*(currentDmg() + 
				attackDistance()/100 * currentDmg())) ;
	}
	
	@Override
	void printInfo() {
		System.out.println(
				"Hidra " + id + ", attack distance " + attackDistance() + 
				", current Dmg " + currentDmg()
		);
	}
}
