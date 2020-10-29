package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import pojo.Hero;

public class HeroAction {
	private Hero hero;
	private List<Hero> heros;

	// xml文件中指明被调用，随后再执行jsp文件。
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		System.out.println("request:\t" + request);
		System.out.println("response:\t" + response);
		hero = new Hero();
		hero.setId(7);
		hero.setName("bond");
		return "show";
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public String addHero() {
		ServletActionContext.getRequest().getSession().setAttribute("name", hero.getName());
		Map m = ActionContext.getContext().getSession();
		m.put("actionName", "addHero");
		System.out.println("hero.name: " + hero.getName());
		return "showHero";
	}

	public List<Hero> getHeros() {
		return heros;
	}

	public void setHeros(List<Hero> heros) {
		this.heros = heros;
	}

	public String list() {
		heros = new ArrayList<Hero>();
		Hero h1 = new Hero();
		h1.setId(1);
		h1.setName("storm");
		h1.setAttackPower(21);
		heros.add(h1);

		Hero h2 = new Hero();
		h2.setId(1);
		h2.setName("storm");
		h2.setAttackPower(21);
		heros.add(h2);
		Hero h3 = new Hero();
		h3.setId(1);
		h3.setName("storm");
		h3.setAttackPower(21);
		heros.add(h3);
		return "list";
	}

}
