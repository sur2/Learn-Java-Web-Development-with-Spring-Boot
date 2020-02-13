package info.thecodinglive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * RestController Annotation은 ResponseBody와 Controller Annotation을 조합하여 만든 것
 * 컨트롤러 응답 자체가 몸체가 되므로 별도의 뷰페이지 없이 작동 확인 가능
 */
@RestController
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "Hello Spring boot";
	}
}
