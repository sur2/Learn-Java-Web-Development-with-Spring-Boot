package com.pyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String home() {
		// ViewResolver에 따라 home.jsp가 실행	
		return "home";
	}
	@RequestMapping("/mv")
	public ModelAndView modal() {
		// ViewResolver에 따라 home.jsp가 실행	
		ModelAndView mv = new ModelAndView("modal");
		return mv;
	}
}
