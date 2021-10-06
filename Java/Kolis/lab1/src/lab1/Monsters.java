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
