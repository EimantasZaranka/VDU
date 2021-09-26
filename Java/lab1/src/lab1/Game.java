package lab1;

import java.util.ArrayList;
import java.util.Collections;

class Game extends ArrayList<Team> {

	private static final long serialVersionUID = 1L;

	Game(int numberOfTeams, int maximumNumberOfMonsters, int maximumMonsterLevel){
		for(int i = 0; i < numberOfTeams; i++)
			add(new Team(i, maximumNumberOfMonsters, maximumMonsterLevel));
	}
	
	void sortTeamsByDmg() {
		Collections.sort(this, new TeamDmg());
	}
	
	void sortTeamsBySkillfulness() {
		Collections.sort(this, new TeamSkillfulness());
	}
	
	void sortTeamsByRange() {
		Collections.sort(this, new TeamRange());
	}
	
	void printTeams() {
		Team team;
		for(int i=0; i<size(); i++) {
			team = get(i);
			System.out.println("Team # " + team.getName());
			System.out.println("Team Dmg: " + team.monsters.evaluateDamageDelt());
			System.out.println("Team Range: " + team.monsters.evaluateAttackRange());
			System.out.println("Team Skillfulness" + team.monsters.evaluateAttackSkillfulness());
			
			team.monsters.printMonsters();
			System.out.println();
		}
	}
	
}
