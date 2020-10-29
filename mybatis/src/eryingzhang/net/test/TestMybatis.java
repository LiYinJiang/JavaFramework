package eryingzhang.net.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import eryingzhang.net.mapper.HeroMapper;
import eryingzhang.net.mapper.TeamMapper;
import eryingzhang.net.mapper.TeamMemberMapper;
import eryingzhang.net.mapper.UserMapper;
import eryingzhang.net.pojo.Equipment;
import eryingzhang.net.pojo.Hero;
import eryingzhang.net.pojo.Team;
import eryingzhang.net.pojo.TeamMember;
import eryingzhang.net.pojo.User;

public class TestMybatis {

	public static void main(String[] args) {

		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			// testUser(session);
			testCacheByUser(sqlSessionFactory);
			// testHero(session);
			// testEquipment(session);
			// testTeamMembers(session);
			// testTeamMemberByAnnotations(session);
			// testTeamByAnnotations(session);
			// testHeroAnnotations(session);
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testCacheByUser(SqlSessionFactory sqlSessionFactory) {
		SqlSession s1 = sqlSessionFactory.openSession();
		SqlSession s2 = sqlSessionFactory.openSession();
		s1.selectOne("getUser", 4);
		s1.selectOne("getUser", 4);
		s1.commit();
		s2.selectOne("getUser", 4);
	}

	public static void testUser(SqlSession session) {
		PageHelper.offsetPage(5, 10); // 第三方插件进行分页， 查询前执行语句即可
		List<User> users = session.selectList("listUser");
		PageInfo info = new PageInfo<>(users); // 分页信息
		System.out.println(info.getPageSize());
		listAll(users);
		// for (User user : users) {
		// session.delete("deleteUser", user.getId());
		// }
		//
		// for (int i = 0; i < 100; i++) {
		// User u = new User();
		// u.setName("user" + i);
		// u.setAge(i);
		// session.insert("insertUser", u);
		// }
		// session.commit();
		Map<String, Object> map = new HashMap<>();
		// map.put("start", 0);
		// map.put("count", 10);
		// users.clear();
		// users = session.selectList("listUserPage", map);
		UserMapper mapper = session.getMapper(UserMapper.class);
		users = mapper.listPage(1, 20);
		listAll(users);
	}

	public static void testHero(SqlSession session) {
		List<Hero> heros = session.selectList("listHero");
		Hero h = new Hero();
		// insert
		// h.setName("burning");
		// session.insert("addHero", h);

		h.setId(2);
		// delete
		// session.delete("deleteHero",h);
		h.setName("stone");
		// update
		// session.update("updateHero", h);
		// session.commit();
		// listAll(heros);
		// heros = session.selectList("listHeroByName", "st"); // 模糊查詢
		// System.out.println(" listHeroByName");
		// listAll(heros);

		// 多條件模糊查詢
		Map<String, Object> conditions = new HashMap<>();
		// conditions.put("name", "st");
		// conditions.put("id", 1);
		// heros = session.selectList("listHeroByIdAndName", conditions);
		// System.out.println(" listHeroByIdAndName");
		// listAll(heros);
		// heros = session.selectList("listHero");
		// listAll(heros);

	}

	public static void testHeroAnnotations(SqlSession session) {
		HeroMapper heroMapper = session.getMapper(HeroMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Seek");
		heroMapper.add(map);
		List<Hero> heros = heroMapper.listAll();
		listAll(heros);
		Hero hero = heroMapper.get(11);
		System.out.println(hero);
	}

	public static void testEquipment(SqlSession session) {
		List<Equipment> equipments = session.selectList("liseEquipment");
		System.out.println(" listEquipment");
		for (Equipment equipment : equipments) {
			System.out.println("name: " + equipment);
		}

		Equipment eq = session.selectOne("selectEquipment", 5);
		Hero hero = session.selectOne("selectHero", 2);
		eq.setHero(hero);
		session.update("updateEquipment", eq);
		session.commit();
		for (Equipment equipment : equipments) {
			System.out.println("name: " + equipment);
		}

	}

	public static void testTeamMembers(SqlSession session) {
		List<TeamMember> teamMembers = session.selectList("listTeamMember");
		for (TeamMember teamMember : teamMembers) {
			System.out.println("all: " + teamMember);
		}
		Map<String, Object> map = new HashMap<>();
		// map.put("name", "Burning");
		// teamMembers = session.selectList("listTeamMember", map);
		// for (TeamMember teamMember : teamMembers) {
		// System.out.println("by name: " + teamMember);
		// }
		// map.put("id", 2);
		// teamMembers = session.selectList("listTeamMember", map);
		// for (TeamMember teamMember : teamMembers) {
		// System.out.println("by name and Id: " + teamMember);
		// }
		//
		// TeamMember tm = new TeamMember();
		// tm.setId(2);
		// tm.setName("BOBOka");
		// tm.setTid(2);
		// session.update("updateTeamMember", tm);
		// teamMembers = session.selectList("listTeamMember", map);
		// for (TeamMember teamMember : teamMembers) {
		// System.out.println("by name: " + teamMember);
		// }

		map.clear();
		// map.put("name", "B");
		// map.put("tid", 1);
		map.put("id", 4);
		teamMembers = session.selectList("listTeamMemberByOtherWise", map);
		for (TeamMember teamMember : teamMembers) {
			System.out.println("listTeamMemberByOtherWise : " + teamMember);
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		teamMembers.clear();
		teamMembers = session.selectList("listTeamMemberByForEach", list);
		for (TeamMember teamMember : teamMembers) {
			System.out.println("listTeamMemberByForEach : " + teamMember);
		}
		teamMembers.clear();
		map.clear();
		map.put("name", "B");
		teamMembers = session.selectList("listTeamMemberByBindName", map);
		for (TeamMember teamMember : teamMembers) {
			System.out.println("listTeamMemberByBindName : " + teamMember);
		}

	}

	public static void testTeamMemberByAnnotations(SqlSession session) {
		TeamMemberMapper teamMemberMapper = session.getMapper(TeamMemberMapper.class);
		// TeamMember teamMember = new TeamMember();
		// teamMember.setId(10);
		// teamMember.setName("FY");
		// teamMember.setTid(2);
		// teamMemberMapper.insert(teamMember);
		// session.commit();
		// listAll(teamMemberMapper.listAll());
		// teamMember.setName("MMY");
		// teamMemberMapper.update(teamMember);
		// session.commit();
		// listAll(teamMemberMapper.listAll());
		// TeamMember tm = teamMemberMapper.select(teamMember.getId());
		// System.out.println(tm);
		//
		// teamMemberMapper.delete(10);
		// session.commit();
		List<Hero> heros = teamMemberMapper.listHeroByTeamId(2);
		listAll(heros);

		listAll(teamMemberMapper.listAll());

	}

	public static void testTeamByAnnotations(SqlSession session) {
		TeamMapper teamMapper = session.getMapper(TeamMapper.class);
		List<Team> teams = teamMapper.list();
		for (Team team : teams) {
			System.out.println(team);
		}
	}

	public static <T> void listAll(List<T> list) {
		if (list == null || list.isEmpty())
			return;
		for (Object object : list) {
			System.out.println(object);
		}

	}
}
