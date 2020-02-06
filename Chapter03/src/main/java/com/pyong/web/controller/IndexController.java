package com.pyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/home")
	public String home() {
		// ViewResolver에 따라 home.jsp가 실행	
		return "home";
	}
}
