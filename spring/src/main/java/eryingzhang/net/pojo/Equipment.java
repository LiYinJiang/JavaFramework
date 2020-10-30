package eryingzhang.net.pojo;

import org.springframework.stereotype.Component;

@Component("e")
public class Equipment {
	private int id;
	private String name;
	private float price;
	private Hero hero;

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
