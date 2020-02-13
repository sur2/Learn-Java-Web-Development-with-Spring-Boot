package info.thecodinglive.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UIController {
	@RequestMapping("/th")
	public String template(Model model) {
		model.addAttribute("message", "boot template");
		
		return "th";
	}
}
