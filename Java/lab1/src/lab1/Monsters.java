package lab1;

import java.util.ArrayList;

class Monsters extends ArrayList<Monster>{

	private static final long serialVersionUID = 1L;
	
	int evaluateAttackRange() {
		int value = 0;
		
		for(int i = 0; i < size(); i++) {
			if(get(i) instanceof Hidra)
				value += ((Hidra) get(i)).attackDistance();
		}
		
		return value;
	}
	
	float evaluateAttackSkillfulness() {
		float value = 0f;
		
		for(int i=0; i < size(); i++) {
			if(get(i) instanceof Goblin) {
				value += ((Goblin) get(i)).attackSkillfulness();
			}
		}
		
		return value;
		
	}
	
	int evaluateDamageDelt() {
		int value = 0;
		
		for(int i = 0; i < size(); i++) {
			value += get(i).calc_dmg();
		}
		
		return value;
	}
	
	void printMonsters() {
		Monster monster;
		
		for(int i = 0; i < size(); i++) {
			monster = get(i);
			monster.printInfo();
		}
	}
	
}
