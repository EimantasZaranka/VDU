package lab1;

import java.util.Comparator;

public class MaxRange implements Comparator<Team>{
	public int compare(Team a, Team b) {
		return b.monsters.evaluateByMaxDistance() - a.monsters.evaluateByMaxDistance();
	}
}