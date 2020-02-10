package info.thecodinglive.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * '@Controller' Annotation을 이용하여 cotroller scan를 지정한 패키지에 컨트롤러를 만들 수 있다.
 * '@RequestMapping("/root")' Annotation을 사용하여 해당 주소에 메서드가 실행된다.
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	public ModelAndView home() {
		// 데이터에 해당하는 모델과 View를 지정		
		ModelAndView mv = new ModelAndView("home");
		// key, value 형태로 데이터 전달	
		mv.addObject("title", "Jpub Spring WEB");
		mv.addObject("today", new Date().toString());
		System.out.println("ModelAndView:: index 컨트롤러 home 메서드 실행");
		return mv;
	}
}
