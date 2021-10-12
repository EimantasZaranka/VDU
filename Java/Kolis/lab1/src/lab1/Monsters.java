package lab1;

//import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Monsters extends HashSet<Monster>{

	private static final long serialVersionUID = 1L;
	
	int evaluateAttackRange() {
		int value = 0;
		
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			if(m instanceof Hidra) {
				value += ((Hidra) m).attackDistance();
			}
			
		}
		
		/*for(int i = 0; i < size(); i++) {
			if(get(i) instanceof Hidra)
				value += ((Hidra) get(i)).attackDistance();
		}*/
		
		return value;
	}
	
	float evaluateAttackSkillfulness() {
		float value = 0f;
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			if(m instanceof Goblin) {
				value += ((Goblin) m).attackSkillfulness();
			}
		}
		/*for(int i=0; i < size(); i++) {
			if(get(i) instanceof Goblin) {
				value += ((Goblin) get(i)).attackSkillfulness();
			}
		}*/
		
		return value;
		
	}
	
	int evaluateDamageDelt() {
		int value = 0;
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			value += m.calc_dmg();
		}
		
		/*for(int i = 0; i < size(); i++) {
			value += get(i).calc_dmg();
		}*/
		
		return value;
	}
	
	int evaluateByMaxDmg() {
		int maxDmg = 0;
		
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			if(m.calc_dmg() >= maxDmg) 
				maxDmg=m.calc_dmg();
		}
		
		return maxDmg;
	}
	
	int evaluateByMaxDistance() {
		int maxDist = 0;
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			if(m instanceof Hidra) {
				if(((Hidra) m).attackDistance() >= maxDist)
					maxDist = ((Hidra) m).attackDistance();
			}
			
		}
		
		return maxDist;
	}
	
	float evaluateByMaxSkillfullness() {
		float maxSkillfullness = 0;
		
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			if(m instanceof Goblin) {
				if(((Goblin) m).attackSkillfulness() >= maxSkillfullness)
					maxSkillfullness = ((Goblin) m).attackSkillfulness();
			}
		}
		
		return maxSkillfullness;
	}
	
	void printMonsters() {
		//Monster monster;
		Iterator<Monster> iter = iterator();
		while(iter.hasNext()) {
			Monster m = iter.next();
			m.printInfo();
			
		}
		
		/*for(int i = 0; i < size(); i++) {
			monster = get(i);
			monster.printInfo();
		}*/
	}
	
}
