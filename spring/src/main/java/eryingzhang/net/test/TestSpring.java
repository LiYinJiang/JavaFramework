package eryingzhang.net.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eryingzhang.net.service.EquipmentService;
import eryingzhang.net.service.HeroService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpring {
	@Autowired
	HeroService heroService;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "" });
		HeroService s = (HeroService) context.getBean("s");
		s.doSomeService();
		EquipmentService e = (EquipmentService) context.getBean("e");
		e.list();

	}

	@Test
	public void test() {
		heroService.doSomeService();

	}
}
