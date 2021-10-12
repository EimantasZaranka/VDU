package lab1;

import java.util.Random;

class Goblin extends Monster{
	float expGained = .01f;
	float autoAttackMultiplier;
	int timesAttacked;
	int timesDmgDelt;
	float randommult;
	
	Goblin(String id, int level, int baseHealth,
			int baseDmg, int timesAttacked)
	{
		super(id, level, baseHealth, baseDmg);
		
		Random rnd = new Random();
		
		float leftLimit = 1f;
		float rightLimit = 3f;
		this.autoAttackMultiplier = leftLimit + rnd.nextFloat() * 
									(rightLimit-leftLimit);
		
		this.timesAttacked = timesAttacked;
		this.timesDmgDelt = rnd.nextInt(this.timesAttacked);
		this.randommult = 1+ rnd.nextFloat()*(2-1);
	}
	
	float attackSkillfulness() {
		Random rnd = new Random();
		return timesAttacked*expGained*randommult;
	}
	
	float currentDmg() {
		float dmgBasedOnLevel = baseDmg + (level*autoAttackMultiplier);
		return Math.round((attackSkillfulness()*dmgBasedOnLevel) + dmgBasedOnLevel);
	}
	
	@Override
	int calc_dmg() {
		return Math.round(timesDmgDelt*currentDmg());
	}
	
	@Override
	void printInfo() {
		System.out.println(
				"Goblin " + id + ", skillfulness " + attackSkillfulness() +
				", current Dmg " + calc_dmg()
		);
	}

}
