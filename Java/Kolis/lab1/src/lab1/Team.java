package lab1;

import java.util.Random;

class Team {
	int name;
	Monsters monsters;
	
	Team(int name, int level, int maxMonstersInTeam){
		Random rnd = new Random();
		int k;
		
		this.name = name;
		monsters = new Monsters();
		
		for (int i=0; i < rnd.nextInt(maxMonstersInTeam)+1; i++) {
			k = rnd.nextInt(2);
			new String();
			if(k==0) {
				monsters.add(new Goblin(String.valueOf(i),
					rnd.nextInt(15)+1, 275, 10, rnd.nextInt(level)+1
				));
			}else {
				monsters.add(new Hidra(String.valueOf(i),
					rnd.nextInt(20)+1, 145, 15, 2, rnd.nextInt(level)+1						
				));
			}
		}
	}
	
	int getName() {
		return name;
	}
}
