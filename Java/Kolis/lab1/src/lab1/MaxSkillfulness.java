package lab1;

import java.util.Comparator;

public class MaxSkillfulness implements Comparator<Team>{
	public int compare(Team a, Team b) {
		return b.monsters.evaluateByMaxSkillfullness() < a.monsters.evaluateByMaxSkillfullness() ? -1
				: b.monsters.evaluateByMaxSkillfullness() > a.monsters.evaluateByMaxSkillfullness() ? 1
				: 0;
	}
}