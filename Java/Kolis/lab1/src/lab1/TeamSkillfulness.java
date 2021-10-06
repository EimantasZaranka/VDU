package lab1;

import java.util.Comparator;

class TeamSkillfulness implements Comparator<Team>{
	public int compare(Team a, Team b) {
		return b.monsters.evaluateAttackSkillfulness() < a.monsters.evaluateAttackSkillfulness() ? -1
				: b.monsters.evaluateAttackSkillfulness() > a.monsters.evaluateAttackSkillfulness() ? 1
				: 0;
	}
}
