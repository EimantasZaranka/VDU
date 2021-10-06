package lab1;

public class Lab1Home {

	public static void main(String[] args) {
		
		int numberOfTeams = 3;
		int maximumNumberOfMonsters = 5;
		int maximumMonsterLevel = 20;
		
		Game game = new Game(numberOfTeams, maximumNumberOfMonsters,
							 maximumMonsterLevel);
		
		System.out.println("Not Sorted Teams");
		game.printTeams(null);
		System.out.println();
		
		System.out.println("Teams sorted by Damage Done");
		game.sortTeamsByDmg();
		//game.printTeams();
		System.out.println();
		
		System.out.println("Teams sorted by Skillfulness");
		game.sortTeamsBySkillfulness();
		//game.printTeams();
		System.out.println();
		
		System.out.println("Teams sorted by Combined Range");
		game.sortTeamsByRange();
		//game.printTeams();
		System.out.println();
		
	}

}
