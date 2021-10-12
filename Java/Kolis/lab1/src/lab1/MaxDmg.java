package lab1;

import java.util.Comparator;

public class MaxDmg implements Comparator<Team>{
	public int compare(Team a, Team b) {
		return b.monsters.evaluateByMaxDmg() -
			   a.monsters.evaluateByMaxDmg();
	}
}

