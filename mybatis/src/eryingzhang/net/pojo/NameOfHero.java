package eryingzhang.net.pojo;

//ÿ����Ա���ó�Ӣ�� ��Զࡣ ��һ��Ӣ�ۻᱻ�����Ա�ó��� һ����Ա�ó����Ӣ��
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
