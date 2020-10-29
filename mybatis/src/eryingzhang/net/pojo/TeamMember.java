package eryingzhang.net.pojo;

import java.util.List;

public class TeamMember {
	private int id;
	private String name;
	private int tid;
	private List<Hero> heros;

	public List<Hero> getHeros() {
		return heros;
	}

	public void setHeros(List<Hero> heros) {
		this.heros = heros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "TeamMember [id=" + id + ", name=" + name + ", tid=" + tid + ", heros=" + heros + "]";
	}

}
