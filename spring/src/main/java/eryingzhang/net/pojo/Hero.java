package eryingzhang.net.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("h")
public class Hero {
	private int id;
	private String name = "Dire";

//	@Autowired
	private List<Equipment> equipments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", equipments=" + equipments + "]";
	}

}
