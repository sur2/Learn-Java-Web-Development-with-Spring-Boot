package info.thecodinglive.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.thecodinglive.service.InMemoryProductService;

@Controller
public class UIController {
	@Autowired
	InMemoryProductService inMemoryProductService;
	
	@RequestMapping("/th")
	public String template(Model model) {
		model.addAttribute("message", "boot template");
		return "th";
	}
	
	@RequestMapping("/th2")
	public String templatePage2(Model model) {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("color", "red");
		pageMap.put("name", "jam");
		pageMap.put("price", 3000);
		model.addAttribute("product", pageMap);
		return "th2";
	}

	@RequestMapping(value = "/th3", method = RequestMethod.GET)
	public String templatePage3(Model model) {
		model.addAttribute("products", inMemoryProductService.getProductList());
		return "th3";
	}
	
}
