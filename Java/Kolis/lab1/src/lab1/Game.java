package lab1;

/*import java.util.ArrayList;
import java.util.Collections;*/
import java.util.HashSet ;
import java.util.Iterator;
import java.util.TreeSet;
class Game extends HashSet<Team> {

	private static final long serialVersionUID = 1L;

	Game(int numberOfTeams, int maximumNumberOfMonsters, int maximumMonsterLevel){
		for(int i = 0; i < numberOfTeams; i++)
			add(new Team(i, maximumNumberOfMonsters, maximumMonsterLevel));
	}
	
	void sortTeamsByDmg() {
		TreeSet<Team> teams = new TreeSet<Team>(new TeamDmg());
		teams.addAll(this);
		printTeams(teams);
	}
	
	void sortTeamsBySkillfulness() {
		TreeSet<Team> teams = new TreeSet<Team>(new TeamSkillfulness());
		teams.addAll(this);
		printTeams(teams);
		//this.stream().sorted(new TeamSkillfulness());
		//Collections.sort(this, new TeamSkillfulness());
	}
	
	void sortTeamsByRange() {
		TreeSet<Team> teams = new TreeSet<Team>(new TeamRange());
		teams.addAll(this);
		printTeams(teams);
		//this.stream().sorted(new TeamRange());
		//Collections.sort(this, new TeamRange());
	}
	
	void printTeams(TreeSet<Team> teams) {
		Iterator<Team> iter = iterator();
		
		if(teams != null) {
			iter = teams.iterator();
		}
		
		while(iter.hasNext()) {
			Team team = iter.next();
			System.out.println("Team # " + team.getName());
			System.out.println("Team Dmg: " + team.monsters.evaluateDamageDelt());
			System.out.println("Team Range: " + team.monsters.evaluateAttackRange());
			System.out.println("Team Skillfulness" + team.monsters.evaluateAttackSkillfulness());
			
			team.monsters.printMonsters();
			System.out.println();
		}
	}
	
}
