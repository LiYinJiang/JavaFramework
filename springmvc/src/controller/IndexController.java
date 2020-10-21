package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "hello erYingZhang");
		return mav;
	}

	@RequestMapping("/jump")
	public ModelAndView jump() {
		ModelAndView mav = new ModelAndView("redirect:index");
		return mav;
	}

	@RequestMapping("/check")
	public ModelAndView jump(HttpSession session) {
		Integer i = (Integer) session.getAttribute("count");
		if (i == null)
			i = 0;
		i++;
		session.setAttribute("count", i);
		ModelAndView mav = new ModelAndView("check");
		return mav;
	}

	@RequestMapping("/clear")
	public ModelAndView clear(HttpSession session) {
		Integer i = (Integer) session.getAttribute("count");
		i = 0;

		session.setAttribute("count", i);
		ModelAndView mav = new ModelAndView("redirect:check");
		return mav;
	}

}
