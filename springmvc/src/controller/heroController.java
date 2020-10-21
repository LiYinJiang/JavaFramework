package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Hero;

@Controller
public class heroController {

	@RequestMapping("/addHero")
	public ModelAndView addHero(Hero hero) {
		ModelAndView mav = new ModelAndView("showHero");
		return mav;
	}

}
