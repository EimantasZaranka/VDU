package lab2;

import java.util.ArrayList;

public interface MonsterDao {
	Monster getMonster(int id);
	ArrayList<Monster> getAllMonsters();
	ArrayList<Monster> getMonsterByName(String name);
	int insertMonster(Monster monster);
	boolean updateMonster(Monster monster);
	boolean deleteUser(int id);
}
