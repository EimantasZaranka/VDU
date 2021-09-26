package lab1;

import java.util.Comparator;

class TeamRange implements Comparator<Team>{
	public int compare(Team a, Team b) {
		return b.monsters.evaluateAttackRange() - a.monsters.evaluateAttackRange();
	}
}
