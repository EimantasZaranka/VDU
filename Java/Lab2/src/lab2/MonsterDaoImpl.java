package lab2;

import java.util.ArrayList;
import java.sql.*;

//	https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
public class MonsterDaoImpl implements MonsterDao{

	
	public MonsterDaoImpl() {
		
	}
	
	@Override
	public Monster getMonster(int id) {
		Connection conn = DB.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * "
					+ "FROM monsters WHERE id=" + id);
			
			if(rs.next()) {
				return extractMonster(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Monster extractMonster(ResultSet rs) throws SQLException{
		Monster monster = new Monster();
		
		monster.setID(rs.getInt("idMonsters"));
		monster.setName(rs.getString("name"));
		monster.setLevel(rs.getInt("level"));
		monster.setHealth(rs.getInt("health"));
		monster.setDamage(rs.getInt("damage"));
		monster.setRange(rs.getInt("range"));
		
		return monster;
	}

	@Override
	public ArrayList<Monster> getAllMonsters() {
		Connection conn = DB.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM monsters");
			
			ArrayList<Monster> monsters = new ArrayList<Monster>();
			
			while(rs.next()) {
				Monster monster = extractMonster(rs);
				monsters.add(monster);
			}
			
			return monsters;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<Monster> getMonsterByName(String name) {
		Connection conn = DB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM monsters WHERE LOWER(name) LIKE LOWER(?)"
			);
			
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Monster> monsterLike = new ArrayList<Monster>();
			
			while(rs.next()) {
				monsterLike.add(extractMonster(rs));
			}
			
			return monsterLike;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertMonster(Monster monster) {
		Connection conn = DB.getConnection();
		String key[] = {"idMonsters"};
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO `java`.`monsters`"
					+ "(`name`, `level`, `health`, `damage`, `range`) "+
					"VALUES(?,?,?,?,?);", key
			);
			
			ps.setString(1, monster.getName());
			ps.setInt(2, monster.getLevel());
			ps.setInt(3, monster.getHealth());
			ps.setInt(4, monster.getDamage());
			ps.setInt(5, monster.getRange());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
			    return rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean updateMonster(Monster monster) {
		Connection conn = DB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE monsters " +
					"SET name=?, level=?, health=?, damage=?, range=?" +
					"WHERE id=?"
			);
			
			ps.setString(1, monster.getName());
			ps.setInt(2, monster.getLevel());
			ps.setInt(3, monster.getHealth());
			ps.setInt(4, monster.getDamage());
			ps.setInt(5, monster.getRange());
			ps.setInt(6, monster.getID());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		Connection conn = DB.getConnection();
		try {
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("DELETE FROM monster WHERE id="+id);
			if(i==1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



}
