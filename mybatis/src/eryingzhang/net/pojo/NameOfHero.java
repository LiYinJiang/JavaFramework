package eryingzhang.net.pojo;

//每个成员的擅长英雄 多对多。 即一个英雄会被多个队员擅长。 一个队员擅长多个英雄
public class NameOfHero {
	private int id;
	private int tmId;
	private int hid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTmId() {
		return tmId;
	}

	public void setTmId(int tmId) {
		this.tmId = tmId;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	@Override
	public String toString() {
		return "NameOfHero [id=" + id + ", tmId=" + tmId + ", hid=" + hid + "]";
	}

}
