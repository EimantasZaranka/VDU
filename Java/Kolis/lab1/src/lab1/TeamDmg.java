package lab1;

import java.util.Comparator;

class TeamDmg implements Comparator<Team>{
	public int compare(Team a, Team b) {
		return b.monsters.evaluateDamageDelt() -
			   a.monsters.evaluateDamageDelt();
	}
}
