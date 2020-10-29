package eryingzhang.net.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class HeroSqlProvider {
	public String list() {
		return new SQL().SELECT("*").FROM("hero_").toString();
	}

	public String get() {
		return new SQL().SELECT("*").FROM("hero_").WHERE("id=#{id}").toString();
	}

	public String delete() {
		return new SQL().DELETE_FROM("hero_").WHERE("id=#{id}").toString();
	}

	public String update() {
		return new SQL().UPDATE("hero_").SET("name=#{name}").WHERE("id=#{id}").toString();
	}

	public String add() {
		return new SQL().INSERT_INTO("hero_").VALUES("name", "#{name}").toString();
	}
}
